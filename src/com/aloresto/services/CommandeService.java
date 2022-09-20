
package com.aloresto.services;

import com.aloresto.entites.Commande;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CommandeService implements IServices<Commande>{
    
    private Connection cnx;
    
    public CommandeService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Commande t) throws SQLException {
        String req = "INSERT INTO Commande (date_com) VALUES('"+ t.getDate_com() +"' );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Commande t) throws SQLException{
        String req = "UPDATE `commande` SET `date_com`= '"+t.getDate_com()+"' WHERE ref_com = "+t.getRef_com();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Commande t) throws SQLException{
        String req = "DELETE FROM commande WHERE ref_com = "+t.getRef_com();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

  

        @Override
    public List<Commande> afficher() throws SQLException{
        List<Commande> users = new ArrayList<>();
        
        String req = "SELECT * FROM Commande";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Commande c = new Commande(res.getInt("ref_com"), res.getString("date_com"));
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}