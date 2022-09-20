package com.aloresto.gui;

import com.aloresto.entites.Admin;
import com.aloresto.services.AdminService;
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
public class AjouterAFXMLController implements Initializable {

    @FXML
    private TextField nomA;
    @FXML
    private TextField prenomA;
    @FXML
    private TextField telA;
    @FXML
    private TextField adresseA;
    @FXML
    private TextField nomc1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AccueilA(ActionEvent event) {
    }

    @FXML
    private void EnregistrerA(ActionEvent event) {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomA.getText().isEmpty() 
            && !prenomA.getText().isEmpty() 
            && !telA.getText().isEmpty() && !adresseA.getText().isEmpty() ){
            
        try {
            int n = Integer.parseInt(telA.getText());
            Admin c = new Admin(nomA.getText(), prenomA.getText(), n , adresseA.getText() );
             
            AdminService ad = new AdminService();
                
            ad.ajouter(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Administrateur ajouté avec succé !");
                a.setHeaderText("Ajouter Administrateur :");
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
    private void AfficherA(ActionEvent event) {
    
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfficherAFXML.fxml"));
            Parent root = fxmlLoader.load();
            
           /* //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();*/

            //2eme methd
             nomA.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }  

    @FXML
    private void ResetA(ActionEvent event) {
    nomc1.setText("");   
    nomA.setText("");
    prenomA.setText("");
    telA.setText("");
    adresseA.setText("");
    }

    @FXML
    private void suppC(ActionEvent event) {
        
       Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
         if ( !nomc1.getText().isEmpty()){
            
        try {
            int z = Integer.parseInt(nomc1.getText());
           
            Admin c = new Admin(z);
             
            AdminService cl = new AdminService();
                
            cl.supprimer(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Admin supprime avec succé !");
                a.setHeaderText("Supprimier Admin :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("Le téléphone doit etre en format numerique !");
                a.show();
            } catch (SQLException ex) {
                a.setHeaderText("Erreur suppression :");
                a.setContentText(ex.getMessage());
                a.show();
            }  
        
      } else{
            a.show();
        }
    }
    
    

    @FXML
    private void modif(ActionEvent event) {
        
        
        
            Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomc1.getText().isEmpty() 
            &&!nomA.getText().isEmpty() 
            && !prenomA.getText().isEmpty() 
            && !telA.getText().isEmpty() && !adresseA.getText().isEmpty() ){
            
        try {
            int n = Integer.parseInt(telA.getText());
            int z = Integer.parseInt(nomc1.getText());
            Admin c = new Admin(z,nomA.getText(), prenomA.getText(), n , adresseA.getText() );
             
            AdminService ad = new AdminService();
                
            ad.modifier(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Administrateur modifier avec succé !");
                a.setHeaderText("Modifier Administrateur :");
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
