package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.*;

import org.apache.ibatis.annotations.One;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExceptionServicioSolidaridadECI;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;

@ManagedBean(name="administratorBean")
@SessionScoped
public class AdministratorBean extends BasePageBean implements Serializable{
	
	private String name;
	private String desc;
	private String state;
	private Category category;
	
	@Inject
	private ServicioSolidaridadECI ssECI;
	
	public List<Category> searchCategories(){
		return ssECI.searchCategories();
	}
	
	public List<Category> searchActiveCategories(){
		return ssECI.searchActiveCategories();
	}
	
	public List<String> searchActiveCategoryNames(){
		return ssECI.searchActiveCategoryNames();
	}
	
	public List<String> searchCategoryNames(){
		return ssECI.searchCategoryNames();
	}
	
	public void newCategory(String name, String desc, String state) throws ExceptionServicioSolidaridadECI {
		ssECI.crearNuevaCategoria(name, desc, state);
	}
	
	public void updateCategory(String oName, String nName, String desc, String state) throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria(oName, nName, desc, state);
	}
	
	public void deleteCategory() {
		System.out.println("Esta es la categoria que da null  "+ getCategory().toString());
		ssECI.eliminarCategoria(getCategory());
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}