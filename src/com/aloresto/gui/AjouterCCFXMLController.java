package com.aloresto.gui;

import com.aloresto.entites.Chef;
import com.aloresto.services.ChefService;
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
public class AjouterCCFXMLController implements Initializable {

    @FXML
    private TextField nomCC;
    @FXML
    private TextField prenomCC;
    @FXML
    private TextField telCC;
    @FXML
    private TextField adresseCC;
    @FXML
    private TextField specialiteCC;
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
    private void AccueilCC(ActionEvent event) {
    }

    @FXML
    private void EnregistrerCC(ActionEvent event) {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomCC.getText().isEmpty() 
            && !prenomCC.getText().isEmpty() 
            && !telCC.getText().isEmpty() && !adresseCC.getText().isEmpty() && !specialiteCC.getText().isEmpty()     ){
            
        try {
            int n = Integer.parseInt(telCC.getText());
            Chef d = new Chef(nomCC.getText(), prenomCC.getText(), n , adresseCC.getText(), specialiteCC.getText()  );
             
            ChefService us = new ChefService();
                
            us.ajouter(d);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Chef ajouté avec succé !");
                a.setHeaderText("Ajouter Chef :");
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
    private void AfficherCC(ActionEvent event) {
    
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfficherCCFXML.fxml"));
            Parent root = fxmlLoader.load();
            
           /* //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();*/

            //2eme methd
             nomCC.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }  

    @FXML
    private void ResetCC(ActionEvent event) {
     nomC1.setText("");   
    nomCC.setText("");
    prenomCC.setText("");
    telCC.setText("");
    adresseCC.setText("");
    specialiteCC.setText("");
    }

    @FXML
    private void mod(ActionEvent event) {
        
            Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomC1.getText().isEmpty() 
            &&!nomCC.getText().isEmpty() 
            && !prenomCC.getText().isEmpty() 
            && !telCC.getText().isEmpty() && !adresseCC.getText().isEmpty() && !specialiteCC.getText().isEmpty()     ){
            
        try {
            int z = Integer.parseInt(nomC1.getText());
            int n = Integer.parseInt(telCC.getText());
            Chef d = new Chef(z,nomCC.getText(), prenomCC.getText(), n , adresseCC.getText(), specialiteCC.getText()  );
             
            ChefService us = new ChefService();
                
            us.modifier(d);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Chef modifier avec succé !");
                a.setHeaderText("Modifier Chef :");
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

    @FXML
    private void sup(ActionEvent event) {
         Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
         if ( !nomC1.getText().isEmpty()){
            
        try {
            int z = Integer.parseInt(nomC1.getText());
           
            Chef c = new Chef(z);
             
            ChefService cl = new ChefService();
                
            cl.supprimer(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Chef supprimier avec succé !");
                a.setHeaderText("Supprimier Chef :");
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
    }
