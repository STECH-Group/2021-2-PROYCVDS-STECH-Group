package edu.eci.cvds.samples.test;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

import edu.eci.cvds.samples.beans.UsuarioBean;
import edu.eci.cvds.samples.entities.AnswerNeed;
import edu.eci.cvds.samples.entities.AnswerOffer;
import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.entities.Need;
import edu.eci.cvds.samples.entities.Offer;
import edu.eci.cvds.samples.entities.Reporte;
import edu.eci.cvds.samples.entities.User;
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
		Category categoria = new Category(8, "Otros", "Productos de otras categor??as", Date.valueOf(LocalDate.now()), "Activo", Date.valueOf(LocalDate.now()));
		Assert.assertEquals(8, categoria.getId());
		Assert.assertEquals("Otros", categoria.getName());
		Assert.assertEquals("Productos de otras categor??as", categoria.getDescription());
		Assert.assertEquals(java.sql.Date.valueOf(LocalDate.now()), categoria.getCreationDate());
		Assert.assertEquals("Activo", categoria.getState());
		Assert.assertEquals(java.sql.Date.valueOf(LocalDate.now()), categoria.getModifyDate());
	}
	
	@Test
	public void deberiaCrearCategoria() {
		try {
			ssECI.crearNuevaCategoria("Implementos de estudio", "Utiles como cuadernos, hojas, reglas, lapiceros y dem??s implementos de estudio", "Activo");
		} catch (ExceptionServicioSolidaridadECI e) {
			Assert.assertTrue(false);
		}
		String salidaEsperada = "Category [id=7, name=Implementos de estudio, description=Utiles como cuadernos, hojas, reglas, lapiceros y dem??s implementos de estudio, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t";
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
		ssECI.actualizarCategoria("Electronica", "", "Implementos de las materias relacionadas con Electr??nica", "");
		
		String salidaEsperada = "Category [id=2, name=Electronica, description=Implementos de las materias relacionadas con Electr??nica, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t";
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
			ssECI.crearNuevaCategoria("Implementos de Papeler??a", "Utiles como cuadernos, hojas, lapiceros y dem??s implementos de papeler??a", "Activo");
		} catch (ExceptionServicioSolidaridadECI e) {
			Assert.assertTrue(false);
		}
		Category categoria = ssECI.searchCategoriesByName("Implementos de Papeler??a").get(0);
		ssECI.eliminarCategoria(categoria);
		
		String salidaEsperada = "[]";
		Assert.assertEquals(salidaEsperada, ssECI.searchCategoriesByName("Implementos de Papeler??a").toString());
	}
	
	@Test
	public void deberiaConsultarNecesidades() {
		int numeroNecesidades = 5;
		Assert.assertEquals(numeroNecesidades, ssECI.consultarNecesidades().size());
	}
	
	@Test
	public void deberiaConsultarNecesidadesPorId() {
		String salidaEsperada = "Need [id=3, category=Expresi??n Gr??fica, name=Jos?? Gamboa, description=Necesito tabla de dibujo para la clase, urgency=5, creationDate=" + LocalDate.now() + ", state=Activo, modifyDate=" + LocalDate.now() + "]\n\t";
		Assert.assertEquals(salidaEsperada, ssECI.consultarNecesidadesPorId(3).toString());
	}
	
	@Test
	public void deberiaCrearObjetoNecesidad() {
		Need necesidad = new Need(6, "Textos", "Jos?? Gamboa", "Necesito texto de f??sica mec??nica", 4, Date.valueOf(LocalDate.now()), "Activo", Date.valueOf(LocalDate.now()));
		Assert.assertEquals(6, necesidad.getId());
		Assert.assertEquals("Textos", necesidad.getCategory());
		Assert.assertEquals("Jos?? Gamboa", necesidad.getName());
		Assert.assertEquals("Necesito texto de f??sica mec??nica", necesidad.getDescription());
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
		
		String salidaEsperada = "Offer [id=4, category=Deportes, name=Zuly Vargas, description=Facilito la adquisici??n de Brownies Veganos, creationDate=" + LocalDate.now() + ", state=Est Prueba, modifyDate=" + LocalDate.now() + "]\n\t";
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
		Offer oferta = new Offer(6, "Expresi??n Gr??fica", "Zuly Vargas", "Regalo comp??s de precisi??n", Date.valueOf(LocalDate.now()), "Activo", Date.valueOf(LocalDate.now()));
		Assert.assertEquals(6, oferta.getId());
		Assert.assertEquals("Expresi??n Gr??fica", oferta.getCategory());
		Assert.assertEquals("Zuly Vargas", oferta.getName());
		Assert.assertEquals("Regalo comp??s de precisi??n", oferta.getDescription());
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
	
	@Test
	public void deberiaCrearObjetoAnswerOffer() {
		AnswerOffer respuestaOferta = new AnswerOffer(6, "Camilo Pichimata", "Deseo ver Bal??n de futbol", Date.valueOf(LocalDate.now()), 2);
		Assert.assertEquals(6, respuestaOferta.getId());
		Assert.assertEquals("Camilo Pichimata", respuestaOferta.getName());
		Assert.assertEquals("Deseo ver Bal??n de futbol", respuestaOferta.getResponse());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), respuestaOferta.getCreationDate());
		Assert.assertEquals(2, respuestaOferta.getOffer());
	}
	
	@Test
	public void deberiaActualizarDatosObjetoAnswerOffer() {
		AnswerOffer respuestaOferta = new AnswerOffer(6, "Andr??s Pichimata", "Deseo ver Bal??n de futbol", Date.valueOf(LocalDate.now()), 2);
		respuestaOferta.setId(6);
		respuestaOferta.setName("Camilo Pichimata");
		respuestaOferta.setResponse("Deseo obtener Bal??n de futbol");
		respuestaOferta.setCreationDate(Date.valueOf(LocalDate.now()));
		respuestaOferta.setOffer(2);
		Assert.assertEquals(6, respuestaOferta.getId());
		Assert.assertEquals("Camilo Pichimata", respuestaOferta.getName());
		Assert.assertEquals("Deseo obtener Bal??n de futbol", respuestaOferta.getResponse());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), respuestaOferta.getCreationDate());
		Assert.assertEquals(2, respuestaOferta.getOffer());
	}
	
	@Test
	public void deberiaPasarAnswerOfferAString() {
		AnswerOffer respuestaOferta = new AnswerOffer(6, "Andr??s Pichimata", "Deseo ver Bal??n de futbol", Date.valueOf(LocalDate.now()), 2);
		String salidaEsperada = "AnswerOffer [id=6, name=Andr??s Pichimata, response=Deseo ver Bal??n de futbol, creationDate=" + Date.valueOf(LocalDate.now()) + ", offer=2]";
		Assert.assertEquals(salidaEsperada, respuestaOferta.toString());
	}
	
	@Test
	public void deberiaCrearObjetoAnswerNeed() {
		AnswerNeed respuestaNecesidad = new AnswerNeed(6, "Cristian Forero", "Tengo tabla de dibujo", Date.valueOf(LocalDate.now()), 3);
		Assert.assertEquals(6, respuestaNecesidad.getId());
		Assert.assertEquals("Cristian Forero", respuestaNecesidad.getName());
		Assert.assertEquals("Tengo tabla de dibujo", respuestaNecesidad.getResponse());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), respuestaNecesidad.getCreationDate());
		Assert.assertEquals(3, respuestaNecesidad.getNeed());
	}
	
	@Test
	public void deberiaActualizarDatosObjetoAnswerNeed() {
		AnswerNeed respuestaNecesidad = new AnswerNeed(6, "Manuel Gamboa", "Tengo tabla de dibujo", Date.valueOf(LocalDate.now()), 3);
		respuestaNecesidad.setId(6);
		respuestaNecesidad.setName("Manuel Gamboa");
		respuestaNecesidad.setResponse("Tengo tabla para clase de expresi??n");
		respuestaNecesidad.setCreationDate(Date.valueOf(LocalDate.now()));
		respuestaNecesidad.setNeed(3);
		Assert.assertEquals(6, respuestaNecesidad.getId());
		Assert.assertEquals("Manuel Gamboa", respuestaNecesidad.getName());
		Assert.assertEquals("Tengo tabla para clase de expresi??n", respuestaNecesidad.getResponse());
		Assert.assertEquals(Date.valueOf(LocalDate.now()), respuestaNecesidad.getCreationDate());
		Assert.assertEquals(3, respuestaNecesidad.getNeed());
	}
	
	@Test
	public void deberiaPasarAnswerNeedAString() {
		AnswerNeed respuestaNecesidad = new AnswerNeed(6, "Manuel Gamboa", "Deseo ver Bal??n de futbol", Date.valueOf(LocalDate.now()), 2);
		String salidaEsperada = "AnswerNeed [id=6, name=Manuel Gamboa, response=Deseo ver Bal??n de futbol, creationDate=" + Date.valueOf(LocalDate.now()) + ", need=2]";
		Assert.assertEquals(salidaEsperada, respuestaNecesidad.toString());
	}
	
	@Test
	public void deberiaCrearObjetoUser() {
		User usuario = new User("andres", "Andr??s C??rdenas", "andrescardenas@hotmail.com", "asdfghjkl??", "Estudiante");
		Assert.assertEquals("andres", usuario.getUserName());
		Assert.assertEquals("Andr??s C??rdenas", usuario.getName());
		Assert.assertEquals("andrescardenas@hotmail.com", usuario.getMail());
		Assert.assertEquals("asdfghjkl??", usuario.getPasswd());
		Assert.assertEquals("Estudiante", usuario.getRol());
	}
	
	@Test
	public void deberiaActualizarDatosObjetoUser() {
		User usuario = new User("andres", "Andr??s C??rdenas", "andrescardenas@hotmail.com", "asdfghjkl??", "Estudiante");
		usuario.setUserName("Andr??s");
		usuario.setName("Camilo C??rdenas");
		usuario.setMail("andrescardenas@gmail.com");
		usuario.setPasswd("??lkjhgfdsa");
		usuario.setRol("Graduado");
		Assert.assertEquals("Andr??s", usuario.getUserName());
		Assert.assertEquals("Camilo C??rdenas", usuario.getName());
		Assert.assertEquals("andrescardenas@gmail.com", usuario.getMail());
		Assert.assertEquals("??lkjhgfdsa", usuario.getPasswd());
		Assert.assertEquals("Graduado", usuario.getRol());
	}
	
	@Test
	public void deberiaPasarUserAString() {
		User usuario = new User("andres", "Andr??s C??rdenas", "andrescardenas@hotmail.com", "asdfghjkl??", "Estudiante");
		
		String salidaEsperada = "User [userName=andres, name=Andr??s C??rdenas, mail=andrescardenas@hotmail.com, passwd=asdfghjkl??, rol=Estudiante]\n\t";
		Assert.assertEquals(salidaEsperada, usuario.toString());
	}
}