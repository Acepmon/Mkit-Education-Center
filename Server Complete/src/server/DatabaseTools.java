package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

public class DatabaseTools {

    public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    Properties props = new Properties();
    static Connection connection;

    public DatabaseTools() {
        try {
            try (FileInputStream in = new FileInputStream("E:\\db.properties")) {
                props.load(in);
            }

            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Aмжилтгүй боллоо  " + e.getMessage());
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
            JOptionPane.showMessageDialog(null, "Таны мэдээлэл алдаатай байна" + e.getMessage());

        }
        return result;
    }
    public boolean insertIntoTailan(Object tailanName, Object teacher_id, Object current_time) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Tailan (tailan_name, teacher_id, date) values(?, ?, ?) ");
            ps.setString(1, tailanName.toString());
            ps.setInt(2, Integer.parseInt(teacher_id.toString()));
            java.sql.Date sqlDate = new java.sql.Date(java.util.Date.from(Instant.now()).getTime());
            ps.setDate(3, sqlDate);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean insertSubject(Object sub_name, Object start, Object end){
         try{
             PreparedStatement ps = connection.prepareStatement("insert into subject values (null, ?,?,?)");
             ps.setObject(1, sub_name);
             ps.setObject(2, start);
             ps.setObject(3, end);
             ps.executeUpdate();
         } catch (SQLException e){
             e.printStackTrace();
         }
         return true;
     }
     public String deleteFromSubject(Object id) {
         String str = "true";
        try {
            PreparedStatement ps = connection.prepareStatement("delete from subject where subject_id=?");
            ps.setObject(1, id);
            System.out.println(">>>>>>>>>>>"+ps.toString());
            ps.executeUpdate();
        } catch (Exception e) {
            str = "Can not delete parent row!";
            return str;
        }
        return str;
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

    public boolean insertIntoAdmin(Object lastname, Object firstname, Object phone, Object address, Object email, Object status_id, Object zurag) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Admin (Lastname, firstName, phone, Address, email, statusstatus_id, admin_picture) values (?,?,?,?,?,?,?)");
            ps.setObject(1, lastname);
            ps.setObject(2, firstname);
            ps.setObject(3, phone);
            ps.setObject(4, address);
            ps.setObject(5, email);
            ps.setObject(6, status_id);
            ps.setObject(7, zurag);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

  public boolean insertIntoManager(
            Object reg,
            Object lastname,
            Object firstname,
            Object status_id,
            Object phone,
            Object email_address,
            Object social_address,
            Object address,
            Object manager_pic,
            Object del_flag,
            Object username,
            Object password
                            ) {
        try {
            PreparedStatement ps 
            = connection.prepareStatement("insert into Manager "
                    + "(reg_num, "
                    + "lastname, "
                    + "firstname, "
                    + "status_id,"
                    + "phone,"
                    + "email_address, "
                    + "social_address,"
                    + "address,"
                    + "manager_picture,"
                    + "del_flag,"
                    + "username,"
                    + "password"
                    + ") values (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setObject(1, reg);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, status_id);
            ps.setObject(5, phone);
            ps.setObject(6, email_address);
            ps.setObject(7, social_address);
            ps.setObject(8, address);
            ps.setObject(9, manager_pic);
            ps.setObject(10, del_flag);
            ps.setObject(11, username);
            ps.setObject(12, password);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIntoTeacher(
            Object reg,
            Object lastname,
            Object firstname,
            Object phone,
            Object email_address,
            Object social_address,
            Object address,
            Object teacher_pic,
            Object username,
            Object password,
            Object del_flag,
            Object class_type,
            Object status_id
                            ) {
        try {
            PreparedStatement ps 
            = connection.prepareStatement("insert into teacher "
                    + "(reg_num, "
                    + "lastname, "
                    + "firstname, "
                    + "phone,"
                    + "email_address, "
                    + "social_address,"
                    + "address,"
                    + "teacher_picture,"
                    + "username,"
                    + "password,"
                    + "del_flag,"
                    + "class_type,"
                    + "status_id"
                    + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setObject(1, reg);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, email_address);
            ps.setObject(6, social_address);
            ps.setObject(7, address);
            ps.setObject(8, teacher_pic);
            ps.setObject(9, username);
            ps.setObject(10, password);
            ps.setObject(11, del_flag);
            ps.setObject(12, class_type);
            ps.setObject(13, status_id);
            System.out.println(".......>>>>>>>"+ps.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean insertIntoStudent(
            Object code,
            Object lastname,
            Object firstname,
            Object phone,
            Object email,
            Object social,
            Object reg,
            Object addr,
            Object com,
            Object elselt_id,
            Object flag,
            Object reason,
            Object pic,
            Object elselt_onoo,
            Object talk,
            Object status
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into student "
                    + "(code,"
                    + "lastname,"
                    + "firstname,"
                    + "phone,"
                    + "email_address,"
                    + "social_address,"
                    + "reg_num,"
                    + "address,"
                    + "com_num,"
                    + "elseltiin_id,"
                    + "del_flag, "
                    + "reason,"
                    + "student_pic,"
                    + "elselt_onoo,"
                    + "yriltslaga,"
                    + "status_id)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setObject(1, code);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, email);
            ps.setObject(6, social);
            ps.setObject(7, reg);
            ps.setObject(8, addr);
            ps.setObject(9, com);
            ps.setObject(10, elselt_id);
            ps.setObject(11, flag);
            ps.setObject(12, reason);
            ps.setObject(13, pic);
            ps.setObject(14, elselt_onoo);
            ps.setObject(15, talk);
            ps.setObject(16, status);
            System.out.println("query>>>>>>>>>>>>>"+ps.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public ArrayList<String> insertIntoStudentTeacher2(String student_id, String... teacher_ids) {
        ArrayList<String> returnList = new ArrayList<>();
        try {
            for (String teacher_id : teacher_ids) {
                PreparedStatement ps = connection.prepareStatement("insert into student_teacher (student_id, teacher_id) values (?, ?) ");
                ps.setString(1, student_id);
                ps.setString(2, teacher_id);
                ps.executeUpdate();
                
                String query = "select * from student_teacher order by id desc limit 1";
                ResultSet result = runQuery(query);
                while (result.next()) {
                    returnList.add(result.getObject("id") + "::" + result.getObject("student_id") + "::" + result.getObject("teacher_id"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
        return returnList;
    }
    public boolean insertIntoStudent(
            Object burtgel,
            Object ovog,
            Object ner,
            Object status,
            Object utas,
            Object email,
            Object social,
            Object reg,
            Object addr,
            Object kom,
            Object elselt,
            Object flag,
            Object shaltgan,
            Object pic
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into student (code, lastname, firstname, status, phone, email_address, social_address, reg_num, address, com_num, elseltiin_id, del_flag, reason, student_pic) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setObject(1, burtgel);
            ps.setObject(2, ovog);
            ps.setObject(3, ner);
            ps.setObject(4, status);
            ps.setObject(5, utas);
            ps.setObject(6, email);
            ps.setObject(7, social);
            ps.setObject(8, reg);
            ps.setObject(9, addr);
            ps.setObject(10, kom);
            ps.setObject(11, elselt);
            ps.setObject(12, flag);
            ps.setObject(13, shaltgan);
            ps.setObject(14, pic);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIntoStuTeach(
            Object id,
            Object stu,
            Object teach
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into student_teacher (id, student_id, teacher_id) values (?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, stu);
            ps.setObject(3, teach);
            ps.executeUpdate();
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIntoStatus(Object status_name, Object type) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into status_torol (status_name,type) values (?,?)");
            ps.setString(1, status_name.toString());
            ps.setString(2, type.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Database tools Error!");
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
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIntoTaskName(Object task_id,
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
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIntoTeacherClass(Object class_id,
            Object teacher_id,
            Object teacher_class_id
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into TeacherClass (Class_id, Teacher_id,teacher_class_id) values (?,?,?)");
            ps.setObject(1, class_id);
            ps.setObject(2, teacher_id);
            ps.setObject(3, teacher_class_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIntoTeam(Object team_id,
            Object team_name,
            Object team_motto
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Team (team_id, team_name,team_motto) values (?,?,?)");
            ps.setObject(1, team_id);
            ps.setObject(2, team_name);
            ps.setObject(3, team_motto);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIntoTeamStudents(Object team_id,
            Object student_id,
            Object role
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into Team_students (team_id, student_id,role) values (?,?,?)");
            ps.setObject(1, team_id);
            ps.setObject(2, student_id);
            ps.setObject(3, role);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteFromTeam(Object id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Team where team_id=?");
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean deleteFromTeacherClass(Object id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from TeacherClass where teacher_class_id=?");
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean deleteFromTeacherAcc(Object id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from TeacherAcc where Teacher_id=?");
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean deleteFromTeacher(Object id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Teacher where Teacher_id=?");
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean deleteFromTaskName(Object id) {
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
            Object subject_type_id) {
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

    public boolean deleteFromSubjectType(Object id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Subject_Type where subject_type_id=?");
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean deleteFromStudent(Object id) {
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
            Object acc_id) {
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

    public boolean deleteFromStatus(Object id) {
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
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteAdmin(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Admin where Admin_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteAdminAcc(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from AdminAcc where Admin_id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteClass(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Class where Class_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteDaalgavar(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Daalgavar where Homework_id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteDasgal(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dasgal where Exercise_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

//    public boolean deleteDunDaalgavar(Object d1) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("delete from Dun_Daalgavar where Student_homework_id=?");
//            ps.setObject(1, d1);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

    public boolean deleteDunDasgal(Object d1, Object d2) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Dasgal where Student_exercise_id =? and Student_id=? ");
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

//    public boolean deleteDunIdevh(Object d1, Object d2) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("delete from Dun_Idevh where student_id=? and subject_type_id=? ");
//            ps.setObject(1, d1);
//            ps.setObject(2, d2);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

//    public boolean deleteDunIrts(Object d1, Object d2) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("delete from Dun_Irts where student_id=? and subject_type_id=? ");
//            ps.setObject(1, d1);
//            ps.setObject(2, d2);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

    public boolean deleteDunIrtsLavlah(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Dun_Irts_Lavlah where irts_onoo=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

//    public boolean deleteDunShalgalt(Object d1, Object d2) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("delete from Dun_Shalgalt where Student_id=? and  Exam_ID=?");
//            ps.setObject(1, d1);
//            ps.setObject(2, d2);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

    public boolean deleteLecture(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from lecture where lecture_id=? ");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteLectureSession(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from  Lecture_sessions where lecture_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteManager(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Manager where Manager_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteProject(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Project where project_name=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
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

    public boolean updateAdmin(Object id, Object lastname, Object firstname, Object phone, Object address, Object email, Object status_id, Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  Admin set  Admin_id =?, Lastname=?, firstName=? , phone=? , Address =?, email=?,statusstatus_id =? where Admin_id =? ");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, address);
            ps.setObject(6, email);
            ps.setObject(7, status_id);
            ps.setObject(8, where);
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

//    public boolean updateDunDaalgavar(Object id, Object HomeworkID, Object status, Object date_received, Object Student_id, Object Point, Object where) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("update Dun_Daalgavar set Student_homework_id=?, Homework_id=? ,status_recieved=?, date_recieved,Student_id,Homework_Point=? where Student_homework_id=?");
//            ps.setObject(1, id);
//            ps.setObject(2, HomeworkID);
//            ps.setObject(3, status);
//            ps.setObject(4, date_received);
//            ps.setObject(5, Student_id);
//            ps.setObject(6, Point);
//            ps.setObject(7, where);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

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

//    public boolean updateDunIdevh(Object s1, Object s2, Object s3, Object s4, Object s5) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("update Dun_Idevh set student_id=?, date=? , idevh_point=?, subject_type_id=? where student_id=?");
//            ps.setObject(1, s1);
//            ps.setObject(2, s2);
//            ps.setObject(3, s3);
//            ps.setObject(4, s4);
//            ps.setObject(5, s5);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

//    public boolean updateDunIrts(Object s1, Object s2, Object s3, Object s4, Object s5, Object s6) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("update Dun_Irts set student_id=?, date=? , missed_time=?, attendance_point=?, subject_type_id=?  where student_id=?");
//            ps.setObject(1, s1);
//            ps.setObject(2, s2);
//            ps.setObject(3, s3);
//            ps.setObject(4, s4);
//            ps.setObject(5, s5);
//            ps.setObject(6, s6);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

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

//    public boolean updateDunShalgalt(Object s1, Object s2, Object s3, Object s4) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("update Dun_Shalgalt set Studentstudent_id=?, Exam_NAMEExam_ID=? , Exam_Point=? where  Studentstudent_id=?");
//            ps.setObject(1, s1);
//            ps.setObject(2, s2);
//            ps.setObject(3, s3);
//            ps.setObject(4, s4);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            return false;
//        }
//        return true;
//    }

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

    public boolean updateManager(Object id,
            Object regNum,
            Object lastname,
            Object firstname,
            Object status,
            Object phone,
            Object emailAddress,
            Object socialAddress,
            Object address,
            Object teacher_pic,
            Object del_flag,
            Object password,
            Object username
            ) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  manager set "
                    + "reg_num=?, "
                    + "lastname=? , "
                    + "firstname=? , "
                    + "status_id =?, "
                    + "phone=?, "
                    + "email_address =?, "
                    + "social_address =?, "
                    + "address =?, "
                    + "manager_picture =?, "
                    + "username =?, "
                    + "password =?  "
                    + " where manager_id =? ");
            ps.setObject(12, id);
            ps.setObject(1, regNum);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, status);
            ps.setObject(5, phone);
            ps.setObject(6, emailAddress);
            ps.setObject(7, socialAddress);
            ps.setObject(8, address);
            ps.setObject(9, teacher_pic);
            ps.setObject(10, username);
            ps.setObject(11, password);
            System.out.println("------------------------>" + ps);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
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

    public boolean updateStudentClass(Object class_id,
            Object student_id) {
        System.out.println(">>>>>>>>>>" + class_id);
        System.out.println(">>>>>>>>>>" + student_id);

        try {
            PreparedStatement ps = connection.prepareStatement("update  studentclass set "
                    + "class_id=? where student_id =? ");
            ps.setObject(1, class_id);
            ps.setObject(2, student_id);
            System.out.println("ps2--->>>>" + ps.toString());
            ps.executeUpdate();

        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public ArrayList<String> insertIntoStudentTeacher(String student_id, String... teacher_ids) {
        ArrayList<String> returnList = new ArrayList<>();
        try {
            for (String teacher_id : teacher_ids) {
                PreparedStatement ps = connection.prepareStatement("insert into student_teacher (student_id, teacher_id) values (?, ?) ");
                ps.setString(1, student_id);
                ps.setString(2, teacher_id);
                ps.executeUpdate();
                
                String query = "select * from student_teacher order by id desc limit 1";
                ResultSet result = runQuery(query);
                while (result.next()) {
                    returnList.add(result.getObject("id") + "::" + result.getObject("student_id") + "::" + result.getObject("teacher_id"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
        return returnList;
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

    public boolean updateTeacher(
            Object where,
            Object regNum,
            Object lastname,
            Object firstname,
            Object status,
            Object class_type,
            Object phone,
            Object email_address,
            Object social_address,
            
            Object del_flag,
            Object address,
            Object pic,
            Object username,
            Object pass
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("update teacher set reg_num=?, lastname=? , firstname=? , status_id =?, class_type=?, phone=?, email_address =?, social_address =?, address =?, teacher_picture=?, username=?, password=? where teacher_id=? ");
            ps.setObject(1, regNum);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, status);
            ps.setObject(5, class_type);          
            ps.setObject(6, phone);
            ps.setObject(7, email_address);
            ps.setObject(8, social_address);
            ps.setObject(9, address);
            ps.setObject(10, pic);
            ps.setObject(11, username);
            ps.setObject(12, pass);
            ps.setObject(13, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteFromStatusTorol(Object id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from status_torol where status_id=?");
            ps.setObject(1, id);
            System.out.println(">>>>>>>>>>>" + ps.toString());
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean updateStatus(Object id,
            Object name,
            Object type,
            Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  status_torol set "
                    + "status_id=?,"
                    + "status_name=?,"
                    + "type=? where status_id =? ");
            ps.setObject(1, id);
            ps.setObject(2, name);
            ps.setObject(3, type);
            ps.setObject(4, where);
            System.out.println("ps--->" + ps.toString());
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

    public boolean updateTeacherClass(Object s1, Object s2, Object s3, Object s4) {
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

    public boolean updateTeam(Object s1, Object s2, Object s3, Object s4) {
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

    public boolean updateTeamStudents(Object s1, Object s2, Object s3, Object s4, Object s5) {
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
    public boolean deleteFromTeamStudent(Object s1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Team_students where team_student_id = ?");
            ps.setObject(1, s1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteFromShalgalt(Object id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from Shalgalt where Exam_ID=?");
            ps.setObject(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    public boolean insertElseltPlan(Object name, Object desc, Object start_date, Object end_date) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into elseltiin_plan (name, descr, start_ognoo, end_ognoo) values(?, ?, ?, ?) ");
            ps.setString(1, name.toString());
            ps.setString(2, desc.toString());
            ps.setString(3, start_date.toString());
            ps.setString(4, end_date.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return true;
    }

    public boolean updateElseltPlan(Object id, Object name, Object desc, Object start_date, Object end_date) {
        try {

            PreparedStatement ps = connection.prepareStatement("update  elseltiin_plan set name =?, descr =? , start_ognoo =?, end_ognoo =? where id =? ");
            ps.setObject(1, name);
            ps.setObject(2, desc);
            ps.setObject(3, start_date);
            ps.setObject(4, end_date);
            ps.setObject(5, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean deleteElseltPlan(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from elseltiin_plan where id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean updateNegdsenDun(Object id, Object name, Object percent, Object teacher_id) {
        try {
            PreparedStatement ps = connection.prepareStatement("update negdsen_dun set name = ?, percent = ?, teacher_id = ? ");
            ps.setString(1, name.toString());
            ps.setInt(2, Integer.parseInt(percent.toString()));
            ps.setInt(3, Integer.parseInt(teacher_id.toString()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean insertNegdsenDun(Object id, Object name, Object percent, Object teacher_id) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into  negdsen_dun values (id=?, name=? , percent=?, teacher_id=?) ");
            ps.setString(1, id.toString());
            ps.setString(2, name.toString());
            ps.setInt(3, Integer.parseInt(percent.toString()));
            ps.setInt(4, Integer.parseInt(teacher_id.toString()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
     public boolean deleteNegdsenDun(Object id){
         try{
             PreparedStatement ps = connection.prepareStatement("delete from negdsen_dun where id=?");
             ps.setObject(1, id);
             ps.executeUpdate();
         } catch(SQLException ex){
             return false;
         }
         return true;
     }
    public boolean flagStudent(Object where, Object del_flag) {
        try {
            PreparedStatement ps = connection.prepareStatement("update student set del_flag =? where student_id=?");
            ps.setObject(1, del_flag);
            ps.setObject(2, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean flagTeacher(Object where, Object del_flag) {
        try {
            PreparedStatement ps = connection.prepareStatement("update teacher set del_flag =? where teacher_id=?");
            ps.setObject(1, del_flag);
            ps.setObject(2, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean flagManager(Object where, Object del_flag) {
        try {
            PreparedStatement ps = connection.prepareStatement("update manager set del_flag =? where manager_id=?");
            ps.setObject(1, del_flag);
            ps.setObject(2, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean flagAdmin(Object where, Object del_flag) {
        try {
            PreparedStatement ps = connection.prepareStatement("update admin set del_flag = ? where admin_id=?");
            ps.setObject(1, del_flag);
            ps.setObject(2, where);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertDaalgavarStatus(
            Object id,
            Object status,
            Object onoo,
            Object teacher_id
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into daalgavar_status  values (?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIdevhStatus(
            Object id,
            Object status,
            Object onoo,
            Object teacher_id
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into idevh_status  values (?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertIrtsStatus(
            Object id,
            Object status,
            Object onoo,
            Object teacher_id
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into irts_status  values (?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean insertShalgaltStatus(
            Object id,
            Object status,
            Object onoo,
            Object teacher_id
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into shalgalt_status  values (?,?,?,?)");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean insertAdminProfile(Object lastname,
                                    Object firstname, 
                                    Object phone, 
                                    Object address, 
                                    Object email, 
                                    Object status_id, 
                                    Object admin_pic, 
                                    Object username, 
                                    Object password, 
                                    Object reg_num, 
                                    Object social_address, 
                                    Object del_flag) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into admin("
                    + "lastname, "
                    + "firstname,"
                    + "phone,"
                    + "address,"
                    + "email_address, "
                    + "status_id,"
                    + "admin_picture,"
                    + "username,"
                    + "password,"
                    + "reg_num,"
                    + "social_address,"
                    + "del_flag"
                    + ") values(?,?,?,?,?,?,?,?,?,?,?,?) ");
            ps.setObject(1, lastname.toString());
            ps.setString(2, firstname.toString());
            ps.setString(3, phone.toString());
            ps.setString(4, address.toString());
            ps.setString(5, email.toString());
            ps.setString(6, status_id.toString());
            ps.setString(7, admin_pic.toString());
            ps.setString(8, username.toString());
            ps.setString(9, password.toString());
            ps.setString(10, reg_num.toString());
            ps.setString(11, social_address.toString());
            ps.setString(12, del_flag.toString());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return true;
    }
      public boolean updateStudent(Object id,
            Object code,
            Object lastname,
            Object firstname,
            Object status,
            Object phone,
            Object email_address,
            Object social_address,
            Object reg_num,
            Object address,
            Object class_id,
            Object com_num,
            Object elseltiin_id,
            Object del_flag,
            Object reason,
            Object student_pic
    ) {
        try {
            PreparedStatement ps = connection.prepareStatement("update  student set "
  
                    + "code=?,"
                    + "lastname=?,"
                    + "firstname=?,"
                    + "status_id=?,"
                    + "phone=?,"
                    + "email_address=? ,"
                    + "social_address =?,"
                    + "reg_num=?,"
                    + "address=?,"
                    + "com_num=?,"
                    + "elseltiin_id =?,"
                    + "del_flag=?, "
                    + "reason=?,"
                    + "student_pic=?"
                    + "where student_id =? ");
            ps.setObject(15, id);
            ps.setObject(1, code);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, status);
            ps.setObject(5, phone);
            ps.setObject(6, email_address);
            ps.setObject(7, social_address);
            ps.setObject(8, reg_num);
            ps.setObject(9, address);
            ps.setObject(10, com_num);
            ps.setObject(11, elseltiin_id);
            ps.setObject(12, del_flag);
            ps.setObject(13, reason);
            ps.setObject(14, student_pic);
            System.out.println("ps--->" + ps.toString());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
     public boolean updateStudent_Teacher(Object stu, Object teach, Object where){
        try{
            PreparedStatement ps = connection.prepareStatement("update student_teacher  set student_id=? , teacher_id=? where id=?");
            ps.setObject(1, stu);
            ps.setObject(2, teach);
            ps.setObject(3, where);
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
      
    public boolean deleteFromStudentTeacher(String student_id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from student_teacher where student_id = ?");
            ps.setInt(1, Integer.parseInt(student_id));
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public String deleteFromIrtsStatus(Object id) {
         String str = "true";
        try {
            PreparedStatement ps = connection.prepareStatement("delete from irts_status where id=?");
            ps.setObject(1, id);
            System.out.println(">>>>>>>>>>>"+ps.toString());
            ps.executeUpdate();
        } catch (Exception e) {
            str = "Can not delete parent row!";
            return str;
        }
        return str;
    }
     
     public String deleteFromIdevhStatus(Object id) {
         String str = "true";
        try {
            PreparedStatement ps = connection.prepareStatement("delete from idevh_status where id=?");
            ps.setObject(1, id);
            System.out.println(">>>>>>>>>>>"+ps.toString());
            ps.executeUpdate();
        } catch (Exception e) {
            str = "Can not delete parent row!";
            return str;
        }
        return str;
    }
    
    
    public boolean deleteAdminProfile(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from admin where admin_id=?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    
    public boolean updateAdminProfile(Object id,
                                    Object lastname,
                                    Object firstname,
                                    Object status,
                                    Object phone,
                                    Object email_address,
                                    Object social_address,
                                    Object reg_num,
                                    Object address,
                                    Object del_flag,
                                    Object admin_pic,
                                    Object username,
                                    Object password,
                                    Object where) {
        try {
            PreparedStatement ps = connection.prepareStatement("update admin set "
                    + "admin_id=?,"
                    + "lastname=?,"
                    + "firstname=?,"
                    + "phone=?,"
                    + "email_address=? ,"
                    + "social_address =?,"
                    + "reg_num=?,"
                    + "address=?,"
                    + "del_flag=?, "
                    + "admin_picture=?,"
                    + "username=?,"
                    + "password=?,"
                    + "status_id=? where admin_id =? ");
            ps.setObject(1, id);
            ps.setObject(2, lastname);
            ps.setObject(3, firstname);
            ps.setObject(4, phone);
            ps.setObject(5, email_address);
            ps.setObject(6, social_address);
            ps.setObject(7, reg_num);
            ps.setObject(8, address);
            ps.setObject(9, del_flag);
            ps.setObject(10, admin_pic);
            ps.setObject(11, username);
            ps.setObject(12, password);
            ps.setObject(13, status);
            ps.setObject(14, where);
            System.out.println("ps--->" + ps.toString());

            try {
                
            ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
       
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    
    public String deleteIrtsStatus(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from irts_status where id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return "error";
        }
        return "true";
    }
    public String deleteIdevhStatus(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from idevh_status where id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return "error";
        }
        return "true";
    }
     public String deleteFromDaalgavarStatus(Object id) {
         String str = "true";
        try {
            PreparedStatement ps = connection.prepareStatement("delete from daalgavar_status where id=?");
            ps.setObject(1, id);
            System.out.println(">>>>>>>>>>>"+ps.toString());
            ps.executeUpdate();
        } catch (Exception e) {
            str = "Can not delete parent row!";
            return str;
        }
        return str;
    }
    public String deleteFromShalgaltStatus(Object id) {
         String str = "true";
        try {
            PreparedStatement ps = connection.prepareStatement("delete from shalgalt_status where id=?");
            ps.setObject(1, id);
            System.out.println(">>>>>>>>>>>"+ps.toString());
            ps.executeUpdate();
        } catch (Exception e) {
            str = "Can not delete parent row!";
            return str;
        }
        return str;
    }
    
public boolean updateIrtsStatus(Object id,
                                    Object status,
                                    Object onoo,
                                    Object teacher_id,
                                    Object where){
        try {
            PreparedStatement ps = connection.prepareStatement("update irts_status set "
                    + "id=?,status=?,onoo=?,teacher_id=? where id =?");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.setObject(5, where);
            System.out.println("ps--->" + ps.toString());

            try {
                
            ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
       
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean updateIdevhStatus(Object id,
                                    Object status,
                                    Object onoo,
                                    Object teacher_id,
                                    Object where){
        try {
            PreparedStatement ps = connection.prepareStatement("update idevh_status set "
                    + "id=?,status=?,onoo=?,teacher_id=? where id =?");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.setObject(5, where);
            System.out.println("ps--->" + ps.toString());

            try {
                
            ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
       
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    

    public boolean updateDaalgavarStatus(Object id,
                                    Object status,
                                    Object onoo,
                                    Object teacher_id,
                                    Object where){
        try {
            PreparedStatement ps = connection.prepareStatement("update daalgavar_status set "
                    + "id=?,status=?,onoo=?,teacher_id=? where id =?");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.setObject(5, where);
            System.out.println("ps--->" + ps.toString());

            try {
                
            ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
       
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public boolean updateShalgaltStatus(Object id,
                                    Object status,
                                    Object onoo,
                                    Object teacher_id,
                                    Object where){
        try {
            PreparedStatement ps = connection.prepareStatement("update shalgalt_status set "
                    + "id=?,status=?,onoo=?,teacher_id=? where id =?");
            ps.setObject(1, id);
            ps.setObject(2, status);
            ps.setObject(3, onoo);
            ps.setObject(4, teacher_id);
            ps.setObject(5, where);
            System.out.println("ps--->" + ps.toString());

            try {
                
            ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
       
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public String insertDunIrts(Object student_id, Object status_id, Object date) {
        
        String str = "true";
        
        try {
            
            PreparedStatement ps = connection.prepareStatement("insert into dun_irts (student_id, irts_statusid, ognoo) values(?, ?, ?) ");
            ps.setString(1, student_id.toString());
            ps.setString(2, status_id.toString());
            ps.setString(3, date.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            str = "Irts_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
            System.out.println("" + ex.getMessage());
        }
      return str;
    }
    
    public String insertDunIdevh(Object student_id, Object status_id, Object date) {
        
        String str = "true";
        
        try {
            
            PreparedStatement ps = connection.prepareStatement("insert into dun_udevh (student_id, idevh_statusid, ognoo) values(?, ?, ?) ");
            ps.setString(1, student_id.toString());
            ps.setString(2, status_id.toString());
            ps.setString(3, date.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            str = "Idevh_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
            System.out.println("" + ex.getMessage());
        }
      return str;
    }
    
    

 public String insertDunShalgalt(Object student_id, Object subject_id, Object shalgalt_ner, Object shalgalt_statusid, Object ognoo) {
        
        String str = "true";
        
        try {
            
            PreparedStatement ps = connection.prepareStatement("insert into dun_shaglalt (student_id, subject_id, shalgalt_ner, shalgalt_statusid, ognoo) values(?, ?, ?, ?, ?) ");
            ps.setInt(1, Integer.parseInt(student_id.toString()));
            ps.setInt(2, Integer.parseInt(subject_id.toString()));
            ps.setString(3, shalgalt_ner.toString());
            ps.setInt(4, Integer.parseInt(shalgalt_statusid.toString()));
            ps.setString(5, ognoo.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            str = "shalgalt_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
        }
      return str;
    }
    
      public String insertDunDaalgavar(Object student_id, Object subject_id, Object daalgavar_ner, Object daalgavar_statusid, Object onoo) {
        
        String str = "true";
        
        try {
            
            PreparedStatement ps = connection.prepareStatement("insert into dun_daalgavar (student_id, subject_id, daalgavar_ner, daalgavar_statusid, onoo) values(?, ?, ?, ?, ?) ");
            ps.setString(1, student_id.toString());
            ps.setString(2, subject_id.toString());
            ps.setString(3, daalgavar_ner.toString());
            ps.setString(4, daalgavar_statusid.toString());
            ps.setString(5, onoo.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            str = "daalgavar_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
            System.out.println("" + ex.getMessage());
        }
      return str;
    }


    
    
    public boolean deleteDunIrts(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from dun_irts where id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunIdevh(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from dun_udevh where id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunShalgalt(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from dun_shaglalt where id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    public boolean deleteDunDaalgavar(Object d1) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from dun_daalgavar where id =?");
            ps.setObject(1, d1);
            ps.executeUpdate();
        }catch(SQLException ex){
            return false;
        }
        return true;
    }
    

    public String update_DunIrts(Object id,
                                    Object student_id,
                                    Object irts_statusId,
                                    Object ognoo,
                                    Object where) {
        
        String str = "";
        
        try {
            
            str = "true";
            PreparedStatement ps = connection.prepareStatement("update dun_irts set "
                    + "id=?,"
                    + "student_id=?,"
                    + "irts_statusid=?,"
                    + "ognoo=?"
                    + " where id =? ");
            ps.setObject(1, id);
            ps.setObject(2, student_id);
            ps.setObject(3, irts_statusId);
            ps.setObject(4, ognoo);
            ps.setObject(5, where);
            System.out.println("ps--->" + ps.toString());
            ps.executeUpdate();
            
       
            
        } catch (Exception ex) {
           
            System.out.println("error" + ex.getMessage());
            str = "Irts_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
            return "";
        }
        return str;
    }
    
    
    public String update_DunIdevh(Object id,
                                    Object student_id,
                                    Object idevh_statusId,
                                    Object ognoo,
                                    Object where) {
        
        String str = "";
        
        try {
            
            str = "true";
            PreparedStatement ps = connection.prepareStatement("update dun_udevh set "
                    + "id=?,"
                    + "student_id=?,"
                    + "idevh_statusid=?,"
                    + "ognoo=?"
                    + " where id =? ");
            ps.setObject(1, id);
            ps.setObject(2, student_id);
            ps.setObject(3, idevh_statusId);
            ps.setObject(4, ognoo);
            ps.setObject(5, where);
            System.out.println("ps--->" + ps.toString());
            ps.executeUpdate();
            
       
            
        } catch (Exception ex) {
           
            System.out.println("error" + ex.getMessage());
            str = "Idevh_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
            return "";
        }
        return str;
    }
    
    
    
    public String update_DunShalgalt(Object id,
                                    Object student_id,
                                    Object subject_id,
                                    Object shalgalt_ner,
                                    Object shalgalt_statusId,
                                    Object ognoo,
                                    Object where) {
        
        String str = "";
        
        try {
            
            str = "true";
            PreparedStatement ps = connection.prepareStatement("update dun_shaglalt set "
                    + "id=?,"
                    + "student_id=?,"
                    + "subject_id=?,"
                    + "shalgalt_ner=?,"
                    + "shalgalt_statusid=?,"
                    + "ognoo=?"
                    + " where id =? ");
            ps.setObject(1, id);
            ps.setObject(2, student_id);
            ps.setObject(3, subject_id);
            ps.setObject(4, shalgalt_ner);
            ps.setObject(5, shalgalt_statusId);
            ps.setObject(6, ognoo);
            ps.setObject(7, where);
            System.out.println("ps--->" + ps.toString());
            ps.executeUpdate();
            
       
            
        } catch (Exception ex) {
           
            System.out.println("error" + ex.getMessage());
            str = "shalgalt_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
            return "";
        }
        return str;
    }
    
    
    public String update_DunDaalgavar(Object id,
                                    Object student_id,
                                    Object subject_id,
                                    Object daalgavar_ner,
                                    Object daalgavar_statusId,
                                    Object onoo,
                                    Object where) {
        
        String str = "";
        
        try {
            
            str = "true";
            PreparedStatement ps = connection.prepareStatement("update dun_daalgavar set "
                    + "id=?,"
                    + "student_id=?,"
                    + "subject_id=?,"
                    + "daalgavar_ner=?,"
                    + "daalgavar_statusid=?,"
                    + "onoo=?"
                    + " where id =? ");
            ps.setObject(1, id);
            ps.setObject(2, student_id);
            ps.setObject(3, subject_id);
            ps.setObject(4, daalgavar_ner);
            ps.setObject(5, daalgavar_statusId);
            ps.setObject(6, onoo);
            ps.setObject(7, where);
            System.out.println("ps--->" + ps.toString());
            ps.executeUpdate();
            
       
            
        } catch (Exception ex) {
           
            System.out.println("error" + ex.getMessage());
            str = "daalgavar_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
            return "";
        }
        return str;
    }
    

    


}
