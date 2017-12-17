/**
 * 
 */
package com.smallprintjobs.Pruebas;

import java.sql.*;
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
		

		UsuariosDaoImpl usuariosDao = new UsuariosDaoImpl();
		
		try {
//			usuariosDao.searchUser();
		} catch (BussinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		// JDBC driver name and database URL
//		   final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";  
//		   final String DB_URL = "jdbc:mysql://79.109.120.149/idraPonferrada";
//
//		   //  Database credentials
//		   final String USER = "root";
//		   final String PASS = "suso1747";
//		   
//
//		   Connection conn = null;
//		   Statement stmt = null;
//		   try{
//		      //STEP 2: Register JDBC driver
//		      Class.forName("org.mariadb.jdbc.Driver");
//
//		      //STEP 3: Open a connection
//		      System.out.println("Connecting to database...");
//		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//		      //STEP 4: Execute a query
//		      System.out.println("Creating statement...");
//		      stmt = conn.createStatement();
//		      String sql;
//		      sql = "SELECT * FROM USUARIOS";
//		      ResultSet rs = stmt.executeQuery(sql);
//
//		      //STEP 5: Extract data from result set
//		      while(rs.next()){
//		         //Retrieve by column name
//		         String alias = rs.getString("ALIAS");
//		         String surname = rs.getString("SURNAME");
//
//		         //Display values
//		         System.out.print("ALIAS: " + alias);
//		         System.out.print(", Age: " + surname);
//		         
//		      }
//		      //STEP 6: Clean-up environment
//		      rs.close();
//		      stmt.close();
//		      conn.close();
//		   }catch(SQLException se){
//		      //Handle errors for JDBC
//		      se.printStackTrace();
//		   }catch(Exception e){
//		      //Handle errors for Class.forName
//		      e.printStackTrace();
//		   }finally{
//		      //finally block used to close resources
//		      try{
//		         if(stmt!=null)
//		            stmt.close();
//		      }catch(SQLException se2){
//		      }// nothing we can do
//		      try{
//		         if(conn!=null)
//		            conn.close();
//		      }catch(SQLException se){
//		         se.printStackTrace();
//		      }//end finally try
//		   }//end try
//		   System.out.println("Goodbye!");
//		
		
		
		
		
		
	}

}
