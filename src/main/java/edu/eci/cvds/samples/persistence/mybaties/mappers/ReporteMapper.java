package edu.eci.cvds.samples.persistence.mybaties.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Reporte;

public interface ReporteMapper {
	
	public List<Reporte> needsReportValuesForGraffic();
	
	public List<Reporte> offersReportValuesForGraffic();

}