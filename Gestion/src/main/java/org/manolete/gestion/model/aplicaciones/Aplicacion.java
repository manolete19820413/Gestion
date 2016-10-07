package org.manolete.gestion.model.aplicaciones;

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

import org.manolete.gestion.model.perfiles.PerfilAplicacion;
import org.manolete.gestion.model.usuarios.Usuario;

@Entity
@Table(name = "aplicaciones")
public class Aplicacion implements Serializable {
	
	private String codigo;
	private String nombre;
	private Date modificado;
	private Usuario modificado_por;
	private List<PerfilAplicacion> perfilesAplicaciones;
		
	private static final long serialVersionUID = -3730041226862705575L;
	
	@Id
	@Column(length = 5, nullable = false)
	public String getCodigo() {
		return codigo;
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
	
	@OneToMany(mappedBy = "aplicacion", fetch = FetchType.EAGER)
	public List<PerfilAplicacion> getPerfilesAplicaciones() {
		return perfilesAplicaciones;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
}