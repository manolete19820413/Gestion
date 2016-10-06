package org.manolete.gestion.model.perfiles;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.manolete.gestion.model.usuarios.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "perfilesDao")
public class PerfilesDao {
	
	private EntityManager entityManager;	
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return this.entityManager.createQuery("select p from Perfil p").getResultList();
	}

}
