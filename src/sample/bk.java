/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mamoun kubur
 */
public class bk {
   private final SimpleStringProperty Id;
   private final SimpleStringProperty Book;
   private final SimpleStringProperty Author;
   private final SimpleStringProperty Date;
   private final SimpleStringProperty Available;
   private final SimpleStringProperty With;

public bk(String id,String book, String author, String date,String available,String with) {
    this.Id=new SimpleStringProperty(id);
    this.Book =new SimpleStringProperty(book);
    this.Author=new SimpleStringProperty(author);
    this.Date=new SimpleStringProperty(date);
    this.Available=new SimpleStringProperty(available);
    this.With=new SimpleStringProperty(with);
    }
    
    public void setID(String id) {
        this.Book.set(id);
    }
    
    public void setBook(String bname) {
        this.Book.set(bname);
    }

    public void setAuthor(String bauthor) {
        this.Author.set(bauthor);
    }

    public void setDate(String bdate) {
        this.Date.set(bdate);
    }
    
     public void setAvailable(String ava) {
        this.Date.set(ava);
    }
     public void setWith(String wi) {
        this.Date.set(wi);
    }
    
    public String getId(){
        return Id.get();
    } 
    public String getBook(){
        return Book.get();
    }
    public String getAuthor(){
        return Author.get();
    }
    public String getDate(){
        return Date.get();
    }
     public String getAvailable(){
        return Available.get();
    }
      public String getWith(){
        return With.get();
    }
      
     public StringProperty Idproperty(){
        return Id;
    }
    
    public StringProperty Bookproperty(){
        return Book;
    }
    public StringProperty Authorproperty(){
        return Author;
    }
    public StringProperty Dateproperty(){
        return Date;
    }
     public StringProperty Availableproperty(){
        return Available;
    }
     
      public StringProperty Withproperty(){
        return With;
    }
    
}
