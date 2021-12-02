package edu.eci.cvds.samples.persistence;

import java.util.List;

import edu.eci.cvds.samples.entities.Reporte;

public interface ReporteDAO {
	
	public List<Reporte> valoresReporteNecesidades();
	
	public List<Reporte> valoresReporteOfertas();
	
	public List<Reporte> reporteCategorias();
	
	public List<Reporte> reporteRespuestas();

}