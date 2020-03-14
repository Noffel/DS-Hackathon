/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author iamrehman
 */
public class FAA extends Application {
    public static Connection con;
    @Override
    public void start(Stage stage) throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/faa","root","rehman");
  
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new
         Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static String warning_message="Please enter valid information!";
    
    public static Stage warn_scene=null;

     public static ResultSet getResultSet(String query) throws SQLException{
      Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      ResultSet rs=st.executeQuery(query);
      return rs;
    }   
    
}
