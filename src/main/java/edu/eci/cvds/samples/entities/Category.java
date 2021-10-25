package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Category implements Serializable{

	private int id;
	private String name;
	private String description;
	private Date creationDate;
	private boolean state;
	private Date modifyDate;
	
	public Category() {
		
	}
	
	public Category(int id, String name, String description, Date creationDate, boolean state, Date modifyDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.state = state;
		this.modifyDate = modifyDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", name=" + name + ", description=" + description + ", creationDate="
				+ creationDate + ", state=" + state + ", modifyDate=" + modifyDate + "]" + "\n\t";
	}
}
