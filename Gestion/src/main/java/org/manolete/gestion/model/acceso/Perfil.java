package org.manolete.gestion.model.perfiles;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.manolete.gestion.model.usuarios.Usuario;
import org.manolete.gestion.model.usuarios.UsuarioPerfil;

@Entity
@Table(name = "perfiles")
public class Perfil implements Serializable {
	
	private String id;
	private String nombre;
	private Date modificado;
	private Usuario modificado_por;
	private List<PerfilAplicacion> perfilesAplicaciones;
	private List<UsuarioPerfil> usuariosPerfiles;
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(length = 75, nullable = false)
	public String getId() {
		return id;
	}
	
	@Basic
	@Column(length = 100, nullable = false)
	public String getNombre() {
		return nombre;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	public Date getModificado() {
		return modificado;
	}
	
	@ManyToOne
	@JoinColumn(name = "modificado_por")
	public Usuario getModificado_por() {
		return modificado_por;
	}
	
	@OneToMany(mappedBy = "perfil", fetch = FetchType.EAGER)
	public List<PerfilAplicacion> getPerfilesAplicaciones() {
		return perfilesAplicaciones;
	}
	
	@OneToMany(mappedBy = "perfil", fetch = FetchType.EAGER)
	public List<UsuarioPerfil> getUsuariosPerfiles() {
		return usuariosPerfiles;
	}
		
	public void setId(String id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}
	
	public void setModificado_por(Usuario modificado_por) {
		this.modificado_por = modificado_por;
	}
	
	public void setPerfilesAplicaciones(List<PerfilAplicacion> perfilesAplicaciones) {
		this.perfilesAplicaciones = perfilesAplicaciones;
	}

	public void setUsuariosPerfiles(List<UsuarioPerfil> usuariosPerfiles) {
		this.usuariosPerfiles = usuariosPerfiles;
	}
}
