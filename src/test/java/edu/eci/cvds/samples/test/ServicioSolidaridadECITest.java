package edu.eci.cvds.samples.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;
import edu.eci.cvds.samples.entities.*;
import junit.framework.Assert;

public class ServicioSolidaridadECITest {
	
	ServicioSolidaridadECI ssECI;

	public ServicioSolidaridadECITest() {
		ssECI = ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECITesting();
	}
	
	
	@Before
	public void setUp() {
		try {
			ssECI.crearNuevaCategoria("Laboratorios", "Implementos de seguridad para practicas de laboratorio", "Activo");
			ssECI.crearNuevaCategoria("Electronica", "Implmentos de electronica", "Activo");
			ssECI.crearNuevaCategoria( "Textos", "Libros, guias, manuales, etc. para clases teoricas", "Inactivo");
			ssECI.crearNuevaCategoria("Deportes", "Equipo de practica para los integrantes de los equipos de la Escuela", "Activo");
			ssECI.crearNuevaCategoria("Expresión Gráfica", "Instrumentos de dibujo para EGR", "Inactivo");
		} catch (ExceptionServicioSolidaridadECI e) {
			e.printStackTrace();
		}
	}
	@Test
	public void deberiaConsultarCategoriesTest() {
		Assert.assertEquals("Category [id=3, name=Textos, description=Libros, guias, manuales, etc. para clases teoricas, creationDate=2021-10-28, state=Inactivo, modifyDate=2021-10-28]\n\t", ssECI.searchCategories().get(2).toString());
		
	}
	/**
	@Test
	public void deberiaActualizarTodosCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Laboratorios", "Labs", "Implementos XD", "Inactivo");
		System.out.println(ssECI.searchCategories().get(0).toString());
		Assert.assertEquals("Category [id=1, name=Labs, description=null, creationDate=2021-10-28, state=Inactivo, modifyDate=2021-10-28]\n\t", ssECI.searchCategories().get(0).toString());
	}*/

}