package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Offer;

public interface AnswerOfferDAO {
	
	public void registrarRespuestaOferta(String respuesta, Offer oferta);
	
	public void eliminarRespuestasOfertas();

}