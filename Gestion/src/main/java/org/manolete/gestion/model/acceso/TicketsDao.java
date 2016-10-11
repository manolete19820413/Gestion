package org.manolete.gestion.model.tickets;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "ticketsDao")
public class TicketsDao {
	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Ticket> findAll() {
		List<Ticket> tickets = this.entityManager.createQuery("select t from Ticket t").getResultList();
		
		return tickets;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}