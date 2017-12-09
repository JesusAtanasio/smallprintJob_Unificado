package com.smallprintjobs.Utils;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml"))
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

//public class HibernateUtils {
//	
//	
//	private static SessionFactory sessionFactory;
//	
//	static{
//		sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
//	}
//	
//	public static SessionFactory getSessionFactory(){
//		return sessionFactory;
//	}
//}
//	
//	
//	
//	
//	
	
	
	
//    private final static Logger log = Logger.getLogger(HibernateUtil.class);
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        BasicConfigurator.configure();
//        Logger.getLogger("org.hibernate").setLevel(Level.WARN);
//        new HibernateUtil();
//    }
//
//    public HibernateUtil() {
//        createAndStoreEvent("El Event", new Date());
//        listEvents();
//        HibernateUtil.getSessionFactory().close();
//    }
//
//    private Long createAndStoreEvent(String title, Date theDate) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Event theEvent = new Event();
//        theEvent.setTitle(title);
//        theEvent.setDate(theDate);
//        session.save(theEvent);
//        session.getTransaction().commit();
//        log.info("Insertado: "+theEvent);
//        return theEvent.getId();
//    }
//
//    private List<Event> listEvents() {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        List<Event> result = (List<Event>)session.createQuery("from Event").list();
//        session.getTransaction().commit();
//        for (Event evento : result) {
//            log.info("Leido: "+evento);
//        }
//        return result;
//    }

