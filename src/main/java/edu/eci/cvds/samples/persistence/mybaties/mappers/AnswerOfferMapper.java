package edu.eci.cvds.samples.persistence.mybaties.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Offer;

public interface AnswerOfferMapper {
	
	public void regiterAnswerOffer(@Param ("name") String name,
																@Param ("resp") String response,
																@Param ("offer") int offer);
	
	public void deleteAnswersOffers();
	
	public void restartSequenceAnswerOffers();

}