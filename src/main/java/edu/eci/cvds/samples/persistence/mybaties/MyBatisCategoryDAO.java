package edu.eci.cvds.samples.persistence.mybaties;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.persistence.CategoryDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.CategoryMapper;

public class MyBatisCategoryDAO implements CategoryDAO{
	
	@Inject
	private CategoryMapper categoryMapper;
	
	public void crearCategoria(String name, String description, String state) throws PersistenceException {

		try {
		categoryMapper.newCategory(name, description, state);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al crear la categoria, el nombre ya esta en uso",e);
		}
	}

	public void actualizarCategoria(String oName, String nName, String description, String state) throws PersistenceException {

		try{
			if (nName != "") categoryMapper.updateCategoryName(oName, nName);
			if (description != "") categoryMapper.updateCategoryDescription(oName, description);
			if(state != "") categoryMapper.updateCategoryState(oName, state);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar la categoria",e);
        }
	}

	@Override
	public List<Category> consultarCategorias() {
		// TODO Auto-generated method stub
		return categoryMapper.searchCategories();
	}
}
