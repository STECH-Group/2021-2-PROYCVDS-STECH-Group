package edu.eci.cvds.samples.persistence;

import edu.eci.cvds.samples.entities.Need;

public interface AnswerNeedDAO {
	
	public void registrarRespuestaNecesidad(String respuesta, Need necesidad);
	
	public void eliminarRespuestasNecesidades();

}