package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Offer implements Serializable{
	private int id;
	private String category;
	private String name;
	private String description;
	private Date creationDate;
	private String state;
	private Date modifyDate;
	
	public Offer(int id, String category, String name, String description, Date creationDate, String state,
			Date modifyDate) {
		this.id = id;
		this.category = category;
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
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
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
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
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
		return "Offer [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
				+ ", creationDate=" + creationDate + ", state=" + state + ", modifyDate=" + modifyDate + "]";
	}
}
