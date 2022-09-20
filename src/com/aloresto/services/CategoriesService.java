
package com.aloresto.services;

import com.aloresto.entites.Categories;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CategoriesService implements IServices<Categories>{
    
    private Connection cnx;
    
    public CategoriesService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Categories t) throws SQLException {
        String req = "INSERT INTO Categories (type_cat, libelle) VALUES('"+ t.getType_cat() +"', '"+ t.getLibelle()+"' );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Categories t) throws SQLException{
        String req = "UPDATE `categories` SET `type_cat`= '"+t.getType_cat()+"' ,`libelle`= '"+t.getLibelle()+"' WHERE ref_cat = "+t.getRef_cat();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Categories t) throws SQLException{
        String req = "DELETE FROM categories WHERE ref_cat = "+t.getRef_cat();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

  

        @Override
    public List<Categories> afficher() throws SQLException{
        List<Categories> users = new ArrayList<>();
        
        String req = "SELECT * FROM Categories";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Categories c = new Categories(res.getInt("ref_cat"), res.getString("type_cat"),
            res.getString("libelle") );
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}
