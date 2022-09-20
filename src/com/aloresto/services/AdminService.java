
package com.aloresto.services;

import com.aloresto.entites.Admin;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AdminService implements IServices<Admin>{
    
    private Connection cnx;
    
    public AdminService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Admin t) throws SQLException {
        String req = "INSERT INTO Admin (nom , prenom, tel, adresse) VALUES('"+ t.getNom() +"', '"+ t.getPrenom()+"', "+ t.getTel()+", '"+ t.getAdresse()+"' );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Admin t) throws SQLException{
        String req = "UPDATE `admin` SET `nom`= '"+t.getNom()+"' ,`prenom`= '"+t.getPrenom()+"' ,`tel`= "+t.getTel()+" ,`adresse`= '"+t.getAdresse()+"' WHERE ref_admin = "+t.getRef_admin();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Admin t) throws SQLException{
        String req = "DELETE FROM admin WHERE ref_admin = "+t.getRef_admin();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

        @Override
    public List<Admin> afficher() throws SQLException{
        List<Admin> users = new ArrayList<>();
        
        String req = "SELECT * FROM admin";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Admin c = new Admin(res.getInt("ref_admin"), res.getString("nom"),
                    res.getString("prenom"), res.getInt("tel"),res.getString("adresse") );
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}