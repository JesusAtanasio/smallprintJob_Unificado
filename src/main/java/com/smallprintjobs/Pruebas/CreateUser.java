package com.smallprintjobs.Pruebas;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class CreateUser {
	
//	  @Autowired
//	    IUsuariosDao usuariosDao; 

	
	private final static Logger log = Logger.getLogger(CreateUser.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getLogger("org.hibernate").setLevel(Level.WARN);
//        createUser2();
        deleteUser();
//        searchUser();
    }
	

    
    private static void searchUser() {
		UsuariosDaoImpl usuariosDao = new UsuariosDaoImpl();
		
        Usuario nuevoUsuario = new Usuario();
        
        nuevoUsuario.setId_user(800);
        try {
			List datosUser = usuariosDao.searchUser(nuevoUsuario);
			
//			for(String str : datosUser) {
				
//			}
			

//		         
//		      }
		} catch (BussinessException e) {
			// TODO Auto-generated catch block
			
//			Logger.error("This is error : " + e );
			e.printStackTrace();
		}
	}



	private static void deleteUser() {  
		
		UsuariosDaoImpl usuariosDao = new UsuariosDaoImpl();
		Usuario nuevoUsuario = new Usuario();
    
		nuevoUsuario.setId_user(800);
		try {
			 usuariosDao.deleteUser(nuevoUsuario);
		} catch (BussinessException e) {
		//		Logger.error("This is error : " + e );
			e.printStackTrace();
		}

	}

	public void createUser() {
    	
		UsuariosDaoImpl usuariosDao = new UsuariosDaoImpl();

    	try {
    		
    		Date date = new Date();
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    		DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			usuariosDao.insertUser("Suso", "Atc", "Jesús",dateFormat.format(date),"H", "títulos", "suso", "lt@ls.com",1, 1,"Prueb", hourdateFormat.format(date));
			
			
		} catch (BussinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void createUser2() {
    	
		UsuariosDaoImpl usuariosDao = new UsuariosDaoImpl();
		
		Date date = new Date("1987/12/11");


		
        Usuario nuevoUsuario = new Usuario();
        
        nuevoUsuario.setAlias("Suso");
        nuevoUsuario.setSurname("Atc");
        nuevoUsuario.setName("Jesús");
        
		nuevoUsuario.setBirth(date);
        nuevoUsuario.setSex("H");
        nuevoUsuario.setDegrees("títulos");
        nuevoUsuario.setPassword("12234");
        nuevoUsuario.setMail("suso@suso.com");
        nuevoUsuario.setEnable(true);
        nuevoUsuario.setMailVerify(true);
        
        try {
			usuariosDao.insertUser(nuevoUsuario);
		} catch (BussinessException e) {
			// TODO Auto-generated catch block
			
//			Logger.error("This is error : " + e );
			e.printStackTrace();
		}
    }
	
    
//    private List<UsuariosDaoImpl> listEvents() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        List<UsuariosDaoImpl> result = (List<UsuariosDaoImpl>)session.createQuery("from Usuario").list();
//        session.getTransaction().commit();
//        for (UsuariosDaoImpl usuario : result) {
//            log.info("Leido: " + usuario);
//        }
//        return result;
//    }
}
	
	
	