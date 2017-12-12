package com.smallprintjobs.Modelo.impl;
// Generated 01-feb-2017 21:02:19 by Hibernate Tools 5.2.0.CR1

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

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class UsuariosDaoImpl implements IUsuariosDao{
	
	// JDBC driver name and database URL
	   final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";  
	   final String DB_URL = "jdbc:mysql://79.109.120.149/idraPonferrada";

	   //  Database credentials
	   final String USER = "root";
	   final String PASS = "suso1747";
	   

	   Connection conn = null;
	   Statement stmt = null;
	
//    @Override
//    public void insert(Usuario usuario) throws BussinessException {
//    	
//		 Connection connection = null;
//		 try {
//		     connection = getConnection();
//		     PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `USUARIOS` (`alias`, `surname`, `name`, `birth`, "
//		 		+ "`sex`, `degrees`, `password`, `mail`, `enable`, `coberturadental`, `mailVerify`, "
//		 		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//		     
//		     preparedStatement.setString(1, String.valueOf(usuario.getId_user()));
//		     preparedStatement.setString(2, usuario.getAlias());
//		     preparedStatement.setString(3,usuario.getSurname() );
//		     preparedStatement.setString(4,usuario.getName());
//		     preparedStatement.setDate(5,(java.sql.Date) usuario.getBirth());
//		     preparedStatement.setString(6,usuario.getSex() );
//		     preparedStatement.setString(7,usuario.getDegrees() );
//		     preparedStatement.setString(8, usuario.getPassword());
//		     preparedStatement.setString(9,usuario.getMail());
//		     preparedStatement.setBoolean(10,usuario.getEnable());
//		     preparedStatement.setBoolean(11,usuario.getMailVerify() );
//		
//		     preparedStatement.executeUpdate();
//		
//		 } catch (SQLException ex) {
//		     throw new RuntimeException(ex);
//		 } finally {
//		     if (connection != null) {
//		         try {
//		             connection.close();
//		         } catch (SQLException ex) {
//		
//		         }
//		     }
//		 }
//    }
//    
//	@Override
//	public void insertUsuario(String alias, String surname, String name, Date birth, String sex, String degrees,
//			String password, String mail, Boolean enable, Boolean mailVerify)  {
//		 Connection connection = null;		
//		 try {
//		     connection = getConnection();
//		
//		     PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `USUARIOS` (`alias`, `surname`, `name`, `birth`, "
//		 		+ "`sex`, `degrees`, `password`, `mail`, `enable`, `mailVerify`, "
//		 		+ "VALUES ("+  alias  + ", " + 
//		 					surname + ", " +
//		 					name +  ", " +
//		 					birth + "," + 
//		 					sex + ", " +
//		 					degrees + ", "+
//		 					password +", " +
//		 					mail + ","+  
//		 					enable +", "+  
//		 					mailVerify + ")");
//
//		     preparedStatement.executeUpdate();    
//		     
//		 } catch (SQLException ex) {
//		     throw new RuntimeException(ex);
//		 } finally {
//		     if (connection != null) {
//		         try {
//		             connection.close();
//		         } catch (SQLException ex) {
//		
//		         }
//		     }
//		 }
//		
//	}
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
//    

    public void searchUser() throws BussinessException {
        
    	Connection connection = null;

        try {

            String sql = "SELECT * FROM USUARIOS WHERE id_user=715";
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
		      
		      //STEP 5: Extract data from result set		
		      while(rs.next()){
			         //Retrieve by column name
			         String alias = rs.getString("ALIAS");
			         String surname = rs.getString("SURNAME");

			         //Display values
			         System.out.print("Alias: " + alias);
			         System.out.print(", Apellido: " + surname);
			      }

        }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		    	  se2.printStackTrace();
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }  
		      
    }
    
//    @Override
//    public void delete(int id_user) throws BussinessException {
//
//        Connection connection = null;
//
//        try {
//            connection = getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usuario WHERE idusuario=?");
//
//            preparedStatement.setInt(1, id_user);
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//
//                }
//            }
//        }
//    }
//    
//    private Usuario CrearUsuario(ResultSet rst) {
//        try {
//        	Usuario Usuario = new Usuario();
//
//            Usuario.setId_user(rst.getInt("idUsuario"));
//            Usuario.setAlias(rst.getString("alias"));
//            Usuario.setSurname(rst.getString("surname"));
//            Usuario.setName(rst.getString("name"));
//            Usuario.setBirth(rst.getDate("birth"));
//            Usuario.setSex(rst.getString("sex"));
//            Usuario.setDegrees(rst.getString("degrees"));
//            Usuario.setPassword(rst.getString("password"));
//            Usuario.setMail(rst.getString("mail"));
//            Usuario.setEnable(rst.getBoolean("enable"));
//            Usuario.setMailVerify(rst.getBoolean("mailVerify"));
//            
//            return Usuario;
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
    
//    private Connection getConnection() {
//        try {
//            InitialContext initCtx = new InitialContext();
//            Context envCtx = (Context) initCtx.lookup("java:comp/env");
//            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/seguromedico");
//
//            return dataSource.getConnection();
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }



}
    
 
