package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;

@ManagedBean(name="administratorBean")
@ApplicationScoped
public class AdministratorBean extends BasePageBean implements Serializable{
	
	private String name;
	private String desc;
	private String state;
	
	@Inject
	private ServicioSolidaridadECI ssECI;
	
	public List<Category> consultarCategories(){
		return ssECI.searchCategories();
	}
	
	public void newCategory(String name, String desc, String state) throws ExceptionServicioSolidaridadECI {
		ssECI.crearNuevaCategoria(name, desc, state);
	}
	
	public void updateCategory(String oName, String nName, String desc, String state) throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria(oName, nName, desc, state);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
