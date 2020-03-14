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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class signUPController implements Initializable {
    @FXML
    private AnchorPane name;
    @FXML
    private JFXButton sign;
    @FXML
    private JFXTextField ID;
    @FXML
    private JFXPasswordField password;
    @FXML
    private AnchorPane ImagePane;
    @FXML
    private JFXPasswordField repassword;
    @FXML
    private DatePicker date;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField phone;
    @FXML
    private ImageView image;
    @FXML
    private JFXTextField adminName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signHandler(ActionEvent event) throws IOException {
        boolean scene_on =  FAA.warn_scene!=null && FAA.warn_scene.isShowing();
        if(!password.getText().equals(repassword.getText())){
            if(!scene_on )
                show_warn("passwords do not match!");
        }
            
        if(date.getValue()==null)
        {
            if(!scene_on)
                show_warn("please pick your date of birth.");
        }
            
        Admin admin= new Admin(ID.getText(),adminName.getText(),date.getValue().toString(),address.getText(),
        phone.getText(),password.getText());
        
        QuerryController qt= new QuerryController();
        boolean added = qt.addAdmin(admin);
        if(added==true){
         
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            /* first close this window */

            Stage stage = new Stage();
            FAA.warn_scene=stage;
            
            stage.setScene(new Scene(root1)); 
            stage.show();
            
             Stage st = (Stage) ID.getScene().getWindow();
            // do what you have to do
            st.close();
     
            Stage stage2 = new Stage();
            stage2.hide();
            stage2.setScene(new Scene(root1)); 
            stage2.show();
        }  
        
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
