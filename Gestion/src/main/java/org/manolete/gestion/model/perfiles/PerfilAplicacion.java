package org.manolete.gestion.model.perfiles;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.manolete.gestion.model.usuarios.Usuario;

@Entity
@Table(name = "perfiles_aplicaciones")
public class PerfilAplicacion implements Serializable {
	
	@EmbeddedId
	private PerfilAplicacionId id;
	// private Perfil perfil;
	// private Aplicacion aplicacion;
	private Date asignado;
	private Usuario asignado_por;
	
	private static final long serialVersionUID = 1L;
	
	public PerfilAplicacionId getId() {
		return id;
	}
	
	/*
	public Perfil getPerfil() {
		return perfil;
	}
	*/
	
	/*
	@ManyToOne
	@MapsId("aplicacion")
	@JoinColumn(name = "aplicacion")
	public Aplicacion getAplicacion() {
		return aplicacion;
	}
	*/
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	public Date getAsignado() {
		return asignado;
	}
	
	@ManyToOne
	@JoinColumn(name = "asignado_por")
	public Usuario getAsignado_por() {
		return asignado_por;
	}
	
	public void setId(PerfilAplicacionId id) {
		this.id = id;
	}
	
	/*
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	*/
	/*
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	*/
	public void setAsignado(Date asignado) {
		this.asignado = asignado;
	}
	
	public void setAsignado_por(Usuario asignado_por) {
		this.asignado_por = asignado_por;
	}
}