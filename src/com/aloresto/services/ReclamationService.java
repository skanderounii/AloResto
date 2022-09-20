
package com.aloresto.services;

import com.aloresto.entites.Reclamation;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ReclamationService implements IServices<Reclamation>{
    
    private Connection cnx;
    
    public ReclamationService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reclamation t) throws SQLException {
        String req = "INSERT INTO Reclamation (description , date_rec, heure_rec) VALUES('"+ t.getDescription() +"', '"+ t.getDate_rec()+"', "+ t.getHeure_rec()+" );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Reclamation t) throws SQLException{
        String req = "UPDATE `Reclamation` SET `description`= '"+t.getDescription()+"' ,`date_rec`= '"+t.getDate_rec()+"' ,`heure_rec`= "+t.getHeure_rec()+ " WHERE ref_rec = "+t.getRef_rec();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Reclamation t) throws SQLException{
        String req = "DELETE FROM Reclamation WHERE ref_rec = "+t.getRef_rec();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

        @Override
    public List<Reclamation> afficher() throws SQLException{
        List<Reclamation> users = new ArrayList<>();
        
        String req = "SELECT * FROM Reclamation";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Reclamation c = new Reclamation(res.getInt("ref_rec"), res.getString("description"),
            res.getString("date_rec"), res.getFloat("heure_rec") );
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}