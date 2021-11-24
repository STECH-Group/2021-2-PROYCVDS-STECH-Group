package edu.eci.cvds.samples.persistence.mybaties.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Need;

public interface AnswerNeedMapper {
	
	public void regiterAnswerNeed(@Param ("name") String name,
																@Param ("resp") String response,
																@Param ("need") Need need);
	
	public void deleteAnswersNeeds();
	
	public void restartSequenceAnswerNeeds();

}