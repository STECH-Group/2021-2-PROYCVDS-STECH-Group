package edu.eci.cvds.samples.persistence.mybaties;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Offer;
import edu.eci.cvds.samples.entities.User;
import edu.eci.cvds.samples.persistence.AnswerOfferDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.AnswerOfferMapper;
import edu.eci.cvds.samples.persistence.mybaties.mappers.UserMapper;

public class MyBatisAnswerOfferDAO implements AnswerOfferDAO{
	
	@Inject
	private AnswerOfferMapper ao;
	
	@Inject
	private UserMapper userMapper;

	@Override
	public void registrarRespuestaOferta(String respuesta, Offer oferta) {
		Subject user = SecurityUtils.getSubject();
		User user2 = userMapper.searchNameUserByMail(user.getSession().getAttribute("mail").toString());
		ao.regiterAnswerOffer(user2.getName(), respuesta, oferta);
	}

	@Override
	public void eliminarRespuestasOfertas() {
		ao.deleteAnswersOffers();
		ao.restartSequenceAnswerOffers();
	}

}