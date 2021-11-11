package edu.eci.cvds.samples.services.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.entities.Need;
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
	
	@Override
	public void limpiarTablas() {
		categoryDAO.limpiarCategorias();
		needDAO.eliminarNecesidades();
		offerDAO.eliminarOfertas();
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
	public void eliminarCategoria(String name, int id) {
		categoryDAO.eliminarCategoria(name, id);
	}

	@Override
	public void registrarNecesidad(String category, String description, int urgency, String state)
			throws PersistenceException {
		needDAO.registrarNecesidad(category, description, urgency, state);	
	}

	@Override
	public void actualizarEstadoNecesidad(int id, String state) throws PersistenceException {
		needDAO.actualizarEstadoNecesidad(id, state);
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

}