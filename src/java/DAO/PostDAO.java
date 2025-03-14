package DAO;

import entity.Post;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class PostDAO extends BaseFacade{

	public PostDAO() {
		super();
	}
	
	public void create(Post p) {
		this.getEM().persist(p);
	}

	public List<Post> findAll() {
		Query q = this.getEM().createQuery("Select p from Post p order by p.id asc", Post.class);
		return q.getResultList();
	}
	
	public void delete(Post c) {
		this.getEM().remove(this.getEM().merge(c));
	}

	public void update(Post entity) {
		this.getEM().persist(this.getEM().merge(entity));
	}
}
