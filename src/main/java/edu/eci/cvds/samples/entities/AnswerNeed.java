package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class AnswerNeed implements Serializable{
	
	private int id;
	private String name;
	private String response;
	private Date creationDate;
	private int need;
	
	public AnswerNeed(int id, String name, String response, Date creationDate, int need) {
		super();
		this.id = id;
		this.name = name;
		this.response = response;
		this.creationDate = creationDate;
		this.need = need;
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
	public int getNeed() {
		return need;
	}
	public void setNeed(int need) {
		this.need = need;
	}
	@Override
	public String toString() {
		return "AnswerNeed [id=" + id + ", name=" + name + ", response=" + response + ", creationDate=" + creationDate
				+ ", need=" + need + "]";
	}

}