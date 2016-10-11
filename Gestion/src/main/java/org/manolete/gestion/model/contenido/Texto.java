package org.manolete.gestion.model.contenido;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.manolete.gestion.model.acceso.Usuario;
import org.manolete.gestion.model.aplicaciones.Aplicacion;

@Entity
@Table(name = "textos", uniqueConstraints = @UniqueConstraint(columnNames = {"codigo", "categoria", "lenguaje", "aplicacion"}))
public class Texto implements Serializable {
	
	private int id;
	private String codigo;
	private String categoria;
	private Lenguaje lenguaje;
	private Aplicacion aplicacion;
	private String valor;
	private byte[] imagen;
	private Date modificado;
	private Usuario modificado_por;
	
	private static final long serialVersionUID = 1177407192806555266L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(precision = 5, nullable = false)
	public int getId() {
		return id;
	}
	
	@Basic
	@Column(length = 50, nullable = false)
	public String getCodigo() {
		return codigo;
	}
	
	@Basic
	@Column(length = 8, nullable = false)
	public String getCategoria() {
		return categoria;
	}
	
	@ManyToOne
	@JoinColumn(name = "lenguaje")
	public Lenguaje getLenguaje() {
		return lenguaje;
	}
	
	@ManyToOne
	@JoinColumn(name = "aplicacion")
	public Aplicacion getAplicacion() {
		return aplicacion;
	}
		
	@Basic
	@Column(length = 255)
	public String getValor() {
		return valor;
	}
	
	@Lob
	public byte[] getImagen() {
		return imagen;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setLenguaje(Lenguaje lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}

	public void setModificado_por(Usuario modificado_por) {
		this.modificado_por = modificado_por;
	}
}