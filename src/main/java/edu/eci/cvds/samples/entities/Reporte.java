package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Reporte implements Serializable{
	
	private String estado;
	private int cantidad;
	private int cantidad2;
	
	public Reporte(String estado, int cantidad, int cantidad2) {
		super();
		this.estado = estado;
		this.cantidad = cantidad;
		this.cantidad2 = cantidad2;
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
	public int getCantidad2() {
		return cantidad2;
	}
	public void setCantidad2(int cantidad2) {
		this.cantidad2 = cantidad2;
	}
	public void setCatidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Reporte [estado=" + estado + ", cantidad=" + cantidad + ", cantidad2=" + cantidad2 + "]";
	}
}