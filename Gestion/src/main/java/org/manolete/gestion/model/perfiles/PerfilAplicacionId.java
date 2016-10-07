package org.manolete.gestion.model.perfiles;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PerfilAplicacionId implements Serializable {
	
	private String perfil;
	private String aplicacion;
	
	private static final long serialVersionUID = -1288164248959004449L;
	
	@Basic
	@Column(length = 75)
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil_id) {
		this.perfil = perfil_id;
	}
	
	@Basic
	@Column(length = 5)
	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion_id) {
		this.aplicacion = aplicacion_id;
	}	
}
