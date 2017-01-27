package org.manolete.gestion.model.contenido;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MenuPerfilId implements Serializable {
	
	private int menu;
	private String perfil;

	private static final long serialVersionUID = -6093708611312039055L;
	
	@Basic
	@Column(precision = 5, nullable = false)
	public int getMenu() {
		return menu;
	}
	
	@Basic
	@Column(length = 75, nullable = false)
	public String getPerfil() {
		return perfil;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public boolean equals(Object obj) {
		boolean salida;
		
		if (obj instanceof MenuPerfilId) {
			MenuPerfilId argumento = (MenuPerfilId) obj;
			
			salida = this.menu == argumento.menu && this.perfil.equals(argumento.perfil);
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