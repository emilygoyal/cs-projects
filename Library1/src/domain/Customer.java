/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package domain;
/**
 *
 * @author emilygoyal
 */
public class Customer {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    
    public Customer(String f, String l, String u, String p){
        this.first_name = f;
        this.last_name = l;
        this.username = u;
        this.password = p;
        //createDBConnection();    
    } 
    
    public int getCustomer_id(){
        return this.customer_id;
    }
    
    public String getFirst_name(){
        return this.first_name;
    }
    
    public void setFirst_name(String f){
           this.first_name = f;
    }
    
    public String getLast_name(){
        return this.last_name;
    }
    
    public void setLast_name(String l){
        this.last_name = l;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String u){
        this.username = u;
    }
    
    public String getPassword(){
      return this.password;  
    }
    
    public void setPassword(String p){
        this.password = p;
    }
   
}
