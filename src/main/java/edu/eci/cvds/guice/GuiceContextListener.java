package edu.eci.cvds.guice;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.samples.persistence.*;
import edu.eci.cvds.samples.persistence.mybaties.*;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;
import edu.eci.cvds.samples.services.impl.ServicioSolidaridadECIImpl;


public class GuiceContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                bind(ServicioSolidaridadECI.class).to(ServicioSolidaridadECIImpl.class);
	            bind(CategoryDAO.class).to(MyBatisCategoryDAO.class);
	            bind(UserDAO.class).to(MyBatisUserDAO.class);
	            bind(NeedDAO.class).to(MyBatisNeedDAO.class);
	            bind(OfferDAO.class).to(MyBatisOfferDAO.class);
	            bind(AnswerNeedDAO.class).to(MyBatisAnswerNeedDAO.class);
	            bind(AnswerOfferDAO.class).to(MyBatisAnswerOfferDAO.class);
	            bind(ReporteDAO.class).to(MyBatisReporteDAO.class);
            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}