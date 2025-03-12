package DAO;

import entity.Category;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class CategoryDAO {
	
	@PersistenceContext(unitName = "FirstWebPU")
	private EntityManager em;
	
//	public EntityManager getEntityManager() {
//		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("FirstWebPU");
//		return emf.createEntityManager();
//	}
	
	public void create(Category c) {
		System.out.println("----------------before persist");
		this.em.persist(c);
		System.out.println("----------------after persist");
	}

	public List<Category> findAll() {
		Query q = this.em.createQuery("Select c from Category c order by c.id asc", Category.class);
		return q.getResultList();
	}
}
