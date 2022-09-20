
package com.aloresto.services;

import com.aloresto.entites.Client;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ClientService implements IServices<Client>{
    
    private Connection cnx;
    
    public ClientService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Client t) throws SQLException {
        String req = "INSERT INTO Client (nom , prenom, tel, adresse) VALUES('"+ t.getNom() +"', '"+ t.getPrenom()+"', "+ t.getTel()+", '"+ t.getAdresse()+"' );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Client t) throws SQLException{
        String req = "UPDATE `client` SET `nom`= '"+t.getNom()+"' ,`prenom`= '"+t.getPrenom()+"' ,`tel`= "+t.getTel()+" ,`adresse`= '"+t.getAdresse()+"' WHERE ref_client = "+t.getRef_client();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Client t) throws SQLException{
        String req = "DELETE FROM client WHERE ref_client = "+t.getRef_client();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

  

        @Override
    public List<Client> afficher() throws SQLException{
        List<Client> users = new ArrayList<>();
        
        String req = "SELECT * FROM client";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Client c = new Client(res.getInt("ref_client"), res.getString("nom"),
                    res.getString("prenom"), res.getInt("tel"),res.getString("adresse") );
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}

