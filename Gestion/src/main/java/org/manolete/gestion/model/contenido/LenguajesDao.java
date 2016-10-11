package org.manolete.gestion.model.contenido;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "lenguajesDao")
public class LenguajesDao {
	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Lenguaje> findAll() {
		List<Lenguaje> lenguajes = this.entityManager.createQuery("select l from Lenguaje l").getResultList();
		
		return lenguajes;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}