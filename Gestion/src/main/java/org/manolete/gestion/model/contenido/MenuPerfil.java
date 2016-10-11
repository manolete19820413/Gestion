package org.manolete.gestion.model.contenido;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.manolete.gestion.model.acceso.Perfil;
import org.manolete.gestion.model.acceso.Usuario;

@Entity
@Table(name = "menus_perfiles")
public class MenuPerfil implements Serializable {
	
	private MenuPerfilId id;
	private Date asignado;
	private Usuario asignado_por;
	private Menu menu;
	private Perfil perfil;

	private static final long serialVersionUID = -6093708611312039055L;
	
	@EmbeddedId
	public MenuPerfilId getId() {
		return id;
	}
	
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
	
	@ManyToOne
	@MapsId("menu")
	@JoinColumn(name = "menu", referencedColumnName = "id")
	public Menu getMenu() {
		return menu;
	}
	
	@ManyToOne
	@MapsId("perfil")
	@JoinColumn(name = "perfil", referencedColumnName = "id")
	public Perfil getPerfil() {
		return perfil;
	}

	public void setId(MenuPerfilId id) {
		this.id = id;
	}

	public void setAsignado(Date asignado) {
		this.asignado = asignado;
	}

	public void setAsignado_por(Usuario asignado_por) {
		this.asignado_por = asignado_por;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
