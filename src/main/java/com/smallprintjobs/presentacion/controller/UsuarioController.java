package com.smallprintjobs.presentacion.controller;

import com.smallprintjobs.Beans.Usuario;
import com.smallprintjobs.Modelo.IUsuariosDao;
import com.smallprintjobs.presentacion.json.IJsonTransformer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UsuarioController {

	 @Autowired
	    private IJsonTransformer iJsonTransformer;
	    
	    @Autowired
	    IUsuariosDao usuariosDao;
	    
	    @RequestMapping(value = {"/Usuario"})
	    public void prueba(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
	    	Usuario usuarios = usuariosDao.get(1);
	        String jsonUsuario=iJsonTransformer.toJson(usuarios);
	        
	        httpServletResponse.getWriter().println(jsonUsuario);
	}
	    
}
