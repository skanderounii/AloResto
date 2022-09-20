
package com.aloresto.services;

import com.aloresto.entites.Chef;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ChefService implements IServices<Chef>{
    
    private Connection cnx;
    
    public ChefService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Chef t) throws SQLException {
        String req = "INSERT INTO Chef (nom , prenom, tel, adresse,specialite) VALUES('"+ t.getNom() +"', '"+ t.getPrenom()+"', "+ t.getTel()+", '"+ t.getAdresse()+"','"+ t.getSpecialite()+"'  );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Chef t) throws SQLException{
        String req = "UPDATE `chef` SET `nom`= '"+t.getNom()+"' ,`prenom`= '"+t.getPrenom()+"' ,`tel`= "+t.getTel()+" ,`adresse`= '"+t.getAdresse()+"', `specialite`= '"+t.getSpecialite()+"'  WHERE ref_chef = "+t.getRef_chef();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Chef t) throws SQLException{
        String req = "DELETE FROM chef WHERE ref_chef = "+t.getRef_chef();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

  

        @Override
    public List<Chef> afficher() throws SQLException{
        List<Chef> users = new ArrayList<>();
        
        String req = "SELECT * FROM chef";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Chef d = new Chef(res.getInt("ref_chef"), res.getString("nom"),
                    res.getString("prenom"), res.getInt("tel"),res.getString("adresse"), res.getString("specialite")  );
            users.add(d);
            
        }
        
        return users;
    } 

    
     
}