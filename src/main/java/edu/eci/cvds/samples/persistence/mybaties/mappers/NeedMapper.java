package edu.eci.cvds.samples.persistence.mybaties.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Need;

public interface NeedMapper {
	public List<Need> searchNeeds();
	
	public void registerNeed();
	
	public void updateStateNeed();
	
	public void deleteNeeds();
}
