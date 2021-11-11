package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;
import edu.eci.cvds.samples.services.impl.ServicioSolidaridadECIImpl;

public class Main {
	
	public static void main(String[] args) throws ExceptionServicioSolidaridadECI{
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Laboratorios", "Implementos de seguridad para practicas de laboratorio", "Activo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Electronica", "Implmentos de electronica", "Activo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Textos", "Libros, guias, manuales, etc. para clases teoricas", "Inactivo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Deportes", "Equipo de practica para los integrantes de los equipos de la Escuela", "Activo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("Expresión Gráfica", "Instrumentos de dibujo para EGR", "Inactivo");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().actualizarCategoria("Expresión Gráfica", "", "", "Inactivo");
		//System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().searchCategories());
		System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().searchActiveCategoryNames());
		System.exit(0);
	}
}