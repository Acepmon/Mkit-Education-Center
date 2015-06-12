package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

public class DatabaseTools {

    public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    Properties props = new Properties();
    Connection connection = null;

    public DatabaseTools() {
        try {
            FileInputStream in = new FileInputStream("E:/db.properties");
            props.load(in);
            in.close();

            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Aмжилтгүй боллоо  ");
        }
    }

    public ResultSet runQuery(String query) {
        Statement statement;
        ResultSet result = null;

        try {
            statement = connection.createStatement();
            if (query.toLowerCase().startsWith("update") || query.toLowerCase().startsWith("insert") || query.toLowerCase().startsWith("delete")) {
                statement.executeUpdate(query);
            } else {
                result = statement.executeQuery(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Таны мэдээлэл алдаатай байна");

        }
        return result;
    }
    public boolean insertIntoAccount(Object username, Object password, Object type) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Account (user_name, password, type) values (?, ?, ?)");
            ps.setObject(1, username);
            ps.setObject(2, password);
            ps.setObject(3, type);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
      public boolean insertIntoAdmin(Object lastname, Object firstname, Object phone, Object address, Object status_id) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Admin (Lastname, firstName, phone, Address, statusstatus_id) values (?,?,?,?,?)");
            ps.setObject(1, lastname);
            ps.setObject(2, firstname);
            ps.setObject(3, phone);
            ps.setObject(4, address);
            ps.setObject(5, status_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoManager(Object id,
                                    Object lastname,
                                    Object firstname,
                                    Object phone,
                                    Object address, 
                                    Object status_id) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Manager (Manager_id, Lastname, FirstName, Phone, Address, status_id) values (?,?,?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, status_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     
     public boolean insertIntoTeacher(Object id,
                                    Object lastname,
                                    Object firstname,
                                    Object phone,
                                    Object address, 
                                    Object status_id) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Teacher (Teacher_id, last_name, first_name, phone, address, status_id) values (?,?,?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, status_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     
     public boolean insertIntoStudent(Object id,
                                    Object lastname,
                                    Object firstname,
                                    Object phone,
                                    Object address, 
                                    Object comNum,
                                    Object classID,
                                    Object statusID
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Student (student_id, last_name, first_name, phone, address, computer_num, Class_id,status_id) values (?,?,?,?,?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, comNum);
            ps.setObject(7, classID);
            ps.setObject(8, statusID);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     
     public boolean insertIntoClass(Object id,
                                    Object className,
                                    Object classType
                                    
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Class (Class_id, Class_name, Class_type) values (?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, className);
            ps.setObject(3, classType);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
   public boolean insertIntoDaalgavar(Object id,
                                    Object subID,
                                    Object startDate,
                                    Object endDate
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Daalgavar (Homework_id, Subject_id, start_date, end_date) values (?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, subID);
            ps.setObject(3, startDate);
            ps.setObject(4, endDate);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
   public boolean insertIntoSubject(Object id,
                                    Object subName,
                                    Object startDate,
                                    Object endDate,
                                    Object teacherClassID,
                                    Object subjectTypeID
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Subject (subject_id, subject_name, start_date, end_date, teacher_class_id,subject_type_id) values (?,?,?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, subName);
            ps.setObject(3, startDate);
            ps.setObject(4, endDate);
            ps.setObject(5, teacherClassID);
            ps.setObject(6, subjectTypeID);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean insertIntoDasgal(Object exercise_id,
                                    Object subID,
                                    Object startDate,
                                    Object endDate
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dasgal (Exercise_id, Subject_id, start_date, end_date) values (?,?,?,?)");
            ps.setObject(1, exercise_id);
            ps.setObject(2, subID);
            ps.setObject(3, startDate);
            ps.setObject(4, endDate);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoDunBiedaalt(Object student_id,
                                    Object task_id,
                                    Object task_point
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dun_Biedaalt (Student_id, Task_ID, Task_POINT) values (?,?,?)");
            ps.setObject(1, student_id);
            ps.setObject(2, task_id);
            ps.setObject(3, task_point);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoDunDaalgavar(Object student_homework_id,
                                    Object homework_id,
                                    Object status_recieved,
                                    Object date_recieved,
                                    Object student_id,
                                    Object homework_point
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dun_Daalgavar (Student_id, Homework_id, status_recieved, date_recieved, Student_id, Homework_Point) values (?,?,?,?,?,?)");
            ps.setObject(1, student_homework_id);
            ps.setObject(2, homework_id);
            ps.setObject(3, status_recieved);
            ps.setObject(4, date_recieved);
            ps.setObject(5, student_id);
            ps.setObject(6, homework_point);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     
     public boolean insertIntoDunDasgal(Object student_exercise_id,
                                    Object exercise_recieved_status,
                                    Object exercise_recieved_date,
                                    Object Student_id,
                                    Object Exercise_id,
                                    Object exercise_point
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dun_Dasgal (Student_exercise, ex_recieved_status, ex_date_recieved, Student_id, Exercise_id, Exercise_Point) values (?,?,?,?,?,?)");
            ps.setObject(1, student_exercise_id);
            ps.setObject(2, exercise_recieved_status);
            ps.setObject(3, exercise_recieved_date);
            ps.setObject(4, Student_id);
            ps.setObject(5, Exercise_id);
            ps.setObject(6, exercise_point);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoIdevh(Object student_id,
                                    Object date,
                                    Object idevh_point,
                                    Object subject_type_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dun_Idevh (student_id, date, idevh_point, subject_type_id) values (?,?,?,?)");
            ps.setObject(1, student_id);
            ps.setObject(2, date);
            ps.setObject(3, idevh_point);
            ps.setObject(4, subject_type_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoDunIrts(Object student_id,
                                    Object date,
                                    Object missed_time,
                                    Object attendance_point,
                                    Object subject_type_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dun_Irts (student_id, date, missed_time, attendance_point,subject_type_id) values (?,?,?,?,?)");
            ps.setObject(1, student_id);
            ps.setObject(2, date);
            ps.setObject(3, missed_time);
            ps.setObject(4, attendance_point);
            ps.setObject(5, subject_type_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     
     public boolean insertIntoDunIrtsLavlah(Object irts_point,
                                            Object irts_type
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dun_Irts_Lavlah (irts_onoo, onoo_ner) values (?,?)");
            ps.setObject(1, irts_point);
            ps.setObject(2, irts_type);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoDunShalgalt(Object student_id,
                                          Object exam_id,
                                          Object exam_point
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Dun_Shalgalt (Student_id, Exam_ID,Exam_Point) values (?,?,?)");
            ps.setObject(1, student_id);
            ps.setObject(2, exam_id);
            ps.setObject(3, exam_point);

            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoSubjectType(Object subject_type_id,
                                          Object type
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Subject_Type (subject_type_id, type) values (?,?)");
            ps.setObject(1, subject_type_id);
            ps.setObject(2, type);

            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     
     public boolean insertIntoLecture(Object lecture_id,
                                    Object lecture_name,
                                    Object lecture_start_date,
                                    Object lecture_end_date,
                                    Object teacher_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into lecture (lecture_id, lecture_name, lecture_start_date, lecture_end_date,Teacher_id) values (?,?,?,?,?)");
            ps.setObject(1, lecture_id);
            ps.setObject(2, lecture_name);
            ps.setObject(3, lecture_start_date);
            ps.setObject(4, lecture_end_date);
            ps.setObject(5, teacher_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     
     public boolean insertIntoLectureSession(Object lecture_id,
                                             Object subject_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Lecture_sessions (lecture_id, Subject_id) values (?,?)");
            ps.setObject(1, lecture_id);
            ps.setObject(2, subject_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertIntoAdminAcc(Object admin_id,
                                       Object acc_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into AdminAcc (Admin_id, Acc_id) values (?,?)");
            ps.setObject(1, admin_id);
            ps.setObject(2, acc_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
      public boolean insertIntoManagerAcc(Object manager_id,
                                       Object acc_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into ManagerAcc (Manager_id, Acc_id) values (?,?)");
            ps.setObject(1, manager_id);
            ps.setObject(2, acc_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
      public boolean insertIntoTeacherAcc(Object teacher_id,
                                       Object acc_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into TeacherAcc (Teacher_id, Acc_id) values (?,?)");
            ps.setObject(1, teacher_id);
            ps.setObject(2, acc_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
      public boolean insertIntoStudentAcc(Object student_id,
                                          Object acc_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into StudentAcc (Student_id, Acc_id) values (?,?)");
            ps.setObject(1, student_id);
            ps.setObject(2, acc_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean insertIntoProject(Object team_id,
                                     Object project_name,
                                     Object project_type,
                                     Object project_mark
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Project (team_id, project_name,project_type,project_mark) values (?,?,?,?)");
            ps.setObject(1, team_id);
            ps.setObject(2, project_name);
            ps.setObject(3, project_type);
            ps.setObject(4, project_mark);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    } 
    public boolean insertIntoShalgalt(Object subject_id,
                                     Object exam_name,
                                     Object date
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Shalgalt (Subject_id,EXAM_NAME,Date) values (?,?,?)");
            ps.setObject(1, subject_id);
            ps.setObject(2, exam_name);
            ps.setObject(3, date);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    } 
    public boolean insertIntoStatus(Object status_id,
                                    Object status_name
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into status (status_id, status_name) values (?,?)");
            ps.setObject(1, status_id);
            ps.setObject(2, status_name);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean insertIntoSubjectTypeClass(Object class_id,
                                              Object subject_type_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Subject_typeClass (class_id, subject_type_id) values (?,?)");
            ps.setObject(1, class_id);
            ps.setObject(2, subject_type_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
     public boolean insertIntoTaskName (Object task_id,
                                        Object subject_id,
                                        Object task_name,
                                        Object start_date,
                                        Object end_date
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Task_NAME (Task_ID, Subject_id,Task_Name,Start_date,Finish_date) values (?,?,?,?,?)");
            ps.setObject(1, task_id);
            ps.setObject(2, subject_id);
            ps.setObject(3, task_name);
            ps.setObject(4, start_date);
            ps.setObject(5, end_date);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    } 
     public boolean insertIntoTeacherClass (Object class_id,
                                        Object teacher_id,
                                        Object teacher_class_id
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into TeacherClass (Class_id, Teacher_id,teacher_class_id) values (?,?,?)");
            ps.setObject(1, class_id);
            ps.setObject(2, teacher_id);
            ps.setObject(3, teacher_class_id);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    } 
     public boolean insertIntoTeam (Object team_id,
                                        Object team_name,
                                        Object team_motto
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Team (team_id, team_name,team_motto) values (?,?,?)");
            ps.setObject(1, team_id);
            ps.setObject(2, team_name);
            ps.setObject(3, team_motto);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    } 
     public boolean insertIntoTeamStudents (Object team_id,
                                        Object student_id,
                                        Object role
                                    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Team_students (team_id, student_id,role) values (?,?,?)");
            ps.setObject(1, team_id);
            ps.setObject(2, student_id);
            ps.setObject(3, role);
            ps.executeUpdate();
        }catch (SQLException ex) {
            return false;
        }
        return true;
    } 

     
     public boolean deleteFromTeam(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Team where team_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
     
     public boolean deleteFromTeacherClass(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from TeacherClass where teacher_class_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
      public boolean deleteFromTeacherAcc(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from TeacherAcc where Teacher_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
      public boolean deleteFromTeacher(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Teacher where Teacher_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
       public boolean deleteFromTaskName(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Task_NAME where Task_ID=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
//      ************2**********************2**********************2********************** 
       
       public boolean deleteFromSubject_typeClass(Object class_id,
                                        Object subject_type_id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Subject_typeClass where class_id=? and subject_type_id = ?");
             ps.setObject(1, class_id);
             ps.setObject(2, subject_type_id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
       public boolean deleteFromSubjectType(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Subject_Type where subject_type_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
        public boolean deleteFromSubject(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Subject where subject_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
        
           public boolean deleteFromStudent(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Student where Student_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
           
            public boolean deleteFromStudentAcc(Object st_id,
                                                Object acc_id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from StudentAcc where Student_id=? and Acc_id = ?");
             ps.setObject(1, st_id);
             ps.setObject(2, acc_id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }
                public boolean deleteFromStatus(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from status where status_id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
    }
    
    public boolean deleteAccount(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Account where acc_id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteAdmin(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Admin where Admin_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteAdminAcc(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from AdminAcc where Admin_id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteClass(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Class where Class_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDaalgavar(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Daalgavar where Homework_id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDasgal(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dasgal where Exercise_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunBieDaalt(Object d1, Object d2) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Biedaalt where Student_id=? and Task_ID=?");
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunDaalgavar(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Daalgavar where Student_homework_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunDasgal(Object d1, Object d2) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Dasgal where Student_exercise_id =? and Student_id=? ");
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunIdevh(Object d1, Object d2) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Idevh where student_id=? and subject_type_id=? ");
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunIrts(Object d1, Object d2) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Irts where student_id=? and subject_type_id=? ");
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunIrtsLavlah(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Irts_Lavlah where irts_onoo=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunShalgalt(Object d1, Object d2) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Shalgalt where Student_id=? and  Exam_ID=?");
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteLecture(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from lecture where lecture_id=? ");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteLectureSession(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from  Lecture_sessions where lecture_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteManager(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Manager where Manager_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
     public boolean deleteMangagerAcc(Object d1, Object d2) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Manager where Manager_id=? and Acc_id=?");
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
     public boolean deleteProject(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Project where project_name=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
      
      
         //------------Update-----------------Begin-----------------------------------------------------------------------------------//
    public boolean updateAccount(Object acc_id, Object username, Object password, Object type, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Account set  acc_id =?, user_name =?, password =? , type =? where acc_id =? ");
            ps.setObject(1, acc_id);
            ps.setObject(2, username);
            ps.setObject(3, password);
            ps.setObject(4, type);
            ps.setObject(5, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateAdmin(Object id, Object lastname, Object firstname, Object phone, Object address, Object status_id, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Admin set  Admin_id =?, Lastname=?, firstName=? , phone=? , Address =?, statusstatus_id =? where Admin_id =? ");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, status_id);
            ps.setObject(7, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateAdminAcc(Object admin_id, Object acc_id, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update AdminAcc set Admin_id=?, Acc_id=?  where Admin_Acc=?");
            ps.setObject(1, admin_id);
            ps.setObject(2, acc_id);
            ps.setObject(3, where);
            ps.executeUpdate();

        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateClass(Object id, Object className, Object classType, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Class set  Class_id =?, Class_name=?, Class_type=? where Class_id=? ");
            ps.setObject(1, id);
            ps.setObject(2, className);
            ps.setObject(3, classType);
            ps.setObject(4, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDaalgavar(Object Homework_id, Object Subject_id, Object start_date, Object end_date, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Daalgavar set Homework_id =?, Subject_id=? , start_date=?, end_date=? where Homework_id=?");
            ps.setObject(1, Homework_id);
            ps.setObject(2, Subject_id);
            ps.setObject(3, start_date);
            ps.setObject(4, end_date);
            ps.setObject(5, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDasgal(Object dasgal_id, Object Subject_id, Object start_date, Object end_date, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dasgal set Exersice_id =?, Subject_id=? , start_date=?, end_date=? where Homework_id=?");
            ps.setObject(1, dasgal_id);
            ps.setObject(2, Subject_id);
            ps.setObject(3, start_date);
            ps.setObject(4, end_date);
            ps.setObject(5, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDunBiedaalt(Object studentID, Object TaskID, Object TaskPoint, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dun_Biedaalt set Student_id=?, Task_ID=? , Task_POINT=? where Homework_id=?");
            ps.setObject(1, studentID);
            ps.setObject(2, TaskID);
            ps.setObject(3, TaskPoint);
            ps.setObject(4, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDunDaalgavar(Object id, Object HomeworkID, Object status, Object date_received, Object Student_id, Object Point, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dun_Daalgavar set Student_homework_id=?, Homework_id=? ,status_recieved=?, date_recieved,Student_id,Homework_Point=? where Student_homework_id=?");
            ps.setObject(1, id);
            ps.setObject(2, HomeworkID);
            ps.setObject(3, status);
            ps.setObject(4, date_received);
            ps.setObject(5, Student_id);
            ps.setObject(6, Point);
            ps.setObject(7, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDunDasgal(Object id, Object HomeworkID, Object status, Object date_received, Object Student_id, Object Point, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dun_Dasgal set Student_exersice_id=?, ex_recieved_status=? ,ex_date_recieved=?, Student_id=?, Exersice_id=? ,Exercise_Point=? where Student_exersice_id=?");
            ps.setObject(1, id);
            ps.setObject(2, HomeworkID);
            ps.setObject(3, status);
            ps.setObject(4, date_received);
            ps.setObject(5, Student_id);
            ps.setObject(6, Point);
            ps.setObject(7, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDunIdevh(Object s1, Object s2, Object s3, Object s4, Object s5) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dun_Idevh set student_id=?, date=? , idevh_point=?, subject_type_id=? where student_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.setObject(4, s4);
            ps.setObject(5, s5);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDunIrts(Object s1, Object s2, Object s3, Object s4, Object s5, Object s6) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dun_Irts set student_id=?, date=? , missed_time=?, attendance_point=?, subject_type_id=?  where student_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.setObject(4, s4);
            ps.setObject(5, s5);
            ps.setObject(6, s6);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDunIrtsLavlah(Object s1, Object s2, Object s3) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dun_Irts_Lavlah set irts_onoo=?, onoo_ner=? where irts_onoo=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateDunShalgalt(Object s1, Object s2, Object s3, Object s4) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Dun_Shalgalt set Studentstudent_id=?, Exam_NAMEExam_ID=? , Exam_Point=? where  Studentstudent_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.setObject(4, s4);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateLecture(Object id, Object name, Object startDate, Object endDate, Object teacherID, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update lecture set lecture_id=?, lecture_name=?, lecture_start_date=?, lecture_end_date =? , Teacher_id=?  where lecture_id=?");
            ps.setObject(1, id);
            ps.setObject(2, name);
            ps.setObject(3, startDate);
            ps.setObject(4, endDate);
            ps.setObject(5, teacherID);
            ps.setObject(6, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateLectureSession(Object s1, Object s2, Object s3) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Lecture_sessions set lecture_id=?, Subject_id=? where lecture_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateManager(Object id, Object lastname, Object firstname, Object phone, Object address, Object status_id, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Manager set  Manager_id=?, LastName=?, FirstName=? , Phone=? , Address =?, status_id =? where Manager_id =? ");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, status_id);
            ps.setObject(7, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateManagerAcc(Object s1, Object s2, Object s3) {
        try {
            PreparedStatement ps = connection.prepareStatement("update ManagerAcc set Manager_id=?, Acc_id=? where Manager_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateProject(Object team_id, Object project_name, Object project_type, Object project_mark, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Project set team_id=?, project_name=? , project_type=?, project_mark=? where team_id=? ");
            ps.setObject(1, team_id);
            ps.setObject(2, project_name);
            ps.setObject(3, project_type);
            ps.setObject(4, project_mark);
            ps.setObject(5, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateShalgalt(Object exam_id, Object subject_id, Object name, Object Date, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update lecture set lecture_id=?, lecture_name=?, lecture_start_date=?, lecture_end_date =? , Teacher_id=?  where lecture_id=?");
            ps.setObject(1, exam_id);
            ps.setObject(2, subject_id);
            ps.setObject(3, name);
            ps.setObject(4, Date);
            ps.setObject(5, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateStatus(Object s1, Object s2, Object s3) {
        try {
            PreparedStatement ps = connection.prepareStatement("update status set status_id=?, status_name=? where status_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateStudent(Object id, Object lastname, Object firstname, Object phone, Object address, Object comNum, Object classId, Object status_id, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Student set Student_id=?, last_name=?, first_name=? , phone=? , address =?, computer_num =?, Class_id=?, status_id =? where Student_id =? ");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, comNum);
            ps.setObject(7, classId);
            ps.setObject(8, status_id);
            ps.setObject(9, where);
            ps.executeUpdate();

        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateStudentAcc(Object s1, Object s2, Object s3) {
        try {
            PreparedStatement ps = connection.prepareStatement("update StudentAcc set Student_id=?, Acc_id=? where Student_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateSubject(Object subject_id, Object subject_name, Object start_date, Object end_date, Object teacher_class_id, Object subject_type_id, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Subject set subject_id=?, subject_name=? , start_date=?, end_date=?, teacher_class_id=?, subject_type_id=?  where subject_id=?");
            ps.setObject(1, subject_id);
            ps.setObject(2, subject_name);
            ps.setObject(3, start_date);
            ps.setObject(4, end_date);
            ps.setObject(5, teacher_class_id);
            ps.setObject(6, subject_type_id);
            ps.setObject(7, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateSubjectType(Object sub_t_id, Object type, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Subject_Type set subject_type_id=?, type=? where subject_type_id=?");
            ps.setObject(1, sub_t_id);
            ps.setObject(2, type);
            ps.setObject(3, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateSubjectTypeClass(Object s1, Object s2, Object s3) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Subject_typeClass set class_id=?,   subject_type_id=? where class_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateTask(Object task_id, Object sub_id, Object name, Object beginDate, Object endDate, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Task_NAME set Task_ID=?, Subject_id=? , Task_Name=? , Start_date=? , Finish_date where Task_ID=?");
            ps.setObject(1, task_id);
            ps.setObject(2, sub_id);
            ps.setObject(3, name);
            ps.setObject(4, beginDate);
            ps.setObject(5, endDate);
            ps.setObject(5, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateTeacher(Object id, Object lastname, Object firstname, Object phone, Object address, Object status_id, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Teacher set Teacher_id =?, last_name=?, first_name=? , phone=? , address =?, status_id =? where Teacher_id =? ");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, status_id);
            ps.setObject(7, where);
            ps.executeUpdate();

        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean updateTeacherAcc(Object s1, Object s2, Object s3) {
        try {
            PreparedStatement ps = connection.prepareStatement("update TeacherAcc set Teacher_id=?, Acc_id=? where Teacher_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean updateTeacherClass(Object s1, Object s2, Object s3,Object s4) {
        try {
            PreparedStatement ps = connection.prepareStatement("update TeacherClass set Class_id=?, Teacher_id=? , teacher_class_id=? where Class_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.setObject(4, s4);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean  updateTeam(Object s1, Object s2, Object s3, Object s4) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Team set team_id=?, team_name=? , team_motto=? where team_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.setObject(4, s4);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean  updateTeamStudents(Object s1, Object s2, Object s3, Object s4,Object s5) {
        try {
            PreparedStatement ps = connection.prepareStatement("update Team_students set team_student_id = ?,team_id=?, student_id=? , role=? where team_student_id=?");
            ps.setObject(1, s1);
            ps.setObject(2, s2);
            ps.setObject(3, s3);
            ps.setObject(4, s4);
            ps.setObject(5, s5);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }   
        //------------Update-----------------End-----------------------------------------------------------
    public boolean  deleteFromTeamStudent(Object s1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Team_students where team_student_id = ?");
            ps.setObject(1, s1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean deleteFromShalgalt(Object id){
         try {
             PreparedStatement ps = connection.prepareStatement("delete from Shalgalt where Exam_ID=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch (Exception e) {
             return false;
         }
         return true;
     
    }


}
