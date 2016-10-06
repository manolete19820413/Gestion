package org.manolete.gestion.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.manolete.gestion.model.usuarios.UsuariosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	
	@Autowired
	private UsuariosDao usuariosDao;

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
		
		log.debug(new Date());
		
		ModelAndView mv = new ModelAndView("usuarios");
		
		mv.getModel().put("usuarios", this.usuariosDao.findAll());
		
		return mv;		
	}

	public void setUsuariosDao(UsuariosDao usuariosDao) {
		this.usuariosDao = usuariosDao;
	}
}
