package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Reporte implements Serializable{
	
	private String estado;
	private int cantidad;
	
	public Reporte(String estado, int cantidad) {
		super();
		this.estado = estado;
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCatidad() {
		return cantidad;
	}
	public void setCatidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Reporte [estado=" + estado + ", cantidad=" + cantidad + "]";
	}

}