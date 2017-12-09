/**
 * 
 */
package com.smallprintjobs.Pruebas;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.smallprintjobs.Beans.Usuario;
import com.smallprintjobs.Utils.HibernateUtils;
import com.smallprintjobs.Modelo.*;
import com.smallprintjobs.Modelo.impl.UsuariosDaoImpl;


/**
 * @author Jesús
 *
 */
public class CrearAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   IUsuariosDao usuariosDao = new UsuariosDaoImpl(); 
		  
    	usuariosDao.insertUsuario("Suso", "Atc", "Jesús", new Date(), "H", "títulos", "suso", "lt", true, true);
	}

}
