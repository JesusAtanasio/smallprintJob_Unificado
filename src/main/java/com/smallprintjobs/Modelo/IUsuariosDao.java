package com.smallprintjobs.Modelo;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.smallprintjobs.Beans.Usuario;

// Generated 01-feb-2017 21:02:19 by Hibernate Tools 5.2.0.CR1


public interface IUsuariosDao  {
	
    List searchUser(Usuario usuario) throws BussinessException;

	void insertUser(Usuario usuario) throws BussinessException;
	
	void insertUser(String alias, String surname, String name, String birth, 
			String sex, String degrees, String password, String mail, int enable, 
			int mailVerify, String audUser,String audTime) throws BussinessException;


    void deleteUser(Usuario usuario) throws BussinessException;
//    
//    void insertUsuario(String alias, String surname, String name, Date birth, String sex, String degrees, String password,
//			String mail, Boolean enable, Boolean mailVerify);
//    

    
//
//	
//	
//
//	public Integer getId_user() throws BussinessException; 
//
//	public void setId_user(Integer id_user) throws BussinessException ; 
//
//	public String getAlias() throws BussinessException;
//
//	public void setAlias(String alias) throws BussinessException; 
//
//	public String getSurname() throws BussinessException; 
//
//	public void setSurname(String surname) throws BussinessException; 
//
//	public String getName() throws BussinessException; 
//
//	public void setName(String name) throws BussinessException; 
//
//	public Date getBirth() throws BussinessException; 
//
//	public void setBirth(Date birth) throws BussinessException; 
//
//	public String getSex() throws BussinessException; 
//
//	public void setSex(String sex) throws BussinessException; 
//
//	public String getDegrees() throws BussinessException; 
//
//	public void setDegrees(String degrees) throws BussinessException; 
//
//	public String getPassword() throws BussinessException; 
//
//	public void setPassword(String password) throws BussinessException; 
//
//	public String getMail() throws BussinessException; 
//	
//	public void setMail(String mail) throws BussinessException;
//
//	public Boolean getEnable() throws BussinessException;
//
//	public void setEnable(Boolean enable) throws BussinessException;
//
//	public Boolean getMailVerify() throws BussinessException; 
//
//	public void setMailVerify(Boolean mailVerify) throws BussinessException;
}
