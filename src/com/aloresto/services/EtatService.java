
package com.aloresto.services;

import com.aloresto.entites.Etat;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EtatService implements IServices<Etat>{
    
    private Connection cnx;
    
    public EtatService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Etat t) throws SQLException {
        String req = "INSERT INTO Etat (ref_etat , type_etat) VALUES("+ t.getRef_etat() +", '"+ t.getType_etat()+"' );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Etat t) throws SQLException{
        String req = "UPDATE `etat` SET `type_etat`= '"+t.getType_etat()+ "' WHERE ref_etat = "+t.getRef_etat();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Etat t) throws SQLException{
        String req = "DELETE FROM etat WHERE ref_etat = "+t.getRef_etat();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

        @Override
    public List<Etat> afficher() throws SQLException{
        List<Etat> users = new ArrayList<>();
        
        String req = "SELECT * FROM etat";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Etat c = new Etat(res.getInt("ref_etat"), res.getString("type_etat") );
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}
