package edu.eci.cvds.samples.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Category;

public interface CategoryDAO {
	
	public List<Category> consultarCategorias(); 
	
	public List<Category> consultarCategoriasActivas();
	
	public List<String> consultarNombresDeCategoriasActivas();
	
	public List<String> consultarNombresDeCategorias();
	
	public List<Category> consultarCategoriasPorNombre(String name);
	
	public void crearCategoria(String name, String description, String state) throws PersistenceException;
	
	public void actualizarCategoria(String oName, String nName, String description, String state) throws PersistenceException;
	
	public void limpiarCategorias();
	
	public void eliminarCategoria(Category category);
}
