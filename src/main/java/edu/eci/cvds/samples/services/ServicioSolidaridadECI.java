package edu.eci.cvds.samples.services;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.*;

public interface ServicioSolidaridadECI {
	
	public void limpiarTablas();
	
	public List<Category> searchCategories();
	
	public List<Category> searchActiveCategories();
	
	public List<String> searchActiveCategoryNames();
	
	public List<String> searchCategoryNames();
	
	public List<Category> searchCategoriesByName(String name);
	
	public void crearNuevaCategoria(String name, String description, String state) throws ExceptionServicioSolidaridadECI, PersistenceException;
	
	public void actualizarCategoria(String oName, String nName, String description, String state) throws ExceptionServicioSolidaridadECI;
	
	public void eliminarCategoria(Category category);

	public List<Need> consultarNecesidades();
	
	public List<Need> consultarNecesidadesPorUsuario();
	
	public List<Need> reporteDeNecesidades();
	
	public List<Reporte> reporteNecesidadesGrafico();
	
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException;
	
	public void actualizarEstadoNecesidad(Need need, String state) throws PersistenceException;
	
	public void eliminarNecesidadPorId(int id) throws PersistenceException;
	
	public List<Need> consultaNecesidadesActivasOEnProceso();
	
	public List<Offer> consultaOfertas();
	
	public List<Offer> consultaOfertasActivasOEnProceso();
	
	public List<Offer> consultaOfertasPorUsuario();
	
	public List<Offer> reporteDeOfertas();
	
	public List<Reporte> reporteOfertasGrafico();
	
	public void nuevaOferta(String category, String description, String state) throws PersistenceException;
	
	public void actualizarEstadoOferta(Offer offer, String state) throws PersistenceException;
	
	public void eliminarOfertaPorId(int id) throws PersistenceException;
	
	public void eliminarOfertas();
	
	public void registrarRespuestaNecesidad(String resp, Need nece);
	
	public void registrarRespuestaOferta(String resp, Offer ofer);
	
}