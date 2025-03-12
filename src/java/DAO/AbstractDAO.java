/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public abstract class AbstractDAO {
	
//	@PersistenceContext(unitName = "FirstWebPU")
//	protected EntityManager em;
	
	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FirstWebPU");
		return emf.createEntityManager();
	}
}
