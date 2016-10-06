package org.manolete.gestion.model.aplicaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.manolete.gestion.model.usuarios.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "aplicacionesDao")
public class AplicacionesDao {

	private EntityManager entityManager;	
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return this.entityManager.createQuery("select a from Aplicacion a").getResultList();
	}
	
}
