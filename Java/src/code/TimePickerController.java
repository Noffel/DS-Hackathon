/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class TimePickerController implements Initializable {
    @FXML
    private JFXTimePicker picker;
    @FXML
    private JFXButton start;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }    

    @FXML
    private void startHandler(ActionEvent event) {
        
       
        ObjectProperty<LocalTime> p= picker.valueProperty();
       LocalTime time= p.getValue();
        
      
      long minutes = ChronoUnit.MINUTES.between(LocalTime.now(), time);
       
       HomeController.wait= (int) minutes ;
       
         Stage st = (Stage) picker.getScene().getWindow();
            // do what you have to do
            st.close();
       
    }
    
    
}
