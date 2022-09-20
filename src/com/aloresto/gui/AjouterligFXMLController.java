/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aloresto.gui;

import com.aloresto.entites.Lignecommande;
import com.aloresto.services.LignecommandeService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Chaouki-NH
 */
public class AjouterligFXMLController implements Initializable {

    @FXML
    private TextField quantiteLig;
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
    private void AccueilC(ActionEvent event) {
           
}    
    

    @FXML
    private void EnregistrerC(ActionEvent event) {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !quantiteLig.getText().isEmpty() 
           ){
            
        try {
            Lignecommande c = new Lignecommande(quantiteLig.getText() );
             
            LignecommandeService cl = new LignecommandeService();
                
            cl.ajouter(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Lignecommande ajouté avec succé !");
                a.setHeaderText("Ajouter LigneCommande :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("saisir la quantite !");
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
    private void AfficherC(ActionEvent event) {
    
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfficherLigFXML.fxml"));
            Parent root = fxmlLoader.load();
            
           /* //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();*/

            //2eme methd
             quantiteLig.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }  

    @FXML
    private void ResetC(ActionEvent event) {
    
    nomC1.setText("");
    quantiteLig.setText("");
   
    }

    @FXML
    private void mod(ActionEvent event) {
    
        
           Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomC1.getText().isEmpty() 
            &&!quantiteLig.getText().isEmpty() 
           ){
            
        try {
            int z = Integer.parseInt(nomC1.getText());
            Lignecommande c = new Lignecommande(quantiteLig.getText() );
             
            LignecommandeService cl = new LignecommandeService();
                
            cl.modifier(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Lignecommande modifier avec succé !");
                a.setHeaderText("Modifier LigneCommande :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("saisir la quantite !");
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

    }}