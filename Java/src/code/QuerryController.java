/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author iamrehman
 */
public class QuerryController {
    
     

    public static  ArrayList<Admin> getAdmin(String id) throws SQLException{
        
         ArrayList<Admin> admins = new ArrayList<>();
        
        ResultSet rs= FAA.getResultSet("select * from admin where id= '" + id+ "' ;");
        
       
        while(rs.next()){
            
            //Admin(String id, String name,  String dob, String address, String phone, String pass)
            Admin admin = new Admin(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("dob"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("password")
            );
            
            admins.add(admin);
        }
        
        return admins;
    }
    
    
    public boolean addAdmin(Admin admin) throws IOException{
        // Admin(String id, String name,  String dob, String address, String phone, String pass
         String INSERT_RECORD = "insert into admin(id, name, dob, address, phone, password ) values(?, ?, ?, ? ,? ,?)";
        
       PreparedStatement pstmt=null;
        try {
             pstmt = FAA.con.prepareStatement(INSERT_RECORD);
             pstmt.setString(1, admin.id.getValue());
             pstmt.setString(2, admin.name.getValue());
             pstmt.setString(3, admin.dob.getValue());
             pstmt.setString(4, admin.address.getValue());
             pstmt.setString(5, admin.phone.getValue());
             pstmt.setString(6, admin.pass.getValue());
             pstmt.executeUpdate();
        } catch (SQLException e) {
                    while (e != null) {
                String errorMessage = e.getMessage();

                show_warn(errorMessage);

                e = e.getNextException();
                } 
           return false;
       }   
        
        show_warn("Account Successfully created!");
        return true;
    }
    
     public void  show_warn(String message) {
         
            FAA.warning_message=message;
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warning.fxml"));
            Parent root1=null;

        try {
            root1 = (Parent) fxmlLoader.load();
            /* first close this window */
        } catch (IOException ex) {
            Logger.getLogger(QuerryController.class.getName()).log(Level.SEVERE, null, ex);
        }

            Stage stage = new Stage();
            FAA.warn_scene=stage;
            
            stage.setScene(new Scene(root1)); 
            stage.showAndWait();
  
    }
    
    
     public ArrayList<Attendance> student_rec(String id) throws IOException{
         
         ArrayList<Attendance> attend= new ArrayList<>();
         
        ResultSet rs=null;
         
        try {
            rs = FAA.getResultSet("select * from attendance where StudentId= '" + id+ "' ;");
                   while(rs.next()){ 
                       
                   attend.add(new Attendance(rs.getString("record_no"), rs.getString("StudentID"), rs.getString("Date")));                       
                }
        
        } 
        catch (SQLException e) {
                     while (e != null) {
                 String errorMessage = e.getMessage();

                 show_warn(errorMessage);

                 e = e.getNextException();
          }          
         
        }
   return attend;  
     
     }
    
    
    public ArrayList<Student> students_on_day(String date)  {
         ArrayList<Student> students= new ArrayList<>();
         
         ArrayList<String> ids= new ArrayList<>();
         ResultSet rs=null;
         
        try {
            rs = FAA.getResultSet("select * from attendance where date= '" + date+ "' ;");
                   while(rs.next()){                            
                       ids.add(rs.getString("StudentId"));        
                       
              
             }
        
        } 
        catch (SQLException e) {
                     while (e != null) {
                 String errorMessage = e.getMessage();

                 show_warn(errorMessage);

                 e = e.getNextException();
        }           
       
    } 
        
            students=getStudents(ids);
          
       
    
         return students;
 }
    public ArrayList<Student> getStudents (ArrayList<String> ids) {
        
        ArrayList<Student> students= new ArrayList<>();
        
        for (String id: ids){
            if (id.equals("Unknown Face") )
            {
                students.add(new Student("00000000", "unknown-face", "---------"));
                continue;
            }
           try{
           ResultSet rs= FAA.getResultSet("select * from student where StudentId= '" + id+ "' ;");
           while(rs.next()) {
               Student student = new Student(
                       rs.getString("StudentId"),
                       rs.getString("name"),
                       rs.getString("section")
                       
               );
               students.add(student);
           }
           }
          catch (SQLException e) {
                     while (e != null) {
                 String errorMessage = e.getMessage();

                 show_warn(errorMessage);

                 e = e.getNextException();
                 } 
        }
        
        }
        if(students.size()==0){
            show_warn("No records found!");
        }
        return students;
    }
    
    public boolean AddAttendance(ArrayList<Student> students) throws IOException{
        // Admin(String id, String name,  String dob, String address, String phone, String pass
    return true;
    }
}