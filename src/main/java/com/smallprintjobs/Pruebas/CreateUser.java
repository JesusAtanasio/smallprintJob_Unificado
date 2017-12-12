package com.smallprintjobs.Pruebas;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	  @Autowired
	    IUsuariosDao usuariosDao; 

	
	private final static Logger log = Logger.getLogger(CreateUser.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getLogger("org.hibernate").setLevel(Level.WARN);
        new CreateUser();
    }
	

    
    public CreateUser() {
    	
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
    	  
    	//UsuariosDaoImpl.insertUsuario("Suso", "Atc", "Jesús", new Date(), "H", "títulos", "suso", "lt", true, true);
//        
//        HibernateUtils.getSessionFactory().close();
    }
	

//    private Integer createAndStoreEvent(String alias, String surname,String name, Date nuevoBith, String sex, 
//    		String degrees,String password,String mail,boolean enable,boolean mail_verify) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        
//        UsuariosDaoImpl nuevoUsuario = new UsuariosDaoImpl();
//        
//        nuevoUsuario.setAlias(alias);
//        nuevoUsuario.setSurname(surname);
//        nuevoUsuario.setName(name);
//        nuevoUsuario.setBirth(nuevoBith);
//        nuevoUsuario.setDegrees(degrees);
//        nuevoUsuario.setPassword(password);
//        nuevoUsuario.setMail(mail);
//        nuevoUsuario.setEnable(enable);
//        nuevoUsuario.setMailVerify(mail_verify);
//        
//        session.save(nuevoUsuario);
//        session.getTransaction().commit();
//        log.info("Insertado: "+nuevoUsuario);
//        return nuevoUsuario.getId_user();
//    }
//    
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
	
	
	