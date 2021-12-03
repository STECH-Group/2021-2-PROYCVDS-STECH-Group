package edu.eci.cvds.samples.persistence.mybaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.mail.imap.protocol.ID;

import edu.eci.cvds.samples.entities.Need;

public interface NeedMapper {
	
	public List<Need> searchNeeds();
	
	public Need searchNeedsById(@Param ("Id") int id);
	
	public List<Need> searchNeedsByUser(@Param ("Name") String name);
	
	public List<Need> searchActiveOrInProcessNeeds();
	
	public List<Need> needsReport();
	
	public void registerNeed(@Param ("Cat") String category,
			@Param ("Name") String name, 
			@Param ("Desc") String description,
			@Param ("Urg") int urgency,
			@Param ("State") String state);
	
	public void updateStateNeed(@Param ("Id") int idNeed, 
			@Param ("State") String state);
	
	public void deleteNeedById(@Param ("Id") int idNeed);
	
	public void deleteNeeds();
	
	public void restartSequenceNeeds();
	
}