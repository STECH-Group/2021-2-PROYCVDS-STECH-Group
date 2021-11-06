package edu.eci.cvds.samples.services;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Category;

public interface ServicioSolidaridadECI {
	
	public List<Category> searchCategories();
	
	public List<Category> searchActiveCategories();
	
	public void crearNuevaCategoria(String name, String description, String state) throws ExceptionServicioSolidaridadECI;
	
	public void actualizarCategoria(String oName, String nName, String description, String state) throws ExceptionServicioSolidaridadECI;
	
	public void limpiarCategorias();
	
	public void eliminarCategoria(String name, int id);

	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException;
	
	public void actualizarEstadoNecesidad(int id, String state) throws PersistenceException;
	
	public void eliminarNecesidadPorId(int id) throws PersistenceException;
	
	public void eliminarNecesidades();
}
