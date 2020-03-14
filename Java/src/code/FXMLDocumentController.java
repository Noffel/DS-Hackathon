/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author iamrehman
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private JFXButton login;
    private JFXTextField idLogin;
    private JFXPasswordField password;
    @FXML
    private AnchorPane ImagePane;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton login1;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginHandler(ActionEvent event) throws IOException, SQLException {
        ArrayList<Admin> admins=QuerryController.getAdmin(idLogin.getText());
         if(  admins.size()!=0){
             
            if(!admins.get(0).pass.getValue().equals(password.getText())) {
                show_warn("incorrect password!");
                return;
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) login.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
        }
        else{
             show_warn("Admin id not found!");
        }
    }

    private void signupcontroller(ActionEvent event) throws IOException {
        
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */
            Stage st = (Stage) login.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage = new Stage();
            stage.hide();
            stage.setScene(new Scene(root1)); 
            stage.show();
    }

      public void  show_warn(String message) throws IOException{
         
            FAA.warning_message=message;
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warning.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */

            Stage stage = new Stage();
            FAA.warn_scene=stage;
            
            stage.setScene(new Scene(root1)); 
            stage.showAndWait();
  
    }
    

    
}
