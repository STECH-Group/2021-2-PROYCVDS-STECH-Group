package edu.eci.cvds.samples.test;

import java.time.LocalDate;

import org.bouncycastle.operator.AADProcessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.persistence.mybaties.mappers.NeedMapper;
import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;

public class ServicioSolidaridadECITest {
	
	ServicioSolidaridadECI ssECI;
	
	//@Inject
	//NeedMapper needMapper;

	public ServicioSolidaridadECITest() {
		ssECI = ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECITesting();
	}
	
	@Before
	public void setUp() {
		try {
			// Categories
			ssECI.crearNuevaCategoria("Laboratorios", "Implementos de seguridad para practicas de laboratorio", "Activo");
			ssECI.crearNuevaCategoria("Electronica", "Implmentos de electronica", "Activo");
			ssECI.crearNuevaCategoria("Textos", "Libros, guias, manuales, etc. para clases teoricas", "Inactivo");
			ssECI.crearNuevaCategoria("Deportes", "Equipo de practica para los integrantes de los equipos de la Escuela", "Activo");
			ssECI.crearNuevaCategoria("Expresión Gráfica", "Instrumentos de dibujo para EGR", "Inactivo");
			
			//Needs
			//needMapper.registerNeed("Laboratorios", "Camilo Pichimata", "Ncesito una bata de laboratorio", 4, "Activo");
			
		} catch (ExceptionServicioSolidaridadECI e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deberiaConsultarCategorias() {
		//System.out.println();
		//System.out.println(ssECI.searchCategories().toString());
		Assert.assertEquals(5, ssECI.searchCategories().size());
	}
	
	@Test
	public void deberiaConsultarCategoriasActivas() {
		Assert.assertEquals("[Laboratorios, Electronica, Deportes]", ssECI.searchActiveCategoryNames().toString());
	}
	
	@Test
	public void deberiaConsultarNombresDeCategoriasActivas() {
		Assert.assertEquals("Category [id=4, name=Deportes, description=Equipo de practica para los integrantes de los equipos de la Escuela, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchActiveCategories().get(2).toString());
	}
	
	@Test
	public void deberiaConsultarCategoriasPorNombre() {
		Assert.assertEquals("Category [id=3, name=Textos, description=Libros, guias, manuales, etc. para clases teoricas, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategoryByName("Textos").toString());
	}
	
	@Test
	public void deberiaCrearCategoria() {
		try {
			ssECI.crearNuevaCategoria("Implementos de estudio", "Utiles como cuadernos, hojas, reglas, lapiceros y demás implementos de estudio", "Activo");
		} catch (ExceptionServicioSolidaridadECI e) {
			Assert.assertTrue(false);
		}
		Assert.assertEquals("Category [id=6, name=Implementos de estudio, description=Utiles como cuadernos, hojas, reglas, lapiceros y demás implementos de estudio, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t", ssECI.searchCategories().get(5).toString());
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
	
	@Test
	public void deberiaEliminarCategoriasPorNombre() {
		//ssECI.eliminarCategoria("Laboratorios", 0);
		Category categoria = ssECI.searchCategoryByName("Laboratorios");
		ssECI.eliminarCategoria(categoria);
		Assert.assertEquals("[]", ssECI.searchCategoryByName("Laboratorios").toString());
	}
	
	/*
	@Test
	public void deberiaEliminarCategoriasPorId() {
		ssECI.eliminarCategoria("", 2);
		Assert.assertEquals("[]", ssECI.searchCategoriesByName("Electronica").toString());
	}*/
	
	@Test
	public void deberiaConsultarNecesidades() {
		System.out.println();
		System.out.println(ssECI.consultarNecesidades().toString());
		Assert.assertEquals(0, ssECI.consultarNecesidades().size());
	}
	
	@Test
	public void deberiaEliminarLosRegistrosDeLasTablas() {
		ssECI.limpiarTablas();
		Assert.assertEquals("[]", ssECI.searchCategories().toString());
		//Assert.assertEquals("[]", ssECI.consultarNecesidades().toString());
		//Assert.assertEquals("[]", ssECI.searchCategories().toString());
	}
	
	@After
	public void setUpAfter() {
		ssECI.limpiarTablas();
	}

}