package edu.eci.cvds.samples.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Category;

public interface CategoryDAO {
	
	public List<Category> searchCategories(); 
	
	public void crearCategoria(String name, String description, boolean state) throws PersistenceException;
	
	public void actualizarCategoria(String name, String description, boolean state) throws PersistenceException;
}
