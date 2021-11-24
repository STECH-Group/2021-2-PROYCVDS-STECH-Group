package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class AnswerOffer implements Serializable{
	
	private int id;
	private String name;
	private String response;
	private Date creationDate;
	private int offer;
	
	public AnswerOffer(int id, String name, String response, Date creationDate, int offer) {
		super();
		this.id = id;
		this.name = name;
		this.response = response;
		this.creationDate = creationDate;
		this.offer = offer;
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
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	@Override
	public String toString() {
		return "AnswerOffer [id=" + id + ", name=" + name + ", response=" + response + ", creationDate=" + creationDate
				+ ", offer=" + offer + "]";
	}

}