package org.manolete.gestion.model.perfiles;

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

import org.manolete.gestion.model.aplicaciones.Aplicacion;
import org.manolete.gestion.model.usuarios.Usuario;

@Entity
@Table(name = "perfiles_aplicaciones")
public class PerfilAplicacion implements Serializable {
	
	private PerfilAplicacionId id;
	private Perfil perfil;
	private Aplicacion aplicacion;
	private Date asignado;
	private Usuario asignado_por;
	
	private static final long serialVersionUID = -219295844924150590L;
	
	@EmbeddedId
	public PerfilAplicacionId getId() {
		return id;
	}
	
	@ManyToOne
	@MapsId("perfil")
	@JoinColumn(name = "perfil", referencedColumnName = "id")
	public Perfil getPerfil() {
		return perfil;
	}
		
	@ManyToOne
	@MapsId("aplicacion")
	@JoinColumn(name = "aplicacion", referencedColumnName = "codigo")
	public Aplicacion getAplicacion() {
		return aplicacion;
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
	
	public void setId(PerfilAplicacionId id) {
		this.id = id;
	}
		
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public void setAplicacion(Aplicacion apli) {
		this.aplicacion = apli;
	}
		
	public void setAsignado(Date asignado) {
		this.asignado = asignado;
	}
	
	public void setAsignado_por(Usuario asignado_por) {
		this.asignado_por = asignado_por;
	}	
}