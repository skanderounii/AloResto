/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aloresto.gui;

import com.aloresto.entites.Route;
import com.aloresto.services.RouteService;
import java.io.IOException;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Chaouki-NH
 */
public class AjouterRotController implements Initializable {

    @FXML
    private TextField locaRot;
    @FXML
    private TextField nomC1;
 @FXML
    private TextField emailtxt;
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
    private void EnregistrerC(ActionEvent event) throws AddressException, MessagingException {
    
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if ( !locaRot.getText().isEmpty() 
           ){
            
        try {
            Route c = new Route(locaRot.getText() );
             
            RouteService cl = new RouteService();
                
            cl.ajouter(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Route ajouté avec succé !");
                a.setHeaderText("Ajouter Route :");
                a.setTitle("Succes :");
                a.show();
                
               String host="ouni.skander@esprit.tn";  //← my email address
        final String user="ouni.skander@esprit.tn";//← my email address
        final String password="E09933369";//change accordingly   //← my email password

        String to=emailtxt.getText();//→ the EMAIL i want to send TO →

        // session object
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //My message :
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(" NOTIFICATION APPOINTEMENTT !!! ");
            //Text in emial :
            //message.setText("  → Text message for Your Appointement ← ");
            //Html code in email :
            message.setContent(
                    "<h1 style =\"color:red\" >DON'T MISS YOUR APPOINTEMENT !! </h1> <br/> <img width=\"50%\" height=\"50%\" src=https://i.imgur.com/iYcBkOf.png>",
                    "text/html");

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully via mail ... !!! ");

        } catch (MessagingException e) {e.printStackTrace();}

       
    
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("saisir la date !");
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfficherRot.fxml"));
            Parent root = fxmlLoader.load();
            
           /* //1er methd 
            Scene scene = new Scene(root);
            Stage st = new Stage();
            st.setTitle("Afficher Personne :");
            st.setScene(scene);
            st.show();*/

            //2eme methd
             locaRot.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }  

    @FXML
    private void ResetC(ActionEvent event) {
     nomC1.setText("");   
    locaRot.setText("");
   
    }

    @FXML
    private void mod(ActionEvent event) {
    
                Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("Champs vide !");
        a.setHeaderText("Controle de saisie :");
        a.setTitle("Erreur :");
        
        if (  !nomC1.getText().isEmpty() 
            &&!locaRot.getText().isEmpty() 
           ){
            
        try {
            int z = Integer.parseInt(nomC1.getText());
            Route c = new Route(z,locaRot.getText() );
             
            RouteService cl = new RouteService();
                
            cl.modifier(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Route modifier avec succé !");
                a.setHeaderText("Modifier Route :");
                a.setTitle("Succes :");
                a.show();
                
            } catch (NumberFormatException e) {
                a.setHeaderText("Controle de saisie :");
                a.setContentText("saisir la date !");
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
           
            Route c = new Route(z);
             
            RouteService cl = new RouteService();
                
            cl.supprimer(c);
            
            a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Route supprimer avec succé !");
                a.setHeaderText("supprimer Route :");
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
