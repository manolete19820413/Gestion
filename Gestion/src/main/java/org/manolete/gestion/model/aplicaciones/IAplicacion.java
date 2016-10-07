package org.manolete.gestion.model.aplicaciones;

import java.util.Date;
import java.util.List;

import org.manolete.gestion.model.perfiles.PerfilAplicacion;
import org.manolete.gestion.model.usuarios.Usuario;

public interface IAplicacion {
	
	public String getCodigo();
	
	public String getNombre();
	
	public Date getModificado();
	
	public Usuario getModificado_por();
	
	public List<PerfilAplicacion> getPerfilesAplicaciones();
}
