/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aloresto.gui;
import com.aloresto.entites.User;
import com.aloresto.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chaouki-NH
 */
public class Menu1FXMLController implements Initializable {

    @FXML
    private ImageView im;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reclamationM(ActionEvent event) {
        
            try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("RECLAMATION :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    @FXML
    private void commandeM(ActionEvent event) {
        
        try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterComFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("COMMANDE :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void etatM(ActionEvent event) {
        
            try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterEta.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("ETAT :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ligneCommandeM(ActionEvent event) {
        
                try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterLigFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("LIGNE COMMANDE :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void livraisonM(ActionEvent event) {
        
                try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterLiv.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("RECLAMATION :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    @FXML
    private void routeM(ActionEvent event) {
        
                   try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterRot.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("ROUTE :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    @FXML
    private void platM(ActionEvent event) {
        
            try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterPlaFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("PLAT :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    @FXML
    private void categoriesM(ActionEvent event) {
        
            try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterCatFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle(" CATEGORIES :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    @FXML
    private void userM(ActionEvent event) {
        
        
    try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterUFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("USER :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
      
    }

    @FXML
    private void administrateurM(ActionEvent event) {
    
    try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterAFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("ADMINISTRATEUR :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
      
    }

    @FXML
    private void livreurM(ActionEvent event) {
    
        try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterLFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("LIVREUR :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
      
    }

    @FXML
    private void ClientM(ActionEvent event) {
    
        try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterCFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("CLIENT :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
      
    }

    @FXML
    private void ChefM(ActionEvent event) {
    
        try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterCCFXML.fxml"));
    Parent root = fxmlLoader.load();
            
            //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("CHEF :");
            st.setScene(scene);
            st.show();

            //2eme methd
             //nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
      
    }

    @FXML
    private void quitterM(ActionEvent event) {
        
    Platform.exit();
    }
}

    


