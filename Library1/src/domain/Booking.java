/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author emilygoyal
 */
public class Booking {
    private int booking_id = -1;
    private String checkout;
    private String due_date;
    private int waitlist = -1;
    private int customer_id;
    private int book_id;
    
    public Booking(int c_id, int b_id){
        this.customer_id = c_id;
        this.book_id = b_id;  
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDate now = LocalDate.now();
        this.checkout = dtf.format(now);
        LocalDate later = now.plusDays(21);  
        this.due_date = dtf.format(later);          
    } 
    
     public int getBooking_id(){
        return this.booking_id;
    }
    
    public String getCheckout(){
        return this.checkout;
    }
    
    public void setCheckout(String c){
           this.checkout = c;
    }
    
    public String getDue_date(){
        return this.due_date;
    }
    
    public void setDue_date(String d){
        this.due_date = d;
    }
    
    public int getWaitlist(){
        return this.waitlist;
    }
    
    public void setWaitlist(int w){
        this.waitlist = w;
    }   
    
     public int getCustomer_id(){
        return this.customer_id;
    }
    
    public void setCustomer_id(int c_id){
         this.customer_id = c_id;
    }
    
    public int getBook_id(){
        return this.book_id;
    }
    
    public void setBook_id(int b_id){
         this.book_id = b_id;
    }
}
