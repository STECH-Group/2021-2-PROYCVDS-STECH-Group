package edu.eci.cvds.samples.persistence.mybaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;

import edu.eci.cvds.samples.entities.Offer;

public interface OfferMapper {

	public List<Offer> searchOffers();
	
	public List<Offer> searchActiveOffers();
	
	public List<Offer> searchInProcessOffers();
	
	public void newOffer(@Param ("Cat") String category,
			@Param ("Name") String name, 
			@Param ("Desc") String description,
			@Param ("State") String state);
	
	public void deleteAllOffers();

	public void deleteOfferById(@Param ("idCat") int idCategory);

	public void restartSequenceOffers();
}