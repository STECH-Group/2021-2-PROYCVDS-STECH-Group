package edu.eci.cvds.samples.services;

import org.apache.ibatis.exceptions.PersistenceException;

public class ExceptionServicioSolidaridadECI extends Exception{

	public ExceptionServicioSolidaridadECI(String message, Exception ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

	public ExceptionServicioSolidaridadECI(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}