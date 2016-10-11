package org.manolete.gestion.model.correos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.manolete.gestion.model.acceso.Usuario;

@Entity
@Table(name = "correos")
public class Correo implements Serializable {
	
	private int id;
	private Usuario receptor;
	private String asunto;
	private Date envio;
	private EstadoEnvio estado;
	private Usuario solicitado_por;
	
	public enum EstadoEnvio {ENVIANDO, EXITO, ERROR};	

	private static final long serialVersionUID = -5063419788150759918L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(precision = 5, nullable = false)
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name = "receptor")
	public Usuario getReceptor() {
		return receptor;
	}
	
	@Basic
	@Column(length = 100, nullable = false)
	public String getAsunto() {
		return asunto;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false)
	public Date getEnvio() {
		return envio;
	}
	
	@Enumerated(EnumType.STRING)
	public EstadoEnvio getEstado() {
		return estado;
	}
	
	@ManyToOne
	@JoinColumn(name = "solicitado_por")
	public Usuario getSolicitado_por() {
		return solicitado_por;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public void setEnvio(Date envio) {
		this.envio = envio;
	}

	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	public void setSolicitado_por(Usuario solicitado_por) {
		this.solicitado_por = solicitado_por;
	}
}
