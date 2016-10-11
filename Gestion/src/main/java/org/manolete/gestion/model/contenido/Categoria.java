package org.manolete.gestion.model.contenido;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "categorias", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "aplicacion"}))
public class Categoria implements Serializable {
	
	private String id;
	private Aplicacion aplicacion;
	private List<Texto> descripciones;
	private Date modificada;
	private Usuario modificada_por;

	private static final long serialVersionUID = -7290423909166631067L;
	
	@Id
	@Column(length = 8, nullable = false)
	public String getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name = "aplicacion", referencedColumnName = "codigo")
	public Aplicacion getAplicacion() {
		return aplicacion;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo")
	public List<Texto> getDescripciones() {
		return descripciones;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	public Date getModificada() {
		return modificada;
	}
	
	@ManyToOne
	@JoinColumn(name = "modificada_por")
	public Usuario getModificada_por() {
		return modificada_por;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public void setDescripciones(List<Texto> descripciones) {
		this.descripciones = descripciones;
	}
	
	public void setModificada(Date modificada) {
		this.modificada = modificada;
	}

	public void setModificada_por(Usuario modificada_por) {
		this.modificada_por = modificada_por;
	}
}