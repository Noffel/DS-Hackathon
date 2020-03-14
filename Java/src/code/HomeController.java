/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import org.python.util.PythonInterpreter;
import org.python.core.*;
/**
 * FXML Controller class
 *
 * @author iamrehman
 */
public class HomeController implements Initializable {
    @FXML
    private ImageView image;
    @FXML
    private JFXButton recordButton;

    
    public static int wait=0;
    @FXML
    private JFXButton idSearch;
    @FXML
    private JFXButton dateSearch;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
   boolean isRunning(Process process) {
    try {
        process.exitValue();
        return false;
    } catch (Exception e) {
        return true;
    }
}
   
   
    @FXML
    private void recordHandler(ActionEvent event) throws InterruptedException, IOException{
        
       show_win("timePicker.fxml");
        
    try{
        
        
        if(wait<=0)
            return;
          Process runtime = Runtime.getRuntime().exec("cmd /c start  microsoft.windows.camera:");
        TimeUnit.SECONDS.sleep(wait*60);
       
       
        
      
        Process runtime2 = Runtime.getRuntime().exec("cmd /c start python D:\\workspace\\FASTAutonomousAttendance\\faceRecognition\\TestModel.py");
        
         
        File output= new File("D:\\workspace\\FASTAutonomousAttendance\\faceRecognition\\result.txt");
//       String command = "python /c start python D:\\workspace\\FASTAutonomousAttendance\\faceRecognition\\TestModel.py";
//       Process p = Runtime.getRuntime().exec("python D:\\workspace\\FASTAutonomousAttendance\\faceRecognition\\TestModel.py");
//       
//       ProcessBuilder pb = new ProcessBuilder("python","D:\\workspace\\FASTAutonomousAttendance\\faceRecognition\\TestModel.py");
//       pb.start();
//        
        while(!output.exists()){
            
        }      
        
        
        ArrayList<String> arr = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(output)))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }
            
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } 
           
       output.delete();
        Set<String> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        
        AddRecController.ids=arr;
        show_win("AddRec.fxml");
        
       System.out.println("yikes");
    }
    catch(IOException e){    
                 while (e != null) {
                String errorMessage = e.getMessage();

                show_warn(errorMessage);
                } 
        
    }
       
    }
 
    
        
     public void  show_warn(String message) {
         
            FAA.warning_message=message;
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warning.fxml"));
            Parent root1=null;

        try {
            root1 = (Parent) fxmlLoader.load();
            /* first close this window */
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

            Stage stage = new Stage();
            FAA.warn_scene=stage;
            
            stage.setScene(new Scene(root1)); 
            stage.showAndWait();
  
    }
     
     
     public void show_win(String win) throws IOException{
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(win));
         Parent root1 = (Parent) fxmlLoader.load();
        /* first close this window */

        Stage stage = new Stage();
        FAA.warn_scene=stage;
            
        stage.setScene(new Scene(root1)); 
        stage.showAndWait();
        
     }

    @FXML
    private void searchIdHandler(ActionEvent event) throws IOException {
        
        show_win("SearchID.fxml");
    }

    @FXML
    private void SearchDateHandler(ActionEvent event) throws IOException {
        show_win("searchByDate.fxml");
    }
     
}
