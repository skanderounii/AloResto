
package com.aloresto.services;

import com.aloresto.entites.Route;
import com.aloresto.utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RouteService implements IServices<Route>{
    
    private Connection cnx;
    
    public RouteService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Route t) throws SQLException {
        String req = "INSERT INTO Route (localisation) VALUES('"+ t.getLocalisation() +"' );";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Insertion ok !");
    }

    @Override
    public void modifier(Route t) throws SQLException{
        String req = "UPDATE `route` SET `localisation`= '"+t.getLocalisation()+"' WHERE ref_route = "+t.getRef_route();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Modification ok !");
    }

    @Override
    public void supprimer(Route t) throws SQLException{
        String req = "DELETE FROM route WHERE ref_route = "+t.getRef_route();
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("Suppression ok !");
    }

        @Override
    public List<Route> afficher() throws SQLException{
        List<Route> users = new ArrayList<>();
        
        String req = "SELECT * FROM route";
        
        Statement st = cnx.createStatement();
        
        ResultSet res = st.executeQuery(req);
        
        while(res.next()){
            
            Route c = new Route(res.getInt("ref_route"), res.getString("localisation")
                     );
            
            users.add(c);
            
        }
        
        return users;
    } 

    
     
}
