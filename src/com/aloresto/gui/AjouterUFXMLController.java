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
public class AjouterUFXMLController implements Initializable {

    @FXML
    private TextField nomU;
    @FXML
    private TextField prenomU;
    @FXML
    private TextField telU;
    @FXML
    private TextField adresseU;
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
    private void AccueilU(ActionEvent event) {
    }

    @FXML
    private void EnregistrerU(ActionEvent event) {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomU.getText().isEmpty() 
            && !prenomU.getText().isEmpty() 
            && !telU.getText().isEmpty() && !adresseU.getText().isEmpty() ){
            
        try {
            int n = Integer.parseInt(telU.getText());
            User u = new User(nomU.getText(), prenomU.getText(), n , adresseU.getText() );
             
            UserService us = new UserService();
                
            us.ajouter(u);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Personne ajouté avec succé !");
                a.setHeaderText("Ajouter Personne :");
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
    private void AfficherU(ActionEvent event) {
    
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfficherUFXML.fxml"));
            Parent root = fxmlLoader.load();
            
           /* //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();*/

            //2eme methd
             nomU.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }  

    @FXML
    private void ResetU(ActionEvent event) {
    
    nomC1.setText("");   
    nomU.setText("");
    prenomU.setText("");
    telU.setText("");
    adresseU.setText("");
    }

    @FXML
    private void mod(ActionEvent event) {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomC1.getText().isEmpty() 
            &&!nomU.getText().isEmpty() 
            && !prenomU.getText().isEmpty() 
            && !telU.getText().isEmpty() && !adresseU.getText().isEmpty() ){
            
        try {
            int z = Integer.parseInt(nomC1.getText());
            int n = Integer.parseInt(telU.getText());
            User u = new User(z,nomU.getText(), prenomU.getText(), n , adresseU.getText() );
             
            UserService us = new UserService();
                
            us.modifier(u);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("User Modifier avec succé !");
                a.setHeaderText("Modification User :");
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
           
            User c = new User(z);
             
            UserService cl = new UserService();
                
            cl.supprimer(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("User supprimer avec succé !");
                a.setHeaderText("Supprimer User :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("Le téléphone doit etre en format numerique !");
                a.show();
            } catch (SQLException ex) {
                a.setHeaderText("Erreur Suppression  :");
                a.setContentText(ex.getMessage());
                a.show();
            }  
        
      } else{
            a.show();
        }
        
    }
    }
