package edu.eci.cvds.samples.persistence.mybaties;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.samples.persistence.NeedDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.NeedMapper;

public class MyBatisNeedDAO implements NeedDAO{

	@Inject
	private NeedMapper needMapper;
	
	public void registrarNecesidad(String category, String name, String description, int urgency, String state) throws PersistenceException {
		try {	
			needMapper.registerNeed(category, name, description, urgency, state);
		} catch(org.apache.ibatis.exceptions.PersistenceException e) {
	        throw new PersistenceException("Error al registrar la necesidad",e);
		}
	}
	
	private void actualizarEstadoNecesidad(int id, String state) throws PersistenceException{
		try {	
			needMapper.updateStateNeed(id, state);
		} catch(org.apache.ibatis.exceptions.PersistenceException e) {
	        throw new PersistenceException("Error al actualizar la necesidad",e);
		}
	}
	
	private void eliminarNecesidadPorId(int id) throws PersistenceException{
		try {	
			needMapper.deleteNeedById(id);
		} catch(org.apache.ibatis.exceptions.PersistenceException e) {
	        throw new PersistenceException("La necesidad que desea eliminar no existe",e);
		}
	}
	
	private void eliminarNecesidades() {	
		needMapper.deleteNeeds();
	}
}
