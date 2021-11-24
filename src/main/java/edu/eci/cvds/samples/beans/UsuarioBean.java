package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList; 

import javax.faces.bean.*;
import com.google.inject.Inject;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;

import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ServicioSolidaridadECI;


@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean extends BasePageBean implements Serializable {
	
	private String cat;
	private String desc;
	private String state;
	private int urgencia;
	private Need needUpdate;
	private Offer offerUpdate;
	private Need need;
	private Offer offer;
	
	@Inject
	private ServicioSolidaridadECI ssECI;
	
	public List<Offer> searchActiveOrInProcessOffers() {
		return ssECI.consultaOfertasActivasOEnProceso();
	}
	
	public List<Need> searchActiveOrInProcessNeeds() {
		return ssECI.consultaNecesidadesActivasOEnProceso();
	}
	
	public List<Offer> searchOffersByUser() {
		return ssECI.consultaOfertasPorUsuario();
	}
	
	public List<Need> searchNeedsByUser() {
		
		List<Need> categories = new ArrayList<Need>();
		Subject user = SecurityUtils.getSubject();
		if (user.hasRole("Administrador")) {
            categories = searchNeeds();
		} else {
			categories = ssECI.consultarNecesidadesPorUsuario();
		}
		return categories;
	}
	
	public List<Offer> searchOffers() {
		return ssECI.consultaOfertas();
	}
	
	public List<Need> searchNeeds() {
		return ssECI.consultarNecesidades();
	}
	
	public void newOffer(String category, String description, String state) {
		ssECI.nuevaOferta(category, description, state);
	}
	
	public void registerNeed(String category, String description, int urgency, String state) {
		ssECI.registrarNecesidad(category, description, urgency, state);
	}
	
	public void updateStateOffer(String state) {
		ssECI.actualizarEstadoOferta(getOfferUpdate(), state);
	}
	
	public void updateStateNeed(String state) {
		ssECI.actualizarEstadoNecesidad(getNeedUpdate(), state);
	}
	
	public void registerAnswerNeed(String resp, Need need) {
		ssECI.registrarRespuestaNecesidad(resp, need);
	}
	
	public void registerAnswerOffer(String resp, Offer offer) {
		ssECI.registrarRespuestaOferta(resp, offer);
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(int urgencia) {
		this.urgencia = urgencia;
	}

	public Need getNeedUpdate() {
		return needUpdate;
	}

	public void setNeedUpdate(Need needUpdate) {
		this.needUpdate = needUpdate;
	}

	public Offer getOfferUpdate() {
		return offerUpdate;
	}

	public void setOfferUpdate(Offer offerUpdate) {
		this.offerUpdate = offerUpdate;
	}

	public Need getNeed() {
		return need;
	}

	public void setNeed(Need need) {
		this.need = need;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public ServicioSolidaridadECI getSsECI() {
		return ssECI;
	}

	public void setSsECI(ServicioSolidaridadECI ssECI) {
		this.ssECI = ssECI;
	}

}