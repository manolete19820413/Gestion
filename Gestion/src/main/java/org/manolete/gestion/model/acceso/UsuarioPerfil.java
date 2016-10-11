package org.manolete.gestion.model.usuarios;

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

import org.manolete.gestion.model.perfiles.Perfil;

@Entity
@Table(name = "usuarios_perfiles")
public class UsuarioPerfil implements Serializable {
	
	private UsuarioPerfilId id;
	private Date asignado;
	private Usuario asignado_por;
	private Usuario usuario;
	private Perfil perfil;

	private static final long serialVersionUID = -7568458517967429698L;
	
	@EmbeddedId
	public UsuarioPerfilId getId() {
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
	@MapsId("usuario")
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	public Usuario getUsuario() {
		return usuario;
	}
	
	@ManyToOne
	@MapsId("perfil")
	@JoinColumn(name = "perfil", referencedColumnName = "id")
	public Perfil getPerfil() {
		return perfil;
	}

	public void setId(UsuarioPerfilId id) {
		this.id = id;
	}

	public void setAsignado(Date asignado) {
		this.asignado = asignado;
	}

	public void setAsignado_por(Usuario asignado_por) {
		this.asignado_por = asignado_por;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
