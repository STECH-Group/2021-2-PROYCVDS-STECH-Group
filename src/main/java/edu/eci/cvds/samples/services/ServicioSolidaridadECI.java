package edu.eci.cvds.samples.services;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.*;

public interface ServicioSolidaridadECI {
	
	public void limpiarTablas();
	
	public List<Category> searchCategories();
	
	public List<Category> searchActiveCategories();
	
	public List<String> searchActiveCategoryNames();
	
	public void crearNuevaCategoria(String name, String description, String state) throws ExceptionServicioSolidaridadECI;
	
	public void actualizarCategoria(String oName, String nName, String description, String state) throws ExceptionServicioSolidaridadECI;
	
	public void eliminarCategoria(String name, int id);

	public List<Need> consultarNecesidades();
	
	public List<Need> consultarNecesidadesPorUsuario();
	
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException;
	
	public void actualizarEstadoNecesidad(int id, String state) throws PersistenceException;
	
	public void eliminarNecesidadPorId(int id) throws PersistenceException;
	
	
}