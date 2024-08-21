/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author emilygoyal
 */
public class BookDAO {
 
    public static String getIdByNameQry(){
        return "select book_id from book where name = ?";
    } 
   
    public int getIdFromName(String name, Connection conn){
        int book_id = -1;
        try{
        PreparedStatement preparedStmt = conn.prepareStatement(getIdByNameQry());
        preparedStmt.setString (1, name);
        ResultSet b_id = preparedStmt.executeQuery();
        while (b_id.next()){
                book_id = b_id.getInt(1); 
            }
        }
        catch(Exception error){
            System.out.print(error);
        }
        return book_id;
    }
    
}
