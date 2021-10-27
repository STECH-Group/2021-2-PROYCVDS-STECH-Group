package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECIFactory;
import edu.eci.cvds.samples.services.impl.ServicioSolidaridadECIImpl;

public class Main {
	
	public static void main(String[] args) throws ExceptionServicioSolidaridadECI{
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().crearNuevaCategoria("fgdf", "jwsfdggsffgsgfseu", "sdfgs");
		//ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().actualizarCategoria("fgdf", "efjgjsfdngjs", "", "");
		System.out.println(ServicioSolidaridadECIFactory.getInstance().getServicioSolidaridadECI().searchCategories());
		System.exit(0);
	}
}