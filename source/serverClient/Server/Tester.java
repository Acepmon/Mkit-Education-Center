/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author JAVA M2
 */
public class Tester {
    
    public static DatabaseTools db;
    
    public Tester() {
        db = new DatabaseTools();
        DB_Copy copy = new DB_Copy();
        
      //  System.out.println(RequestFilter.Request("login", "dulam::pass"));
        
     //   boolean loggedIn = RequestFilter.Login("Login", "asda");
//        System.out.print("Anhnii--->");
//        System.out.println(RequestFilter.Request("getAllStudentProfile",  null));
//        System.out.println(RequestFilter.Request("getStudentProfile", "bataa"));
//        System.out.println(RequestFilter.Request("getGrade", "boldoo"));
//        System.out.println(RequestFilter.Request("getTeacherProfile","dulam"));
//        System.out.println(RequestFilter.Request("getAllTeacherProfile",null));
        
//        System.out.println(RequestFilter.Request("getAllAdminProfile",null));
//        System.out.println(RequestFilter.Request("getExerciseGrade","bataa"));
//        System.out.println(RequestFilter.Request("getHomeworkGrade","boldoo"));
//        System.out.println(RequestFilter.Request("getTaskGrade","bataa"));
//        System.out.println(RequestFilter.Request("getAttendanceGrade","boldoo"));
        
       // RequestFilter.Request("insertStudent","shineOyutan::shineOyutan::shineOyutan::shineOyutan::shineOyutan");
        
       
//        System.out.println("asd zsjgid bfsijs ");
//        for (ArrayList<Object> list : DB_Copy.getDatas("Student")) {   
//            for (Object obj : list) {
//                System.out.print(obj + "-");
//            }
//            System.out.println("\n");
//        }
//        System.out.println(RequestFilter.Request("getAllHomework",null));
//        System.out.println(RequestFilter.Request("getStudentHomework","boldoo"));
//        System.out.println(RequestFilter.Request("getAllManagerProfile",null));
//        System.out.println(RequestFilter.Request("getManagerProfile","Suvd"));
//        System.out.println(RequestFilter.Request("getManProfile", "suvdman1"));
//        
//         for (String str : (ObservableList<String>) RequestFilter.Request("manGetAllStudents",null)) {
//              System.out.println(str);
//          }
        
//        for (ArrayList<Object> list : DB_Copy.getDatas("Student")) {
//            for (Object obj : list) {
//                System.out.print(obj + "-");
//            }
//            System.out.println("\n");
//        }
        
        System.out.println(RequestFilter.Request("getClassStudents", "teacher001"));
    }
    
    public static void main(String[] args) {
        new Tester();
    }
}