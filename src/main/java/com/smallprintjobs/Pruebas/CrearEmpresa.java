package com.smallprintjobs.Pruebas;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smallprintjobs.Modelo.impl.EmpresasDaoImpl;
import com.smallprintjobs.Utils.HibernateUtils;

public class CrearEmpresa {
	
	private final static Logger log = Logger.getLogger(CrearEmpresa.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getLogger("org.hibernate").setLevel(Level.WARN);
        new CrearEmpresa();
    }
    
    public CrearEmpresa() {
    	
    	
        createAndStoreEvent("1R", "job", "adv","direccion", "localidad","provinca","pais","123456","madrid","www.fasj.com");
        listEvents();
        HibernateUtils.getSessionFactory().close();
    }
	

    private Integer createAndStoreEvent(String cif, String nombre, String sector, String direccion, 
    		String localidad, String provincia,String pais,String codPostal, String sede, String web) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        EmpresasDaoImpl newEmpresa = new EmpresasDaoImpl();
        
        newEmpresa.setCif(cif);
        newEmpresa.setNombre(nombre);
        newEmpresa.setSector(sector);
        newEmpresa.setDireccion(direccion);
        newEmpresa.setLocalidad(localidad);
        newEmpresa.setProvincia(provincia);;
        newEmpresa.setPais(pais);
        newEmpresa.setCodPostal(codPostal);
        newEmpresa.setSede(sede);
        newEmpresa.setWeb(web);
        
        session.save(newEmpresa);
        session.getTransaction().commit();
        log.info("Insertado: "+newEmpresa);
        return newEmpresa.getIdEmp();
    }
    
    private List<EmpresasDaoImpl> listEvents() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<EmpresasDaoImpl> result = (List<EmpresasDaoImpl>)session.createQuery("from Empresas").list();
        session.getTransaction().commit();
        for (EmpresasDaoImpl usuario : result) {
            log.info("Leido: " + usuario);
        }
        return result;
    }
}
