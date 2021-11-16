package edu.eci.cvds.samples.persistence.mybaties;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Need;
import edu.eci.cvds.samples.entities.User;
import edu.eci.cvds.samples.persistence.NeedDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.*;

public class MyBatisNeedDAO implements NeedDAO{

	@Inject
	private NeedMapper needMapper;
	
	@Inject
	private UserMapper userMapper;
	
	@Override
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException {
		try {	
			System.out.println("Antes de crear el Subject ");
			Subject user = SecurityUtils.getSubject();
			if (user.hasRole("Estudiante")) {
				User user2 = userMapper.searchNameUserByMail(user.getSession().getAttribute("mail").toString());
				needMapper.registerNeed(category, user2.getName(), description, urgency, state);
			} else {
				throw new PersistenceException("El rol del usuario no tiene permiso para registrar una necesidad");
			}
		} catch(PersistenceException e) {
	        throw new PersistenceException("Error al crear la categoria, el nombre ya esta en uso",e);
		}
	}
	
	@Override
	public void actualizarEstadoNecesidad(Need need, String state) throws PersistenceException{
		try {	
			needMapper.updateStateNeed(need.getId(), state);
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
		needMapper.restartSequenceNeeds();
	}

	@Override
	public List<Need> consultarNecesidades() {
		return needMapper.searchNeeds();
	}

	@Override
	public List<Need> consultarNecesidadesPorUsuario() throws PersistenceException{
		try {
			Subject user = SecurityUtils.getSubject();
			return needMapper.searchNeedsByUser(user.getSession().getAttribute("name").toString());
		} catch(PersistenceException e) {
	        throw new PersistenceException("El usuario no se encuentra registrado en la base de datos",e);
		}
	}

	@Override
	public List<Need> consultarNecesidadesActivasOEnProceso() throws PersistenceException {
		return needMapper.searchActiveOrInProcessNeeds();
	}
}