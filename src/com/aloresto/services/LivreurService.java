
package com.aloresto.services;

import com.aloresto.entites.Livreur;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LivreurService implements IServices<Livreur>{
    
    private Connection cnx;
    
    public LivreurService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Livreur t) throws SQLException {
        String req = "INSERT INTO Livreur (nom , prenom, tel, adresse,zone) VALUES('"+ t.getNom() +"', '"+ t.getPrenom()+"', "+ t.getTel()+", '"+ t.getAdresse()+"','"+ t.getZone()+"'  );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Livreur t) throws SQLException{
        String req = "UPDATE `livreur` SET `nom`= '"+t.getNom()+"' ,`prenom`= '"+t.getPrenom()+"' ,`tel`= "+t.getTel()+" ,`adresse`= '"+t.getAdresse()+"', `zone`= '"+t.getZone()+"'  WHERE ref_livreur = "+t.getRef_livreur();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Livreur t) throws SQLException{
        String req = "DELETE FROM livreur WHERE ref_livreur = "+t.getRef_livreur();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

  

        @Override
    public List<Livreur> afficher() throws SQLException{
        List<Livreur> users = new ArrayList<>();
        
        String req = "SELECT * FROM livreur";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Livreur l = new Livreur(res.getInt("ref_livreur"), res.getString("nom"),
                    res.getString("prenom"), res.getInt("tel"),res.getString("adresse"), res.getString("zone")  );
            users.add(l);
            
        }
        
        return users;
    } 

    
     
}