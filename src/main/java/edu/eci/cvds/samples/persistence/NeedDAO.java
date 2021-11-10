package edu.eci.cvds.samples.persistence;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Need;

public interface NeedDAO {
	
	public List<Need> consultarNecesidades();
	
	public List<Need> consultarNecesidadesPorUsuario(String nombre);
	
	public void registrarNecesidad(String category,  String description, int urgency, String state) throws PersistenceException;
	
	public void actualizarEstadoNecesidad(int id, String state) throws PersistenceException;
	
	public void eliminarNecesidadPorId(int id) throws PersistenceException;
	
	public void eliminarNecesidades();

}