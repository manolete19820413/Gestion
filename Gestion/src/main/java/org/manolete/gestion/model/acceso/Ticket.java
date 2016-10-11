package org.manolete.gestion.model.acceso;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
	
	private String id;
	private Date login;
	private Usuario usuario;

	private static final long serialVersionUID = -927258552204184309L;
	
	@Id
	@Column(name = "usuario", length = 20, nullable = false)
	public String getId() {
		return id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	public Date getLogin() {
		return login;
	}
	
	@OneToOne
	@JoinColumn(name = "usuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLogin(Date login) {
		this.login = login;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}