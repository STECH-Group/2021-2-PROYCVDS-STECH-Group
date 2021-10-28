package edu.eci.cvds.guice;

import javax.servlet.ServletContextEvent;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.samples.persistence.CategoryDAO;
import edu.eci.cvds.samples.persistence.UserDAO;
import edu.eci.cvds.samples.persistence.mybaties.MyBatisCategoryDAO;
import edu.eci.cvds.samples.persistence.mybaties.MyBatisUserDAO;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;
import edu.eci.cvds.samples.services.impl.ServicioSolidaridadECIImpl;


public class GuiceContextListener {

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
            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}