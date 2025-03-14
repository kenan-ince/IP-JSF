package controller;

import DAO.PostDAO;
import entity.Post;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PostBean implements Serializable {

	private Post entity;
	private List<Post> list;
	
	@Inject
	private PostDAO dao;

	public PostBean() {
	}
	
	public void create() {
		this.dao.create(entity);
		this.entity = new Post();
	}
	
	public void delete(Post p) {
		this.dao.delete(p);
	}
	
	public void update() {
		this.dao.update(entity);
	}
	
	public void clear() {
		this.entity = new Post();
	}

	public Post getEntity() {
		if (this.entity == null) {
			this.entity = new Post();
		}
		return entity;
	}

	public void setEntity(Post entity) {
		this.entity = entity;
	}

	public List<Post> getList() {
		this.list = this.getDao().findAll();
		return list;
	}

	public void setList(List<Post> list) {
		this.list = list;
	}

	public PostDAO getDao() {
		return dao;
	}

	public void setDao(PostDAO dao) {
		this.dao = dao;
	}
}
