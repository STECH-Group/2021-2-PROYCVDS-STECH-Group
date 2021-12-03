package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Reporte implements Serializable{
	
	private String estado;
	private int cantidad;
	private int cantidad2;
	private String responseNO;
	
	public Reporte(String estado, int cantidad, int cantidad2, String responseNO) {
		super();
		this.estado = estado;
		this.cantidad = cantidad;
		this.cantidad2 = cantidad2;
		this.responseNO = responseNO;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getCantidad2() {
		return cantidad2;
	}
	
	public void setCantidad2(int cantidad2) {
		this.cantidad2 = cantidad2;
	}
	
	public String getResponseNO() {
		return responseNO;
	}
	
	public void setResponseNO(String responseNO) {
		this.responseNO = responseNO;
	}
	
	public int getTotal() {
		return getCantidad2() + getCantidad();
	}
	
	@Override
	public String toString() {
		return "Reporte [estado=" + estado + ", cantidad=" + cantidad + ", cantidad2=" + cantidad2 + ", responseNO="
				+ responseNO + "]";
	}
}