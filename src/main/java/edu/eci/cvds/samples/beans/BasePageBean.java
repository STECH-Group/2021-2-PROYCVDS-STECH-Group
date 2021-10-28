package edu.eci.cvds.samples.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.google.inject.Injector;

public abstract class BasePageBean implements Serializable{

	private Injector injector;
	
	
	public Injector getInjector() {
		if (injector == null) {
			ServletContext sContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			injector = (Injector) sContext.getAttribute(Injector.class.getName());
		}
		return injector;
	}
	
	public void setInjector(Injector injector) {
		this.injector = injector;
	}
	
	@PostConstruct
	public void init() {
		getInjector().injectMembers(this);
	}
}