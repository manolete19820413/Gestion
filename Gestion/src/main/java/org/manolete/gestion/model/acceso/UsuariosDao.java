package org.manolete.gestion.model.acceso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "usuariosDao")
public class UsuariosDao {
	
	private EntityManager entityManager;	
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Cacheable("usuarios")
	public List<Usuario> findAll() {
		System.out.println("Usuarios.findAll");
		return this.entityManager.createQuery("select u from Usuario u").getResultList();
	}

}
