package Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RequestFilter {
    static DatabaseTools db = new DatabaseTools();
    static int j = 0;

    private static ArrayList<Object> responseData = new ArrayList<>();

    public static Object Request(String request, Object data) {
        String o1,o2,o3,o4,o5,o6,o7,o8,o9;
        Object response = null;
        switch (request) {
            case "Account":
                String username = data.toString().split("::")[0];
                String password = data.toString().split("::")[1];
                response = Login(username, password);
                break;
            case "getAllStudentProfile":
                response = allStudentProfile();
                break;
            case "getStudentProfile":
                String first_name = data.toString().split("::")[0];
                response = studentProfile(first_name);

                break;
            case "getTaskGrade":
                String first_names = data.toString().split("::")[0];
                response = TaskgetGrade(first_names);
                break;
            case "getExamGrade":
                String first_names1 = data.toString().split("::")[0];
                response = ExamgetGrade(first_names1);
                break;
            case "getProjectGrade":
                String first_names2 = data.toString().split("::")[0];
                response = ProjectgetGrade(first_names2);
                break;
            case "getTeacherProfile":
                String first_names3 = data.toString().split("::")[0];
                response = teacherProfile(first_names3);
                break;
            case "getAllTeacherProfile":
                response = allTeacherProfile();
                break;
            case "getAllAdminProfile":
                response = allAdminProfile();
                break;
            case "getExerciseGrade":
                String first_names4 = data.toString().split("::")[0];
                response = ExercisegetGrade(first_names4);
                break;
            case "getHomeworkGrade":
                String first_names5 = data.toString().split("::")[0];
                response = HomeworkgetGrade(first_names5);
                break;
            case "getAttendanceGrade":
                String first_names6 = data.toString().split("::")[0];
                response = getAttendanceGrade(first_names6);
            case "insertStudent":

                String student_id = data.toString().split("::")[0];
                String first_names7 = data.toString().split("::")[1];
                String last_name = data.toString().split("::")[2];
                String phone = data.toString().split("::")[3];
                String address = data.toString().split("::")[4];
                String comNum = data.toString().split("::")[5];
                String classId = data.toString().split("::")[6];
                String statusId = data.toString().split("::")[7];

                if (insertStudent(student_id, first_names7, last_name, phone, address, comNum, classId, statusId)) {
                    System.out.println("Amjilttai orloo");
                } else {
                    System.err.println("Amjiltgui");
                }
            case "getAllHomework":
                response = getHomework();
                break;
            case "getStudentHomework":
                String first_names8 = data.toString().split("::")[0];
                response = getStudentHomework(first_names8);
                break;
           // case "getReport":
            //      response = getReport();
            //     break;
            case "getAllManagerProfile":
                response = getAllManager();
                break;
            case "getManagerProfile":
                String first_names9 = data.toString().split("::")[0];
                response = getManagerProfile(first_names9);
                break;
            case "getManProfile":
                String user_name = data.toString();
                response = managerLogin(user_name);
                break;
            case "manGetAllStudents":
//                String first_names11 = data.toString().split("::")[0];
                response = managerGetAllStudents();
                break;
                
            case "manGetAllTeachers":
                response = managerGetAllTeachers();
                break;
            case "manGetTeacher":
                String first_name11 = data.toString();
                response = manGetTeacher(first_name11);
                break;
            case "manGetStudent":
                String first_name12 = data.toString();
                response = managerGetStudent(first_name12);
                break;
            case "adminGetAllTeachers":
                response = adminGetAllTeacher();
                break;
                
            case "getStudentProfileForList":
                String first_nameFor = data.toString();
                response = studentProfileFor(first_nameFor);
                break;
            case "getClassStudents":

                String teach_username = data.toString();
                response = classStudents(teach_username);
                break;
            case "getClassIrts":
                String teach_username1 = data.toString();
                response = irtsAll(teach_username1);
                break;
            case "getClassIdevh":
                String teach_username2 = data.toString();
                response = idevhAll(teach_username2);
            case "adminGetAllTeacher":
                response = adminGetAllTeacher();
                break;
            case "adminGetTeacher":
                String first_name13 = data.toString();
                response = adminGetTeacher(first_name13);
                break;
            case "getHomeworkDate":
                response = getHomeworkDate();
                break;
            case "adminGetAllStudents":
                response = adminGetAllStudents();
                break;
            case "adminGetStudent":
                String first_name14 = data.toString();
                response = adminGetStudent(first_name14);
                break;
            case "getSubjectNames":
                response = getSubjectNames();
                break;
            case "getStudentGrade":
                String student_id1 = data.toString().split("||")[0];
                response = studentGradeTest(data.toString());
                break;
            case "getGradePlace":
                String student_id2 = data.toString().split("::")[0];
                response = studentGradePlace(student_id2);
                break;
            case "getOtherClassGradePlace":
                String class_id = data.toString().split("::")[0];
                response = otherClassGradePlace(class_id);
                break;
            case "getJavaClassGradePlace":
                String class_idJava = "1";
                response = otherClassGradePlace(class_idJava);
                break;
            case "getCClassGradePlace":
                String class_idC = "2";
                response = otherClassGradePlace(class_idC);
                break;
//            *****************************************************ADDED****************************
                
             //-----------------------INSERT BEGIN ------------------------//   
               case "insertAccount":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                
                response = insertAccount(o1,o2,o3);
                break;
            case "insertAdmin":
                String a1 =  data.toString().split("::")[0];
                String a2 =  data.toString().split("::")[1];
                String a3 =  data.toString().split("::")[2];
                String a4 =  data.toString().split("::")[3];
                String a5 =  data.toString().split("::")[4];
                
                response = insertAdmin(a1,a2,a3,a4,a5);
                break;
            case "insertAdminAcc":
                String b1 =  data.toString().split("::")[0];
                String b2 =  data.toString().split("::")[1];
                
                response = insertAdminAcc(b1,b2);     
            case "insertClass":
                String c1 =  data.toString().split("::")[0];
                String c2 =  data.toString().split("::")[1];
                String c3 =  data.toString().split("::")[2];
                
                response = insertClass(c1,c2,c3);
                break;
            case "insertDaalgavar":
                
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                
                response = insertDaalgavar(o1, o2, o3, o4);
                break;
            case "insertDasgal":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                
                response = insertDasgal(o1, o2, o3, o4);
                break;
            case "insertDunBiedaalt":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                
                response = insertDunBieDaalt(o1, o2, o3);
                break;
            case "insertDunDasgal":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                o6 =  data.toString().split("::")[5];
                
                response = insertDunDasgal(o1, o2, o3, o4, o5, o6);
                break;
            case "insertDunIdevh":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                
                response = insertDunIdevh(o1, o2, o3, o4);
                break;
            case "insertDunIrts":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                
                response = insertDunIrts(o1, o2, o3, o4, o5);
                break;   
            case "insertDunIrtsLavlah":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                
                response = insertDunIrtsLavlah(o1, o2);
                break;
            case "insertDunShalgalt":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                response = insertDunShalgalt(o1, o2, o3);
                break;
            case "insertLecture":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                
                response = insertLecture(o1, o2, o3, o4, o5);
                break;
            case "insertLectureSession":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                response = insertLectureSession(o1, o2);
                break;
             case "insertManager":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                response = insertManager(o1,o2, o3, o4, o5);
                break;
             case "insertManagerAcc":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                response = insertManagerAcc(o1, o2);
                 break;
//                ************************************************************************
            case "insertIntoTeamStudents":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                response = insertIntoTeamStudents(o1, o2, o3);
                break;
            case "insertIntoTeam":
                String oo1 = data.toString().split("::")[0];
                String oo2 = data.toString().split("::")[1];
                String oo3 = data.toString().split("::")[1];
                response = insertIntoTeam(oo1, oo2, oo3);
                break;
//                ************************************************************************
            case "insertIntoTeacherClass":
                String a12 = data.toString().split("::")[0];
                String a22 = data.toString().split("::")[1];
                String a32 = data.toString().split("::")[2];
                response = insertIntoTeamStudents(a12, a22, a32);
                break;
            case "insertIntoTeacherAcc":
                String aa1 = data.toString().split("::")[0];
                String aa2 = data.toString().split("::")[1];
                response = insertIntoTeacherAcc(aa1, aa2);
                break;
            case "insertIntoTeacher":
                String aaa1 = data.toString().split("::")[0];
                String aaa2 = data.toString().split("::")[1];
                String aaa3 = data.toString().split("::")[2];
                String aaa4 = data.toString().split("::")[3];
                String aaa5 = data.toString().split("::")[4];
                String aaa6 = data.toString().split("::")[5];
                response = insertIntoTeacher(aaa1, aaa2, aaa3, aaa4, aaa5, aaa6);
                break;
            case "insertIntoTaskName":
                String b11 = data.toString().split("::")[0];
                String b21 = data.toString().split("::")[1];
                String b31 = data.toString().split("::")[2];
                String b41 = data.toString().split("::")[3];
                String b51 = data.toString().split("::")[4];
                response = insertIntoTaskName(b11, b21, b31, b41, b51);
                break;
            case "insertIntoSubjectTypeClass":
                String bb1 = data.toString().split("::")[0];
                String bb2 = data.toString().split("::")[1];
                response = insertIntoSubjectTypeClass(bb1, bb2);
                break;
            case "insertIntoSubjectType":
                String bbb1 = data.toString().split("::")[0];
                String bbb2 = data.toString().split("::")[1];
                response = insertIntoSubjectType(bbb1, bbb2);
                break;
            case "insertIntoSubject":
                String c12 = data.toString().split("::")[0];
                String c22 = data.toString().split("::")[1];
                String c32 = data.toString().split("::")[2];
                String c42 = data.toString().split("::")[3];
                String c52 = data.toString().split("::")[4];
                String c62 = data.toString().split("::")[5];
                response = insertIntoSubject(c12, c22, c32, c42, c52, c62);
                break;
            case "insertIntoStudentAcc":
                String cc1 = data.toString().split("::")[0];
                String cc2 = data.toString().split("::")[1];
                response = insertIntoStudentAcc(cc1, cc2);
                break;
            case "insertIntoStudent":
                String ccc1 = data.toString().split("::")[0];
                String ccc2 = data.toString().split("::")[1];
                String ccc3 = data.toString().split("::")[2];
                String ccc4 = data.toString().split("::")[3];
                String ccc5 = data.toString().split("::")[4];
                String ccc6 = data.toString().split("::")[5];
                String ccc7 = data.toString().split("::")[6];
                String ccc8 = data.toString().split("::")[7];
                response = insertIntoStudent(ccc1, ccc2, ccc3, ccc4, ccc5, ccc6, ccc6, ccc8);
                break;
            case "insertIntoStatus":
                String cccc1 = data.toString().split("::")[0];
                String cccc2 = data.toString().split("::")[1];
                response = insertIntoStatus(cccc1, cccc2);
                break;
            case "insertIntoShalgalt":
                String d1 = data.toString().split("::")[0];
                String d2 = data.toString().split("::")[1];
                String d3 = data.toString().split("::")[2];
                response = insertIntoShalgalt(d1, d2, d3);
                break;
            case "insertIntoProject":
                String dd1 = data.toString().split("::")[0];
                String dd2 = data.toString().split("::")[1];
                String dd3 = data.toString().split("::")[2];
                String dd4 = data.toString().split("::")[3];
                response = insertIntoProject(dd1, dd2, dd3, dd4);
                break;
     //------------------------INSERT END----------------------//////////////////
     //----------------------UPDATE BEGIN -------------------------------------//
            case "updateAccount":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                 
               response = updateAccount(o1, o2, o3, o4, o5);
                 break;
             case "updateAdmin":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                o6 =  data.toString().split("::")[5];
                o7 =  data.toString().split("::")[6];
               response = updateAdmin(o1, o2, o3, o4, o5, o6, o7);
                 break;
            
             case "updateAdminAcc":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                
                response = updateAdminAcc(o1, o2, o3);
                 break;
                 
             case "updateClass":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                
                response = updateClass(o1, o2, o3, o4);
                 break;
            case "updateDaalgavar":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                response = updateDaalgavar(o1, o2, o3, o4, o5);
                 break;
            case "updateDasgal":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                response = updateDasgal(o1, o2, o3, o4, o5);
                 break;
            case "updateDunBieDaalt":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                response = updateDunBieDaalt(o1, o2, o3, o4);
                 break;
            case "updateDunDaalgavar":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                o6 =  data.toString().split("::")[5];
                o7 =  data.toString().split("::")[6];
                response = updateDunDaalgavar(o1, o2, o3, o4, o5, o6, o7);
                 break;
            case "updateDunDasgal":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                o6 =  data.toString().split("::")[5];
                o7 =  data.toString().split("::")[6];
                response = updateDunDasgal(o1, o2, o3, o4, o5, o6, o7);
                 break;
            case "updateDunIdevh":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                response = updateDunIdevh(o1, o2, o3, o4, o5);
                 break;
            case "updateDunIrts":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                o6 =  data.toString().split("::")[5];
                response = updateDunIrts(o1, o2, o3, o4, o5, o6);
                 break;
            case "updateDunIrtsLavlah":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                response = updateDunIrtsLavlah(o1, o2, o3);
                 break;
            case "updateDunShalgalt":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                response = updateDunShalgalt(o1, o2, o3, o4);
                 break;
            case "updateLecture":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                o6 =  data.toString().split("::")[5];
                response = updateLecture(o1, o2, o3, o4, o5, o6);
                 break;
             case "updateLectureSession":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                response = updateLectureSession(o1, o2, o3);
                 break;
            case "updateManager":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                o4 =  data.toString().split("::")[3];
                o5 =  data.toString().split("::")[4];
                o6 =  data.toString().split("::")[5];
                o7 =  data.toString().split("::")[6];
                response = updateManager(o1, o2, o3, o4, o5, o6, o7);
                 break;
            case "updateManagerAcc":
                o1 =  data.toString().split("::")[0];
                o2 =  data.toString().split("::")[1];
                o3 =  data.toString().split("::")[2];
                response = updateManagerAcc(o1, o2, o3);
                 break;
            //-----------------update adiyahuu end----------------//    
            case "updateTeamStudents":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                response = updateTeamStudents(o1, o2, o3, o4, o5);
                break;
            case "updateTeam":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                response = updateTeam(o1, o2, o3, o4);
                break;
            case "updateTeacherClass":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                response = updateTeacherClass(o1, o2, o3, o4);
                break;
            case "updateTeacherAcc":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                response = updateTeacherAcc(o1, o2, o3);
                break;
            case "updateTeacher":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                o6 = data.toString().split("::")[5];
                o7 = data.toString().split("::")[6];
                response = updateTeacher(o1, o2, o3, o4, o5, o6, o7);
                break;
            case "updateTaskName":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                o6 = data.toString().split("::")[5];
                response = updateTaskName(o1, o2, o3, o4, o5, o6);
                break;
            case "updateSubjectTypeClass":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                response = updateSubject_typeClass(o1, o2, o3);
                break;
            case "updateSubjectType":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                o6 = data.toString().split("::")[5];
                response = updateSubjectType(o1, o2, o3, o4, o5, o6);
                break;
            case "updateSubject":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                o6 = data.toString().split("::")[5];
                o7 = data.toString().split("::")[6];
                response = updateSubject(o1, o2, o3, o4, o5, o6, o7);
                break;
            case "updateStudentAcc":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                response = updateStudentAcc(o1, o2, o3);
                break;
            case "updateStudent":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                o6 = data.toString().split("::")[5];
                o7 = data.toString().split("::")[6];
                o8 = data.toString().split("::")[7];
                o9 = data.toString().split("::")[8];
                response = updateStudent(o1, o2, o3, o4, o5, o6, o7, o8, o9);
                break;
            case "updateStatus":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                response = updateStatus(o1, o2, o3);
                break;
            case "updateShalgalt":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                response = updateShalgalt(o1, o2, o3, o4, o5);
                break;
            case "updateProject":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                o3 = data.toString().split("::")[2];
                o4 = data.toString().split("::")[3];
                o5 = data.toString().split("::")[4];
                response = updateProject(o1, o2, o3, o4, o5);
                break;
//                *-*********************DELETE******************************************
            case "deleteFromTeamStudents":
                response = deleteFromTeamStudent(data);
                break;
            case "deleteFromTeam":
                response = deleteFromTeam(data);
                break;
            case "deleteFromTeacherAcc":
                response = deleteFromTeacherAcc(data);
                break;
            case "deleteFromTeacherClass":
                response = deleteFromTeacherClass(data);
                break;
            case "deleteFromTeacher":
                response = deleteFromTeacher(data);
                break;
            case "deleteFromTaskName":
                response = deleteFromTaskName(data);
                break;
            case "deleteFromSubjectTypeClass":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromSubjectTypeClass(o1,o2);
                break;
            case "deleteFromSubjectType":
                response = deleteFromSubjectType(data);
                break;
            case "deleteFromSubject":
                response = deleteFromSubject(data);
                break;
            case "deleteFromStudent":
                response = deleteFromStudent(data);
                break;
            case "deleteFromStudentAcc":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromStudentAcc(o1,o2);
                break;
            case "deleteFromStatus":
                response = deleteFromStatus(data);
                break;
            case "deleteFromShalgalt":
                response = deleteFromShalgalt(data);
                break;
            case "deleteFromProject":
                response = deleteFromProject(data);
                break;
            case "deleteFromManagerAcc":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromManagerAcc(o1,o2);
                break;
            case "deleteFromManager":
                response = deleteFromManager(data);
                break;
            case "deleteFromLectureSessions":
                response = deleteFromLectureSession(data);
                break;
            case "deleteFromLecture":
                response = deleteLecture(data);
                break;
            case "deleteFromDunShalgalt":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromDunShalgalt(o1,o2);
                break;
            case "deleteFromDunIrtsLavlah":
                response = deleteFromDunIrtsLavlah(data);
                break;
             case "deleteFromDunIrts":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromDunIrts(o1,o2);
                break;
            case "deleteFromDunIdevh":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromDunIdevh(o1,o2);
                break;
            case "deleteFromDunDasgal":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromDunDasgal(o1,o2);
                break;
            case "deleteFromDunDaalgavar":
                response = deleteFromDunDaalgavar(data);
                break;
            case "deleteFromDunBiedaalt":
                o1 = data.toString().split("::")[0];
                o2 = data.toString().split("::")[1];
                response = deleteFromDunBieDaalt(o1,o2);
                break;
            case "deleteFromDasgal":
                response = deleteFromDasgal(data);
                break;
            case "deleteFromClass":
                response = deleteFromClass(data);
                break;
            case "deleteFromAdminAcc":
                response = deleteFromAdminAcc(data);
                break;
            case "deleteFromAdmin":
                response = deleteFromAdmin(data);
                break;
            case "deleteFromAccount":
                response = deleteFromAccount(data);
                break;
        }
        return response;
    }

    public static String Login(String username, String password) {

        // String "оюутан::true"
        ArrayList<Object> usernameColumn = DB_Copy.getDatas("Account", "user_name");
        ArrayList<Object> passwordColumn = DB_Copy.getDatas("Account", "password");
        ArrayList<Object> typeColumn = DB_Copy.getDatas("Account", "type");

        for (int i = 0; i < usernameColumn.size(); i++) {
            if (usernameColumn.get(i).equals(username) && passwordColumn.get(i).equals(password)) {
                j = 1;
                return typeColumn.get(i)+"::true";
            }
        }
        j = 0;
        return "::false";
    }

    public static Object allStudentProfile() {
        ArrayList<Object> allProfile = new ArrayList<>();

        allProfile.add(DB_Copy.getDatas("Student", "first_name"));
        return allProfile;
    }

    public static Object allTeacherProfile() {
        ArrayList<Object> allProfile = new ArrayList<>();

        allProfile.add(DB_Copy.getDatas("Teacher", "first_name"));
        return allProfile;
    }

    public static Object allAdminProfile() {
        
        ArrayList<Object> allProfile = new ArrayList<>();
        int i = 0;
        String statusNamse = "";
        
        ArrayList<Object> idCol = DB_Copy.getDatas("Admin", "Admin_id");
        for (; i < idCol.size(); i++) {
            String str = "";
            str += DB_Copy.getDatas("Admin","Admin_id", i);
            str += "::";
            str += DB_Copy.getDatas("Admin","Lastname",i);
            str += "::";
            str += DB_Copy.getDatas("Admin","firtsName",i);
            str +="::";
            str += DB_Copy.getDatas("Admin", "phone", i);
            str +="::";
            str += DB_Copy.getDatas("Admin", "Address", i);
            
            ArrayList<Object> status = DB_Copy.getDatas("status", "status_id");
            
            for(int s = 0; s<status.size(); s++){
            Object TstatusID = DB_Copy.getDatas("Admin", "statusstatus_id", i);
            ArrayList<Object> StatusName = DB_Copy.getDatas("status","status_name");
            if(TstatusID.equals(status.get(s))){
                statusNamse = (String) StatusName.get(s);
                }
            }
            str +="::";
            str += statusNamse;
            
            
            allProfile.add(str);
        }
        return allProfile;    
        
    }

    public static Object studentProfile(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();

        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");

        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {
                profile.add(DB_Copy.getDatas("Student", i));
                break;
            }
        }

        return profile;
    }

    public static Object teacherProfile(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();

        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Teacher", "first_name");

        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {
                profile.add(DB_Copy.getDatas("Teacher", i));
                break;
            }
        }

        return profile;
    }

    public static Object TaskgetGrade(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {

                profile.add(DB_Copy.getDatas("Task", "Task_POINT int", i));
                break;
            }
        }
        return profile;
    }

    public static Object ExercisegetGrade(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {

                profile.add(DB_Copy.getDatas("Student_exercise", "Exercise_Point", i));
                break;
            }
        }
        return profile;
    }

    public static Object ProjectgetGrade(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {

                profile.add(DB_Copy.getDatas("Project", "project_mark", i));
                break;
            }
        }
        return profile;
    }

    public static Object ExamgetGrade(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {

                profile.add(DB_Copy.getDatas("Exam", "Exam_Point", i));
                break;
            }
        }
        return profile;
    }

    public static Object HomeworkgetGrade(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {

                profile.add(DB_Copy.getDatas("Student_homework", "Homework_Point", i));
                break;
            }
        }
        return profile;
    }

    public static Object getAttendanceGrade(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {

                profile.add(DB_Copy.getDatas("attendance", "attendance_point", i));
                break;
            }
        }
        return profile;
    }

    public static boolean insertStudent(String student_id, String first_name, String last_name, String phone, String address, String computerNum, String classId, String statusId) {

        ArrayList<Object> newDatas = new ArrayList<>();

        newDatas.add(student_id);
        newDatas.add(first_name);
        newDatas.add(last_name);
        newDatas.add(phone);
        newDatas.add(address);
        newDatas.add(computerNum);
        newDatas.add(classId);
        newDatas.add(statusId);

        try {
            DB_Copy.insertRow("Student", newDatas);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
//             table_temp.add(newDatas);
        return true;
    }

    public static Object getHomework() {
        ArrayList<String> returnData = new ArrayList<>();

        ArrayList<Object> idCol = DB_Copy.getDatas("Dun_Daalgavar", "Student_homework_id");
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Dun_Daalgavar", "status_recieved");
        ArrayList<Object> comCol = DB_Copy.getDatas("Dun_Daalgavar", "Homework_Point");

        ArrayList<Object> class_idCol = DB_Copy.getDatas("Daalgavar", "Subject_id");
        ArrayList<Object> classCol = DB_Copy.getDatas("Subject", "subject_id");
        ArrayList<Object> className = DB_Copy.getDatas("Subject", "subject_name");

        String line = "";
        for (int i = 0; i < class_idCol.size(); i++) {
            Object class_name = "";
            for (int j = 0; j < classCol.size(); j++) {
                if (class_idCol.get(i).equals(classCol.get(j))) {
                    class_name = className.get(j);
                    break;
                }
            }
            line = "    "+class_name+"           " + first_nameCol.get(i) +  "        " + comCol.get(i);
            returnData.add(line);
        }

        return returnData;
    }
    public static Object getHomeworkDate() {
        ArrayList<String> returnData = new ArrayList<>();
        ArrayList<Object> aCol = DB_Copy.getDatas("Dun_Daalgavar", "date_recieved");
        for (int i = 0; i < aCol.size(); i++) {
            returnData.add(aCol.get(i).toString());
        }
        
        return returnData;
    }

    public static Object getStudentHomework(String first_name) {
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {
                profile.add(DB_Copy.getDatas("Student_homework", i));
                break;
            }

        }
        return profile;
    }
    /* public static Object getReport() {
     ArrayList<Object> allProfile = new ArrayList<>();
     int i = 0;
     ArrayList<Object> idCol = DB_Copy.getDatas("Report", "Report_id");
     for (; i < idCol.size(); i++) {
     allProfile.add(DB_Copy.getDatas("Report", i));

     }
     return allProfile;  
     }*/
    
    public static Object getAllManager(){
            ArrayList<Object> allProfile = new ArrayList<>();
        int i = 0;
        String statusNamse = "";
        
        ArrayList<Object> idCol = DB_Copy.getDatas("Manager", "Manager_id");
        for (; i < idCol.size(); i++) {
            String str = "";
            str += DB_Copy.getDatas("Manager","Manager_id", i);
            str += "::";
            str += DB_Copy.getDatas("Manager","Lastname",i);
            str += "::";
            str += DB_Copy.getDatas("Manager","firtsName",i);
            str +="::";
            str += DB_Copy.getDatas("Manager", "Phone", i);
            str +="::";
            str += DB_Copy.getDatas("Manager", "Address", i);
            
            ArrayList<Object> status = DB_Copy.getDatas("status", "status_id");
            
            for(int s = 0; s<status.size(); s++){
            Object TstatusID = DB_Copy.getDatas("Manager", "status_id", i);
            ArrayList<Object> StatusName = DB_Copy.getDatas("status","status_name");
            if(TstatusID.equals(status.get(s))){
                statusNamse = (String) StatusName.get(s);
                }
            }
            str +="::";
            str += statusNamse;
            
            
            allProfile.add(str);
        }
        return allProfile;   
    }
    public static Object getManagerProfile(String first_name){
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> fNameColumn = DB_Copy.getDatas("Manager", "first_name");
        int i=0;
        for(; i< fNameColumn.size();i++){
            if(fNameColumn.get(i).equals(first_name)){
                profile.add(DB_Copy.getDatas("Manager", i));
                break;
            }
        }
        return profile;
    }
    
    public static Object managerLogin(String first_name){
        String acc_id = null;
        String man_id = null;
        String newProfile = "";
        ArrayList<Object> profile = new ArrayList<>();
        ArrayList<Object> nameCol = DB_Copy.getDatas("Account", "user_name");
        for(int i = 0; i<nameCol.size();i++){
            if(nameCol.get(i).equals(first_name)){
                acc_id = DB_Copy.getDatas("Account", "acc_id", i).toString();
                break;
            }
        }
        ArrayList<Object> acc_idCol = DB_Copy.getDatas("ManagerAcc", "Acc_id");
        for(int i=0; i < acc_idCol.size();i++){
            if(acc_idCol.get(i).toString().equals(acc_id)){
                man_id = DB_Copy.getDatas("ManagerAcc", "Manager_id", i).toString();
                break;
            }
        }
        ArrayList<Object> idCol= DB_Copy.getDatas("Manager", "Manager_id");
        for(int i = 0; i<idCol.size();i++){
            if(idCol.get(i).toString().equals(man_id)){
                profile = DB_Copy.getDatas("Manager", i);
                break;
            }
        }
        
        for (int b = 0; b < profile.size(); b++) {
            if ((b+1) == profile.size()) {
                newProfile += profile.get(b).toString();
            } else {
                newProfile += profile.get(b).toString() + "::";
            }
        }
        
        return newProfile;
    }
    
    public static Object managerGetAllStudents(){
        
        ObservableList<String> returnData = FXCollections.observableArrayList();
        
        ArrayList<Object> idCol = DB_Copy.getDatas("Student", "student_id");
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");
        ArrayList<Object> comCol = DB_Copy.getDatas("Student", "computer_num");
        
        ArrayList<Object> class_idCol = DB_Copy.getDatas("Student", "Class_id");
        ArrayList<Object> classCol = DB_Copy.getDatas("Class", "Class_id");
        ArrayList<Object> className = DB_Copy.getDatas("Class", "Class_name");
        
        String line = "";
        for (int i = 0; i < idCol.size(); i++) {
            Object class_name = "";
            for (int j = 0; j < classCol.size(); j++) {
                if (class_idCol.get(i).equals(classCol.get(j))) {
                    class_name = className.get(j);
                    break;
                }
            }
            line = idCol.get(i) + "::" + first_nameCol.get(i) + "::" + class_name + "::" + comCol.get(i);
            returnData.add(line);
        }
        
        return returnData;
    }
    
//    *******************************add****Adiyahuu************************add*******Adiyahuu***
    
    
    /*Тухайн багшийн хэрэглэгчийн нэрээр тухайн багшийн ордог ангийн бүх сурагчдийн нэр харагдна. */
    public static Object classStudents(String user_name) {

        ArrayList<Object> classStudents = new ArrayList<>();
        ArrayList<Object> TC_teacher_id = DB_Copy.getDatas("TeacherClass", "Teacher_id");
        ArrayList<Integer> tc_classids = new ArrayList<>();
        ArrayList<Object> userNames = DB_Copy.getDatas("Account", "user_name");

        int i = 0;
        int teacherID = 0;
        int TC_class_id = 0;
        int TC_classID = 0;
        int acc_id = 0;

        for (i = 0; i < userNames.size(); i++) {
            if (userNames.get(i).equals(user_name)) {
                acc_id = (int) DB_Copy.getDatas("Account", "acc_id", i);
                System.out.println("acc_id---> " + acc_id);
            }
        }

        ArrayList<Object> TA_acc_id = DB_Copy.getDatas("TeacherAcc", "Acc_id");

        for (i = 0; i < TA_acc_id.size(); i++) {
            if (TA_acc_id.get(i).equals(acc_id)) {
                teacherID = (int) DB_Copy.getDatas("TeacherAcc", "Teacher_id", i);
                System.out.println("teacher_id---> " + teacherID);
                break;
            }
        }

        for (i = 0; i < TC_teacher_id.size(); i++) {
            int TC_teacherID = (int) DB_Copy.getDatas("TeacherClass", "Teacher_id", i);
            TC_class_id = (int) DB_Copy.getDatas("TeacherClass", "Class_id", i);
            if (TC_teacherID == teacherID) {
                TC_classID = TC_class_id;
                tc_classids.add(TC_class_id);
                System.out.println("TC_class_id--->" + TC_classID);
            }
        }

        for (Integer tc_classid : tc_classids) {
            ArrayList<Object> firstnames = DB_Copy.getDatas("Student", "first_name");
            ArrayList<Object> ids = DB_Copy.getDatas("Student", "Class_id");
            for (int c = 0; c < ids.size(); c++) {
                if (ids.get(c).equals(tc_classid)) {
                    classStudents.add(firstnames.get(c));
                }
            }
        }

        return classStudents;
    }
    //----------------------------------------------------------------------------------------------------/
    /*Тухайн багшийн хэрэглэгчийн нэрээр тухайн багшийн ордог ангийн бүх сурагчдийн  нэр ирцийн дүн (нэрээр)
    он сар өдөр харагдна*/
    public static Object irtsAll(String username) {

        ObservableList<String> irts = FXCollections.observableArrayList();

        ArrayList<Object> classStudents = new ArrayList<>();
        ArrayList<Object> classStudentIrtsPoints = new ArrayList<>();
        ArrayList<Object> classStudentIrtsDate = new ArrayList<>();
        ArrayList<Object> TC_teacher_id = DB_Copy.getDatas("TeacherClass", "Teacher_id");
        ArrayList<Object> userNames = DB_Copy.getDatas("Account", "user_name");

        int i = 0;
        int teacherID = 0;
        int TC_class_id = 0;
        int TC_classID = 0;
        Object irtss = null;
        int acc_id = 0;

        for (i = 0; i < userNames.size(); i++) {
            if (userNames.get(i).equals(username)) {
                acc_id = (int) DB_Copy.getDatas("Account", "acc_id", i);
                System.out.println("acc_id---> " + acc_id);
            }
        }

        ArrayList<Object> TA_acc_id = DB_Copy.getDatas("TeacherAcc", "Acc_id");
        ArrayList<Integer> tc_classids = new ArrayList<>();

        for (i = 0; i < TA_acc_id.size(); i++) {
            if (TA_acc_id.get(i).equals(acc_id)) {
                teacherID = (int) DB_Copy.getDatas("TeacherAcc", "Teacher_id", i);
                System.out.println("teacher_id---> " + teacherID);
                break;
            }
        }

        for (i = 0; i < TC_teacher_id.size(); i++) {
            int TC_teacherID = (int) DB_Copy.getDatas("TeacherClass", "Teacher_id", i);
            TC_class_id = (int) DB_Copy.getDatas("TeacherClass", "Class_id", i);
            if (TC_teacherID == teacherID) {
                TC_classID = TC_class_id;
                tc_classids.add(TC_class_id);
                System.out.println("TC_class_id--->" + TC_classID);
            }
        }

        for (Integer tc_classid : tc_classids) {
            ArrayList<Object> firstnames = DB_Copy.getDatas("Student", "first_name");
            ArrayList<Object> ids = DB_Copy.getDatas("Student", "Class_id");
            for (int c = 0; c < ids.size(); c++) {
                if (ids.get(c).equals(tc_classid)) {
                    classStudents.add(firstnames.get(c));
                }
            }
        }

        ArrayList<Object> irts_onoonuud = DB_Copy.getDatas("Dun_Irts_Lavlah", "irts_onoo");

        for (i = 0; i < irts_onoonuud.size(); i++) {
            irtss = irts_onoonuud.get(i);
        }

        for (Integer tc_classid : tc_classids) {
            ArrayList<Object> attendance_points = DB_Copy.getDatas("Dun_Irts", "attendance_point");
            ArrayList<Object> ids = DB_Copy.getDatas("Student", "Class_id");
            for (int c = 0; c < ids.size(); c++) {
                if (ids.get(c).equals(tc_classid)) {
                    String ss = attendance_points.get(c).toString();
                    if ((int) attendance_points.get(c) == 0) {
                        ss = "Тасалсан";
                    }
                    if ((int) attendance_points.get(c) == 2) {
                        ss = "Өвчтэй/Чөлөөтэй";
                    }
                    if ((int) attendance_points.get(c) == 4) {
                        ss = "Хоцорсон";
                    }
                    if ((int) attendance_points.get(c) == 5) {
                        ss = "Ирсэн";
                    }

                    classStudentIrtsPoints.add(ss);
                }
            }
        }

        for (Integer tc_classid : tc_classids) {
            ArrayList<Object> studentIDs = DB_Copy.getDatas("Dun_Irts", "date");
            ArrayList<Object> ids = DB_Copy.getDatas("Student", "Class_id");
            for (int c = 0; c < ids.size(); c++) {
                if (ids.get(c).equals(tc_classid)) {
                    classStudentIrtsDate.add(studentIDs.get(c));
                }
            }
        }

        for (i = 0; i < classStudents.size(); i++) {
            String list = classStudents.get(i) + "::" + classStudentIrtsPoints.get(i) + "::" + classStudentIrtsDate.get(i);
            irts.add(list);
        }
        return irts;
    }
    //----------------------------------------------------------------------------------------------------/
    
    /*Тухайн багшийн хэрэглэгчийн нэрээр тухайн багшийн ордог ангийн бүх сурагчдийн  нэр идэвхийн дүн
    он сар өдөр харагдна*/

    public static Object idevhAll(String username) {
        ObservableList<String> idevh = FXCollections.observableArrayList();

        ArrayList<Object> classStudents = new ArrayList<>();
        ArrayList<Object> classStudentIrtsPoints = new ArrayList<>();
        ArrayList<Object> classStudentIrtsDate = new ArrayList<>();
        ArrayList<Object> TC_teacher_id = DB_Copy.getDatas("TeacherClass", "Teacher_id");
        ArrayList<Object> userNames = DB_Copy.getDatas("Account", "user_name");

        int i = 0;
        int teacherID = 0;
        int TC_class_id = 0;
        int TC_classID = 0;
        int acc_id = 0;

        for (i = 0; i < userNames.size(); i++) {
            if (userNames.get(i).equals(username)) {
                acc_id = (int) DB_Copy.getDatas("Account", "acc_id", i);
                System.out.println("acc_id---> " + acc_id);
            }
        }
        ArrayList<Object> TA_acc_id = DB_Copy.getDatas("TeacherAcc", "Acc_id");
        ArrayList<Integer> tc_classids = new ArrayList<>();

        for (i = 0; i < TA_acc_id.size(); i++) {
            if (TA_acc_id.get(i).equals(acc_id)) {
                teacherID = (int) DB_Copy.getDatas("TeacherAcc", "Teacher_id", i);
                System.out.println("teacher_id---> " + teacherID);
                break;
            }
        }

        for (i = 0; i < TC_teacher_id.size(); i++) {
            int TC_teacherID = (int) DB_Copy.getDatas("TeacherClass", "Teacher_id", i);
            TC_class_id = (int) DB_Copy.getDatas("TeacherClass", "Class_id", i);
            if (TC_teacherID == teacherID) {
                TC_classID = TC_class_id;
                tc_classids.add(TC_class_id);
                System.out.println("TC_class_id--->" + TC_classID);
            }
        }

        for (Integer tc_classid : tc_classids) {
            ArrayList<Object> firstnames = DB_Copy.getDatas("Student", "first_name");
            ArrayList<Object> ids = DB_Copy.getDatas("Student", "Class_id");
            for (int c = 0; c < ids.size(); c++) {
                if (ids.get(c).equals(tc_classid)) {
                    classStudents.add(firstnames.get(c));
                }
            }
        }

        for (Integer tc_classid : tc_classids) {
            ArrayList<Object> studentIDs = DB_Copy.getDatas("Dun_Idevh", "idevh_point");
            ArrayList<Object> ids = DB_Copy.getDatas("Student", "Class_id");
            for (int c = 0; c < ids.size(); c++) {
                if (ids.get(c).equals(tc_classid)) {
                    classStudentIrtsPoints.add(studentIDs.get(c));
                }
            }
        }

        for (Integer tc_classid : tc_classids) {
            ArrayList<Object> studentIDs = DB_Copy.getDatas("Dun_Idevh", "date");
            ArrayList<Object> ids = DB_Copy.getDatas("Student", "Class_id");
            for (int c = 0; c < ids.size(); c++) {
                if (ids.get(c).equals(tc_classid)) {
                    classStudentIrtsDate.add(studentIDs.get(c));
                }
            }
        }

        for (i = 0; i < classStudents.size(); i++) {
            String list = classStudents.get(i) + "::" + classStudentIrtsPoints.get(i) + "::" + classStudentIrtsDate.get(i);
            idevh.add(list);
        }
        return idevh;
    }
    
    


//    *******************************add****Adiyahuu************************add******Adiyahuu******
    
    // Тухайн нэвтэрсэн оюутан өөрийн профайлыг харах
    public static Object studentProfileFor(String user_name) {
        
        ArrayList<String> profile = new ArrayList<>();

        ArrayList<Object> student_idCol = DB_Copy.getDatas("Student", "student_id");
        ArrayList<Object> userNames = DB_Copy.getDatas("Account", "user_name");
        
        
        int i = 0;
        int acc_id = 0;
        int student_id = 0;
        
        for(i = 0; i<userNames.size(); i++){
            if (userNames.get(i).equals(user_name)){
                acc_id = (int)DB_Copy.getDatas("Account","acc_id", i);
            }
        }
        ArrayList<Object> SA_acc_id = DB_Copy.getDatas("StudentAcc", "Acc_id");
        
        for(i = 0; i<SA_acc_id.size(); i++){
            if(SA_acc_id.get(i).equals(acc_id)){
                student_id = (int)DB_Copy.getDatas("StudentAcc","Student_id",i);
            }
        }
        
        
        for (i = 0; i < student_idCol.size(); i++) {
            if (Integer.parseInt(student_idCol.get(i).toString()) == student_id) {

                Object ovog = DB_Copy.getDatas("Student", "last_name", i);
                Object ner = DB_Copy.getDatas("Student", "first_name", i);
                String ovogNer = ovog + "-ийн " + ner;

                ArrayList<Object> first_nameCol = DB_Copy.getDatas("Student", "first_name");

                profile.add(ovogNer);
                profile.add(DB_Copy.getDatas("Student", "student_id", i).toString());
                profile.add(DB_Copy.getDatas("Student", "phone", i).toString());
                profile.add(DB_Copy.getDatas("Student", "address", i).toString());
                profile.add(DB_Copy.getDatas("Student", "computer_num", i).toString());


                break;
            }

        }
        
        return profile;
    }
//    ***********************************************************************************
    public static Object managerGetAllTeachers() {
        ArrayList<String> returnData =  new ArrayList<>();
        ArrayList<Object> idCol = DB_Copy.getDatas("Teacher", "Teacher_id");
        ArrayList<Object> firstNameCol = DB_Copy.getDatas("Teacher", "first_name");
        ArrayList<Object> phoneNumCol = DB_Copy.getDatas("Teacher", "phone");

        ArrayList<Object> CT_teacher_id = DB_Copy.getDatas("TeacherClass", "Teacher_id");

        
        ArrayList<Object> teacherClass_id = new ArrayList<>();
        for (int i = 0; i < idCol.size(); i++) {
            for (int j = 0; j < CT_teacher_id.size(); j++) {
                if (CT_teacher_id.get(j).toString().equals(idCol.get(i).toString())) {
                    Object class_id = DB_Copy.getDatas("TeacherClass", "Class_id", j);
                    teacherClass_id.add(class_id);
                    System.out.println(">>> "+class_id);
                }
            }
        }
        
        ArrayList<Object> class_name = new ArrayList<>();
        ArrayList<Object> classClass_id = DB_Copy.getDatas("Class", "Class_id");
        for (int i = 0; i < teacherClass_id.size(); i++) {
            for (int j = 0; j < classClass_id.size(); j++) {
                if (teacherClass_id.get(i).toString().equals(classClass_id.get(j).toString())) {
                    class_name.add(DB_Copy.getDatas("Class", "Class_name", j));
                }
            }
        }

        String line = "";

        for (int i = 0; i < idCol.size(); i++) {
            line = idCol.get(i) + "::" + firstNameCol.get(i) + "::" + phoneNumCol.get(i) + "::" + class_name.get(i);
            returnData.add(line);
        }

        return returnData;
    }
    public static Object manGetTeacher(String first_name) {
        ObservableList<String> profile = FXCollections.observableArrayList();
        ArrayList<Object> aCol = DB_Copy.getDatas("Teacher","Teacher_id");
        ArrayList<Object> bCol = DB_Copy.getDatas("Teacher","last_name");
        ArrayList<Object> cCol = DB_Copy.getDatas("Teacher","first_name");
        ArrayList<Object> dCol = DB_Copy.getDatas("Teacher","phone");
        ArrayList<Object> eCol = DB_Copy.getDatas("Teacher","address");

        ArrayList<Object> class_idCol = DB_Copy.getDatas("TeacherClass", "Class_id");
        ArrayList<Object> classCol = DB_Copy.getDatas("Class", "Class_id");
        ArrayList<Object> className = DB_Copy.getDatas("Class", "Class_name");
        ArrayList<Object> classID = DB_Copy.getDatas("Class","Class_id");

        String line = "";
        ArrayList<Object> first_nameCol = DB_Copy.getDatas("Teacher", "first_name");
        int i = 0;
        for (; i < first_nameCol.size(); i++) {
            if (first_nameCol.get(i).equals(first_name)) {
                Object class_name = "";
                Object class_id ="";
                ArrayList<Object> class_ids = new ArrayList<>();
                ArrayList<Object> class_names = new ArrayList<>();
                for (int a = 0; a < class_idCol.size(); a++) {
                    if (class_idCol.get(a).equals(classCol.get(a))) {
                        class_name = className.get(a);
                        class_id = classID.get(a);
                        System.out.println(class_name);
                        System.out.println(class_id);
                        class_ids.add(class_id);
                        class_names.add(class_name);
                    }
                }
               
                    line = aCol.get(i) + "::" + bCol.get(i) + "::" + cCol.get(i) + "::" + dCol.get(i) + "::" + eCol.get(i) + "::"+class_ids.get(i)+"::" + class_names.get(i);
                    profile.add(line);
                
                
                break;
            }
        }
        return profile;
    }
    public static Object managerGetStudent(String first_name){
        ObservableList<String> profile = FXCollections.observableArrayList();
        String line = "";
        ArrayList<Object> firstNameCol = DB_Copy.getDatas("Student", "first_name");
        ArrayList<Object> lastNameCol = DB_Copy.getDatas("Student", "last_name");
        ArrayList<Object> idCol = DB_Copy.getDatas("Student", "student_id");
        ArrayList<Object> phoneCol = DB_Copy.getDatas("Student", "phone");
        ArrayList<Object> addressCol = DB_Copy.getDatas("Student", "address");
        ArrayList<Object> class_idCol = DB_Copy.getDatas("Student", "Class_id");
        ArrayList<Object> classClass_idCol = DB_Copy.getDatas("Class", "Class_id");
        ArrayList<Object> classClassNameCol = DB_Copy.getDatas("Class", "Class_name");
        int i = 0;
        String id=null;
        
        for(i=0; i< firstNameCol.size();i++){
            if(firstNameCol.get(i).toString().equals(first_name)){
                id = idCol.get(i).toString();
                line = idCol.get(i).toString()+"::"+lastNameCol.get(i).toString()+"::"+firstNameCol.get(i).toString()+"::"
                        +phoneCol.get(i).toString()+"::"+addressCol.get(i).toString()+"::"+class_idCol.get(i).toString()+"";
            }
        }
        
        for(int j = 0; j < classClass_idCol.size();j++){
            if(classClass_idCol.get(j).toString().equals(id)){
                line +="::"+classClassNameCol.get(j).toString();
            }
        }
        profile.add(line);
    return profile;
    }
    
    public static Object adminGetAllTeacher() {

        ArrayList<Object> allProfile = new ArrayList<>();
        int i = 0;
        String statusNamse = "";
        
        ArrayList<Object> idCol = DB_Copy.getDatas("Teacher", "Teacher_id");
        for (; i < idCol.size(); i++) {
            String str = "";
            str += DB_Copy.getDatas("Teacher","Teacher_id", i);
            str += "::";
            str += DB_Copy.getDatas("Teacher","last_name",i);
            str += "::";
            str += DB_Copy.getDatas("Teacher","first_name",i);
            str +="::";
            str += DB_Copy.getDatas("Teacher", "phone", i);
            str +="::";
            str += DB_Copy.getDatas("Teacher", "address", i);
            
            ArrayList<Object> status = DB_Copy.getDatas("status", "status_id");
            
            for(int s = 0; s<status.size(); s++){
            Object TstatusID = DB_Copy.getDatas("Teacher", "status_id", i);
            ArrayList<Object> StatusName = DB_Copy.getDatas("status","status_name");
            if(TstatusID.equals(status.get(s))){
                statusNamse = (String) StatusName.get(s);
                }
            }
            str +="::";
            str += statusNamse;
            
            
            allProfile.add(str);
        }
        return allProfile;
    }
    public static Object adminGetTeacher(String first_name){
        ArrayList<String> returnData=new ArrayList<>();
        String line ="";
        ArrayList<Object> idCol = DB_Copy.getDatas("Teacher", "Teacher_id");
        ArrayList<Object> lastNameCol = DB_Copy.getDatas("Teacher", "last_name");
        ArrayList<Object> firstNameCol = DB_Copy.getDatas("Teacher", "first_name");
        ArrayList<Object> phoneCol = DB_Copy.getDatas("Teacher", "phone");
        ArrayList<Object> addressCol = DB_Copy.getDatas("Teacher", "address");
        
        int i = 0;
        Object teacher_id = null;
        int class_id = 0;
        
        for(; i<idCol.size();i++){
            if(firstNameCol.get(i).equals(first_name)){
                teacher_id = idCol.get(i);
                System.out.println("Teacher ID>>>"+teacher_id);
                break;
            }
        }
        ArrayList<Object> teacher_idCol = DB_Copy.getDatas("TeacherClass", "Teacher_id");
        ArrayList<Object> class_idCol = DB_Copy.getDatas("TeacherClass", "Class_id");
        
        
        for(i= 0;i<teacher_idCol.size();i++){
            System.out.println(teacher_idCol.get(i));
            if(teacher_idCol.get(i).toString().equals(teacher_id.toString())){
                class_id = (int)class_idCol.get(i);
                System.out.println("Class_id>>>"+class_id);
                break;
            }
        }
        
        ArrayList<Object> class_nameCol= DB_Copy.getDatas("Class", "Class_name");
        for(; i<idCol.size();i++){
            if(firstNameCol.get(i).equals(first_name)){
                line += idCol.get(i)+"::"+lastNameCol.get(i)+"::"+firstNameCol.get(i)+"::"+phoneCol.get(i)+"::"+addressCol.get(i)+"::"+class_nameCol.get(class_id-1);
            }
        }
        returnData.add(line);
        return returnData;
    }
    public static Object adminGetStudent(String first_name){
        String profile = "";
        ArrayList<Object>  idCol= DB_Copy.getDatas("Student", "student_id");
        ArrayList<Object> lastNameCol = DB_Copy.getDatas("student", "last_name");
        ArrayList<Object> firstNameCol = DB_Copy.getDatas("Student", "first_name");
        ArrayList<Object> phoneCol = DB_Copy.getDatas("Student", "phone");
        ArrayList<Object> addressCol = DB_Copy.getDatas("Student", "address");
        ArrayList<Object> comCol = DB_Copy.getDatas("Student", "computer_num");
        ArrayList<Object> class_idCol = DB_Copy.getDatas("Student", "Class_id");
        ArrayList<Object> class_class_idCol = DB_Copy.getDatas("Class", "Class_id");
        
        ArrayList<Object> status_idCol = DB_Copy.getDatas("Student", "status_id");
        ArrayList<Object> status_status_idCol = DB_Copy.getDatas("Status", "status_id");
        
        int i = 0;
        String class_name = "";
        String status_name = "";
        for(i=0;i<firstNameCol.size();i++){
            if(firstNameCol.get(i).toString().equals(first_name)){
                for(int j = 0;j < class_class_idCol.size();j++){
                    if(class_class_idCol.get(j).equals(class_idCol.get(i))){
                        class_name = DB_Copy.getDatas("Class", "class_name", j).toString();
                    }
                }
                for(int j = 0;j < status_status_idCol.size();j++){
                    if(status_status_idCol.get(j).equals(status_idCol.get(i))){
                        status_name = DB_Copy.getDatas("Status", "status_name", j).toString();
                    }
                }
                profile += idCol.get(i).toString()+"::"+lastNameCol.get(i)+"::"+firstNameCol.get(i)+"::"+phoneCol.get(i)+"::"+addressCol.get(i)+"::"+comCol.get(i)+"::"+class_name+"::"+status_name;
            }
        }
        
        return profile;
    }
      public static Object adminGetAllStudents(){
       ArrayList<Object> allProfile = new ArrayList<>();
        int i = 0;
        String statusNamse = "";
        String classNamse = "";
        
        ArrayList<Object> idCol = DB_Copy.getDatas("Student", "Student_id");
        for (; i < idCol.size(); i++) {
            String str = "";
            str += DB_Copy.getDatas("Student","Student_id", i);
            str += "::";
            str += DB_Copy.getDatas("Student","last_name",i);
            str += "::";
            str += DB_Copy.getDatas("Student","first_name",i);
            str +="::";
            str += DB_Copy.getDatas("Student", "phone", i);
            str +="::";
            str += DB_Copy.getDatas("Student", "address", i);
            str +="::";
            str += DB_Copy.getDatas("Student","computer_num", i);
            
             ArrayList<Object> classs = DB_Copy.getDatas("Class", "Class_id");
            
            for(int s = 0; s<classs.size(); s++){
            Object TstatusID = DB_Copy.getDatas("Student", "Class_id", i);
            ArrayList<Object> classNames = DB_Copy.getDatas("Class","Class_type");
            if(TstatusID.equals(classs.get(s))){
                classNamse = (String) classNames.get(s);
                }
            }
            
                    
            ArrayList<Object> status = DB_Copy.getDatas("status", "status_id");
            
            for(int s = 0; s<status.size(); s++){
            Object TstatusID = DB_Copy.getDatas("Student", "status_id", i);
            ArrayList<Object> StatusName = DB_Copy.getDatas("status","status_name");
            if(TstatusID.equals(status.get(s))){
                statusNamse = (String) StatusName.get(s);
                }
            }
            str +="::";
            str += classNamse;
            
            str +="::";
            str += statusNamse;
            
            
            allProfile.add(str);
        }
        return allProfile;
    }
      public static Object getSubjectNames(){
        ArrayList<Object> subNames = new ArrayList<>();
        String line = "";
        ArrayList<Object> subNameCol = DB_Copy.getDatas("Subject", "subject_name");
        int i = 0;
        
        for(;i<subNameCol.size();i++){
            subNames.add(subNameCol.get(i));
        }
        return subNames;
    }
      public static Object studentGradeTest(String user_name) {
        

        ArrayList<Object> userNames = DB_Copy.getDatas("Account", "user_name");


        Object acc_id = 0;
        int student_id = 0;

        for (int z = 0; z <userNames.size(); z++) {
            if (userNames.get(z).equals(user_name)) {
                acc_id = DB_Copy.getDatas("Account", "acc_id", z);
                System.out.println("Account acc_id-->" + acc_id);
            }
        }
        ArrayList<Object> SA_acc_id = DB_Copy.getDatas("StudentAcc", "Acc_id");

        for (int z = 0; z < SA_acc_id.size(); z++) {
            if (SA_acc_id.get(z).equals(acc_id)) {
                student_id = (int)DB_Copy.getDatas("StudentAcc", "Student_id", z);
                System.out.println("StuAcc student_id-->" + student_id);
            }
        }
        

        ArrayList<Object> profile = new ArrayList<>();

        ArrayList<Object> student_class_id = DB_Copy.getDatas("Student", "Class_id");
        ArrayList<Object> student_student_id = DB_Copy.getDatas("Student", "Student_id");
        String class_id = "";
        for (int index = 0; index < student_student_id.size(); index++) {
            if (Integer.parseInt(student_student_id.get(index).toString())==(student_id)) {

                class_id = student_class_id.get(index).toString();
                break;
            }
        }
        //---------------------------------------------------------1

        ArrayList<Object> subjectTypeClass_class_id = DB_Copy.getDatas("Subject_typeClass", "class_id");
        ArrayList<Object> subjectTypeClass_type = DB_Copy.getDatas("Subject_typeClass", "subject_type_id");

        ArrayList<Object> type = new ArrayList<>();
        for (int index = 0; index < subjectTypeClass_class_id.size(); index++) {
            if (subjectTypeClass_class_id.get(index).toString().equals(class_id)) {

                type.add(subjectTypeClass_type.get(index).toString());

            }
        }
        //---------------------------------------------------------2

        ArrayList<Object> typeName = new ArrayList<>();
        ArrayList<Object> subjectType_id = DB_Copy.getDatas("Subject_Type", "subject_type_id");
        ArrayList<Object> subjectType_type = DB_Copy.getDatas("Subject_Type", "type");
        ArrayList<Object> attendancePoints = new ArrayList<>();
        ArrayList<Object> activityPoints = new ArrayList<>();
        ArrayList<Object> biyDaalt_subjectIds = new ArrayList<>();
        ArrayList<Object> taskIds = new ArrayList<>();
        ArrayList<Object> homeworkIds = new ArrayList<>();
        ArrayList<Object> examIds = new ArrayList<>();
        
        ArrayList<Object> taskPointList = new ArrayList<>();

        ArrayList<Object> homeworkPointList = new ArrayList<>();
        ArrayList<Object> examPointList = new ArrayList<>();
        ArrayList<Object> totalPointList = new ArrayList<>();
        
        for (int i = 0; i < type.size(); i++) {
            for (int index = 0; index < subjectType_id.size(); index++) {

                if (subjectType_id.get(index).toString().equals(type.get(i).toString())) {

                    typeName.add(subjectType_type.get(index).toString());
                    break;
                }
            }
            
            
            
            //-----------------------------------3
            ArrayList<Object> dunIrts_studentId = DB_Copy.getDatas("Dun_Irts", "student_id");
            ArrayList<Object> dunIrts_subjectTypeId = DB_Copy.getDatas("Dun_Irts", "subject_type_id");
            ArrayList<Object> allAttendancePoints = DB_Copy.getDatas("Dun_Irts", "attendance_point");

            for (int index = 0; index < dunIrts_studentId.size(); index++) {
                if (Integer.parseInt(dunIrts_studentId.get(index).toString())==(student_id) && dunIrts_subjectTypeId.get(index).toString().equals(type.get(i).toString())) {
                    attendancePoints.add(allAttendancePoints.get(index).toString());
                }
            }
            //------------------------------------4

            ArrayList<Object> dunIdevh_studentId = DB_Copy.getDatas("Dun_Idevh", "student_id");
            ArrayList<Object> dunIdevh_subjectTypeId = DB_Copy.getDatas("Dun_Idevh", "subject_type_id");
            ArrayList<Object> allActivityPoints = DB_Copy.getDatas("Dun_Idevh", "idevh_point");

            for (int index = 0; index < dunIdevh_studentId.size(); index++) {

                if (Integer.parseInt(dunIdevh_studentId.get(index).toString())==(student_id) && dunIdevh_subjectTypeId.get(index).toString().equals(type.get(i).toString())) {
                    activityPoints.add(allActivityPoints.get(index).toString());
                }
            }
            //----------------------------------------------------------5

            ArrayList<Object> subject_subjectTypeId = DB_Copy.getDatas("Subject", "subject_type_id");
            ArrayList<Object> subject_subject_id = DB_Copy.getDatas("Subject", "subject_id");
            ArrayList<Object> hicheel = new ArrayList<>();
            ArrayList<Object> subject_type_type = DB_Copy.getDatas("Subject_Type", "type");


            for (int index = 0; index < subject_subjectTypeId.size(); index++) {
                if (subject_subjectTypeId.get(index).toString().equals(type.get(i))) {
                    hicheel.add(subject_subject_id.get(index));
                }
            }

            biyDaalt_subjectIds.add(hicheel);
            //--------------------------------------------------6
            ArrayList<Object> bagtsal = new ArrayList<>();
            for (int y = 0; y < hicheel.size(); y++) {

                ArrayList<Object> taskName_subjectId = DB_Copy.getDatas("Task_NAME", "Subject_id");
                ArrayList<Object> taskName_taskId = DB_Copy.getDatas("Task_NAME", "Task_ID");

                ArrayList<Object> hicheelList = new ArrayList<>();
                ArrayList<Object> taskIdSep = new ArrayList<>();

                hicheelList = (ArrayList<Object>) biyDaalt_subjectIds.get(i);

                for (int index = 0; index < taskName_subjectId.size(); index++) {
                    if (taskName_subjectId.get(index).toString().equals(hicheelList.get(y).toString())) {
                        taskIdSep.add(taskName_taskId.get(index));
                    }

                }
                bagtsal.add(taskIdSep);

            }
            taskIds.add(bagtsal);
            //--------------------------------------------------7
            
            ArrayList<Object> sums = new ArrayList<>();
            int avg123456789 = 0;
            for (Object first : taskIds) {
                sums = new ArrayList<>();
                avg123456789 = 0;
                for (Object second : (ArrayList<Object>) first) {

                    int sum = 0;
                    for (Object task_index : (ArrayList<Object>) second) {

                        ArrayList<Object> dunBiyDaalt_taskId = DB_Copy.getDatas("Dun_Biedaalt", "Task_ID");
                        ArrayList<Object> dunBiyDaalt_taskPoint = DB_Copy.getDatas("Dun_Biedaalt", "Task_POINT");
                        ArrayList<Object> dunBiyDaalt_student_id = DB_Copy.getDatas("Dun_Biedaalt", "Student_id");
                        for (int index = 0; index < dunBiyDaalt_taskId.size(); index++) {
                            if ((task_index.toString().equals(dunBiyDaalt_taskId.get(index).toString())) && (Integer.parseInt(dunBiyDaalt_student_id.get(index).toString())==(student_id))) {
                                int t = Integer.parseInt(dunBiyDaalt_taskPoint.get(index).toString());
                                sum += t;
                            }
                        }
                    }
                    sums.add(sum);
                }
                
                int total = 0;
                int count = 0;
                for (Object num : sums) {
                    
                    int number = Integer.parseInt(num.toString());
                    total += number;
                    count++;
                }
                avg123456789 = total / count;
                
            }
            taskPointList.add(avg123456789);
            //----------------------------------------------------
            
            ArrayList<Object> bagtsalDaalgavar = new ArrayList<>();
            for (int y = 0; y < hicheel.size(); y++) {

                ArrayList<Object> daalgavar_subjectId = DB_Copy.getDatas("Daalgavar", "Subject_id");
                ArrayList<Object> daalgavar_taskId = DB_Copy.getDatas("Daalgavar", "Homework_id");

                ArrayList<Object> hicheelList = new ArrayList<>();
                ArrayList<Object> homeworkIdSep = new ArrayList<>();

                hicheelList = (ArrayList<Object>) biyDaalt_subjectIds.get(i);

                for (int index = 0; index < daalgavar_subjectId.size(); index++) {
                    if (daalgavar_subjectId.get(index).toString().equals(hicheelList.get(y).toString())) {
                        homeworkIdSep.add(daalgavar_taskId.get(index));
                    }

                }
                bagtsalDaalgavar.add(homeworkIdSep);

            }
            homeworkIds.add(bagtsalDaalgavar);
            
            //----------------------------------------------------
            
            ArrayList<Object> sums2 = new ArrayList<>();
            
            ArrayList<Object> dunDaalgavar_homeworkId = DB_Copy.getDatas("Dun_Daalgavar", "Homework_id");
            ArrayList<Object> dunDaalgavar_homeworkPoint = DB_Copy.getDatas("Dun_Daalgavar", "Homework_Point");
            ArrayList<Object> dunDaalgavar_student_id = DB_Copy.getDatas("Dun_Daalgavar", "Student_id");
            
            int avg12345 = 0;
            for (Object first : homeworkIds) {
                sums2 = new ArrayList<>();
                avg12345 = 0;
                for (Object second : (ArrayList<Object>) first) {

                    int sum2 = 0;
                    
                    
                    for (Object homework_index : (ArrayList<Object>) second) {

                        
                        for ( int index = 0; index < dunDaalgavar_homeworkId.size(); index++) {
                            
                            if ((homework_index.toString().equals(dunDaalgavar_homeworkId.get(index).toString())) && (Integer.parseInt(dunDaalgavar_student_id.get(index).toString())==(student_id))) {
                                int t = Integer.parseInt(dunDaalgavar_homeworkPoint.get(index).toString());
                                sum2 += t;
                            }
                            
                        }

                    }
                    sums2.add(sum2);
                }
                
                int total = 0;
                int count = 0;
                for (Object num2 : sums2) {
                    
                    int number = Integer.parseInt(num2.toString());
                    total += number;
                    count++;
                }
                avg12345 = total / count;
                
            }
            homeworkPointList.add(avg12345);
                
            
            
            //---------------------------------------------------------------------------------->
            
            ArrayList<Object> bagtsalExam = new ArrayList<>();
            for (int y = 0; y < hicheel.size(); y++) {

                ArrayList<Object> shalgalt_subjectId = DB_Copy.getDatas("Shalgalt", "Subject_id");
                ArrayList<Object> shalgalt_examId = DB_Copy.getDatas("Shalgalt", "Exam_ID");

                ArrayList<Object> hicheelList = new ArrayList<>();
                ArrayList<Object> examIdSep = new ArrayList<>();

                hicheelList = (ArrayList<Object>) biyDaalt_subjectIds.get(i);

                for (int index = 0; index < shalgalt_subjectId.size(); index++) {
                    if (shalgalt_subjectId.get(index).toString().equals(hicheelList.get(y).toString())) {
                        examIdSep.add(shalgalt_examId.get(index));
                    }

                }
                bagtsalExam.add(examIdSep);

            }
            examIds.add(bagtsalExam);
            
            //----------------------------------------------------
            
            ArrayList<Object> sums3 = new ArrayList<>();
            
            ArrayList<Object> dunShalgalt_examId = DB_Copy.getDatas("Dun_Shalgalt", "Exam_ID");
            ArrayList<Object> dunShalgalt_examPoint = DB_Copy.getDatas("Dun_Shalgalt", "Exam_Point");
            ArrayList<Object> dunShalgalt_student_id = DB_Copy.getDatas("Dun_Shalgalt", "Student_id");
          
            int avg123 = 0;
            for (Object first : examIds) {
                sums3 = new ArrayList<>();
                avg123 = 0;
                for (Object second : (ArrayList<Object>) first) {

                    int sum3 = 0;
                    for (Object exam_index : (ArrayList<Object>) second) {
                        for ( int index = 0; index < dunShalgalt_examId.size(); index++) {
                            if ((exam_index.toString().equals(dunShalgalt_examId.get(index).toString())) && (Integer.parseInt(dunShalgalt_student_id.get(index).toString())==(student_id))) {
                                int t = Integer.parseInt(dunShalgalt_examPoint.get(index).toString());
                                sum3 += t;
                            }
                        }
                    }
                    sums3.add(sum3);
                }
                
                int total = 0;
                int count = 0;
                for (Object num3 : sums3) {
                    int number = Integer.parseInt(num3.toString());
                    total += number;
                    count++;
                }
                avg123 = total / count;
                
            }
            examPointList.add(avg123);
        }
        
        for(int index = 0; index<2; index++){
        

                     
 //            totalPointList.add(total);
            Object subListExam = examPointList.get(index);
            Object subListTask = taskPointList.get(index);
            Object subListHomework = homeworkPointList.get(index);
            
            int subAttendance = Integer.parseInt(attendancePoints.get(index).toString());
            int subActivity = Integer.parseInt(activityPoints.get(index).toString());
            int subListExamInt = Integer.parseInt(subListExam.toString());
            int subListTaskInt = Integer.parseInt(subListTask.toString());
            int subListHomeworkInt = Integer.parseInt(subListHomework.toString());
            
            double total = subAttendance*0.2 + subActivity*0.3 +subListExamInt*0.25 + (subListTaskInt + subListHomeworkInt)*0.25;
                System.out.println("total"+ total);
                totalPointList.add(total);
        }
        
        
        ArrayList<Object> result = new ArrayList<>();
        ArrayList<Object> separated; 
        

//        profile.add(class_id);
//        profile.add(type);
        profile.add(typeName);
        profile.add(attendancePoints);
        profile.add(activityPoints);
//        profile.add(biyDaalt_subjectIds);
//        profile.add(taskIds);
        profile.add(taskPointList);
//        profile.add(homeworkIds);
        profile.add(homeworkPointList);
//        profile.add(examIds);
        profile.add(examPointList);
        profile.add(totalPointList);
        
        
        for (int si = 0; si < ((ArrayList<Object>) profile.get(0)).size(); si++) {
            String row_str = "";
            for (int row = 0; row < profile.size(); row++) {
                row_str += ((ArrayList<Object>) profile.get(row)).get(si);
                if ((row+1) != profile.size()) {
                    row_str += "||";
                }
            }
            result.add(row_str);
        }

        return result;
    }
      
      //Тухайн оюутан өөрийн ангийн дүнгийн жагсаалтыг харах
    public static Object studentGradePlace(String user_name) {
        
        
        ArrayList<Object> userNames = DB_Copy.getDatas("Account", "user_name");


        Object acc_id = 0;
        int student_id = 0;

        for (int z = 0; z <userNames.size(); z++) {
            if (userNames.get(z).equals(user_name)) {
                acc_id = DB_Copy.getDatas("Account", "acc_id", z);
            }
        }
        ArrayList<Object> SA_acc_id = DB_Copy.getDatas("StudentAcc", "Acc_id");

        for (int z = 0; z < SA_acc_id.size(); z++) {
            if (SA_acc_id.get(z).equals(acc_id)) {
                student_id = (int)DB_Copy.getDatas("StudentAcc", "Student_id", z);
            }
        }
        
        ArrayList<ArrayList<Object>> profile = new ArrayList<>();
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> students_Grade = new ArrayList<>();

        ArrayList<Object> student_class_id = DB_Copy.getDatas("Student", "Class_id");
        ArrayList<Object> student_student_id = DB_Copy.getDatas("Student", "Student_id");
        ArrayList<Object> student_ovog = DB_Copy.getDatas("Student", "last_name");
        ArrayList<Object> student_ner = DB_Copy.getDatas("Student", "first_name");
        
        String class_id = "";
        for (int index = 0; index < student_student_id.size(); index++) {
            if (Integer.parseInt(student_student_id.get(index).toString())==(student_id)) {
                class_id = student_class_id.get(index).toString();
                break;
            }
        }

        ArrayList<Object> students_of_class = new ArrayList<>();
        ArrayList<Object> student_firstName = new ArrayList<>();
        ArrayList<Object> student_lastName = new ArrayList<>();
        
        for (int index = 0; index < student_student_id.size(); index++) {
            if (student_class_id.get(index).toString().equals(class_id)) {
                students_of_class.add(student_student_id.get(index));
                student_firstName.add(student_ner.get(index));
                student_lastName.add(student_ovog.get(index));
            }
        }
        
        ArrayList<Object> studentAcc_acc_id = DB_Copy.getDatas("StudentAcc", "Acc_id");
        ArrayList<Object> studentAcc_student_id = DB_Copy.getDatas("StudentAcc", "Student_id");
        ArrayList<Object> account_id = new ArrayList<>();
        ArrayList<Object> account_accId = DB_Copy.getDatas("Account", "acc_id");
        ArrayList<Object> account_userName = DB_Copy.getDatas("Account", "user_name");
        ArrayList<Object> studentUsername = new ArrayList<>();
        
        for(int x = 0; x<students_of_class.size(); x++){
            
            for(int a = 0; a<studentAcc_acc_id.size(); a++){
                if(studentAcc_student_id.get(a).equals(students_of_class.get(x)))
                    account_id.add(studentAcc_acc_id.get(a));
            }

            int id = Integer.parseInt(students_of_class.get(x).toString());
      
            for(int u=0; u<account_accId.size(); u++){
                if(account_accId.get(u).equals(account_id.get(x)))
                    studentUsername.add(account_userName.get(u));
            }
            
                
        }
        for(int st=0; st<studentUsername.size(); st++){
            students_Grade.add(studentGradeTestForPlace(studentUsername.get(st).toString()));

            }
        
        ArrayList<Object> dunguud = new ArrayList<>();
        ArrayList turList = new ArrayList<>();
        ArrayList<Object> realList = new ArrayList<>();
        String turElement = "";
        for(int v = 0; v<students_Grade.size(); v++){
         
            for(int l=0; l<((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).size(); l++){
                dunguud.add((((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).get(l).toString()));
            }
            double sum = 0;
                    int count = 0;
            
            for(int l=0; l<((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).size(); l++){
                   sum += (double)((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).get(l);
                   count++;
            }
           double avera = sum/count;
	   String averag = String.format("%.2f", avera);
           Object nerDun = "";
           nerDun =  averag +" "+ student_lastName.get(v).toString() + "-ийн" + " " + student_firstName.get(v).toString();
           turList.add(nerDun);
                    
        }
        ArrayList<Object> ll = new ArrayList<>();
        ll.add(((ArrayList<Object>)students_Grade.get(0)).get(0).toString());
        
        list.add(class_id);
        list.add(students_of_class);
//        profile.add(list);
//        profile.add(account_id);
//        profile.add(studentUsername);
//        //profile.add(ll);
//        profile.add(dunguud);
        Collections.sort(turList);
        for(int r = turList.size()-1; r>=0; r--){
            realList.add(turList.get(r));
        }
        profile.add(realList);
        return realList;
    }



    
    //Бусад ангийн оюутнуудын дүнгийн жагсаалтыг харах
    public static Object otherClassGradePlace(String class_id) {
        

        ArrayList<ArrayList<Object>> profile = new ArrayList<>();
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> students_Grade = new ArrayList<>();

        ArrayList<Object> student_class_id = DB_Copy.getDatas("Student", "Class_id");
        ArrayList<Object> student_student_id = DB_Copy.getDatas("Student", "Student_id");
        ArrayList<Object> student_ovog = DB_Copy.getDatas("Student", "last_name");
        ArrayList<Object> student_ner = DB_Copy.getDatas("Student", "first_name");


        ArrayList<Object> students_of_class = new ArrayList<>();
        ArrayList<Object> student_firstName = new ArrayList<>();
        ArrayList<Object> student_lastName = new ArrayList<>();
        
        for (int index = 0; index < student_student_id.size(); index++) {
            if (student_class_id.get(index).toString().equals(class_id)) {
                students_of_class.add(student_student_id.get(index));
                student_firstName.add(student_ner.get(index));
                student_lastName.add(student_ovog.get(index));
            }
        }
        
        ArrayList<Object> studentAcc_acc_id = DB_Copy.getDatas("StudentAcc", "Acc_id");
        ArrayList<Object> studentAcc_student_id = DB_Copy.getDatas("StudentAcc", "Student_id");
        ArrayList<Object> account_id = new ArrayList<>();
        ArrayList<Object> account_accId = DB_Copy.getDatas("Account", "acc_id");
        ArrayList<Object> account_userName = DB_Copy.getDatas("Account", "user_name");
        ArrayList<Object> studentUsername = new ArrayList<>();
        
        for(int x = 0; x<students_of_class.size(); x++){
            
            for(int a = 0; a<studentAcc_acc_id.size(); a++){
                if(studentAcc_student_id.get(a).equals(students_of_class.get(x)))
                    account_id.add(studentAcc_acc_id.get(a));
            }

            int id = Integer.parseInt(students_of_class.get(x).toString());
      
            for(int u=0; u<account_accId.size(); u++){
                if(account_accId.get(u).equals(account_id.get(x)))
                    studentUsername.add(account_userName.get(u));
            }
            
                
        }
        for(int st=0; st<studentUsername.size(); st++){
            students_Grade.add(studentGradeTestForPlace(studentUsername.get(st).toString()));

            }
        
        ArrayList<Object> dunguud = new ArrayList<>();
        ArrayList turList = new ArrayList<>();
        ArrayList<Object> realList = new ArrayList<>();
        String turElement = "";
        for(int v = 0; v<students_Grade.size(); v++){
         
            for(int l=0; l<((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).size(); l++){
                dunguud.add((((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).get(l).toString()));
            }
            double sum = 0;
                    int count = 0;
            
            for(int l=0; l<((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).size(); l++){
                   sum += (double)((ArrayList<Object>) ((ArrayList<Object>) students_Grade.get(v)).get(1)).get(l);
                   count++;
            }
           double avera = sum/count;
	   String averag = String.format("%.2f", avera);
           String nerDun = "";
           nerDun = averag +" "+ student_lastName.get(v).toString()+"-ийн " + student_firstName.get(v).toString() ;
           turList.add(nerDun);
        }
        
            list.add(class_id);
            list.add(students_of_class);
//            profile.add(list);
//            profile.add(account_id);
//            profile.add(studentUsername);
//            profile.add(dunguud); 
            Collections.sort(turList);
            for(int r = turList.size()-1; r>=0; r--){
                realList.add(turList.get(r));
            }
            profile.add(realList);
            return realList;
    }





    //ангийн дүнгийн жагсаалтад зориулсан туслах функц
         public static Object studentGradeTestForPlace(String user_name) {
        

        ArrayList<Object> userNames = DB_Copy.getDatas("Account", "user_name");


        Object acc_id = null;
        int student_id = 0;

        for (int z = 0; z <userNames.size(); z++) {
            if (userNames.get(z).equals(user_name)) {
                acc_id = DB_Copy.getDatas("Account", "acc_id", z);
                //System.out.println("Account acc_id-->" + acc_id);
            }
        }
        ArrayList<Object> SA_acc_id = DB_Copy.getDatas("StudentAcc", "Acc_id");

        for (int z = 0; z < SA_acc_id.size(); z++) {
            if (SA_acc_id.get(z).equals(acc_id)) {
                student_id = (int)DB_Copy.getDatas("StudentAcc", "Student_id", z);
                //System.out.println("StuAcc student_id-->" + student_id);
            }
        }
        

        ArrayList<Object> profile = new ArrayList<>();

        ArrayList<Object> student_class_id = DB_Copy.getDatas("Student", "Class_id");
        ArrayList<Object> student_student_id = DB_Copy.getDatas("Student", "Student_id");
        String class_id = "";
        for (int index = 0; index < student_student_id.size(); index++) {
            if (Integer.parseInt(student_student_id.get(index).toString())==(student_id)) {

                class_id = student_class_id.get(index).toString();
                break;
            }
        }
        //---------------------------------------------------------1

        ArrayList<Object> subjectTypeClass_class_id = DB_Copy.getDatas("Subject_typeClass", "class_id");
        ArrayList<Object> subjectTypeClass_type = DB_Copy.getDatas("Subject_typeClass", "subject_type_id");

        ArrayList<Object> type = new ArrayList<>();
        for (int index = 0; index < subjectTypeClass_class_id.size(); index++) {
            if (subjectTypeClass_class_id.get(index).toString().equals(class_id)) {

                type.add(subjectTypeClass_type.get(index).toString());

            }
        }
        //---------------------------------------------------------2

        ArrayList<Object> typeName = new ArrayList<>();
        ArrayList<Object> subjectType_id = DB_Copy.getDatas("Subject_Type", "subject_type_id");
        ArrayList<Object> subjectType_type = DB_Copy.getDatas("Subject_Type", "type");
        ArrayList<Object> attendancePoints = new ArrayList<>();
        ArrayList<Object> activityPoints = new ArrayList<>();
        ArrayList<Object> biyDaalt_subjectIds = new ArrayList<>();
        ArrayList<Object> taskIds = new ArrayList<>();
        ArrayList<Object> homeworkIds = new ArrayList<>();
        ArrayList<Object> examIds = new ArrayList<>();
        
        ArrayList<Object> taskPointList = new ArrayList<>();

        ArrayList<Object> homeworkPointList = new ArrayList<>();
        ArrayList<Object> examPointList = new ArrayList<>();
        ArrayList<Object> totalPointList = new ArrayList<>();
        
        for (int i = 0; i < type.size(); i++) {
            for (int index = 0; index < subjectType_id.size(); index++) {

                if (subjectType_id.get(index).toString().equals(type.get(i).toString())) {

                    typeName.add(subjectType_type.get(index).toString());
                    break;
                }
            }
            
            
            
            //-----------------------------------3
            ArrayList<Object> dunIrts_studentId = DB_Copy.getDatas("Dun_Irts", "student_id");
            ArrayList<Object> dunIrts_subjectTypeId = DB_Copy.getDatas("Dun_Irts", "subject_type_id");
            ArrayList<Object> allAttendancePoints = DB_Copy.getDatas("Dun_Irts", "attendance_point");

            for (int index = 0; index < dunIrts_studentId.size(); index++) {
                if (Integer.parseInt(dunIrts_studentId.get(index).toString())==(student_id) && dunIrts_subjectTypeId.get(index).toString().equals(type.get(i).toString())) {
                    attendancePoints.add(allAttendancePoints.get(index).toString());
                }
            }
            //------------------------------------4

            ArrayList<Object> dunIdevh_studentId = DB_Copy.getDatas("Dun_Idevh", "student_id");
            ArrayList<Object> dunIdevh_subjectTypeId = DB_Copy.getDatas("Dun_Idevh", "subject_type_id");
            ArrayList<Object> allActivityPoints = DB_Copy.getDatas("Dun_Idevh", "idevh_point");

            for (int index = 0; index < dunIdevh_studentId.size(); index++) {

                if (Integer.parseInt(dunIdevh_studentId.get(index).toString())==(student_id) && dunIdevh_subjectTypeId.get(index).toString().equals(type.get(i).toString())) {
                    activityPoints.add(allActivityPoints.get(index).toString());
                }
            }
            //----------------------------------------------------------5

            ArrayList<Object> subject_subjectTypeId = DB_Copy.getDatas("Subject", "subject_type_id");
            ArrayList<Object> subject_subject_id = DB_Copy.getDatas("Subject", "subject_id");
            ArrayList<Object> hicheel = new ArrayList<>();
            ArrayList<Object> subject_type_type = DB_Copy.getDatas("Subject_Type", "type");


            for (int index = 0; index < subject_subjectTypeId.size(); index++) {
                if (subject_subjectTypeId.get(index).toString().equals(type.get(i))) {
                    hicheel.add(subject_subject_id.get(index));
                }
            }

            biyDaalt_subjectIds.add(hicheel);
            //--------------------------------------------------6
            ArrayList<Object> bagtsal = new ArrayList<>();
            for (int y = 0; y < hicheel.size(); y++) {

                ArrayList<Object> taskName_subjectId = DB_Copy.getDatas("Task_NAME", "Subject_id");
                ArrayList<Object> taskName_taskId = DB_Copy.getDatas("Task_NAME", "Task_ID");

                ArrayList<Object> hicheelList = new ArrayList<>();
                ArrayList<Object> taskIdSep = new ArrayList<>();

                hicheelList = (ArrayList<Object>) biyDaalt_subjectIds.get(i);

                for (int index = 0; index < taskName_subjectId.size(); index++) {
                    if (taskName_subjectId.get(index).toString().equals(hicheelList.get(y).toString())) {
                        taskIdSep.add(taskName_taskId.get(index));
                    }

                }
                bagtsal.add(taskIdSep);

            }
            taskIds.add(bagtsal);
            //--------------------------------------------------7
            
            ArrayList<Object> sums = new ArrayList<>();
            int avg123456789 = 0;
            for (Object first : taskIds) {
                sums = new ArrayList<>();
                avg123456789 = 0;
                for (Object second : (ArrayList<Object>) first) {

                    int sum = 0;
                    for (Object task_index : (ArrayList<Object>) second) {

                        ArrayList<Object> dunBiyDaalt_taskId = DB_Copy.getDatas("Dun_Biedaalt", "Task_ID");
                        ArrayList<Object> dunBiyDaalt_taskPoint = DB_Copy.getDatas("Dun_Biedaalt", "Task_POINT");
                        ArrayList<Object> dunBiyDaalt_student_id = DB_Copy.getDatas("Dun_Biedaalt", "Student_id");
                        for (int index = 0; index < dunBiyDaalt_taskId.size(); index++) {
                            if ((task_index.toString().equals(dunBiyDaalt_taskId.get(index).toString())) && (Integer.parseInt(dunBiyDaalt_student_id.get(index).toString())==(student_id))) {
                                int t = Integer.parseInt(dunBiyDaalt_taskPoint.get(index).toString());
                                sum += t;
                            }
                        }
                    }
                    sums.add(sum);
                }
                
                int total = 0;
                int count = 0;
                for (Object num : sums) {
                    
                    int number = Integer.parseInt(num.toString());
                    total += number;
                    count++;
                }
                avg123456789 = total / count;
                
            }
            taskPointList.add(avg123456789);
            //----------------------------------------------------
            
            ArrayList<Object> bagtsalDaalgavar = new ArrayList<>();
            for (int y = 0; y < hicheel.size(); y++) {

                ArrayList<Object> daalgavar_subjectId = DB_Copy.getDatas("Daalgavar", "Subject_id");
                ArrayList<Object> daalgavar_taskId = DB_Copy.getDatas("Daalgavar", "Homework_id");

                ArrayList<Object> hicheelList = new ArrayList<>();
                ArrayList<Object> homeworkIdSep = new ArrayList<>();

                hicheelList = (ArrayList<Object>) biyDaalt_subjectIds.get(i);

                for (int index = 0; index < daalgavar_subjectId.size(); index++) {
                    if (daalgavar_subjectId.get(index).toString().equals(hicheelList.get(y).toString())) {
                        homeworkIdSep.add(daalgavar_taskId.get(index));
                    }

                }
                bagtsalDaalgavar.add(homeworkIdSep);

            }
            homeworkIds.add(bagtsalDaalgavar);
            
            //----------------------------------------------------
            
            ArrayList<Object> sums2 = new ArrayList<>();
            
            ArrayList<Object> dunDaalgavar_homeworkId = DB_Copy.getDatas("Dun_Daalgavar", "Homework_id");
            ArrayList<Object> dunDaalgavar_homeworkPoint = DB_Copy.getDatas("Dun_Daalgavar", "Homework_Point");
            ArrayList<Object> dunDaalgavar_student_id = DB_Copy.getDatas("Dun_Daalgavar", "Student_id");
            
            int avg12345 = 0;
            for (Object first : homeworkIds) {
                sums2 = new ArrayList<>();
                avg12345 = 0;
                for (Object second : (ArrayList<Object>) first) {

                    int sum2 = 0;
                    
                    
                    for (Object homework_index : (ArrayList<Object>) second) {

                        
                        for ( int index = 0; index < dunDaalgavar_homeworkId.size(); index++) {
                            
                            if ((homework_index.toString().equals(dunDaalgavar_homeworkId.get(index).toString())) && (Integer.parseInt(dunDaalgavar_student_id.get(index).toString())==(student_id))) {
                                int t = Integer.parseInt(dunDaalgavar_homeworkPoint.get(index).toString());
                                sum2 += t;
                            }
                            
                        }

                    }
                    sums2.add(sum2);
                }
                
                int total = 0;
                int count = 0;
                for (Object num2 : sums2) {
                    
                    int number = Integer.parseInt(num2.toString());
                    total += number;
                    count++;
                }
                avg12345 = total / count;
                
            }
            homeworkPointList.add(avg12345);
                
            
            
            //---------------------------------------------------------------------------------->
            
            ArrayList<Object> bagtsalExam = new ArrayList<>();
            for (int y = 0; y < hicheel.size(); y++) {

                ArrayList<Object> shalgalt_subjectId = DB_Copy.getDatas("Shalgalt", "Subject_id");
                ArrayList<Object> shalgalt_examId = DB_Copy.getDatas("Shalgalt", "Exam_ID");

                ArrayList<Object> hicheelList = new ArrayList<>();
                ArrayList<Object> examIdSep = new ArrayList<>();

                hicheelList = (ArrayList<Object>) biyDaalt_subjectIds.get(i);

                for (int index = 0; index < shalgalt_subjectId.size(); index++) {
                    if (shalgalt_subjectId.get(index).toString().equals(hicheelList.get(y).toString())) {
                        examIdSep.add(shalgalt_examId.get(index));
                    }

                }
                bagtsalExam.add(examIdSep);

            }
            examIds.add(bagtsalExam);
            
            //----------------------------------------------------
            
            ArrayList<Object> sums3 = new ArrayList<>();
            
            ArrayList<Object> dunShalgalt_examId = DB_Copy.getDatas("Dun_Shalgalt", "Exam_ID");
            ArrayList<Object> dunShalgalt_examPoint = DB_Copy.getDatas("Dun_Shalgalt", "Exam_Point");
            ArrayList<Object> dunShalgalt_student_id = DB_Copy.getDatas("Dun_Shalgalt", "Student_id");
          
            int avg123 = 0;
            for (Object first : examIds) {
                sums3 = new ArrayList<>();
                avg123 = 0;
                for (Object second : (ArrayList<Object>) first) {

                    int sum3 = 0;
                    for (Object exam_index : (ArrayList<Object>) second) {
                        for ( int index = 0; index < dunShalgalt_examId.size(); index++) {
                            if ((exam_index.toString().equals(dunShalgalt_examId.get(index).toString())) && (Integer.parseInt(dunShalgalt_student_id.get(index).toString())==(student_id))) {
                                int t = Integer.parseInt(dunShalgalt_examPoint.get(index).toString());
                                sum3 += t;
                            }
                        }
                    }
                    sums3.add(sum3);
                }
                
                int total = 0;
                int count = 0;
                for (Object num3 : sums3) {
                    int number = Integer.parseInt(num3.toString());
                    total += number;
                    count++;
                }
                avg123 = total / count;
                
            }
            examPointList.add(avg123);
        }
        
        for(int index = 0; index<2; index++){
        

                     
 //            totalPointList.add(total);
            Object subListExam = examPointList.get(index);
            Object subListTask = taskPointList.get(index);
            Object subListHomework = homeworkPointList.get(index);
            
            int subAttendance = Integer.parseInt(attendancePoints.get(index).toString());
            int subActivity = Integer.parseInt(activityPoints.get(index).toString());
            int subListExamInt = Integer.parseInt(subListExam.toString());
            int subListTaskInt = Integer.parseInt(subListTask.toString());
            int subListHomeworkInt = Integer.parseInt(subListHomework.toString());
            
            double total = subAttendance*0.2 + subActivity*0.3 +subListExamInt*0.25 + (subListTaskInt + subListHomeworkInt)*0.25;
//                System.out.println("total"+ total);
                totalPointList.add(total);
        }
        
        
        ArrayList<Object> result = new ArrayList<>();
        ArrayList<Object> separated; 
        

//        profile.add(class_id);
//        profile.add(type);
        profile.add(typeName);
//        profile.add(attendancePoints);
//        profile.add(activityPoints);
////        profile.add(biyDaalt_subjectIds);
////        profile.add(taskIds);
//        profile.add(taskPointList);
////        profile.add(homeworkIds);
//        profile.add(homeworkPointList);
////        profile.add(examIds);
//        profile.add(examPointList);
        profile.add(totalPointList);
        
        
        for (int si = 0; si < ((ArrayList<Object>) profile.get(0)).size(); si++) {
            String row_str = "";
            for (int row = 0; row < profile.size(); row++) {
                row_str += ((ArrayList<Object>) profile.get(row)).get(si);
                if ((row+1) != profile.size()) {
                    row_str += "||";
                }
            }
            result.add(row_str);
        }

        return profile;


}
//*********************************ADDED***********************************************
         
         public static boolean insertAccount(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();
       
        
       if(db.insertIntoAccount(o1, o2, o3)){
        
            try {
                String query = "select*from Account";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    
                }   
                DB_Copy.insertRow("Account", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    }   
    public static boolean insertAdmin(String o1, String o2, String o3, String o4, String o5) {
        ArrayList<Object> data = new ArrayList<>();
        
       if(db.insertIntoAdmin(o1, o2, o3, o4, o5)){
        
            try {
                String query = "select*from Admin";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                    
                }   
                DB_Copy.insertRow("Admin", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
    public static boolean insertAdminAcc(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();
       
        
       if(db.insertIntoAdminAcc(o1, o2)){
        
            try {
                String query = "select*from AdminAcc";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    
                }   
                DB_Copy.insertRow("Account", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    }  
    public static boolean insertClass(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();
       
        
       if(db.insertIntoClass(null, o2, o3)){
        
            try {
                String query = "select*from Class";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }   
                DB_Copy.insertRow("Class", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
    public static boolean insertDaalgavar(String o1, String o2, String o3, String o4) {
        ArrayList<Object> data = new ArrayList<>();
       
        
       if(db.insertIntoDaalgavar(null, o2, o3, o4)){
        
            try {
                String query = "select*from Daalgavar";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    
                }   
                DB_Copy.insertRow("Daalgavar", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
     public static boolean insertDasgal(String o1, String o2, String o3, String o4) {
        ArrayList<Object> data = new ArrayList<>();
       
        
       if(db.insertIntoDasgal(null, o2, o3, o4)){
        
            try {
                String query = "select*from Dasgal";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getSQLXML(4));
                    
                }   
                DB_Copy.insertRow("Dasgal", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
      public static boolean insertDunBieDaalt(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();
       
        
       if(db.insertIntoDunBiedaalt(o1, o2, o3)){
        
            try {
                String query = "select*from Dun_Biedaalt";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }   
                DB_Copy.insertRow("Dun_Biedaalt", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertDunDaalgavar(String o1, String o2, String o3, String o4, String o5, String o6) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoDunDaalgavar(o1, o2, o3, o4, o5, o6)){
        
            try {
                String query = "select*from Dun_Daalgavar";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                    
                }   
                DB_Copy.insertRow("Dun_Daalgavar", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertDunDasgal(String o1, String o2, String o3, String o4, String o5, String o6) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoDunDasgal(o1, o2, o3, o4, o5, o6)){
        
            try {
                String query = "select*from Dun_Dasgal";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                    
                }   
                DB_Copy.insertRow("Dun_Dasgal", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertDunIdevh(String o1, String o2, String o3, String o4) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoIdevh(o1, o2, o3, o4)){
        
            try {
                String query = "select*from Dun_Idevh";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }   
                DB_Copy.insertRow("Dun_Idevh", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertDunIrts(String o1, String o2, String o3, String o4, String o5) {
            ArrayList<Object> data = new ArrayList<>();

               if(db.insertIntoDunIrts(o1, o2, o3, o4, o5)){

                try {
                    String query = "select*from Dun_Irts";
                    ResultSet result = db.runQuery(query);

                    if(result.last()){
                        data.add(result.getString(1));
                        data.add(result.getString(2));
                        data.add(result.getString(3));
                        data.add(result.getString(4));
                        data.add(result.getString(5));
                    }   
                    DB_Copy.insertRow("Dun_Irts", data);
                 } catch (SQLException ex) {
                }
             }
            return true;
        } 
        public static boolean insertDunIrtsLavlah(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoDunIrtsLavlah(o1, o2)){
        
            try {
                String query = "select*from Dun_Irts_Lavlah";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }   
                DB_Copy.insertRow("Dun_Irts_Lavlah", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertDunShalgalt(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoDunShalgalt(null, o2, o3)){
        
            try {
                String query = "select*from Dun_Shalgalt";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }   
                DB_Copy.insertRow("Dun_Shalgalt", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertLecture(String o1, String o2, String o3, String o4, String o5) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoLecture(null, o2, o3, o4, o5)){
        
            try {
                String query = "select*from lecture";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                }   
                DB_Copy.insertRow("lecture", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertLectureSession(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoLectureSession(o1, o2)){
        
            try {
                String query = "select*from Lecture_sessions";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }   
                DB_Copy.insertRow("Lecture_sessions", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertManager(String o2, String o3, String o4, String o5, String o6) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoManager(null, o2, o3, o4, o5, o6)){
        
            try {
                String query = "select*from Manager";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                }   
                DB_Copy.insertRow("Manager", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean insertManagerAcc(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();
        
           if(db.insertIntoManagerAcc(null, o2)){
        
            try {
                String query = "select*from ManagerAcc";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }   
                DB_Copy.insertRow("ManagerAcc", data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
    //----------------------------INSERT  Adiyahuu END --------------------------------//


    public static boolean insertIntoTeamStudents(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoAccount(o1, o2, o3)) {

            try {
                String query = "select*from Team_students";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }
                DB_Copy.insertRow("Team_students", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoTeam(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoTeam(null, o2, o3)) {
            try {
                String query = "select*from Team";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }
                DB_Copy.insertRow("Team", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoTeacherClass(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoTeacherClass(o1, o2, null)) {

            try {
                String query = "select*from TeacherClass";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }
                DB_Copy.insertRow("TeacherClass", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoTeacherAcc(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoTeacherAcc(o1, o2)) {

            try {
                String query = "select*from TeacherAcc";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
                DB_Copy.insertRow("TeacherAcc", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoTeacher(String o1, String o2, String o3, String o4, String o5, String o6) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoTeacher(null, o2, o3, o4, o5, o6)) {

            try {
                String query = "select*from Teacher";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
                DB_Copy.insertRow("Teacher", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoTaskName(String o1, String o2, String o3, String o4, String o5) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoTaskName(null, o2, o3, o4, o5)) {

            try {
                String query = "select*from Task_NAME";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                }
                DB_Copy.insertRow("Task_NAME", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoSubjectTypeClass(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoSubjectTypeClass(o1, o2)) {

            try {
                String query = "select*from Subject_typeClass";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
                DB_Copy.insertRow("Subject_typeClass", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoSubjectType(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoSubjectType(null, o2)) {

            try {
                String query = "select*from Subject_Type";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
                DB_Copy.insertRow("Subject_Type", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoSubject(String o1, String o2, String o3, String o4, String o5, String o6) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoSubject(null, o2, o3, o4, o5, o6)) {

            try {
                String query = "select*from Subject";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                }
                DB_Copy.insertRow("Subject", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoStudentAcc(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoSubjectType(o1, o2)) {

            try {
                String query = "select*from StudentAcc";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
                DB_Copy.insertRow("StudentAcc", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoStudent(String o1, String o2, String o3, String o4, String o5, String o6, String o7, String o8) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoStudent(null, o2, o3, o4, o5, o6, o7, o8)) {

            try {
                String query = "select*from Student";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                    data.add(result.getString(7));
                    data.add(result.getString(8));
                }
                DB_Copy.insertRow("Student", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoStatus(String o1, String o2) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoStatus(null, o2)) {
            try {
                String query = "select*from status";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
                DB_Copy.insertRow("status", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoShalgalt(String o1, String o2, String o3) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoShalgalt(o1, o2, o3)) {
            try {
                String query = "select*from Shalgalt";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }
                DB_Copy.insertRow("Shalgalt", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

    public static boolean insertIntoProject(String o1, String o2, String o3, String o4) {
        ArrayList<Object> data = new ArrayList<>();

        if (db.insertIntoProject(null, o2, o3, o4)) {
            try {
                String query = "select*from Project";
                ResultSet result = db.runQuery(query);

                if (result.last()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }
                DB_Copy.insertRow("Project", data);
            } catch (SQLException ex) {
            }
        }
        return true;
    }

   
    //----------------------------INSERT badral END --------------------------------//
    
    //----------------------------UPDATE BEGIN --------------------------------//
      public static boolean updateAccount(String o1, String o2, String o3, String o4, String o5) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
         
       if(db.updateAccount(o1, o2, o3, o4, o5)){
        
            try {
                String query = "select*from Account where  acc_id="+o5+"";
                ResultSet result = db.runQuery(query);
               
                if(result.next()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    
                }   
               
                ArrayList<Object> baganuud = DB_Copy.getDatas("Account","acc_id");
                System.out.println("Baganuud"+baganuud);
               
                        row = baganuud.indexOf(Integer.parseInt(o5));
                        System.out.println("row-->"+row);
                     
                    
                System.out.println("Data___?"+data);
                
                DB_Copy.updateRow("Account",row,data);
             } catch (SQLException ex) {
            }
         }
        return true;
    }   
    public static boolean updateAdmin(String o1, String o2, String o3, String o4, String o5, String o6, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
         
       if(db.updateAdmin(o1, o2, o3, o4, o5, o6, where)){
        
            try {
                String query = "select*from Admin where  Admin_id="+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.next()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                    
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Admin","Admin_id");
                System.out.println("Baganuud"+baganuud);
               
                        row = baganuud.indexOf(Integer.parseInt(where));
                        System.out.println("row-->"+row);
                     
                System.out.println("Data___?"+data);
                
                DB_Copy.updateRow("Admin",row,data);
             } catch (SQLException ex) {
            }
         }
        return true;
    }   
     public static boolean updateAdminAcc(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
        
       if(db.updateAdminAcc(o1, o2, where)){
        
            try {
                String query = "select*from AdminAcc where Admin_id="+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    
                }   
                
                ArrayList<Object> baganuud = DB_Copy.getDatas("AdminAcc","Admin_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                
                DB_Copy.updateRow("AdminAcc",row,data);
             } catch (SQLException ex) {
            }
         }
        return true;
    }  
    public static boolean updateClass(String o1, String o2, String o3,String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
        
       if(db.updateClass(o1, o2, o3, where)){
        
            try {
                String query = "select*from Class where Class_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                } 
                ArrayList<Object> baganuud = DB_Copy.getDatas("Class","Class_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                
                DB_Copy.updateRow("Class", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
    public static boolean updateDaalgavar(String o1, String o2, String o3, String o4, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
        
       if(db.updateDaalgavar(o1, o2, o3, o4, where)){
        
            try {
                String query = "select*from Daalgavar where Homework_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Daalgavar","Homework_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                
                DB_Copy.updateRow("Daalgavar", row, data);
               
               } catch (SQLException ex) {
            }
         }
        return true;
    } 
     public static boolean updateDasgal(String o1, String o2, String o3, String o4, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int  row = 0;
        if(db.updateDasgal(o1,o2 ,o3, o4, where)){
        
            try {
                String query = "select*from Dasgal where Exercise_id="+where+" ";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getSQLXML(4));
                    
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Dasgal","Exercise_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                
                DB_Copy.updateRow("Dasgal", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
      public static boolean updateDunBieDaalt(String o1, String o2, String o3, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
        
       if(db.updateDunBiedaalt(o1, o2, o3, where)){
        
            try {
                String query = "select*from Dun_Biedaalt where Student_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Dun_Biedaalt","Student_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("Dun_Biedaalt", row, data);
                
               } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateDunDaalgavar(String o1, String o2, String o3, String o4, String o5, String o6, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
           if(db.updateDunDaalgavar(o1, o2, o3, o4, o5, o6, where)){
        
            try {
                String query = "select*from Dun_Daalgavar where Student_homework_id="+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Dun_Daalgavar","Student_homework_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("Dun_Daalgavar", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateDunDasgal(String o1, String o2, String o3, String o4, String o5, String o6, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
           if(db.updateDunDasgal(o1, o2, o3, o4, o5, o6, where)){
        
            try {
                String query = "select*from Dun_Dasgal where Student_exercise_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                    
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Dun_Dasgal","Student_exercise_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("Dun_Dasgal", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateDunIdevh(String o1, String o2, String o3, String o4, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
           if(db.updateDunIdevh(o1, o2, o3, o4, where)){
        
            try {
                String query = "select*from Dun_Idevh where student_id= "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Dun_Dasgal","student_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("Dun_Idevh", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateDunIrts(String o1, String o2, String o3, String o4, String o5, String where) {
            ArrayList<Object> data = new ArrayList<>();
            int row = 0;

               if(db.updateDunIrts(o1, o2, o3, o4, o5, where)){

                try {
                    String query = "select*from Dun_Irts where student_id="+where+"";
                    ResultSet result = db.runQuery(query);

                    if(result.last()){
                        data.add(result.getString(1));
                        data.add(result.getString(2));
                        data.add(result.getString(3));
                        data.add(result.getString(4));
                        data.add(result.getString(5));
                    }   
                    ArrayList<Object> baganuud = DB_Copy.getDatas("Dun_Irts", "student_id");
                    row = baganuud.indexOf(Integer.parseInt(where));
                    DB_Copy.updateRow("Dun_Irts", row, data);
                } catch (SQLException ex) {
                }
             }
            return true;
        } 
        public static boolean updateDunIrtsLavlah(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
        
           if(db.updateDunIrtsLavlah(o1, o2, where)){
        
            try {
                String query = "select*from Dun_Irts_Lavlah where irts_onoo = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }  
                ArrayList<Object> baganuud = DB_Copy.getDatas("Dun_Irts_Lavlah", "irts_onoo");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("Dun_Irts_Lavlah", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateDunShalgalt(String o1, String o2, String o3, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
           if(db.updateDunShalgalt(o1, o2, o3, where)){
        
            try {
                String query = "select*from Dun_Shalgalt where Student_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Dun_Shalgalt", "Student_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("Dun_Shalgalt", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateLecture(String o1, String o2, String o3, String o4, String o5, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
        
           if(db.updateLecture(o1, o2, o3, o4, o5, where)){
        
            try {
                String query = "select*from lecture where lecture_id= "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("lecture", "lecture_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("lecture", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateLectureSession(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
           if(db.updateLectureSession(o1, o2, where)){
        
            try {
                String query = "select*from Lecture_sessions where lecture_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("Lecture_sessions", "lecture_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("Lecture_sessions", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateManager(String o1, String o2, String o3, String o4, String o5, String o6, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
           if(db.updateManager(o1, o2, o3, o4, o5, o6, where)){
        
            try {
                String query = "select*from Manager where Manager_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                }   
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
        public static boolean updateManagerAcc(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
           if(db.updateManagerAcc(o1, o2, where)){
        
            try {
                String query = "select*from ManagerAcc where Manager_id = "+where+"";
                ResultSet result = db.runQuery(query);
               
                if(result.last()){
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }   
                ArrayList<Object> baganuud = DB_Copy.getDatas("ManagerAcc", "Manager_id");
                row = baganuud.indexOf(Integer.parseInt(where));
                DB_Copy.updateRow("ManagerAcc", row, data);
             } catch (SQLException ex) {
            }
         }
        return true;
    } 
   //-----------------------------------UPDATE adiyahuu END----------------------------------------///
        


    public static boolean updateTeamStudents(String o1, String o2, String o3, String o4, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateTeamStudents(o1, o2, o3, o4, where)) {

            String query = "select*from Team_students where team_student_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Object> baganuud = DB_Copy.getDatas("Team_students", "team_student_id");
            System.out.println("Bagana" + baganuud);

            row = baganuud.indexOf(Integer.parseInt(where));
            System.out.println("row-->" + row);

            System.out.println("Data___?" + data);

            DB_Copy.updateRow("Team_students", row, data);

        }
        return true;
    }

    public static boolean updateTeam(String o1, String o2, String o3, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateTeam(o1, o2, o3, where)) {

            String query = "select*from Team where team_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Object> baganuud = DB_Copy.getDatas("Team", "team_id");
            System.out.println("Bagana" + baganuud);

            row = baganuud.indexOf(Integer.parseInt(where));
            System.out.println("row-->" + row);

            System.out.println("DATA---->" + data);

            DB_Copy.updateRow("Team", row, data);

        }
        return true;
    }

    public static boolean updateTeacherClass(String o1, String o2, String o3, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateTeacherClass(o1, o2, o3, where)) {

            String query = "select*from TeacherClass where teacher_class_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Object> baganuud = DB_Copy.getDatas("TeahcerClass", "teacher_class_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("TeacherClass", row, data);

        }
        return true;
    }

    public static boolean updateTeacherAcc(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateTeacherAcc(o1, o2, where)) {

            String query = "select*from TeacherAcc where Teacher_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Object> baganuud = DB_Copy.getDatas("TeahcerAcc", "Teacher_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("TeacherClass", row, data);

        }
        return true;
    }

    public static boolean updateTeacher(String o1, String o2, String o3, String o4, String o5, String o6, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateTeacherAcc(o1, o2, where)) {

            String query = "select*from Teacher where Teacher_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Object> baganuud = DB_Copy.getDatas("Teacher", "Teacher_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Teacher", row, data);

        }
        return true;
    }

    public static boolean updateTaskName(String o1, String o2, String o3, String o4, String o5, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateTask(o1, o2, o3, o4, o5, where)) {

            String query = "select*from Task_NAME where Task_ID=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Object> baganuud = DB_Copy.getDatas("Task_NAME", "Task_ID");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Task_NAME", row, data);

        }
        return true;
    }

//     ******************************DANGER******************************************  
    public static boolean updateSubject_typeClass(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateSubjectTypeClass(o1, o2, where)) {

            String query = "select*from Subject_typeClass where class_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ArrayList<Object> baganuud = DB_Copy.getDatas("Subject_typeClass", "class_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Subject_typeClass", row, data);

        }
        return true;
    }

    public static boolean updateSubjectType(String o1, String o2, String o3, String o4, String o5, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateSubjectType(o1, o2, where)) {

            String query = "select*from Subject_Type where class_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayList<Object> baganuud = DB_Copy.getDatas("Subject_Type", "class_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Subject_Type", row, data);
        }
        return true;
    }

    public static boolean updateSubject(String o1, String o2, String o3, String o4, String o5, String o6, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateSubject(o1, o2, o3, o4, o5, o6, where)) {

            String query = "select*from Subject where subject_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayList<Object> baganuud = DB_Copy.getDatas("Subject", "subject_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Subject", row, data);
        }
        return true;
    }

    public static boolean updateStudentAcc(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateStudentAcc(o1, o2, where)) {

            String query = "select*from StudentAcc where Student_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayList<Object> baganuud = DB_Copy.getDatas("StudentAcc", "Student_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("StudentAcc", row, data);
        }
        return true;
    }

    public static boolean updateStudent(String o1, String o2, String o3, String o4, String o5, String o6, String o7, String o8, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateStudent(o1, o2, o3, o4, o5, o6, o7, o8, where)) {

            String query = "select*from Student where Student_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                    data.add(result.getString(5));
                    data.add(result.getString(6));
                    data.add(result.getString(7));
                    data.add(result.getString(8));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayList<Object> baganuud = DB_Copy.getDatas("Student", "Student_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Student", row, data);
        }
        return true;
    }

    public static boolean updateStatus(String o1, String o2, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateStatus(o1, o2, where)) {

            String query = "select*from status where status_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayList<Object> baganuud = DB_Copy.getDatas("status", "status_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("status", row, data);
        }
        return true;
    }

    public static boolean updateShalgalt(String o1, String o2, String o3, String o4, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;

        if (db.updateShalgalt(o1, o2, o3, o4, where)) {

            String query = "select*from Shalgalt where Exam_ID=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayList<Object> baganuud = DB_Copy.getDatas("Shalgalt", "Exam_ID");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Shalgalt", row, data);
        }
        return true;
    }
//     *****************************************PROBLEM************************************

    public static boolean updateProject(String o1, String o2, String o3, String o4, String where) {
        ArrayList<Object> data = new ArrayList<>();
        int row = 0;
        if (db.updateProject(o1, o2, o3, o4, where)) {
            String query = "select*from Project where team_id=" + where + "";
            ResultSet result = db.runQuery(query);
            System.out.println(result);
            try {
                while (result.next()) {
                    data.add(result.getString(1));
                    data.add(result.getString(2));
                    data.add(result.getString(3));
                    data.add(result.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ArrayList<Object> baganuud = DB_Copy.getDatas("Project", "team_id");
            row = baganuud.indexOf(Integer.parseInt(where));
            DB_Copy.updateRow("Project", row, data);
        }
        return true;
    }
      //-----------------------------------UPDATE badral END----------------------------------------///
    
      //-----------------------------------DELETE BEGIN----------------------------------------///
    
    public static boolean deleteFromTeamStudent(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Team_students", "team_student_id");
        DB_Copy.removeAt("Team_students", row.indexOf(o1));

        if (db.deleteFromTeamStudent(o1)) {
        }
        return true;
    }

    public static boolean deleteFromTeam(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Team", "team_id");
        DB_Copy.removeAt("Team", row.indexOf(o1));

        if (db.deleteFromTeam(o1)) {
        }
        return true;
    }

    public static boolean deleteFromTeacherClass(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("TeacherClass", "teacher_class_id");
        DB_Copy.removeAt("TeacherClass", row.indexOf(o1));

        if (db.deleteFromTeacherClass(o1)) {
        }
        return true;
    }

    public static boolean deleteFromTeacherAcc(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("TeacherAcc", "Teacher_id");
        DB_Copy.removeAt("TeacherAcc", row.indexOf(o1));

        if (db.deleteFromTeacherAcc(o1)) {
        }
        return true;
    }

    public static boolean deleteFromTeacher(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Teacher", "Teacher_id");
        DB_Copy.removeAt("Teacher", row.indexOf(o1));

        if (db.deleteFromTeacher(o1)) {
        }
        return true;
    }

    public static boolean deleteFromTaskName(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Task_NAME", "Task_ID");
        DB_Copy.removeAt("Task_NAME", row.indexOf(o1));

        if (db.deleteFromTaskName(o1)) {
        }
        return true;
    }

//*************************ZASVARLAH*****************************************************************
    public static boolean deleteFromSubjectTypeClass(Object o1, Object o2) {

//         ArrayList<Object> row = DB_Copy.getDatas("Subject_typeClass","Class_id");         
//         DB_Copy.removeAt("Subject_typeClass", row.indexOf(o1));
        if (db.deleteFromSubject_typeClass(o1, o2)) {
        }
        return true;
    }

    public static boolean deleteFromSubjectType(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Subject_type", "subject_type_id");
        DB_Copy.removeAt("Subject_type", row.indexOf(o1));

        if (db.deleteFromSubjectType(o1)) {
        }
        return true;
    }
    public static boolean deleteFromSubject(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Subject", "subject_id");
        DB_Copy.removeAt("Subject", row.indexOf(o1));

        if (db.deleteFromSubject(o1)) {
        }
        return true;
    }
    public static boolean deleteFromStudentAcc(Object o1,Object o2) {
//**********************************ZASVARlAH********************************************
//        ArrayList<Object> row = DB_Copy.getDatas("StudentAcc", "Student_id");
//        DB_Copy.removeAt("StudentAcc", row.indexOf(o1));

        if (db.deleteFromStudentAcc(o1,o2)) {
        }
        return true;
    }
    
    public static boolean deleteFromStudent(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Student", "Student_id");
        DB_Copy.removeAt("Student", row.indexOf(o1));

        if (db.deleteFromStudent(o1)) {
        }
        return true;
    }
    public static boolean deleteFromStatus(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("status", "status_id");
        DB_Copy.removeAt("status", row.indexOf(o1));

        if (db.deleteFromStatus(o1)) {
        }
        return true;
    }
    public static boolean deleteFromShalgalt(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Shalgalt", "Exam_ID");
        DB_Copy.removeAt("Shalgalt", row.indexOf(o1));

        if (db.deleteFromShalgalt(o1)) {
        }
        return true;
    }
    public static boolean deleteFromProject(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Project", "team_id");
        DB_Copy.removeAt("Project", row.indexOf(o1));

        if (db.deleteProject(o1)) {
        }
        return true;
    }
    public static boolean deleteFromManagerAcc(Object o1, Object o2) {

        ArrayList<Object> row = DB_Copy.getDatas("ManagerAcc", "Manager_id");
        DB_Copy.removeAt("ManagerAcc", row.indexOf(o1));

        if (db.deleteMangagerAcc(o1,o2)) {
        }
        return true;
    }
    
    public static boolean deleteFromManager(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Manager", "Manager_id");
        DB_Copy.removeAt("Manager", row.indexOf(o1));

        if (db.deleteManager(o1)) {
        }
        return true;
    }
    public static boolean deleteFromLectureSession(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Lecture_sessions", "lecture_id");
        DB_Copy.removeAt("Lecture_sessions", row.indexOf(o1));

        if (db.deleteLectureSession(o1)) {
        }
        return true;
    }
    public static boolean deleteLecture(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("lecture", "lecture_id");
        DB_Copy.removeAt("Lecture_sessions", row.indexOf(o1));

        if (db.deleteLecture(o1)) {
        }
        return true;
    }
    public static boolean deleteFromDunShalgalt(Object o1,Object o2) {

        ArrayList<Object> row = DB_Copy.getDatas("Dun_Shalgalt", "Student_id");
        DB_Copy.removeAt("Dun_Shalgalt", row.indexOf(o1));

        if (db.deleteDunShalgalt(o1,o2)) {
        }
        return true;
    }
    
    public static boolean deleteFromDunIrtsLavlah(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Dun_Irts_Lavlah", "irts_onoo");
        DB_Copy.removeAt("Dun_Irts_Lavlah", row.indexOf(o1));

        if (db.deleteDunIrtsLavlah(o1)) {
        }
        return true;
    }
    
    public static boolean deleteFromDunIrts(Object o1,Object o2) {

        ArrayList<Object> row = DB_Copy.getDatas("Dun_Irts", "date");
        DB_Copy.removeAt("Dun_Irts", row.indexOf(o1));

        if (db.deleteDunIrts(o1,o2)) {
        }
        return true;
    }
    public static boolean deleteFromDunIdevh(Object o1,Object o2) {

        ArrayList<Object> row = DB_Copy.getDatas("Dun_Idevh", "date");
        DB_Copy.removeAt("Dun_Idevh", row.indexOf(o1));

        if (db.deleteDunIdevh(o1,o2)) {
        }
        return true;
    }
    public static boolean deleteFromDunDasgal(Object o1,Object o2) {

        ArrayList<Object> row = DB_Copy.getDatas("Dun_Dasgal", "Student_exercise_id");
        DB_Copy.removeAt("Dun_Dasgal", row.indexOf(o1));

        if (db.deleteDunDasgal(o1,o2)) {
        }
        return true;
    }
    public static boolean deleteFromDunDaalgavar(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Dun_Daalgavar", "Student_homework_id");
        DB_Copy.removeAt("Dun_Daalgavar", row.indexOf(o1));

        if (db.deleteDunDaalgavar(o1)) {
        }
        return true;
    }
    
    public static boolean deleteFromDunBieDaalt(Object o1,Object o2) {

        ArrayList<Object> row = DB_Copy.getDatas("Dun_Biedaalt", "Student_homework_id");
        DB_Copy.removeAt("Dun_Biedaalt", row.indexOf(o1));

        if (db.deleteDunBieDaalt(o1,o2)) {
        }
        return true;
    }
    public static boolean deleteFromDasgal(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Dasgal", "Exercise_id");
        DB_Copy.removeAt("Dasgal", row.indexOf(o1));

        if (db.deleteDasgal(o1)) {
        }
        return true;
    }
    
    public static boolean deleteFromDaalgavar(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Daalgavar", "Homework_id");
        DB_Copy.removeAt("Daalgavar", row.indexOf(o1));

        if (db.deleteDaalgavar(o1)) {
        }
        return true;
    }
    public static boolean deleteFromClass(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Class", "Class_id");
        DB_Copy.removeAt("Daalgavar", row.indexOf(o1));

        if (db.deleteClass(o1)) {
        }
        return true;
    }
    
    public static boolean deleteFromAdminAcc(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("AdminAcc", "Admin_id");
        DB_Copy.removeAt("AdminAcc", row.indexOf(o1));

        if (db.deleteAdminAcc(o1)) {
        }
        return true;
    }
    public static boolean deleteFromAdmin(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Admin", "Admin_id");
        DB_Copy.removeAt("Admin", row.indexOf(o1));

        if (db.deleteAdmin(o1)) {
        }
        return true;
    }
    public static boolean deleteFromAccount(Object o1) {

        ArrayList<Object> row = DB_Copy.getDatas("Account", "acc_id");
        DB_Copy.removeAt("Account", row.indexOf(o1));

        if (db.deleteAccount(o1)) {
        }
        return true;
    }


}
