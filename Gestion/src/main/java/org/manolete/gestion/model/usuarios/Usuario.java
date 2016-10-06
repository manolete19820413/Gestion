package org.manolete.gestion.model.usuarios;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	
	private String id;
	private String password;
	private String correo;
	private boolean validado;
	private Date modificado;
	private String modificado_por;

	private static final long serialVersionUID = 1L;
	
	@Id
	public String getId() {
		return id;
	}
	
	@Basic
	public String getPassword() {
		return password;
	}
	
	@Basic
	public String getCorreo() {
		return correo;
	}
	
	@Basic
	public boolean isValidado() {
		return validado;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModificado() {
		return modificado;
	}
	
	@Basic
	public String getModificado_por() {
		return modificado_por;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public void setModificado_por(String modificado_por) {
		this.modificado_por = modificado_por;
	}
}