package DAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public abstract class BaseFacade {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public EntityManager getEM() {
		return this.em;
	}
}
