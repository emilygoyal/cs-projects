/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author emilygoyal
 */
public class Book {
    private final String book_id;
    private String name;
    private String description;
    
    public Book(String b_id, String n, String d){
        this.book_id = b_id;
        this.name = n;
        this.description = d;
        //createDBConnection();    
    } 
    
    public String getBook_id(){
        return this.book_id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String n){
           this.name = n;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String d){
        this.description = d;
    }
}
