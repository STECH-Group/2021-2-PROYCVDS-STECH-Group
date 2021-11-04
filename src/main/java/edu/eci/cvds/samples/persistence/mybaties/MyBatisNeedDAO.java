package edu.eci.cvds.samples.persistence.mybaties;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.samples.persistence.NeedDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.NeedMapper;

public class MyBatisNeedDAO implements NeedDAO{

	@Inject
	private NeedMapper needMapper;
	
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException {
		try {	
			Subject user = SecurityUtils.getSubject();
			needMapper.registerNeed(category, user.getSession().getAttribute("name").toString(), description, urgency, state);
			}
			catch(org.apache.ibatis.exceptions.PersistenceException e) {
	            throw new PersistenceException("Error al crear la categoria, el nombre ya esta en uso",e);
			}
	}
}
