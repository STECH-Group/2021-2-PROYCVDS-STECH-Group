package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;

public class Main {
	
	public static void main(String[] args) throws ExceptionServicioSolidaridadECI{
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Laboratorios", "Implementos de seguridad para practicas de laboratorio", "Activo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Electronica", "Implmentos de electronica", "Activo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Textos", "Libros, guias, manuales, etc. para clases teoricas", "Inactivo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Deportes", "Equipo de practica para los integrantes de los equipos de la Escuela", "Activo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Expresión Gráfica", "Instrumentos de dibujo para EGR", "Inactivo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().actualizarCategoria("Expresión Gráfica", "", "", "Activo");
		//System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().searchCategories());
		//System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().searchActiveCategoryNames());
		//System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().reporteDeNecesidades());
		System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().reporteRespuestas());
		System.exit(0);
	}
}