package edu.eci.cvds.samples.test;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.apache.pdfbox.contentstream.operator.state.SetLineDashPattern;
import org.bouncycastle.operator.AADProcessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

import edu.eci.cvds.samples.beans.LoginBean;
import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.persistence.mybaties.mappers.NeedMapper;
import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;

public class ServicioSolidaridadECITest {
	
	ServicioSolidaridadECI ssECI;
	
	@Inject
	NeedMapper needMapper;

	public ServicioSolidaridadECITest() {
		ssECI = ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECITesting();
	}
	
	@Test
	public void deberiaConsultarCategorias() {
		//System.out.println("---Consultar Categorías---");
		//System.out.println(ssECI.searchCategories().toString());
		
		int numeroCategorias = 5;
		Assert.assertEquals(numeroCategorias, ssECI.searchCategories().size());
	}
	
	@Test
	public void deberiaConsultarNombresDeCategoriasActivas() {
		//System.out.println("---Consultar Nombre Categorías Activas---");
		
		String salidaEsperada = "[Laboratorios, Electronica, Deportes]"; 
		Assert.assertEquals(salidaEsperada, ssECI.searchActiveCategoryNames().toString());
	}
	
	@Test
	public void deberiaConsultarCategoriasActivas() {
		int numeroCategoriasActivas = 3;
		Assert.assertEquals(numeroCategoriasActivas, ssECI.searchActiveCategories().size());
	}
	
	@Test
	public void deberiaConsultarCategoriasPorNombre() {
		String salidaEsperada = "Category [id=3, name=Textos, description=Libros, guias, manuales, etc. para clases teoricas, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t"; 
		Assert.assertEquals(salidaEsperada, ssECI.searchCategoriesByName("Textos").get(0).toString());
	}
	
	@Test
	public void deberiaCrearCategoria() {
		try {
			ssECI.crearNuevaCategoria("Implementos de estudio", "Utiles como cuadernos, hojas, reglas, lapiceros y demás implementos de estudio", "Activo");
		} catch (ExceptionServicioSolidaridadECI e) {
			Assert.assertTrue(false);
		}
		String salidaEsperada = "Category [id=7, name=Implementos de estudio, description=Utiles como cuadernos, hojas, reglas, lapiceros y demás implementos de estudio, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t";
		Assert.assertEquals(salidaEsperada, ssECI.searchCategoriesByName("Implementos de estudio").get(0).toString());
		
		Category categoria = ssECI.searchCategoriesByName("Implementos de estudio").get(0);
		ssECI.eliminarCategoria(categoria);
	}
	
	@Test
	public void deberiaActualizarDatosCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Laboratorios", "Labs", "Implementos necesarios en los labs", "Inactivo");
		
		String salidaEsperada = "Category [id=1, name=Labs, description=Implementos necesarios en los labs, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t"; 
		Assert.assertEquals(salidaEsperada, ssECI.searchCategoriesByName("Labs").get(0).toString());
		
		ssECI.actualizarCategoria("Labs", "Laboratorios", "Implementos de seguridad para practicas de laboratorio", "Activo");
	}
	
	@Test
	public void deberiaActualizarNombreCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "Electronica_v2", "", "");
		
		String salidaEsperada = "Category [id=2, name=Electronica_v2, description=Implmentos de electronica, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t"; 
		Assert.assertEquals(salidaEsperada, ssECI.searchCategoriesByName("Electronica_v2").get(0).toString());
		
		ssECI.actualizarCategoria("Electronica_v2", "Electronica", "", "");
	}
	
	@Test
	public void deberiaActualizarDescripcionCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "", "Implementos de las materias relacionadas con Electrónica", "");
		
		String salidaEsperada = "Category [id=2, name=Electronica, description=Implementos de las materias relacionadas con Electrónica, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t";
		Assert.assertEquals(salidaEsperada, ssECI.searchCategoriesByName("Electronica").get(0).toString());
		
		ssECI.actualizarCategoria("Electronica", "", "Implmentos de electronica", "");
	}
	
	@Test
	public void deberiaActualizarEstadoCategoria() throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria("Electronica", "", "", "Inactivo");
		
		String salidaEsperada = "Category [id=2, name=Electronica, description=Implmentos de electronica, creationDate=" + LocalDate.now() + ", state=Inactivo, modifyDate=" + LocalDate.now() + "]\n\t";
		Assert.assertEquals(salidaEsperada, ssECI.searchCategories().get(1).toString());
		
		ssECI.actualizarCategoria("Electronica", "", "", "Activo");
	}
	
	@Test
	public void deberiaEliminarCategorias() {
		try {
			ssECI.crearNuevaCategoria("Implementos de Papelería", "Utiles como cuadernos, hojas, lapiceros y demás implementos de papelería", "Activo");
		} catch (ExceptionServicioSolidaridadECI e) {
			Assert.assertTrue(false);
		}
		Category categoria = ssECI.searchCategoriesByName("Implementos de Papelería").get(0);
		ssECI.eliminarCategoria(categoria);
		
		String salidaEsperada = "[]";
		Assert.assertEquals(salidaEsperada, ssECI.searchCategoriesByName("Implementos de Papelería").toString());
	}
	
	@Test
	public void deberiaConsultarNecesidades() {
		//System.out.println("---Necesidades---");
		//System.out.println(ssECI.consultarNecesidades().toString());
		int numeroNecesidades = 1;
		Assert.assertEquals(numeroNecesidades, ssECI.consultarNecesidades().size());
	}
	
	/*@Test
	public void deberiaEliminarLosRegistrosDeLasTablas() {
		ssECI.limpiarTablas();
		Assert.assertEquals("[]", ssECI.consultarNecesidades().toString());
		Assert.assertEquals("[]", ssECI.searchCategories().toString());

		//Assert.assertEquals("[]", ssECI.searchCategories().toString());
	}*/

}