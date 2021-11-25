package edu.eci.cvds.samples.services.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.entities.Need;
import edu.eci.cvds.samples.entities.Offer;
import edu.eci.cvds.samples.entities.Reporte;
import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;

public class ServicioSolidaridadECIImpl implements ServicioSolidaridadECI{
	
	@Inject
	private CategoryDAO categoryDAO;
	
	@Inject
	private NeedDAO needDAO;

	@Inject
	private OfferDAO offerDAO;
	
	@Inject
	private AnswerNeedDAO anDAO;
	
	@Inject
	private AnswerOfferDAO aoDAO;
	
	@Inject
	private ReporteDAO reporteDAO;
	
	@Override
	public void limpiarTablas() {
		categoryDAO.limpiarCategorias();
		needDAO.eliminarNecesidades();
		offerDAO.eliminarOfertas();
		anDAO.eliminarRespuestasNecesidades();
		aoDAO.eliminarRespuestasOfertas();
	}
	
	@Override
	public void crearNuevaCategoria(String name, String description, String state)
			throws ExceptionServicioSolidaridadECI {
		categoryDAO.crearCategoria(name, description, state);
	}

	@Override
	public void actualizarCategoria(String oName, String nName, String description, String state)
			throws ExceptionServicioSolidaridadECI {
		try {
			categoryDAO.actualizarCategoria(oName, nName, description, state);
		}
		catch (PersistenceException ex) {
			throw new ExceptionServicioSolidaridadECI("El nombre " + nName + " ya se encuentra en uso.", ex);
		}
	}
	
	@Override
	public List<String> searchActiveCategoryNames() {
		return categoryDAO.consultarNombresDeCategoriasActivas();
	}

	@Override
	public List<Category> searchCategories() {
		return categoryDAO.consultarCategorias();
	}

	@Override
	public List<Category> searchActiveCategories() {
		return categoryDAO.consultarCategoriasActivas();
	}
	
	@Override
	public List<String> searchCategoryNames(){
		return categoryDAO.consultarNombresDeCategorias();
	}
	
	@Override
	public List<Category> searchCategoriesByName(String name) {
		return categoryDAO.consultarCategoriasPorNombre(name);
	}

	@Override
	public void eliminarCategoria(Category category) {
		categoryDAO.eliminarCategoria(category);
	}

	@Override
	public void registrarNecesidad(String category, String description, int urgency, String state)
			throws PersistenceException {
		needDAO.registrarNecesidad(category, description, urgency, state);	
	}

	@Override
	public void actualizarEstadoNecesidad(Need need, String state) throws PersistenceException {
		needDAO.actualizarEstadoNecesidad(need, state);
	}

	@Override
	public void eliminarNecesidadPorId(int id) throws PersistenceException {
		needDAO.eliminarNecesidadPorId(id);
	}

	@Override
	public List<Need> consultarNecesidades() {
		return needDAO.consultarNecesidades();
	}

	@Override
	public List<Need> consultarNecesidadesPorUsuario() {
		return needDAO.consultarNecesidadesPorUsuario();
	}
	
	@Override
	public List<Need> consultaNecesidadesActivasOEnProceso() {
		return needDAO.consultarNecesidadesActivasOEnProceso();
	}

	@Override
	public List<Offer> consultaOfertas() {
		return offerDAO.consultarOfertas();
	}

	@Override
	public List<Offer> consultaOfertasActivasOEnProceso() {
		return offerDAO.consultarOfertasActivasOEnProceso();
	}

	@Override
	public List<Offer> consultaOfertasPorUsuario() {
		return offerDAO.consultarOfertasPorUsuario();
	}

	@Override
	public void nuevaOferta(String category, String description, String state) throws PersistenceException {
		offerDAO.nuevaOferta(category, description, state);
	}

	@Override
	public void actualizarEstadoOferta(Offer offer, String state) throws PersistenceException {
		offerDAO.actualizarEstadoOferta(offer, state);
	}

	@Override
	public void eliminarOfertaPorId(int id) throws PersistenceException {
		offerDAO.eliminarOfertaPorId(id);
	}

	@Override
	public void eliminarOfertas() {
		offerDAO.eliminarOfertas();
	}

	@Override
	public void registrarRespuestaNecesidad(String resp, Need nece) {
		anDAO.registrarRespuestaNecesidad(resp, nece);
	}

	@Override
	public void registrarRespuestaOferta(String resp, Offer ofer) {
		aoDAO.registrarRespuestaOferta(resp, ofer);
	}

	@Override
	public List<Need> reporteDeNecesidades() {
		return needDAO.reporteNecesidades();
	}

	@Override
	public List<Reporte> reporteNecesidadesGrafico() {
		return reporteDAO.valoresReporteNecesidades();
	}
	
	@Override
	public List<Offer> reporteDeOfertas() {
		return offerDAO.reporteOfertas();
	}

	@Override
	public List<Reporte> reporteOfertasGrafico() {
		return reporteDAO.valoresReporteOfertas();
	}

}