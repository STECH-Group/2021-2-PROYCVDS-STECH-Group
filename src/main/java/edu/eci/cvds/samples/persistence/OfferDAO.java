package edu.eci.cvds.samples.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Offer;

public interface OfferDAO {
	
	public List<Offer> consultarOfertas();
	
	public List<Offer> consultarOfertasActivasOEnProceso();
	
	public void nuevaOferta(String category, String description, String state) throws PersistenceException;
	
	public void actualizarEstadoOferta(int id, String state) throws PersistenceException;
	
	public void eliminarOfertaPorId(int id) throws PersistenceException;
	
	public void eliminarOfertas();

}