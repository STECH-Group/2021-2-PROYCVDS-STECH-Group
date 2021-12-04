package edu.eci.cvds.samples.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Offer;

public interface OfferDAO {
	
	public List<Offer> consultarOfertas();
	
	public Offer consultarOfertasPorId(int id);
	
	public List<Offer> consultarOfertasActivasOEnProceso();
	
	public List<Offer> consultarOfertasPorUsuario() throws PersistenceException;
	
	public List<Offer> reporteOfertas();
	
	public void nuevaOferta(String category, String description, String state) throws PersistenceException;
	
	public void actualizarEstadoOferta(Offer offer, String state) throws PersistenceException;
	
	public void eliminarOfertaPorId(int id) throws PersistenceException;
	
	public void eliminarOfertas();

}