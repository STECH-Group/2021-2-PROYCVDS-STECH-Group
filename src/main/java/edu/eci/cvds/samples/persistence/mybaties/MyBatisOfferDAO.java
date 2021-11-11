package edu.eci.cvds.samples.persistence.mybaties;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Offer;
import edu.eci.cvds.samples.persistence.OfferDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.OfferMapper;

public class MyBatisOfferDAO implements OfferDAO{
	
	@Inject
	private OfferMapper offerMapper;

	@Override
	public List<Offer> consultarOfertas() {
		return offerMapper.searchOffers();
	}

	@Override
	public List<Offer> consultarOfertasActivasOEnProceso() {
		return offerMapper.searchActiveOrInProcessOffers();
	}

	@Override
	public void nuevaOferta(String category, String description, String state) throws PersistenceException {
		try {	
			Subject user = SecurityUtils.getSubject();
			if (user.hasRole("Administrador")) {
				throw new PersistenceException("El rol del usuario no tiene permiso para registrar una oferta");
			} else {
				offerMapper.newOffer(category, user.getSession().getAttribute("name").toString(), description, state);				
			}
		} catch(PersistenceException e) {
	        throw new PersistenceException("Error al crear la oferta, la categoría no se esta activa o no está registrada",e);
		}		
	}

	@Override
	public void actualizarEstadoOferta(int id, String state) throws PersistenceException {
		try {	
			offerMapper.updateStateOffer(id, state);
		} catch(PersistenceException e) {
	        throw new PersistenceException("Error al actualizar la oferta",e);
		}
	}

	@Override
	public void eliminarOfertaPorId(int id) throws PersistenceException {
		try {	
			offerMapper.deleteOfferById(id);
		} catch(PersistenceException e) {
	        throw new PersistenceException("La oferta que desea eliminar no existe",e);
		}
	}

	@Override
	public void eliminarOfertas() {
		offerMapper.deleteOffers();
		offerMapper.restartSequenceOffers();
	}

}
