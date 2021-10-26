package edu.eci.cvds.samples.persistence.mybaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Category;

public interface CategoryMapper {
	
	public List<Category> consultarCategorias();
	
	public void newCategory(@Param ("Name") String name,
							@Param ("desc") String description,
							@Param ("State") boolean state);
	
	public void updateCategory(@Param ("nom") String name,
							@Param ("Desc") String description,
							@Param ("state") boolean state);
}