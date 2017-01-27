package org.manolete.gestion.model.acceso;

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
	@Column(length = 75, nullable = false)
	public String getPerfil() {
		return perfil;
	}
	
	@Basic
	@Column(length = 5, nullable = false)
	public String getAplicacion() {
		return aplicacion;
	}
	
	public void setPerfil(String perfil_id) {
		this.perfil = perfil_id;
	}

	public void setAplicacion(String aplicacion_id) {
		this.aplicacion = aplicacion_id;
	}
	
	@Override
	public boolean equals(Object arg0) {
		boolean salida;
		
		if (arg0 instanceof PerfilAplicacionId) {
			PerfilAplicacionId argumento = (PerfilAplicacionId) arg0;
			
			salida = this.perfil.equals(argumento.perfil) && this.aplicacion.equals(argumento.aplicacion);
			
		} else {
			salida = super.equals(arg0); 
		}
		
		return salida; 
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
