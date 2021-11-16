package edu.eci.cvds.samples.persistence.mybaties.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.User;

public interface UserMapper {
	
	public User searchNameUserByMail(@Param ("Email") String mail);

}