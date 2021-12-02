package edu.eci.cvds.samples.persistence.mybaties;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Reporte;
import edu.eci.cvds.samples.persistence.ReporteDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.ReporteMapper;

public class MyBatisReporteDAO implements ReporteDAO{
	
	@Inject
	private ReporteMapper reporteMapper;

	@Override
	public List<Reporte> valoresReporteNecesidades() {
		return reporteMapper.needsReportValuesForGraffic();
	}

	@Override
	public List<Reporte> valoresReporteOfertas() {
		return reporteMapper.offersReportValuesForGraffic();
	}

	@Override
	public List<Reporte> reporteCategorias() {
		return reporteMapper.categoriesReport();
	}

}