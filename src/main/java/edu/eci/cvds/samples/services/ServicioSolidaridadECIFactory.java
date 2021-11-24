package edu.eci.cvds.samples.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;
import com.google.inject.Injector;

import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.persistence.mybaties.*;
import edu.eci.cvds.samples.services.impl.ServicioSolidaridadECIImpl;

public class ServicioSolidaridadECIFactory {
	
	private static ServicioSolidaridadECIFactory instance = new ServicioSolidaridadECIFactory();
	private static Optional<Injector> optInjector;
	
	private Injector myBatisInjector(String env, String pathResource) {
	       return createInjector(new XMLMyBatisModule() {
	           @Override
	           protected void initialize() {
	        	   setEnvironmentId(env);
	        	   setClassPathResource(pathResource);
	               bind(ServicioSolidaridadECI.class).to(ServicioSolidaridadECIImpl.class);
	               bind(CategoryDAO.class).to(MyBatisCategoryDAO.class);
	               bind(UserDAO.class).to(MyBatisUserDAO.class);
	               bind(NeedDAO.class).to(MyBatisNeedDAO.class);
	               bind(OfferDAO.class).to(MyBatisOfferDAO.class);
	               bind(AnswerNeedDAO.class).to(MyBatisAnswerNeedDAO.class);
		           bind(AnswerOfferDAO.class).to(MyBatisAnswerOfferDAO.class);
	           }
	       });
	   }
	
	private ServicioSolidaridadECIFactory() {
		optInjector = Optional.empty();
	}

	public ServicioSolidaridadECI getServicioSolidaridadECI() {
		if (!optInjector.isPresent()) {
	           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
	       }
		
		return optInjector.get().getInstance(ServicioSolidaridadECI.class);
	}
	
	public ServicioSolidaridadECI getServicioSolidaridadECITesting() {
		if (!optInjector.isPresent()) {
	           optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
	       }
		
		return optInjector.get().getInstance(ServicioSolidaridadECI.class);
	}
	
	public static ServicioSolidaridadECIFactory getInstance() {
		return instance;
	}
}