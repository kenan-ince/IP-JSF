package controller;

import DAO.CategoryDAO;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
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
		this.dao.create(entity);
		this.entity = new Category();
	}
	
	public void delete(Category c) {
		this.dao.delete(c);
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
		this.list = this.dao.findAll();
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public Category findById(int id) {
		return  this.dao.findById(id);
	}
}
