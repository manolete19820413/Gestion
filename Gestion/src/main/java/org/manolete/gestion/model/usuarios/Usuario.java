package org.manolete.gestion.model.usuarios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private List<UsuarioPerfil> usuariosPerfiles;

	private static final long serialVersionUID = 7712814502461676427L;
	
	@Id
	@Column(length = 20, nullable = false) 
	public String getId() {
		return id;
	}
	
	@Basic
	@Column(length = 50, nullable = false)
	public String getPassword() {
		return password;
	}
	
	@Basic
	@Column(length = 100, nullable = false)
	public String getCorreo() {
		return correo;
	}
	
	@Basic
	@Column(length = 1, insertable = false, nullable = false)
	public boolean isValidado() {
		return validado;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	public Date getModificado() {
		return modificado;
	}
	
	@Basic
	@Column(length = 20)
	public String getModificado_por() {
		return modificado_por;
	}
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	public List<UsuarioPerfil> getUsuariosPerfiles() {
		return usuariosPerfiles;
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

	public void setUsuariosPerfiles(List<UsuarioPerfil> usuariosPerfiles) {
		this.usuariosPerfiles = usuariosPerfiles;
	}
}