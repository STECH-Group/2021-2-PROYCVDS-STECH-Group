package edu.eci.cvds.samples.persistence.mybaties.mappers;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	public String searchNameUserByMail(@Param ("Email") String mail);

}