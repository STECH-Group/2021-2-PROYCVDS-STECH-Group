package edu.eci.cvds.samples.persistence.mybaties;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Need;
import edu.eci.cvds.samples.entities.User;
import edu.eci.cvds.samples.persistence.AnswerNeedDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.AnswerNeedMapper;
import edu.eci.cvds.samples.persistence.mybaties.mappers.UserMapper;

public class MyBatisAnswerNeedDAO implements AnswerNeedDAO{
	
	@Inject
	private AnswerNeedMapper an;
	
	@Inject
	private UserMapper userMapper;

	@Override
	public void registrarRespuestaNecesidad(String respuesta, Need necesidad) {
		Subject user = SecurityUtils.getSubject();
		User user2 = userMapper.searchNameUserByMail(user.getSession().getAttribute("mail").toString());
		an.regiterAnswerNeed(user2.getName(), respuesta, necesidad);
	}

	@Override
	public void eliminarRespuestasNecesidades() {
		an.deleteAnswersNeeds();
		an.restartSequenceAnswerNeeds();
	}

}