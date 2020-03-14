/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faa;
    
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author iamrehman
 */
public class Attendance {
    public SimpleStringProperty record_no;
    public SimpleStringProperty StudentId;
    public SimpleStringProperty date;
 
    
   public Attendance(String record_no, String StudentId, String date){
        this.record_no= new SimpleStringProperty(record_no);
        this.StudentId= new SimpleStringProperty(StudentId);
        this.date=new SimpleStringProperty(date);
    }
}
