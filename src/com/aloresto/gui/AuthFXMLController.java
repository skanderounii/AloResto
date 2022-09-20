package com.aloresto.gui;

import com.aloresto.utils.MaConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AuthFXMLController implements Initializable {

@FXML
private AnchorPane isConnected;
@FXML
private TextField username;
@FXML
private TextField userpassword;
    
@Override
public void initialize(URL url, ResourceBundle rb) {
}    
@FXML
private void login(ActionEvent event) throws IOException {
        
MaConnexion connectionClass=new MaConnexion();
Connection connection=connectionClass.getCnx();
    
try{
Statement statement=connection.createStatement();
String sql="SELECT * FROM auth WHERE username = '"+username.getText()+"' AND password = '"+userpassword.getText()+"';";
ResultSet resultSet=statement.executeQuery(sql);

if (resultSet.next()){
                
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu1FXML.fxml"));
Parent root = fxmlLoader.load();
username.getScene().setRoot(root);
}

else {
System.out.println("Login et password non valid saisir de nouveau");
username.setText("");
userpassword.setText("");
}
} catch (SQLException e) {
e.printStackTrace();
}
}

@FXML
private void reset(ActionEvent event) throws IOException { 
username.setText("");
userpassword.setText("");
}  
}
    

