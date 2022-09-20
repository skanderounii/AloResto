
package com.aloresto.services;

import com.aloresto.entites.Livraison;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LivraisonService implements IServices<Livraison>{
    
    private Connection cnx;
    
    public LivraisonService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Livraison t) throws SQLException {
        String req = "INSERT INTO Livraison (date_liv , heure_liv) VALUES('"+ t.getDate_liv() +"', "+ t.getHeure_liv()+" );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Livraison t) throws SQLException{
        String req = "UPDATE `livraison` SET `date_liv`= '"+t.getDate_liv()+"' ,`heure_liv`= "+t.getHeure_liv()+" WHERE ref_liv = "+t.getRef_liv();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Livraison t) throws SQLException{
        String req = "DELETE FROM livraison WHERE ref_liv = "+t.getRef_liv();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

        @Override
    public List<Livraison> afficher() throws SQLException{
        List<Livraison> users = new ArrayList<>();
        
        String req = "SELECT * FROM livraison";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Livraison c = new Livraison(res.getInt("ref_liv"), res.getString("date_liv"),
                    res.getFloat("heure_liv") );
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}