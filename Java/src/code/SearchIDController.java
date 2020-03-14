/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static faa.AddRecController.ids;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class SearchIDController implements Initializable {
    
     Attendance at=new Attendance("160306", "Rehman", "E");
     TreeItem<Attendance> root = new TreeItem<>(at);
     
     
    @FXML
    private TreeTableView<Attendance> Table;
    @FXML
    private JFXButton show;
    @FXML
    private TreeTableColumn<Attendance, String> recNo;
    @FXML
    private TreeTableColumn<Attendance, String> Date;
    @FXML
    private JFXTextField stID;
    @FXML
    private TextArea NameText;
    @FXML
    private TextArea SectionText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         Table.setRoot(root);
            recNo.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Attendance, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Attendance, String> param) {
               return param.getValue().getValue().record_no;
            }
        });
            
       Date.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Attendance, String>, ObservableValue<String>>() {           @Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Attendance, String> param) {
               return param.getValue().getValue().date;
            }
        });

        
          
        recNo.setStyle("-fx-font-size: 15pt; -fx-font:Arial; -fx-background-color :  ##daafff   ;");
       Date.setStyle("-fx-font-size: 15pt; -fx-font:Arial; -fx-background-color :  ##daafff ;");
     
       
        
       Table.setShowRoot(false);
//        if(editable){
//        StudentId.setDisable(true);
//         Name.setDisable(true);
//         EnterStudent.setDisable(true);
//        Price.setDisable(true);
//        } 
//        
        
        
    }    

    @FXML
    private void showHandler(ActionEvent event) throws IOException {
        
      
            QuerryController qt =new QuerryController();
            ArrayList<String> ids= new ArrayList<>();
            ids.add(stID.getText());

        ArrayList<Student> sts= qt.getStudents(ids);
      
       if(sts!=null && sts.size()!=0)   
       {
           NameText.setText(sts.get(0).name.getValue());
           SectionText.setText(sts.get(0).section.getValue());
       }
      
       
        
       
       ArrayList<Attendance> atends=null;
       
        atends= qt.student_rec(stID.getText());
 
       if(atends!=null)   
       {
          
    
        for (int i=0; i<atends.size(); ++i){    
            TreeItem<Attendance> item =new TreeItem<Attendance>(atends.get(i));
            Table.getRoot().getChildren().add(item);
        }
        
           
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
