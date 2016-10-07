package org.manolete.gestion.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.manolete.gestion.model.aplicaciones.Aplicacion;
import org.manolete.gestion.model.aplicaciones.AplicacionesDao;
import org.manolete.gestion.model.aplicaciones.IAplicacion;
import org.manolete.gestion.model.perfiles.PerfilAplicacion;
import org.manolete.gestion.model.perfiles.PerfilesDao;
import org.manolete.gestion.model.usuarios.UsuariosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	
	private UsuariosDao usuariosDao;
	private AplicacionesDao aplicacionesDao;
	private PerfilesDao perfilesDao;

	private static final Log log = LogFactory.getLog(BaseController.class);
	
	/*
	@RequestMapping("/**")
	public void handleRequest(HttpServletRequest req) {
		MDC.put("sessionId", req.getSession().getId());
		log.debug("Pasando por el controlador base");
	}*/
	
	@RequestMapping(value = "/hola")
	public ModelAndView diHola(HttpServletRequest req) {
		log.info("Devolviendo la vista hola.jsp");
		
		return new ModelAndView("hola");		
	}
	
	@RequestMapping(value = "/usuarios")
	public ModelAndView diUsuarios(HttpServletRequest req) {
		log.info("Devolviendo la vista usuarios.jsp");
		
		ModelAndView mv = new ModelAndView("usuarios");
		
		mv.getModel().put("usuarios", this.usuariosDao.findAll());
		
		return mv;		
	}
	
	@RequestMapping(value = "/aplicaciones")
	public ModelAndView diAplicaciones(HttpServletRequest req) {
		log.info("Devolviendo la vista aplicaciones.jsp");
		
		ModelAndView mv = new ModelAndView("aplicaciones");
		
		List<IAplicacion> aplicaciones = this.aplicacionesDao.findAll();
		
		List<PerfilAplicacion> lista = aplicaciones.get(0).getPerfilesAplicaciones();
		
		for (PerfilAplicacion elemento : lista) {
			System.out.println(elemento.getId().getAplicacion());
			System.out.println(elemento.getId().getPerfil());
			System.out.println(elemento.getAsignado());
			System.out.println(elemento.getAsignado_por().getId());
		}
		
		mv.getModel().put("aplicaciones", aplicaciones);
		
		return mv;		
	}
	
	@RequestMapping(value = "/perfiles")
	public ModelAndView diPerfiles(HttpServletRequest req) {
		log.info("Devolviendo la vista perfiles.jsp");
		
		ModelAndView mv = new ModelAndView("perfiles");
		
		mv.getModel().put("perfiles", this.perfilesDao.findAll());
		
		return mv;		
	}
	
	@Autowired
	public void setUsuariosDao(UsuariosDao usuariosDao) {
		this.usuariosDao = usuariosDao;
	}
	
	@Autowired
	public void setPerfilesDao(PerfilesDao perfilesDao) {
		this.perfilesDao = perfilesDao;
	}
}
