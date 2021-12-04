package edu.eci.cvds.samples.persistence.mybaties;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Offer;
import edu.eci.cvds.samples.entities.User;
import edu.eci.cvds.samples.persistence.OfferDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.*;

public class MyBatisOfferDAO implements OfferDAO{
	
	@Inject
	private OfferMapper offerMapper;
	
	@Inject
	private UserMapper userMapper;

	@Override
	public List<Offer> consultarOfertas() {
		return offerMapper.searchOffers();
	}
	
	@Override
	public Offer consultarOfertasPorId(int id) {
		return offerMapper.searchOfferById(id);
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
				User user2 = userMapper.searchNameUserByMail(user.getSession().getAttribute("mail").toString());
				offerMapper.newOffer(category, user2.getName(), description, state);				
			}
		} catch(PersistenceException e) {
	        throw new PersistenceException("Error al crear la oferta, la categoría no se esta activa o no está registrada",e);
		}		
	}

	@Override
	public void actualizarEstadoOferta(Offer offer, String state) throws PersistenceException {
		try {	
			offerMapper.updateStateOffer(offer.getId(), state);
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

	@Override
	public List<Offer> consultarOfertasPorUsuario() throws PersistenceException {
		try {
			Subject user = SecurityUtils.getSubject();
			User user2 = userMapper.searchNameUserByMail(user.getSession().getAttribute("mail").toString());
			return offerMapper.searchOffersByUser(user2.getName());
		} catch(PersistenceException e) {
	        throw new PersistenceException("El usuario no se encuentra registrado en la base de datos",e);
		}
	}

	@Override
	public List<Offer> reporteOfertas() {
		return offerMapper.offersReport();
	}

}
