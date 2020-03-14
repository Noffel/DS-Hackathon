/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class SearchByDateController implements Initializable {
    
    Student at=new Student("160306", "Rehman", "E");
    
    TreeItem<Student> root = new TreeItem<>(at);
    
    
    @FXML
    private JFXButton show;
    @FXML
    private TreeTableView<Student> Table;
    @FXML
    private TreeTableColumn<Student, String> StudentId;
    @FXML
    private TreeTableColumn<Student, String> StudentName;
    @FXML
    private TreeTableColumn<Student, String> StudentSection;
    @FXML
    private JFXDatePicker datePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
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
             
         Table.setShowRoot(false);
    }    

    @FXML
    private void showHandler(ActionEvent event) throws IOException {
        String date= datePicker.getValue().toString();
        
        date=date.replaceAll("\\s+","");
        QuerryController qt= new QuerryController();
        
        ArrayList<Student> students_on_day = qt.students_on_day(date);
        for (int i=0; i<students_on_day.size(); ++i){
            
             TreeItem<Student> item =new TreeItem<Student>(students_on_day.get(i));
          
            Table.getRoot().getChildren().add(item);
        }
        
        
    }

    @FXML
    private void datePicked(ActionEvent event) {
    }
    
}
