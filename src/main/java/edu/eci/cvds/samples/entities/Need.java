package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Need implements Serializable{
	
	private int id;
	private Category category;
	private User name;
	private String description;
	private int urgency;
	private Date creationDate;
	private String state;
	private Date modifyDate;
	
	public Need(int id, Category category, User name, String description, int urgency, Date creationDate,
			String state, Date modifyDate) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.description = description;
		this.urgency = urgency;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getName() {
		return name;
	}

	public void setName(User name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUrgency() {
		return urgency;
	}

	public void setUrgency(int urgency) {
		this.urgency = urgency;
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
		return "Need [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
				+ ", urgency=" + urgency + ", creationDate=" + creationDate + ", state=" + state + ", modifyDate="
				+ modifyDate + "]\n\t";
	}

}