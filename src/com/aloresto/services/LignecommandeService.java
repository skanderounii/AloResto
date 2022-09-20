
package com.aloresto.services;

import com.aloresto.entites.Commande;
import com.aloresto.entites.Lignecommande;
import com.aloresto.entites.Plat;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LignecommandeService implements IServices<Lignecommande>{
    
    private Connection cnx;
    
    public LignecommandeService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Lignecommande t) throws SQLException {
        String req = "INSERT INTO Lignecommande (quantite) VALUES('"+ t.getQuantite()+"' );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Lignecommande t) throws SQLException{
        String req = "UPDATE `Lignecommande` SET `quantite`= '"+t.getQuantite()+"' WHERE ref_com = "+t.getRef_com();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Lignecommande t) throws SQLException{
        String req = "DELETE FROM lignecommande WHERE ref_com = "+t.getRef_com();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

  

        @Override
    public List<Lignecommande> afficher() throws SQLException{
        List<Lignecommande> users = new ArrayList<>();
        
//        String req = "SELECT * FROM Lignecommande";
        String req = "SELECT * FROM `lignecommande` lc ,plat p, commande c WHERE p.ref_plat = lc.ref_plat and c.ref_com = lc.ref_com;";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            Plat p =new Plat(0, req, req, 0, 0);
            
            Commande cm = new Commande(res.getInt(9), res.getString(10));
            
            Lignecommande c = new Lignecommande(cm, p, res.getString("quantite"));
            
            users.add(c);
            
        }
        
//        users.get(0).getRef_plat().
        
        return users;
    } 

    
     
}