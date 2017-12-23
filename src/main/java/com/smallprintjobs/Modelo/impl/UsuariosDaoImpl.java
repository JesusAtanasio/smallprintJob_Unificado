package com.smallprintjobs.Modelo.impl;
// Generated 01-feb-2017 21:02:19 by Hibernate Tools 5.2.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.smallprintjobs.Beans.Usuario;
import com.smallprintjobs.Modelo.BussinessException;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Entity;

import com.smallprintjobs.Modelo.IUsuariosDao;

import java.sql.*;

public class UsuariosDaoImpl implements IUsuariosDao{
	
	// JDBC driver name and database URL
	   final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";  
	   final String DB_URL = "jdbc:mysql://79.109.120.149/idraPonferrada";

	   //  Database credentials
	   final String USER = "root";
	   final String PASS = "suso1747";
	   

	   Connection conn = null;
	   Statement stmt = null;
	   

	   public Usuario searchUser(Usuario usuario) throws BussinessException {
	        
	        try {
	        	  final Logger logger
	        	  	= Logger.getLogger(UsuariosDaoImpl.class.getName());   	  
	        	  
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				PreparedStatement ps = null;
				   
				ps = conn.prepareStatement("SELECT * FROM USUARIOS WHERE ID_USER = ?");
				 
				ps.setInt(1, usuario.getId_user());
				
				ResultSet rs = ps.executeQuery();
	
	
			      //STEP 5: Extract data from result set
				while (rs.next()) {
			         //Retrieve by column name
				usuario.setAlias(rs.getString("ALIAS"));
				usuario.setSurname(rs.getString("SURNAME"));
				usuario.setName(rs.getString("NAME"));
				usuario.setBirth(rs.getDate("BIRTH"));
				usuario.setSex(rs.getString("SEX"));
				usuario.setDegrees(rs.getString("DEGREES"));
				usuario.setPassword(rs.getString("PASSWORD"));
				usuario.setMail(rs.getString("MAIL"));
				usuario.setEnable(rs.getBoolean("ENABLE"));
				usuario.setMailVerify(rs.getBoolean("MAIL_VERIFY"));

			    	  
			         //Display values
			         System.out.print("ALIAS: " + usuario.getAlias());
			         System.out.print("SURNAME: " + usuario.getSurname());
			         
			         
				}   
			      
			      //STEP 6: Clean-up environment
			      rs.close();
			      conn.close();
				 
				return usuario;
				
	        } catch (SQLException ex) {
				 Logger.getLogger(ex.toString()).setLevel(Level.ERROR);
			     throw new RuntimeException(ex);
			 }
			  finally {
			     if (conn != null) {
			         try {
			             conn.close();
						 System.out.println("Conexión cerrada");
			         } catch (SQLException ex) {
						 System.out.println("No se ha podido cerrar la conexión");

			         }
			     }
			 }  
	    }
	
	   public List searchAllUser(Usuario usuario) throws BussinessException {
	        
	        try {
	        	
	        	List datosUser = new ArrayList();
	        	
				   conn = DriverManager.getConnection(DB_URL,USER,PASS);
				   PreparedStatement ps = null;
				   
				      stmt = conn.createStatement();

				      String sql = "SELECT * FROM USUARIOS WHERE ID_USER = ?";
				 
			      ResultSet rs = stmt.executeQuery(sql);
	
			      //STEP 5: Extract data from result set
			    
			         //Retrieve by column name
			    	  datosUser.add(rs.getString("ALIAS"));
			    	  datosUser.add(rs.getString("SURNAME"));
			    	  datosUser.add(rs.getString("NAME"));
			    	  datosUser.add(rs.getString("BIRTH"));
			    	  datosUser.add(rs.getString("SEX"));
			    	  datosUser.add(rs.getString("DEGREES"));
			    	  datosUser.add(rs.getString("PASSWORD"));
			    	  datosUser.add(rs.getString("MAIL"));
			    	  datosUser.add(rs.getString("ENABLE"));
			    	  datosUser.add(rs.getString("MAIL_VERIFY"));
			    	  datosUser.add(rs.getString("AUD_USER"));
			    	  datosUser.add(rs.getString("AUD_TIME"));
			    	  
			         //Display values
			         System.out.print("ALIAS: " + datosUser.get(0));
			         System.out.print("SURNAME: " + datosUser.get(1));
			         
			      
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();
				 
				return datosUser;
				
	        } catch (SQLException ex) {
				 Logger.getLogger(ex.toString()).setLevel(Level.ERROR);
			     throw new RuntimeException(ex);
			 }
			  finally {
			     if (conn != null) {
			         try {
			             conn.close();
						 System.out.println("Conexión cerrada");
			         } catch (SQLException ex) {
						 System.out.println("No se ha podido cerrar la conexión");

			         }
			     }
			 }  
	    }
	   
	   @Override
	   public void insertUser(Usuario usuario) throws BussinessException {
    	
		   try {
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   PreparedStatement ps = null;
				
			   Date now = new Date();
			   DateFormat dateFormatYMD = new SimpleDateFormat("yyyy-MM-dd");

			   Date audDate = new Date();
				DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

				ps = conn.prepareStatement("INSERT INTO USUARIOS (ALIAS, SURNAME, NAME, BIRTH, SEX, DEGREES, "
				+ "PASSWORD, MAIL, ENABLE, MAIL_VERIFY, AUD_USER, AUD_TIME )"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				 			
				ps.setString(1, usuario.getAlias());
				ps.setString(2,usuario.getSurname() );
				ps.setString(3,usuario.getName());
				ps.setDate(4, java.sql.Date.valueOf(dateFormatYMD.format(usuario.getBirth())));
				ps.setString(5,usuario.getSex() );
				ps.setString(6,usuario.getDegrees() );
				ps.setString(7, usuario.getPassword());
				ps.setString(8,usuario.getMail());
			 ps.setBoolean(9,usuario.getEnable());
			 ps.setBoolean(10,usuario.getMailVerify() );
			 ps.setString(11, "Usuario");
			 ps.setString(12, hourdateFormat.format(audDate));
			
			 ps.executeUpdate();
			 
			 System.out.println("Insert correcto");
			 Logger.getLogger(ps.toString()).setLevel(Level.INFO);
		
		 } catch (SQLException ex) {
			 Logger.getLogger(ex.toString()).setLevel(Level.ERROR);
		     throw new RuntimeException(ex);
		 }
		  finally {
		     if (conn != null) {
		         try {
		             conn.close();
					 System.out.println("Conexión cerrada");
		         } catch (SQLException ex) {
					 System.out.println("No se ha podido cerrar la conexión");

		         }
		     }
		 }
    }
	   
	   public void insertUser(String alias, String surname, String name, String birth, String sex, String degrees, String password, String mail, int enable, int mailVerify, String audUser,String audTime) throws BussinessException {

			 Connection connection = null;		
			 try {
				 String sql = "INSERT INTO USUARIOS (ALIAS, SURNAME, NAME, BIRTH, SEX, DEGREES, PASSWORD, MAIL, ENABLE, MAIL_VERIFY, AUD_USER, AUD_TIME ) "+
			 		"VALUES ('"+ alias  + "', '" + 
			 					surname + "', '" +
			 					name +  "', '" +
			 					birth + "', '" + 
			 					sex + "', '" +
			 					degrees + "', '"+
			 					password +"', '" +
			 					mail + "', '"+  
			 					enable +"', '"+  
			 					mailVerify +"', '"+
			 					audUser +"', '"+
			 					audTime	+ "') ";

		            conn = DriverManager.getConnection(DB_URL,USER,PASS);
		            stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
			     
		            Logger.getLogger(sql).setLevel(Level.INFO);
		            
		            
			 } catch (SQLException ex) {
			     throw new RuntimeException(ex);
			 } finally {
			     if (connection != null) {
			         try {
			             connection.close();
			         } catch (SQLException ex) {
			
			         }
			     }
			 }
	    } 
 
    public void deleteUser(Usuario usuario) throws BussinessException {

        try {
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   PreparedStatement ps = null;
			   
			ps = conn.prepareStatement("DELETE FROM USUARIOS WHERE ID_USER = ?)");
			 
			ps.setInt(1, usuario.getId_user());
			
        } catch (SQLException ex) {
			 Logger.getLogger(ex.toString()).setLevel(Level.ERROR);
		     throw new RuntimeException(ex);
		 }
		  finally {
		     if (conn != null) {
		         try {
		             conn.close();
					 System.out.println("Conexión cerrada");
		         } catch (SQLException ex) {
					 System.out.println("No se ha podido cerrar la conexión");

		         }
		     }
		 }  
    }
}
	
    
 
