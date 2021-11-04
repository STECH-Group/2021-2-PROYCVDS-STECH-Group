package edu.eci.cvds.samples.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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
			ssECI.crearNuevaCategoria("Textos", "Libros, guias, manuales, etc. para clases teoricas", "Inactivo");
			ssECI.crearNuevaCategoria("Deportes", "Equipo de practica para los integrantes de los equipos de la Escuela", "Activo");
			ssECI.crearNuevaCategoria("Expresión Gráfica", "Instrumentos de dibujo para EGR", "Inactivo");
		} catch (ExceptionServicioSolidaridadECI e) {
			e.printStackTrace();
		}
	}
	/*@SuppressWarnings("deprecation")
	@Test
	public void deberiaConsultarCategoriesTest() {
		Assert.assertEquals("Category [id=3, name=Textos, description=Libros, guias, manuales, etc. para clases teoricas, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(2).toString());
	}*/
	
	/*
	@SuppressWarnings("deprecation")
	@Test
	public void deberiaActualizarDatosCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Laboratorios", "Labs", "", "Inactivo");
		//System.out.println(ssECI.searchCategories().get(0).toString());
		System.out.println(ssECI.searchCategories());
		Assert.assertEquals("Category [id=1, name=Labs, description=Implementos XD, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(0).toString());
		
	}*/
	
	/*
	@SuppressWarnings("deprecation")
	@Test
	public void deberiaActualizarNombreCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "Electronica_v2", "", "");
		//System.out.println(ssECI.searchCategories().get(0).toString());
		System.out.println(ssECI.searchCategories());
		Assert.assertEquals("Category [id=2, name=Electronica_v2, description=Implmentos de electronica, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(1).toString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void deberiaActualizarDescripcionCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "", "Implementos de las materias relacionadas con Electrónica", "");
		//System.out.println(ssECI.searchCategories().get(0).toString());
		System.out.println(ssECI.searchCategories());
		Assert.assertEquals("Category [id=2, name=Electronica, description=Implementos de las materias relacionadas con Electrónica, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(1).toString());
	}*/
	
	@SuppressWarnings("deprecation")
	@Test
	public void deberiaActualizarEstadoCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "", "", "Inactivo");
		//System.out.println(ssECI.searchCategories().get(0).toString());
		System.out.println(ssECI.searchCategories());
		Assert.assertEquals("Category [id=2, name=Electronica, description=Implmentos de electronica, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(1).toString());
	}
	
	@After
	public void setUpAfter() {
		ssECI.limpiarCategorias();
	}

}