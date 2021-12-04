package edu.eci.cvds.samples.test;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.entities.Need;
import edu.eci.cvds.samples.entities.Offer;
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
		int numeroCategorias = 5;
		Assert.assertEquals(numeroCategorias, ssECI.searchCategories().size());
	}
	
	@Test
	public void deberiaConsultarNombresDeCategoriasActivas() {
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
	public void deberiaCrearObjetoCategoria() {
		Category categoria = new Category(8, "Otros", "Productos de otras categorías", Date.valueOf(LocalDate.now()), "Activo", Date.valueOf(LocalDate.now()));
		Assert.assertEquals(8, categoria.getId());
		Assert.assertEquals("Otros", categoria.getName());
		Assert.assertEquals("Productos de otras categorías", categoria.getDescription());
		Assert.assertEquals(java.sql.Date.valueOf(LocalDate.now()), categoria.getCreationDate());
		Assert.assertEquals("Activo", categoria.getState());
		Assert.assertEquals(java.sql.Date.valueOf(LocalDate.now()), categoria.getModifyDate());
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
		int numeroNecesidades = 5;
		Assert.assertEquals(numeroNecesidades, ssECI.consultarNecesidades().size());
	}
	
	@Test
	public void deberiaConsultarNecesidadesPorId() {
		String salidaEsperada = "Need [id=3, category=Expresión Gráfica, name=José Gamboa, description=Necesito tabla de dibujo para la clase, urgency=5, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t";
		Assert.assertEquals(salidaEsperada, ssECI.consultarNecesidadesPorId(3).toString());
	}
	
	@Test
	public void deberiaCrearObjetoNecesidad() {
		Need necesidad = new Need(6, "Textos", "José Gamboa", "Necesito texto de física mecánica", 4, Date.valueOf(LocalDate.now()), "Activo", Date.valueOf(LocalDate.now()));
		Assert.assertEquals(6, necesidad.getId());
		Assert.assertEquals("Textos", necesidad.getCategory());
		Assert.assertEquals("José Gamboa", necesidad.getName());
		Assert.assertEquals("Necesito texto de física mecánica", necesidad.getDescription());
		Assert.assertEquals(4, necesidad.getUrgency());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), necesidad.getCreationDate());
		Assert.assertEquals("Activo", necesidad.getState());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), necesidad.getModifyDate());
	}
	
	@Test
	public void deberiaGenerarReporteDeNecesidades() {
		List<Need> reporte = ssECI.reporteDeNecesidades();
		Assert.assertEquals("Activo", reporte.get(0).getState());
		Assert.assertEquals("Inactivo", reporte.get(reporte.size()-1).getState());
	}
	
	@Test
	public void deberiaActualizarEstadoNecesidad() {
		Need necesidad = ssECI.consultarNecesidadesPorId(2);
		ssECI.actualizarEstadoNecesidad(necesidad, "Est Prueba");
		
		String salidaEsperada = "Need [id=2, category=Deportes, name=Zuly Vargas, description=Necesito raqueta de segunda en buen estado, urgency=2, creationDate=" + LocalDate.now() + ", state=Est Prueba, modifyDate=" + LocalDate.now() + "]\n\t";
		Assert.assertEquals(salidaEsperada, ssECI.consultarNecesidadesPorId(2).toString());
		
		ssECI.actualizarEstadoNecesidad(necesidad, "Activo");
	}
	
	@Test
	public void deberiaConsultarNecesidadesActivasOEnProceso() {
		int numeroNecesidades = 4;
		Assert.assertEquals(numeroNecesidades, ssECI.consultaNecesidadesActivasOEnProceso().size());
	}
	
	@Test
	public void deberiaEliminarNecesidadesPorId() {
		ssECI.eliminarNecesidadPorId(6);
		int numeroNecesidades = 5;
		Assert.assertEquals(numeroNecesidades, ssECI.consultarNecesidades().size());
	}
	
	@Test
	public void deberiaConsultarOfertas() {
		int numeroOfertas = 6;
		Assert.assertEquals(numeroOfertas, ssECI.consultaOfertas().size());
	}
	
	@Test
	public void deberiaConsultarOfertasActivasOEnProceso() {
		int numeroOfertas = 3;
		Assert.assertEquals(numeroOfertas, ssECI.consultaOfertasActivasOEnProceso().size());
	}
	
	@Test
	public void deberiaGenerarReporteDeOfertas() {
		List<Offer> reporte = ssECI.reporteDeOfertas();
		Assert.assertEquals("Activo", reporte.get(0).getState());
		Assert.assertEquals("Inactivo", reporte.get(reporte.size()-1).getState());
	}

	@Test
	public void deberiaActualizarEstadoOferta() {
		Offer oferta = ssECI.consultarOfertaPorId(4);
		ssECI.actualizarEstadoOferta(oferta, "Est Prueba");
		
		String salidaEsperada = "Offer [id=4, category=Deportes, name=Zuly Vargas, description=Facilito la adquisición de Brownies Veganos, creationDate=" + LocalDate.now() + ", state=Est Prueba, modifyDate=" + LocalDate.now() + "]\n\t";
		Assert.assertEquals(salidaEsperada, ssECI.consultarOfertaPorId(4).toString());
		
		ssECI.actualizarEstadoOferta(oferta, "Inactivo");
	}
	
	@Test
	public void deberiaEliminarOfertasPorId() {
		ssECI.eliminarOfertaPorId(6);
		int numeroOfertas = 5;
		Assert.assertEquals(numeroOfertas, ssECI.consultaOfertas().size());
	}
	
	@Test
	public void deberiaCrearObjetoOferta() {
		Offer oferta = new Offer(6, "Expresión Gráfica", "Zuly Vargas", "Regalo compás de precisión", Date.valueOf(LocalDate.now()), "Activo", Date.valueOf(LocalDate.now()));
		Assert.assertEquals(6, oferta.getId());
		Assert.assertEquals("Expresión Gráfica", oferta.getCategory());
		Assert.assertEquals("Zuly Vargas", oferta.getName());
		Assert.assertEquals("Regalo compás de precisión", oferta.getDescription());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), oferta.getCreationDate());
		Assert.assertEquals("Activo", oferta.getState());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), oferta.getModifyDate());
	}
	
	@Test
	public void deberiaGenerarReporteDeOferta() {
		List<Offer> reporte = ssECI.reporteDeOfertas();
		Assert.assertEquals("Activo", reporte.get(0).getState());
		Assert.assertEquals("Inactivo", reporte.get(reporte.size()-1).getState());
	}
}