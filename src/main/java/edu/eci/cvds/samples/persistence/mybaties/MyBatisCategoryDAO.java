package edu.eci.cvds.samples.persistence.mybaties;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.persistence.CategoryDAO;
import edu.eci.cvds.samples.persistence.mybaties.mappers.CategoryMapper;

public class MyBatisCategoryDAO implements CategoryDAO{
	
	@Inject
	private CategoryMapper categoryMapper;
	
	@Override
	public void crearCategoria(String name, String description, String state) throws PersistenceException {
		try {
		categoryMapper.newCategory(name, description, state);
		}
		catch(PersistenceException e) {
            throw new PersistenceException("Error al crear la categoria, el nombre ya esta en uso",e);
		}
	}

	@Override
	public void actualizarCategoria(String oName, String nName, String description, String state) throws PersistenceException {

		try{
			if(description.length() != 0) categoryMapper.updateCategoryDescription(oName, description);
			if(state.length() != 0) categoryMapper.updateCategoryState(oName, state);
			if(nName.length() != 0) categoryMapper.updateCategoryName(oName, nName);
		}
        catch(PersistenceException e){
            throw new PersistenceException("Error al actualizar la categoría",e);
        }
	}

	@Override
	public List<Category> consultarCategorias() {
		return categoryMapper.searchCategories();
	}

	@Override
	public void limpiarCategorias() {
		categoryMapper.deleteAllCategories();
		categoryMapper.restartSequence();
		
	}
	
	@Override
	public void eliminarCategoria(String name, int id) throws PersistenceException{
		try{
			if(name.length() != 0) categoryMapper.deleteCategoryByName(name);
			if(id != 0) categoryMapper.deleteCategoryById(id);
		}
        catch(PersistenceException e){
            throw new PersistenceException("Error al eliminar la categoría",e);
        }
	}

	@Override
	public List<Category> consultarCategoriasActivas() {
		return categoryMapper.searchActiveCategories();
	}

	@Override
	public List<String> consultarNombresDeCategoriasActivas() {
		List<Category> listaCategorias = categoryMapper.searchActiveCategoryNames();
		List<String> lista = new ArrayList<String>() ; 
		for (Category categoria : listaCategorias) {
			 lista.add(categoria.getName());
		}
		return lista;
	}

	@Override
	public List<Category> consultarCategoriasPorNombre(String name) {
		return categoryMapper.searchCategoriesByName(name);
	}
	
	
}