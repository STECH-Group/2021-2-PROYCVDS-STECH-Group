package edu.eci.cvds.samples.persistence;

import org.apache.ibatis.exceptions.PersistenceException;

public interface NeedDAO {
	
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException;

}
