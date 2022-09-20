package com.aloresto.gui;

import com.aloresto.entites.Livreur;
import com.aloresto.services.LivreurService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chaouki-NH
 */
public class AjouterLFXMLController implements Initializable {

    @FXML
    private TextField nomL;
    @FXML
    private TextField prenomL;
    @FXML
    private TextField telL;
    @FXML
    private TextField adresseL;
    @FXML
    private TextField zoneL;
    @FXML
    private TextField nomC1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AccueilL(ActionEvent event) {
    }

    @FXML
    private void EnregistrerL(ActionEvent event) {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomL.getText().isEmpty() 
            && !prenomL.getText().isEmpty() 
            && !telL.getText().isEmpty() && !adresseL.getText().isEmpty() && !zoneL.getText().isEmpty()     ){
            
        try {
            int n = Integer.parseInt(telL.getText());
            Livreur l = new Livreur(nomL.getText(), prenomL.getText(), n , adresseL.getText(), zoneL.getText()  );
             
            LivreurService us = new LivreurService();
                
            us.ajouter(l);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Livreur ajouté avec succé !");
                a.setHeaderText("Ajouter Livreur :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("Le téléphone doit etre en format numerique !");
                a.show();
            } catch (SQLException ex) {
                a.setHeaderText("Erreur insertion :");
                a.setContentText(ex.getMessage());
                a.show();
            }    
      }else{
            a.show();
        }
                
    }

    @FXML
    private void AfficherL(ActionEvent event) {
    
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfficherLFXML.fxml"));
            Parent root = fxmlLoader.load();
            
           /* //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();*/

            //2eme methd
             nomL.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }  

    @FXML
    private void ResetL(ActionEvent event) {
        
    nomC1.setText("");   
    nomL.setText("");
    prenomL.setText("");
    telL.setText("");
    adresseL.setText("");
    zoneL.setText("");
    }

    @FXML
    private void sup(ActionEvent event) {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
         if ( !nomC1.getText().isEmpty()){
            
        try {
            int z = Integer.parseInt(nomC1.getText());
           
            Livreur c = new Livreur(z);
             
            LivreurService cl = new LivreurService();
                
            cl.supprimer(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Livreur supprimer avec succé !");
                a.setHeaderText("supprimer Livreur :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("Le téléphone doit etre en format numerique !");
                a.show();
            } catch (SQLException ex) {
                a.setHeaderText("Erreur suppression  :");
                a.setContentText(ex.getMessage());
                a.show();
            }  
        
      } else{
            a.show();
        }
        
    }

    @FXML
    private void mod(ActionEvent event) {
    
        
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomC1.getText().isEmpty() 
            &&!nomL.getText().isEmpty() 
            && !prenomL.getText().isEmpty() 
            && !telL.getText().isEmpty() && !adresseL.getText().isEmpty() && !zoneL.getText().isEmpty()     ){
            
        try {
            int z = Integer.parseInt(nomC1.getText());
            int n = Integer.parseInt(telL.getText());
            Livreur l = new Livreur(z,nomL.getText(), prenomL.getText(), n , adresseL.getText(), zoneL.getText()  );
             
            LivreurService us = new LivreurService();
                
            us.modifier(l);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Livreur modifier avec succé !");
                a.setHeaderText("Modifier Livreur :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("Le téléphone doit etre en format numerique !");
                a.show();
            } catch (SQLException ex) {
                a.setHeaderText("Erreur modification :");
                a.setContentText(ex.getMessage());
                a.show();
            }    
      }else{
            a.show();
        }
                
    }
    
}
