package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.exceptions.PersistenceException;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

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
	private PieChartModel pieChart;
	
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
	
	public void newCategory(String name, String desc, String state) throws ExceptionServicioSolidaridadECI, PersistenceException{
		try {
			ssECI.crearNuevaCategoria(name, desc, state);
		}catch (PersistenceException ex){
			FacesContext.getCurrentInstance().addMessage("Shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", "Error al crear la categoria, el nombre ya se encuentra en uso"));
		}
	}
	
	public void updateCategory(String oName, String nName, String desc, String state) throws ExceptionServicioSolidaridadECI {
		ssECI.actualizarCategoria(oName, nName, desc, state);
	}
	
	public void deleteCategory() {
		System.out.println("Esta es la categoria que da null  "+ getCategory().toString());
		ssECI.eliminarCategoria(getCategory());
	}
	
	public List<Need> searchNeeds(){
		return ssECI.reporteDeNecesidades();
	}
	
	public void createPieChartNeeds() {
		pieChart = new PieChartModel();
        ChartData data = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        List<Reporte> reportStates = ssECI.reporteNecesidadesGrafico();
        for(Reporte i : reportStates) {
        	values.add(i.getCatidad());
        }
        dataSet.setData(values);
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        for(Reporte i : reportStates) {
        	labels.add(i.getEstado());
        }
        data.setLabels(labels);
        pieChart.setData(data);
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
	
	public PieChartModel getPieChart() {
		return pieChart;
	}
	
	public void setPieChart(PieChartModel pieChart) {
		this.pieChart = pieChart;
	}
}