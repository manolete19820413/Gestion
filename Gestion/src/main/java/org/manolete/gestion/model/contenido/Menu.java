package org.manolete.gestion.model.contenido;

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
import javax.persistence.UniqueConstraint;

import org.manolete.gestion.model.acceso.Usuario;
import org.manolete.gestion.model.aplicaciones.Aplicacion;

@Entity
@Table(name = "menus", uniqueConstraints = @UniqueConstraint(columnNames = {"aplicacion", "orden"}))
public class Menu implements Serializable {
	
	private int id;
	private Aplicacion aplicacion;
	private int orden;
	private List<Texto> descripciones;
	private String url;
	private Date modificado;
	private Usuario modificado_por;
	private List<MenuPerfil> menusPerfiles;
	 
	private static final long serialVersionUID = 7207184649341883836L;
	
	@Id
	@Column(precision = 5, nullable = false)
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name = "aplicacion")
	public Aplicacion getAplicacion() {
		return aplicacion;
	}
	
	@Basic
	@Column(precision = 5, nullable = false)
	public int getOrden() {
		return orden;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo")
	public List<Texto> getDescripciones() {
		return descripciones;
	}
	
	@Basic
	@Column(length = 255, nullable = false)
	public String getUrl() {
		return url;
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
	
	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
	public List<MenuPerfil> getMenusPerfiles() {
		return menusPerfiles;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public void setDescripciones(List<Texto> descripciones) {
		this.descripciones = descripciones;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public void setModificado_por(Usuario modificado_por) {
		this.modificado_por = modificado_por;
	}

	public void setMenusPerfiles(List<MenuPerfil> menusPerfiles) {
		this.menusPerfiles = menusPerfiles;
	}
}
