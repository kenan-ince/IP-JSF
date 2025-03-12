package controller;

import DAO.CategoryDAO;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("categoryBean")
@SessionScoped
public class CategoryBean implements Serializable {

	private Category entity;
	private List<Category> list;
	
	@Inject
	private CategoryDAO dao;

	public CategoryBean() {
	}
	
	public void create() {
		this.getDao().create(entity);
		this.entity = new Category();
	}

	public Category getEntity() {
		if (this.entity == null) {
			this.entity = new Category();
		}
		return entity;
	}

	public void setEntity(Category entity) {
		this.entity = entity;
	}

	public List<Category> getList() {
		this.list = this.getDao().findAll();
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public CategoryDAO getDao() {
//		if (this.dao == null) {
//			this.dao = new CategoryDAO();
//		}
		return dao;
	}

	public void setDao(CategoryDAO dao) {
		this.dao = dao;
	}

}
