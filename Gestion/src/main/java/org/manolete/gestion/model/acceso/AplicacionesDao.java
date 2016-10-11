package org.manolete.gestion.model.aplicaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "aplicacionesDao")
public class AplicacionesDao {

	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Aplicacion> findAll() {
		List<Aplicacion> aplicaciones = this.entityManager.createQuery("select a from Aplicacion a").getResultList();
		
		return aplicaciones;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
}