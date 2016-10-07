package org.manolete.gestion.model.aplicaciones;

import java.util.Date;
import java.util.List;

import org.manolete.gestion.model.perfiles.PerfilAplicacion;
import org.manolete.gestion.model.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

public class IAplicacionImpl implements IAplicacion {
	
	private Aplicacion aplicacion;
	private AplicacionesDao aplicacionesDao;
	
	public IAplicacionImpl(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public String getCodigo() {
		return this.aplicacion.getCodigo();
	}

	@Override
	public String getNombre() {
		return this.aplicacion.getNombre();
	}

	@Override
	public Date getModificado() {
		return this.aplicacion.getModificado();
	}

	@Override
	public Usuario getModificado_por() {
		return this.aplicacion.getModificado_por();
	}

	@Override
	public List<PerfilAplicacion> getPerfilesAplicaciones() {
		return null;
	}
	
	@Autowired
	public void setAplicacionesDao(AplicacionesDao aplicacionesDao) {
		this.aplicacionesDao = aplicacionesDao;
	}
}