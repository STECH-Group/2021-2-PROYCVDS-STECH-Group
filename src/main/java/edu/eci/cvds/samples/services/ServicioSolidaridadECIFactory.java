package edu.eci.cvds.samples.services;

import static com.google.inject.Guice.createInjector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;

import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.persistence.mybaties.*;
import edu.eci.cvds.samples.services.impl.ServicioSolidaridadECIImpl;

public class ServicioSolidaridadECIFactory {
	
	private static ServicioSolidaridadECIFactory instance = new ServicioSolidaridadECIFactory();
	private static Injector injector;
	//private static Optional<Injector> optInjector;
	
	private Injector myBatisInjector(String env, String pathResource) {
	       return createInjector(new XMLMyBatisModule() {
	           @Override
	           protected void initialize() {
	               install(JdbcHelper.PostgreSQL);
	               setClassPathResource("mybatis-config.xml");
	               bind(ServicioSolidaridadECI.class).to(ServicioSolidaridadECIImpl.class);
	               bind(CategoryDAO.class).to(MyBatisCategoryDAO.class);
	               bind(UserDAO.class).to(MyBatisUserDAO.class);   
	           }
	       });
	   }
	/**
	private ServicioSolidaridadECIFactory() {
		optInjector = Optional.empty();
	}
	
	
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
			catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}*/
	
	public ServicioSolidaridadECI getServicioSolidaridadECI() {
		return injector.getInstance(ServicioSolidaridadECI.class);
	}

	public static ServicioSolidaridadECIFactory getInstance() {
		return instance;
	}
}