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
public class Admin {
    public SimpleStringProperty name;
    public SimpleStringProperty id;
    public SimpleStringProperty dob;
    public SimpleStringProperty address;
    public SimpleStringProperty pass;
    public SimpleStringProperty phone;
    
    public SimpleStringProperty getDob() {
        return dob;
    }

    public void setDob(SimpleStringProperty dob) {
        this.dob = dob;
    }

    public SimpleStringProperty getAddress() {
        return address;
    }

    public void setAddress(SimpleStringProperty address) {
        this.address = address;
    }

    public SimpleStringProperty getPhone() {
        return phone;
    }

    public void setPhone(SimpleStringProperty phone) {
        this.phone = phone;
    }

    

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

    public SimpleStringProperty getPrice() {
        return dob;
    }

    /**
     *
     * @param dob
     */
    public void setPrice(SimpleStringProperty dob) {
        this.dob = dob;
    }

   public Admin(String id, String name,  String dob, String address, String phone, String pass){
        this.id=new SimpleStringProperty(id);
        this.name= new SimpleStringProperty(name);
        this.dob=new SimpleStringProperty(dob);
        this.address= new SimpleStringProperty(address);
        this.phone= new SimpleStringProperty(phone);
         this.pass= new SimpleStringProperty(pass);
        
    }
}
