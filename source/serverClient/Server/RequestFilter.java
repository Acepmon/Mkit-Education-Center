package Server;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javafx.scene.control.TableView;

public class RequestFilter {
     static int j = 0;

    private static ArrayList<Object> responseData = new ArrayList<>();

    public static Object Request(String request, Object data) {
        Object response = null;
        switch (request) {
            case "login":
                String username = data.toString().split("::")[0];
                String password = data.toString().split("::")[1];
                response = Login(username, password);
                break;
            case "getAllStudentProfile":

                response = allStudentProfile();
             
                 break;
                //return responseData;
                
            case "getStudentProfile":
                String first_name = data.toString().split("::")[0];
                response = studentProfile(first_name);
                
                break;
        }
        return response;
    }

    public static boolean Login(String username, String password) {
       
        ArrayList<Object> usernameColumn = DB_Copy.getDatas("login", "username");

        ArrayList<Object> passwordColumn = DB_Copy.getDatas("login", "password");

        System.out.println("size---->" + usernameColumn.size());

        for (int i = 0; i < usernameColumn.size(); i++) {
            if (usernameColumn.get(i).equals(username) && passwordColumn.get(i).equals(password)) {
                System.out.println("TRUE");
                 j = 1;
                return true;
               
            }
        }
        System.out.println("FALSE");
        j = 0;
        return false;
    }
    
    
    public static Object allStudentProfile(){
         ArrayList<Object> allProfile = new ArrayList<>();
         
         allProfile.add(DB_Copy.getDatas("student","first_name"));
           return allProfile;
    }
    
      public static Object studentProfile(String first_name){
         ArrayList<Object> profile = new ArrayList<>();
        
         ArrayList<Object> first_nameCol = DB_Copy.getDatas("student","first_name");
         
            int i = 0;
           for (; i < first_nameCol.size(); i++) {             
               if (first_nameCol.get(i).equals(first_name)) {
                   profile.add(DB_Copy.getDatas("student",  i));      
                    break;
               }
           }
         
           return profile;
    }
    public static Object getGrade(String first_name,boolean allResults) {
             ArrayList<Object> profile = new ArrayList<>();
        if (!allResults) {
            ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
            int i = 0;
            for (; i < first_nameCol.size(); i++) {
                if (first_nameCol.get(i).equals(first_name)) {
                    break;
                }
            }

            profile.add(DB_Copy.getDatas("Homework", "Homework_point", i));
            profile.add(DB_Copy.getDatas("Attendance", "Attendance_point", i));
            profile.add(DB_Copy.getDatas("Activity", "Activity_point", i));
            profile.add(DB_Copy.getDatas("Task", "Task_point", i));
            profile.add(DB_Copy.getDatas("Exam", "Exam_point", i));
            profile.add(DB_Copy.getDatas("project", "project_Point", i));
        } else {

            System.out.println("firstnameCol-->" + DB_Copy.getDatas("Student", "first_name"));
            
            ArrayList<Object> student_idCol = DB_Copy.getDatas("Homework", "Homework_point");
            System.out.println("idCol-->>" + DB_Copy.getDatas("Homework", "Homework_point"));
            ArrayList<Object> last_nameCol = DB_Copy.getDatas("Attendance", "Attendance_point");
            System.out.println("lastnameCol-->" + DB_Copy.getDatas("Attendance", "Attendance_point"));
            ArrayList<Object> phoneCol = DB_Copy.getDatas("Activity", "Activity_point");
            System.out.println("phonecol-->>" + DB_Copy.getDatas("Activity", "Activity_point"));
            ArrayList<Object> addressCol = DB_Copy.getDatas("Task", "Task_point");
            System.out.println("addresscol-->>" + DB_Copy.getDatas("Task", "Task_point"));
            ArrayList<Object> computer_numCol = DB_Copy.getDatas("Exam", "Exam_point");
            System.out.println("computer_numCol-->>" + DB_Copy.getDatas("Exam", "Exam_point"));   
            ArrayList<Object> projectcol  = DB_Copy.getDatas("project","project_Point");
         System.out.println("computer_numCol-->>" + DB_Copy.getDatas("project", "project_Point")); 
    }
           return profile;
}
}
