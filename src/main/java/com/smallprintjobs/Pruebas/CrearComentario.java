package com.smallprintjobs.Pruebas;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smallprintjobs.Modelo.impl.ComentariosDaoImpl;
import com.smallprintjobs.Utils.HibernateUtils;

public class CrearComentario {
	
	private final static Logger log = Logger.getLogger(CrearComentario.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getLogger("org.hibernate").setLevel(Level.WARN);
        new CrearComentario();
    }
    
    public CrearComentario() {
    	
    	
        createAndStoreEvent(1, 2, "Programación", "TELCO", new Date(25/11/2016), new Date(25/11/2016), new Date(25/11/2016),
        		"Horas de más", 5);
        listEvents();
        HibernateUtils.getSessionFactory().close();
    }
	

    private Integer createAndStoreEvent(int id_emp, int id_user, String departamento, String proyecto, Date fecha_com,
    		Date fechaIniPro, Date fechaFinPro, String comentario, int valoracion) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        ComentariosDaoImpl nuevoComentario = new ComentariosDaoImpl();
        
        nuevoComentario.setId_emp(id_emp);
        nuevoComentario.setId_user(id_user);
        nuevoComentario.setDepartamento(departamento);
        nuevoComentario.setProyecto(proyecto);
        nuevoComentario.setFechaCom(fecha_com);
        nuevoComentario.setFechaIniPro(fechaIniPro);
        nuevoComentario.setFechaFinProyecto(fechaFinPro);
        nuevoComentario.setComentario(comentario);
        nuevoComentario.setValoracion(valoracion);
        
        
        session.save(nuevoComentario);
        session.getTransaction().commit();
        log.info("Insertado: " + nuevoComentario);
        return nuevoComentario.getIdCom();
    }
    
    private List<ComentariosDaoImpl> listEvents() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ComentariosDaoImpl> result = (List<ComentariosDaoImpl>)session.createQuery("from comentario").list();
        session.getTransaction().commit();
        for (ComentariosDaoImpl comentario : result) {
            log.info("Leido: " + comentario);
        }
        return result;
    }
}
	