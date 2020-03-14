/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class WarningController implements Initializable {
    @FXML
    private JFXButton OK;
    @FXML
    private Label WarnText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
       WarnText.setText(FAA.warning_message);
       
        // TODO
    }    

    @FXML
    private void OKHandler(ActionEvent event) {
            Stage st = (Stage) OK.getScene().getWindow();
            // do what you have to do
            st.close();
    }
    
}
