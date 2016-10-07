package org.manolete.gestion.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.manolete.gestion.model.aplicaciones.AplicacionesDao;
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
		
		mv.getModel().put("aplicaciones", this.aplicacionesDao.findAll());
		
		return mv;		
	}
	
	@RequestMapping(value = "/perfiles")
	public ModelAndView diPerfiles(HttpServletRequest req) {
		log.info("Devolviendo la vista perfiles.jsp");
		
		ModelAndView mv = new ModelAndView("perfiles");
		
		mv.getModel().put("perfiles", this.perfilesDao.findAll());
		
		return mv;		
	}
	
	@RequestMapping(value = "/pa")
	public ModelAndView diPerfilesAplicaciones(HttpServletRequest req) {
		log.info("Calculando perfiles_aplicaciones");
		
		List<PerfilAplicacion> lista = this.perfilesDao.findAllPA();
		
		return this.diPerfiles(req);		
	}
	
	@Autowired
	public void setUsuariosDao(UsuariosDao usuariosDao) {
		this.usuariosDao = usuariosDao;
	}
	
	@Autowired	
	public void setAplicacionesDao(AplicacionesDao aplicacionesDao) {
		this.aplicacionesDao = aplicacionesDao;
	}

	@Autowired
	public void setPerfilesDao(PerfilesDao perfilesDao) {
		this.perfilesDao = perfilesDao;
	}
}
