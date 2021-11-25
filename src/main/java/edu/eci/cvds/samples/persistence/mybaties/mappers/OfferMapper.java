package edu.eci.cvds.samples.persistence.mybaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;

import edu.eci.cvds.samples.entities.Need;
import edu.eci.cvds.samples.entities.Offer;

public interface OfferMapper {

	public List<Offer> searchOffers();
	
	public List<Offer> searchActiveOrInProcessOffers();
	
	public List<Offer> searchOffersByUser(@Param ("Name") String name);
	
	public List<Offer> offersReport();
	
	public void newOffer(@Param ("Cat") String category,
			@Param ("Name") String name, 
			@Param ("Desc") String description,
			@Param ("State") String state);
	
	public void updateStateOffer(@Param ("Id") int idOffer, 
			@Param ("State") String state);
	
	public void deleteOffers();

	public void deleteOfferById(@Param ("idCat") int idCategory);

	public void restartSequenceOffers();
}