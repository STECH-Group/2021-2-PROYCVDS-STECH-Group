package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;

public class Main {
	
	public static void main(String[] args) throws ExceptionServicioSolidaridadECI{
		System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().searchCategories());
		System.exit(0);
	}
}
