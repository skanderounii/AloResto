/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aloresto.gui;

import com.aloresto.entites.Plat;
import com.aloresto.services.PlatService;
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
public class AjouterPlaFXMLController implements Initializable {

    @FXML
    private TextField nomPla;
    @FXML
    private TextField desPla;
    @FXML
    private TextField prixPla;
    @FXML
    private TextField tempsPla;
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
        
        if ( !nomPla.getText().isEmpty() 
            && !desPla.getText().isEmpty() 
            && !prixPla.getText().isEmpty() && !tempsPla.getText().isEmpty() ){
            
        try {
            float z = Float.parseFloat(prixPla.getText());
            int n = Integer.parseInt(tempsPla.getText());
            Plat c = new Plat(nomPla.getText(),desPla.getText(),z,n );
             
            PlatService cl = new PlatService();
                
            cl.ajouter(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Plat ajouté avec succé !");
                a.setHeaderText("Ajouter Plat :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("Le Prix doit etre en format numerique !");
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfficherPlaFXML.fxml"));
            Parent root = fxmlLoader.load();
            
           /* //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();*/

            //2eme methd
             nomPla.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }  

    @FXML
    private void ResetC(ActionEvent event) {
    nomC1.setText("");    
    nomPla.setText("");
    desPla.setText("");
    prixPla.setText("");
    tempsPla.setText("");
    }

    @FXML
    private void mod(ActionEvent event) {
    
            Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !nomC1.getText().isEmpty() 
            &&!nomPla.getText().isEmpty() 
            && !desPla.getText().isEmpty() 
            && !prixPla.getText().isEmpty() && !tempsPla.getText().isEmpty() ){
            
        try {
            int d = Integer.parseInt(nomC1.getText());
            float z = Float.parseFloat(prixPla.getText());
            int n = Integer.parseInt(tempsPla.getText());
            Plat c = new Plat(d,nomPla.getText(),desPla.getText(),z,n );
             
            PlatService cl = new PlatService();
                
            cl.modifier(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Plat modifier avec succé !");
                a.setHeaderText("Modifier Plat :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("Le Prix doit etre en format numerique !");
                a.show();
            } catch (SQLException ex) {
                a.setHeaderText("Erreur Modification :");
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
           
            Plat c = new Plat(z);
             
            PlatService cl = new PlatService();
                
            cl.supprimer(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Plat supprimer avec succé !");
                a.setHeaderText("Supprimer Plat :");
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
