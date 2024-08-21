/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emilygoyal
 */
public class CustomerDAO {
    
    public static String getInsertCustomerQry(){
        return "insert into customer(first_name, last_name, user_name, password)" + "values (?,?,?,?)";
    } 
    
    public static String getIdByNameQry(){
        return "select customer_id from customer where first_name = ? and last_name = ?";
    }
   
    public void addCustomer(Customer c, Connection conn){    
       try{  
        String query = getInsertCustomerQry();
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, c.getFirst_name());
        preparedStmt.setString (2, c.getLast_name());
        preparedStmt.setString   (3, c.getUsername());
        preparedStmt.setString(4, c.getPassword());
        preparedStmt.execute();
       }
    catch(SQLException error){
          System.out.println(error); 
       }
    }
    
    public int getIdFromName(String first_name, String last_name, Connection conn){
        int customer_id = -1;
        try{
        PreparedStatement preparedStmt = conn.prepareStatement(getIdByNameQry());
        preparedStmt.setString (1, first_name);
        preparedStmt.setString (2, last_name);
        ResultSet c_id = preparedStmt.executeQuery();
        
        while (c_id.next()){
                customer_id = c_id.getInt(1); 
            } 
        }
        catch(Exception error){
            System.out.print(error);
        }
        return customer_id;
    }
    
}
