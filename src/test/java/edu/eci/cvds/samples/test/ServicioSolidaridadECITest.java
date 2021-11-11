package edu.eci.cvds.samples.test;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;

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

	@Test
	public void deberiaConsultarCategoriesTest() {
		Assert.assertEquals("Category [id=3, name=Textos, description=Libros, guias, manuales, etc. para clases teoricas, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(2).toString());
	}
	
	@Test
	public void deberiaActualizarDatosCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Laboratorios", "Labs", "Implementos necesarios en los labs", "Inactivo");
		Assert.assertEquals("Category [id=1, name=Labs, description=Implementos necesarios en los labs, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(0).toString());
		
	}
	
	@Test
	public void deberiaActualizarNombreCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "Electronica_v2", "", "");
		Assert.assertEquals("Category [id=2, name=Electronica_v2, description=Implmentos de electronica, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(1).toString());
	}
	
	@Test
	public void deberiaActualizarDescripcionCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "", "Implementos de las materias relacionadas con Electrónica", "");
		Assert.assertEquals("Category [id=2, name=Electronica, description=Implementos de las materias relacionadas con Electrónica, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(1).toString());
	}
	
	@Test
	public void deberiaActualizarEstadoCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "", "", "Inactivo");
		Assert.assertEquals("Category [id=2, name=Electronica, description=Implmentos de electronica, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(1).toString());
	}
	
	@After
	public void setUpAfter() {
		ssECI.limpiarTablas();
	}

}