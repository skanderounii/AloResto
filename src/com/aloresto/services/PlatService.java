
package com.aloresto.services;

import com.aloresto.entites.Plat;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PlatService implements IServices<Plat>{
    
    private Connection cnx;
    
    public PlatService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Plat t) throws SQLException {
        String req = "INSERT INTO Plat (nom_plat , description_plat, prix_plat, temps_pre) VALUES('"+ t.getNom_plat() +"', '"+ t.getDescription_plat()+"', "+ t.getPrix_plat()+", "+ t.getTemps_pre()+" );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Plat t) throws SQLException{
        String req = "UPDATE `plat` SET `nom_plat`= '"+t.getNom_plat()+"' ,`description_plat`= '"+t.getDescription_plat()+"' ,`prix_plat`= "+t.getPrix_plat()+" ,`temps_pre`= "+t.getTemps_pre()+" WHERE ref_plat = "+t.getRef_plat();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Plat t) throws SQLException{
        String req = "DELETE FROM plat WHERE ref_plat = "+t.getRef_plat();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

  

        @Override
    public List<Plat> afficher() throws SQLException{
        List<Plat> users = new ArrayList<>();
        
        String req = "SELECT * FROM plat";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Plat c = new Plat(res.getInt("ref_plat"), res.getString("nom_plat"),
                    res.getString("description_plat"), res.getFloat("prix_plat"),res.getInt("temps_pre") );
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}