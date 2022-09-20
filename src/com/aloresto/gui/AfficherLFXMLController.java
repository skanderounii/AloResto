package com.aloresto.gui;

import com.aloresto.entites.Livreur;
import com.aloresto.services.LivreurService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chaouki-NH
 */
public class AfficherLFXMLController implements Initializable {

    @FXML
    private ListView<Livreur> ListeL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     LivreurService l = new LivreurService();
        
        try {
            
            List<Livreur> users =  l.afficher();
            
            for (int i = 0; i < users.size(); i++) {
                ListeL.getItems().add(users.get(i)); 
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }   

    @FXML
    private void QuitterL(ActionEvent event) {
        
           /*  try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterUFXML.fxml"));
            Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
     */
           
           Platform.exit();
    }  
    }

