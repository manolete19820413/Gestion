package org.manolete.gestion.model.aplicaciones;

import java.util.ArrayList;
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
	public List<IAplicacion> findAll() {
		List<IAplicacion> salida = new ArrayList<>();
		List<Aplicacion> aplicaciones = this.entityManager.createQuery("select a from Aplicacion a").getResultList();
		
		for (Aplicacion aplicacion : aplicaciones) {
			salida.add(new IAplicacionImpl(aplicacion));
		}
		
		return salida;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<IAplicacion> findPerfilesAplicaciones(String codigoApp) {
		List<IAplicacion> salida = new ArrayList<>();
		List<Aplicacion> aplicaciones = this.entityManager.createQuery("select pa from PerfilAplicacion pa where codigo = :codigo").getResultList();
		
		for (Aplicacion aplicacion : aplicaciones) {
			salida.add(new IAplicacionImpl(aplicacion));
		}
		
		return salida;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
}