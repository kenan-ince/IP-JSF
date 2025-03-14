package DAO;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author kenanince
 */
@Stateless
public abstract class BaseFacade {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public EntityManager getEM() {
		return this.em;
	}

//	public EntityManager getEM() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");
//		return emf.createEntityManager();
//	}
}
