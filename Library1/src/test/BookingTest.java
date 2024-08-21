/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.BookDAO;
import dao.BookingDAO;
import dao.CustomerDAO;
//import static dao.CustomerDAO.addCustomer;
import domain.Customer;
import dao.LibConnection;
import domain.Booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author emilygoyal
 */
public class BookingTest {
 public static void main(String[] args) { 
        Scanner input = new Scanner (System.in);
        String first_name = "";
        String last_name = "";
        String uname = "";
        String pass = "";
        int c_id = -1;
        int b_id = -1;
        String name = "";
        int number = 1;
      
      
        CustomerDAO customer1DAO = new CustomerDAO();
        BookDAO book1DAO = new BookDAO();
        BookingDAO booking1DAO = new BookingDAO();
        LibConnection libconn = new LibConnection();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Esg@622@5!");
            //Connection conn = libconn.getLibConnection();
            //System.out.println(conn);

            while(number > 0){
            System.out.print("Enter 0 to stop, Enter 1 to add customer, Enter 2 to check-out a book, Enter 3 to return a book, Enter 4 to see your book list: ");
            number = input.nextInt();

                if(number == 1){
                    System.out.println("First name: ");
                    first_name = input.next();
                    System.out.println("Last name: ");
                    last_name = input.next(); 
                    System.out.println("Username: ");
                    uname = input.next();
                    System.out.println("Password: ");
                    pass = input.next();
                    Customer customer1 = new Customer(first_name, last_name, uname, pass);
                    customer1DAO.addCustomer(customer1, conn);
                    c_id = customer1DAO.getIdFromName(first_name, last_name, conn);
                    System.out.printf("You have been added. Your customer id is: %d%n", c_id);
                }
                if(number == 2){
                    System.out.print("Enter \"yes\" if you have your customer id or \"no\" if you do not: ");
                    String flag = input.next(); 
                    if(flag.equals("yes")){
                        System.out.print("Customer ID: ");  
                        c_id = input.nextInt();   
                    }
                    else{
                        System.out.print("First name: ");
                        first_name = input.next();
                        System.out.print("Last name: ");
                        last_name = input.next(); 
                        input.nextLine();
                        c_id = customer1DAO.getIdFromName(first_name, last_name, conn);
                    }
                    System.out.print("Enter \"yes\" if you have your book id or \"no\" if you do not: ");
                    String flag2 = input.next();
                    if(flag2.equals("yes")){
                        System.out.print("Book ID: ");  
                        b_id = input.nextInt();
                    }
                    
                 else{
                        input.nextLine();
                        System.out.print("Book name: ");
                        name = input.nextLine();
                        b_id = book1DAO.getIdFromName(name, conn);
                    }
                        
                        Booking booking1 = new Booking(c_id, b_id);
                        booking1DAO.checkoutBook(booking1, conn);
                        //checkoutBook(first_name, last_name, name, conn);
                    }
            
                if(number == 3){
                    System.out.print("Enter \"yes\" if you have your customer id or \"no\" if you do not: ");
                    String flag = input.next(); 
                    if(flag.equals("yes")){
                        System.out.print("Customer ID: ");  
                        c_id = input.nextInt();   
                    }
                    else{
                        System.out.print("First name: ");
                        first_name = input.next();
                        System.out.print("Last name: ");
                        last_name = input.next(); 
                        input.nextLine();
                        c_id = customer1DAO.getIdFromName(first_name, last_name, conn);
                    }
                    
                    System.out.print("Enter \"yes\" if you have your book id or \"no\" if you do not: ");
                    String flag2 = input.next();
                    if(flag2.equals("yes")){
                        System.out.print("Book ID: ");  
                        b_id = input.nextInt();
                    }
                    else{
                        input.nextLine();
                        System.out.print("Book name: ");
                        name = input.nextLine();
                        b_id = book1DAO.getIdFromName(name, conn);
                    }
                    
                    Booking booking2 = new Booking(c_id, b_id);
                    booking1DAO.returnBook(booking2, conn);
                }
                if(number == 4){
                    System.out.print("Enter \"yes\" if you have your customer id or \"no\" if you do not: ");
                    String flag = input.next(); 
                    if(flag.equals("yes")){
                        System.out.print("Customer ID: ");  
                        c_id = input.nextInt();   
                    }
                    else{
                        System.out.print("First name: ");
                        first_name = input.next();
                        System.out.print("Last name: ");
                        last_name = input.next();
                        c_id = customer1DAO.getIdFromName(first_name, last_name, conn);
                    }
                    booking1DAO.showMyBooks(c_id, conn);
                }

            }
        
        }
        catch(Exception error){
            System.out.println(error);
        }
    }   
}
