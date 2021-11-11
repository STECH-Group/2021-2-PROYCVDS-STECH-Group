package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import javax.faces.bean.*;
import com.google.inject.Inject;

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
		return ssECI.consultarNecesidadesPorUsuario();
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
		System.out.println("Categoria " +category + "Tipo " + category.getClass());
		System.out.println("Descripcion " + description + "Tipo " + description.getClass());
		System.out.println("Urgencia " + urgency );
		System.out.println("Estado  " + state + "Tipo " + state.getClass());
		ssECI.registrarNecesidad(category, description, urgency, state);
	}
	
	public void updateStateOffer(String state) {
		ssECI.actualizarEstadoOferta(getOfferUpdate(), state);
	}
	
	public void updateStateNeed(String state) {
		ssECI.actualizarEstadoNecesidad(getNeedUpdate(), state);
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