package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.samples.entities.Category;

public interface ServicioSolidaridadECI {
	
	public List<Category> searchCategories();
	
	public List<Category> searchActiveCategories();
	
	public void crearNuevaCategoria(String name, String description, String state) throws ExceptionServicioSolidaridadECI;
	
	public void actualizarCategoria(String oName, String nName, String description, String state) throws ExceptionServicioSolidaridadECI;
	
	public void limpiarCategorias();
	
	public void eliminarCategoria(String name, int id);

}
