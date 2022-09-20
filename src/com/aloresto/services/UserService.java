
package com.aloresto.services;

import com.aloresto.entites.User;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserService implements IServices<User>{
    
    private Connection cnx;
    
    public UserService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(User t) throws SQLException {
        String req = "INSERT INTO user (nom, prenom, tel, adresse) VALUES('"+ t.getNom() +"', '"+ t.getPrenom()+"', "+ t.getTel()+", '"+ t.getAdresse()+"');";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(User t) throws SQLException{
        String req = "UPDATE `user` SET `nom`= '"+t.getNom()+"' ,`prenom`= '"+t.getPrenom()+"' ,`tel`= "+t.getTel()+" ,`adresse`= '"+t.getAdresse()+"'  WHERE id = "+t.getId();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void supprimer(User t) throws SQLException{
        String req = "DELETE FROM user WHERE id = "+t.getId();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

        @Override
    public List<User> afficher() throws SQLException{
        List<User> users = new ArrayList<>();
        
        String req = "SELECT * FROM user";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            User u = new User(res.getInt("id"), res.getString("nom"),
                    res.getString("prenom"), res.getInt("tel"),res.getString("adresse") );
            
            users.add(u);
            
        }
        
        return users;

    }  

    
  
}

