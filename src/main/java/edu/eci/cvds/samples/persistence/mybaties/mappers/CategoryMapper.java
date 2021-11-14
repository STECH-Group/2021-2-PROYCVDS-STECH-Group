package edu.eci.cvds.samples.persistence.mybaties.mappers;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Category;

public interface CategoryMapper {
	
	public List<Category> searchCategories();
	
	public List<Category> searchActiveCategories();
	
	public List<Category> searchActiveCategoryNames();

	public List<Category> searchCategoriesByName(@Param ("Name") String name);
	
	public void newCategory(@Param ("Name") String name,
							@Param ("desc") String description,
							@Param ("State") String state);
	
	public void updateCategoryName(@Param ("Oname") String name,
							@Param ("Nnom") String newName);
	
	public void updateCategoryDescription(@Param ("Oname") String name,
								@Param ("nDesc") String description);
	
	public void updateCategoryState(@Param ("Oname") String name,
								@Param ("nState") String state);

	public void deleteAllCategories();
	
	public void deleteCategoryByName(@Param ("Name") String name);
	
	public void deleteCategoryById(@Param ("idCat") int idCategory);
	
	public void restartSequence();
	
}