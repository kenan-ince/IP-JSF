package DAO;

import entity.Category;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class CategoryDAO extends BaseFacade {

	public CategoryDAO() {
		super();
	}

	public void create(Category c) {
		this.getEM().persist(c);
	}

	public List<Category> findAll() {
		Query q = this.getEM().createQuery("Select c from Category c order by c.id asc", Category.class);
		return q.getResultList();
	}

	public Category findById(int id) {
		Query q = this.getEM().createQuery("select c from Category c where c.id=:id", Category.class);
		q.setParameter("id", id);
		return (Category) q.getSingleResult();
	}

	public void delete(Category c) {
		this.getEM().remove(this.getEM().merge(c));
	}
}
