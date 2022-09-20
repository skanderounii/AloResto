/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aloresto.utils;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Chaouki-NH
 */
public class MaConnexion {
    
private String url="jdbc:mysql://localhost:3306/alorestau"; 
private String login="root";
private String pwd="";    
    
private Connection cnx;
private static MaConnexion instance;

public MaConnexion() { 
    try {
        cnx=DriverManager.getConnection(url,login,pwd);
        System.out.println("Connexion etablie !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}

 public static MaConnexion getInstance(){
        if (instance == null) {
            instance = new MaConnexion();
        }
        
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

   
    
    
}


