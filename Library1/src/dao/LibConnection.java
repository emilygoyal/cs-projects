/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author emilygoyal
 */

public class LibConnection {
        
    private static String url;
    private static String username;
    private static String password;

     static {
        try (InputStream input = new FileInputStream("src//resources/db.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
         }
        catch(Exception error){
            System.out.println(error);
        }    
    }
     
     public Connection getLibConnection() throws SQLException, ClassNotFoundException {
         Connection conn = null;
         
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection(url, username, password);
         }
         catch(Exception e){
             System.out.println(e);
         }
         System.out.println("I am at end");
         return conn;
    }
}

