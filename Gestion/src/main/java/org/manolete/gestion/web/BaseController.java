package org.manolete.gestion.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.manolete.gestion.model.acceso.AplicacionesDao;
import org.manolete.gestion.model.acceso.PerfilesDao;
import org.manolete.gestion.model.acceso.TicketsDao;
import org.manolete.gestion.model.acceso.UsuariosDao;
import org.manolete.gestion.model.contenido.LenguajesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	
	private UsuariosDao usuariosDao;
	private AplicacionesDao aplicacionesDao;
	private PerfilesDao perfilesDao;
	private TicketsDao ticketsDao;
	private LenguajesDao lenguajesDao;

	private static final Log log = LogFactory.getLog(BaseController.class);
	
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
	
	@RequestMapping(value = "/tickets")
	public ModelAndView diTickets(HttpServletRequest req) {
		log.info("Devolviendo la vista perfiles.jsp");
		
		ModelAndView mv = new ModelAndView("tickets");
		
		mv.getModel().put("tickets", this.ticketsDao.findAll());
		
		return mv;
	}
	
	@RequestMapping(value = "/lenguajes")
	public ModelAndView diLenguajes(HttpServletRequest req) {
		log.info("Devolviendo la vista lenguajes.jsp");
		
		ModelAndView mv = new ModelAndView("lenguajes");
		
		mv.getModel().put("lenguajes", this.lenguajesDao.findAll());
		
		return mv;
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
	
	@Autowired
	public void setTicketsDao(TicketsDao ticketsDao) {
		this.ticketsDao = ticketsDao;
	}
	
	@Autowired
	public void setLenguajesDao(LenguajesDao lenguajesDao) {
		this.lenguajesDao = lenguajesDao;
	}
}
