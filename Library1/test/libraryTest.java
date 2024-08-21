/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import domain.Customer;
/**
 *
 * @author emilygoyal
 */
public class libraryTest {
    
     public static void main(String[] args) {
        Customer customer1 = new Customer("Emily", "Goyal", "egoyal", "pass", "12345");
        System.out.printf("Account 1: Name: %s %s, Username: %s, Password: %s, Card ID: %s%n", customer1.getFirst_name(), customer1.getLast_name(), customer1.getUsername(), customer1.getPassword(), customer1.getCard_id());
    }
    
}
