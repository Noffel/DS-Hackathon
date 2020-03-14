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
public class Student {
    public SimpleStringProperty name;
    public SimpleStringProperty id;
    public SimpleStringProperty section;

 

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleStringProperty getId() {
        return id;
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }


   public Student(String id, String name, String section){
        this.id=new SimpleStringProperty(id);
        this.name= new SimpleStringProperty(name);
        this.section=new SimpleStringProperty(section);
   
        
    }
}
