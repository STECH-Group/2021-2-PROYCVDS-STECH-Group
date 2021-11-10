package edu.eci.cvds.samples.persistence.mybaties;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Need;
import edu.eci.cvds.samples.persistence.NeedDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.NeedMapper;

public class MyBatisNeedDAO implements NeedDAO{

	@Inject
	private NeedMapper needMapper;
	
	@Override
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException {
		try {	
			Subject user = SecurityUtils.getSubject();
			needMapper.registerNeed(category, user.getSession().getAttribute("name").toString(), description, urgency, state);
		} catch(PersistenceException e) {
	        throw new PersistenceException("Error al crear la categoria, el nombre ya esta en uso",e);
		}
	}
	
	@Override
	public void actualizarEstadoNecesidad(int id, String state) throws PersistenceException{
		try {	
			needMapper.updateStateNeed(id, state);
		} catch(PersistenceException e) {
	        throw new PersistenceException("Error al actualizar la necesidad",e);
		}
	}
	
	@Override
	public void eliminarNecesidadPorId(int id) throws PersistenceException{
		try {	
			needMapper.deleteNeedById(id);
		} catch(PersistenceException e) {
	        throw new PersistenceException("La necesidad que desea eliminar no existe",e);
		}
	}
	
	@Override
	public void eliminarNecesidades() {	
		needMapper.deleteNeeds();
	}

	@Override
	public List<Need> consultarNecesidades() {
		return needMapper.searchNeeds();
	}

	@Override
	public List<Need> consultarNecesidadesPorUsuario() {
		Subject user = SecurityUtils.getSubject();
		return needMapper.searchNeedsByUser(user.getSession().getAttribute("name").toString());
	}
}