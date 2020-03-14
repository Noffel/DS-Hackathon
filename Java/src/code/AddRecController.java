/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.jfoenix.controls.JFXButton;
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
import javafx.fxml.Initializable;
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
public class AddRecController implements Initializable {
    
    public static ArrayList<String> ids=null;
    
    
    Student at=new Student("160306", "Rehman", "E");
    
    TreeItem<Student> root = new TreeItem<>(at);
    @FXML
    private TreeTableView<Student> Table;
    @FXML
    private TreeTableColumn<Student, String> StudentId;
    @FXML
    private TreeTableColumn<Student, String> StudentName;
    @FXML
    private TreeTableColumn<Student, String> StudentSection;
    @FXML
    private JFXButton login;

    ArrayList<Student> students=null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Table.setRoot(root);
            StudentId.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
               return param.getValue().getValue().id;
            }
        });
            
       StudentName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {           @Override
           public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
               return param.getValue().getValue().name;
            }
        });
        
        StudentSection.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
           @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
               return param.getValue().getValue().section;
            }
        });
        
          
        StudentId.setStyle("-fx-font-size: 15pt; -fx-font:Arial; -fx-background-color :  ##daafff   ;");
       StudentName.setStyle("-fx-font-size: 15pt; -fx-font:Arial; -fx-background-color :  ##daafff ;");
      
        StudentSection.setStyle("-fx-font-size: 15pt; -fx-font:Arial; -fx-background-color :  ##daafff ;");
             
        
        QuerryController qt= new QuerryController();
        
       
         students = qt.getStudents(ids);
     
        
        for (int i=0; i<students.size(); ++i){    
            TreeItem<Student> item =new TreeItem<Student>(students.get(i));
          
            Table.getRoot().getChildren().add(item);
        }
        
        
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
    private void submitHandler(ActionEvent event) throws IOException {
        QuerryController qt= new QuerryController();
        
        qt.AddAttendance(students);
        
          
             Stage st = (Stage) login.getScene().getWindow();
            // do what you have to do
            st.close();
    }
    
}
