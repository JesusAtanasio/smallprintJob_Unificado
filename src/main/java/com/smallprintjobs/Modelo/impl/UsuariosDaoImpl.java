package com.smallprintjobs.Modelo.impl;
// Generated 01-feb-2017 21:02:19 by Hibernate Tools 5.2.0.CR1

import java.util.Date;

import com.smallprintjobs.Beans.Usuario;
import com.smallprintjobs.Modelo.BussinessException;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import com.smallprintjobs.Modelo.IUsuariosDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class UsuariosDaoImpl implements IUsuariosDao{
	
    @Override
    public void insert(Usuario usuario) throws BussinessException {
    	
		 Connection connection = null;
		 try {
		     connection = getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `USUARIOS` (`alias`, `surname`, `name`, `birth`, "
		 		+ "`sex`, `degrees`, `password`, `mail`, `enable`, `coberturadental`, `mailVerify`, "
		 		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		     
		     preparedStatement.setString(1, String.valueOf(usuario.getId_user()));
		     preparedStatement.setString(2, usuario.getAlias());
		     preparedStatement.setString(3,usuario.getSurname() );
		     preparedStatement.setString(4,usuario.getName());
		     preparedStatement.setDate(5,(java.sql.Date) usuario.getBirth());
		     preparedStatement.setString(6,usuario.getSex() );
		     preparedStatement.setString(7,usuario.getDegrees() );
		     preparedStatement.setString(8, usuario.getPassword());
		     preparedStatement.setString(9,usuario.getMail());
		     preparedStatement.setBoolean(10,usuario.getEnable());
		     preparedStatement.setBoolean(11,usuario.getMailVerify() );
		
		     preparedStatement.executeUpdate();
		
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
    
	@Override
	public void insertUsuario(String alias, String surname, String name, Date birth, String sex, String degrees,
			String password, String mail, Boolean enable, Boolean mailVerify)  {
		 Connection connection = null;		
		 try {
		     connection = getConnection();
		
		     PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `USUARIOS` (`alias`, `surname`, `name`, `birth`, "
		 		+ "`sex`, `degrees`, `password`, `mail`, `enable`, `mailVerify`, "
		 		+ "VALUES ("+  alias  + ", " + 
		 					surname + ", " +
		 					name +  ", " +
		 					birth + "," + 
		 					sex + ", " +
		 					degrees + ", "+
		 					password +", " +
		 					mail + ","+  
		 					enable +", "+  
		 					mailVerify + ")");

		     preparedStatement.executeUpdate();    
		     
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
    public void insertUsuario(String alias, String surname, String name, Date birth, String sex, String degrees, String password, String mail, boolean enable, boolean mailVerify) throws BussinessException {

		 Connection connection = null;		
		 try {
		     connection = getConnection();
		
		     PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `USUARIOS` (`alias`, `surname`, `name`, `birth`, "
		 		+ "`sex`, `degrees`, `password`, `mail`, `enable`, `mailVerify`, "
		 		+ "VALUES ("+  alias  + ", " + 
		 					surname + ", " +
		 					name +  ", " +
		 					birth + "," + 
		 					sex + ", " +
		 					degrees + ", "+
		 					password +", " +
		 					mail + ","+  
		 					enable +", "+  
		 					mailVerify + ")");

		     preparedStatement.executeUpdate();    
		     
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
    
    @Override
    public Usuario get(int id_user) throws BussinessException {
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE idusuario=?");
            
            preparedStatement.setInt(1, id_user);
            
            ResultSet rst = preparedStatement.executeQuery();

            if (rst.next()) {
                return CrearUsuario(rst);
            } else {
                return null;
            }

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
    
    @Override
    public void delete(int id_user) throws BussinessException {

        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usuario WHERE idusuario=?");

            preparedStatement.setInt(1, id_user);

            preparedStatement.executeUpdate();

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
    
    private Usuario CrearUsuario(ResultSet rst) {
        try {
        	Usuario Usuario = new Usuario();

            Usuario.setId_user(rst.getInt("idUsuario"));
            Usuario.setAlias(rst.getString("alias"));
            Usuario.setSurname(rst.getString("surname"));
            Usuario.setName(rst.getString("name"));
            Usuario.setBirth(rst.getDate("birth"));
            Usuario.setSex(rst.getString("sex"));
            Usuario.setDegrees(rst.getString("degrees"));
            Usuario.setPassword(rst.getString("password"));
            Usuario.setMail(rst.getString("mail"));
            Usuario.setEnable(rst.getBoolean("enable"));
            Usuario.setMailVerify(rst.getBoolean("mailVerify"));
            
            return Usuario;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private Connection getConnection() {
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/seguromedico");

            return dataSource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



}
    
 
