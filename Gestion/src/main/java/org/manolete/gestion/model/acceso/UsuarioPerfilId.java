package org.manolete.gestion.model.acceso;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioPerfilId implements Serializable {
	
	private String usuario;
	private String perfil;

	private static final long serialVersionUID = -7676152126001563944L;
	
	@Basic
	@Column(length = 20, nullable = false)
	public String getUsuario() {
		return usuario;
	}
	
	@Basic
	@Column(length = 75, nullable = false)
	public String getPerfil() {
		return perfil;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public boolean equals(Object obj) {
		boolean salida;
		
		if (obj instanceof UsuarioPerfilId) {
			UsuarioPerfilId argumento = (UsuarioPerfilId) obj;
			
			salida = this.usuario.equals(argumento.usuario) && this.perfil.equals(argumento.perfil);
		} else {
			salida = super.equals(obj);
		}
		
		return salida;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}