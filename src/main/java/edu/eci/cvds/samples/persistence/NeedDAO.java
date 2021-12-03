package edu.eci.cvds.samples.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Need;

public interface NeedDAO {
	
	public List<Need> consultarNecesidades();
	
	public Need consultarNecesidadesPorId(int id);
	
	public List<Need> consultarNecesidadesPorUsuario() throws PersistenceException;
	
	public List<Need> consultarNecesidadesActivasOEnProceso() throws PersistenceException;
	
	public List<Need> reporteNecesidades();
	
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException;
	
	public void actualizarEstadoNecesidad(Need need, String state) throws PersistenceException;
	
	public void eliminarNecesidadPorId(int id) throws PersistenceException;
	
	public void eliminarNecesidades();
	
}