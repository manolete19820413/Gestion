package org.manolete.gestion.model.perfiles;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PerfilAplicacionId implements Serializable {
	
	private String perfil;
	private String aplicacion;
	
	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(length = 75)
	public String getPerfil() {
		return perfil;
	}
	
	@Basic
	@Column(length = 5)
	public String getAplicacion() {
		return aplicacion;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
}
