/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JAVA M2
 */
public class Tester {
    
    public Tester() {
        
        DB_Copy copy = new DB_Copy();
        
        System.out.println(RequestFilter.Request("login", "dulam::pass"));
        
        boolean loggedIn = RequestFilter.Login("Login", "asda");
        
        System.out.println(RequestFilter.Request("getAllStudentProfile",  null));
        System.out.println(RequestFilter.Request("getStudentProfile", "Dulam"));
    }
    
    public static void main(String[] args) {
        new Tester();
    }
}
