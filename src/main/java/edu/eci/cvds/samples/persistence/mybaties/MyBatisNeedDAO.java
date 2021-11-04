package edu.eci.cvds.samples.persistence.mybaties;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.samples.persistence.mybaties.mappers.NeedMapper;

public class MyBatisNeedDAO {

	@Inject
	private NeedMapper needMapper;
	
	public void registrarNecesidad(String category, String name, String description, int urgency, String state) throws PersistenceException {
		try {	
			needMapper.registerNeed(category, name, description, urgency, state);
			}
			catch(org.apache.ibatis.exceptions.PersistenceException e) {
	            throw new PersistenceException("Error al crear la categoria, el nombre ya esta en uso",e);
			}
	}
}
