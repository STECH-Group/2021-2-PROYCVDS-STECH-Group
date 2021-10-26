package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.samples.entities.Category;

public interface ServicioSolidaridadECI {
	
	public List<Category> searchCategories();
	
	public void crearNuevaCategoria(String name, String description, boolean state) throws ExceptionServicioSolidaridadECI;
	
	public void actualizarCategoria(String name, String description, boolean state) throws ExceptionServicioSolidaridadECI;

}
