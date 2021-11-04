package edu.eci.cvds.samples.services.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;

public class ServicioSolidaridadECIImpl implements ServicioSolidaridadECI{
	
	@Inject
	private CategoryDAO categoryDAO;
	
	@Inject
	private UserDAO userDAO;

	@Override
	public void crearNuevaCategoria(String name, String description, String state)
			throws ExceptionServicioSolidaridadECI {
		// TODO Auto-generated method stub
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
	public List<Category> searchCategories() {
		return categoryDAO.consultarCategorias();
	}

	@Override
	public void limpiarCategorias() {
		categoryDAO.limpiarCategorias();
	}

	@Override
	public List<Category> searchActiveCategories() {
		return categoryDAO.consultarCategoriasActivas();
	}

	@Override
	public void eliminarCategoria(String name, int id) {
		categoryDAO.eliminarCategoria(name, id);
	}
	
}
