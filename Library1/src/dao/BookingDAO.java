/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author emilygoyal
 */
public class BookingDAO {
    
   public static String getInsertCheckoutQry(){
       return "insert into booking (checkout, due_date, customer_id, book_id) values (?,?,?,?)";
    }
    
    public static String getInsertBookingQry(){
        return "insert into booking (checkout, due_date, customer_id, book_id) values (?,?,?,?)";
    }
    
    public static String getSelectCopiesAndUsedCountQry(){
        return "select b.copies, count(bo.book_id) from book b left join booking bo on b.book_id = bo.book_id where b.book_id = ?";
    }
    
    public static String getInsertCustomerOnWaitlistQry(){
        return "insert into booking (waitlist, customer_id, book_id) values (?,?,?)";
    }
    
    public static String getDeleteBookingQry(){
        return "delete from booking where customer_id = ? and book_id = ?";
    }
    
    public static String getUpdateWatlistAfterReturnQry(){
        return "update booking set waitlist = waitlist - 1 where book_id = ?";
    }
    
    public static String getSelectWatlistCountQry(){
        return "select count(waitlist) from booking where book_id = ?";
    }
    
    public static String getSelectBookListQry(){
        return "select b.name from book b, booking bo where bo.book_id = b.book_id and customer_id = ?";
    } 
    
    public void checkoutBook(Booking b, Connection conn){
        try{
        String query3 = getInsertBookingQry();
        String query4 = getSelectCopiesAndUsedCountQry();
        String query5 = getInsertCustomerOnWaitlistQry();
               
        int copies = -1;
        int used = -1;
        
        PreparedStatement preparedStmt = conn.prepareStatement(query4);
        preparedStmt.setInt (1, b.getBook_id());
        ResultSet available = preparedStmt.executeQuery();
        while (available.next()){
                copies = available.getInt(1); 
                used = available.getInt(2);
        }
        
        if(copies <= used){
            Scanner input = new Scanner (System.in);
            System.out.print("This book is currently sold out. Enter yes if you would you like to be added to the wailist: ");
            String answer = input.next();
            if (answer.equals("yes")){
               int waitlist = (used-copies)+ 1; 
               System.out.printf("You have been added. You are now %d on the waitlist.%n", waitlist); 
               preparedStmt = conn.prepareStatement(query5);
               preparedStmt.setInt (1, waitlist);
               preparedStmt.setInt (2, b.getCustomer_id());
               preparedStmt.setInt (3, b.getBook_id());
               preparedStmt.execute();  
            }   
        }
        
        else{       
        preparedStmt = conn.prepareStatement(query3);
        preparedStmt.setString (1,b.getCheckout());
        preparedStmt.setString (2, b.getDue_date());
        preparedStmt.setInt (3, b.getCustomer_id());
        preparedStmt.setInt (4, b.getBook_id());
        preparedStmt.execute();
        }
       }
       catch(SQLException error){
          System.out.println(error); 
       }
    }
  
  public static void returnBook(Booking b, Connection conn){
        try{
        String query3 = getDeleteBookingQry();
        String query4 = getUpdateWatlistAfterReturnQry();
        String query5 = getSelectWatlistCountQry();
        int copies = -1;
        int used = -1;
        int iswaiting = -1;

        PreparedStatement preparedStmt = conn.prepareStatement(query3);
        preparedStmt.setInt (1, b.getCustomer_id());
        preparedStmt.setInt (2, b.getBook_id());
        preparedStmt.execute();
        
        preparedStmt = conn.prepareStatement(query5);
        preparedStmt.setInt (1, b.getBook_id());
        ResultSet waitlist = preparedStmt.executeQuery();
        while (waitlist.next()){
                iswaiting = waitlist.getInt(1); 
        }
        if(iswaiting != 0){
        preparedStmt = conn.prepareStatement(query4);
        preparedStmt.setInt (1, b.getBook_id());
        preparedStmt.execute();    
        }
       }
       catch(SQLException error){
          System.out.println(error); 
       }
    }
  
  public static void showMyBooks(int c_id, Connection conn){
        try{
        String query2 = getSelectBookListQry();  
        
        PreparedStatement preparedStmt = conn.prepareStatement(query2);
        preparedStmt.setInt (1, c_id);
        ResultSet book_list = preparedStmt.executeQuery();
        int book = 0;
         while (book_list.next()){
             book += 1;
                System.out.println(book + ")" + book_list.getString(1));
            }
       }
       catch(SQLException error){
          System.out.println(error); 
       }
    }
}
