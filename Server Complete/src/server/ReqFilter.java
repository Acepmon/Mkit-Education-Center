/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import teacher.model.Columns;

/**
 *
 * @author JAVA M2
 */
public class ReqFilter {

    private static ArrayList<RequestProcess> requestLists = new ArrayList<>();

    public enum ProcessType {

        GET, INSERT, UPDATE, DELETE, ALL
    }

    static class RequestProcess {

        String requestName;
        ProcessAll all;

        ProcessType type;

        public RequestProcess(String requestName, ProcessAll process) {
            this.requestName = requestName;
            this.all = process;
            this.type = ProcessType.ALL;
        }
    }

    public static void InitializeRequest() {
        requestLists.clear();

        DatabaseTools db = SurgaltServer.db;
        //-----------------------REQ BEGIN--------------------------------------------------------------------------//

//        requestLists.add(new RequestProcess("getTeacherStudents", new ProcessAll() {
//
//            @Override
//            public Object run(Object requestDatas) {
//
//                ArrayList<Object> teachIds = DB_Copy.getDatas("teacher", "teacher_id");
//                ArrayList<Object> STteachIds = DB_Copy.getDatas("student_teacher", "teacher_id");
//                ArrayList<String> retReal = new ArrayList<>();
//                String teachUserName = "";
//                String retNegdsen = "";
//
//                String teachId = "";
//                for (int i = 0; i < teachIds.size(); i++) {
//                    teachUserName = DB_Copy.getDatas("teacher", "username", i).toString();
//                    if (requestDatas.toString().equals(teachUserName)) {
//                        teachId = teachIds.get(i).toString();
//                    }
//                }
//                for (int i = 0; i < STteachIds.size(); i++) {
//                    retNegdsen = "";
//                    String STteachId = DB_Copy.getDatas("student_teacher", "teacher_id", i).toString();
//                    if (teachId.equals(STteachId)) {
//
//                        retNegdsen += DB_Copy.getDatas("student", "student_id", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "code", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "lastname", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "firstname", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "phone", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "email_address", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "social_address", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "reg_num", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "address", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "com_num", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "elseltiin_id", i).toString();
//                        retNegdsen += "::";
//                        retNegdsen += DB_Copy.getDatas("student", "student_pic", i).toString();
//
//                        retReal.add(retNegdsen);
//                    }
//                }
//
//                return retReal;
//
//            }
//        }));
        requestLists.add(new RequestProcess("deleteSubject", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String did = requestDatas.toString();
                String str = "true";
                try {
                    str = db.deleteFromSubject(did);
                } catch (Exception e) {
                    str = "error";
                    System.out.println("ErrorMessage>>>>>>>>>>>" + str);
                }
                ArrayList<Object> idCol = DB_Copy.getDatas("subject", "subject_id");

                for (int i = 0; i < idCol.size(); i++) {
                    if (idCol.get(i).toString().equals(did)) {
                        DB_Copy.removeAt("subject", i);
                        break;
                    }
                }
                return str;
            }
        }));

        requestLists.add(new RequestProcess("getSubject", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                ArrayList<String> retReal = new ArrayList<>();
                String retNegdsen = "";
                ArrayList<Object> ids = DB_Copy.getDatas("subject", "subject_id");

                for (int i = 0; i < ids.size(); i++) {
                    retNegdsen = "";
                    retNegdsen += DB_Copy.getDatas("subject", "subject_id", i).toString();
                    retNegdsen += "::";
                    retNegdsen += DB_Copy.getDatas("subject", "subject_name", i).toString();
                    retNegdsen += "::";
                    retNegdsen += DB_Copy.getDatas("subject", "start_date", i).toString();
                    retNegdsen += "::";
                    retNegdsen += DB_Copy.getDatas("subject", "end_date", i).toString();
                    retReal.add(retNegdsen);
                }
                return retReal;
            }
        }));

        requestLists.add(new RequestProcess("insertSubject", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String sub_name = datas[0];
                String start = datas[1];
                String end = datas[2];

                if (db.insertSubject(sub_name, start, end)) {
                    ArrayList<Object> data = new ArrayList<>();
                    try {
                        String query = "select*from subject order by subject_id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        while (result.next()) {
                            data.add(result.getObject(1));
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            break;
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    DB_Copy.insertRow("subject", data);
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("getNegdsenDun", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                ArrayList<Object> teachIds = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> negdsenIds = DB_Copy.getDatas("negdsen_dun", "id");
                String teachUserName = "";
                String retNegdsen = "";
                ArrayList<String> retReal = new ArrayList<>();

                String teachId = "";
                for (int i = 0; i < teachIds.size(); i++) {
                    teachUserName = DB_Copy.getDatas("teacher", "username", i).toString();
                    if (requestDatas.toString().equals(teachUserName)) {
                        teachId = teachIds.get(i).toString();
                    }
                }

                for (int i = 0; i < negdsenIds.size(); i++) {
                    retNegdsen = "";

                    String negdsenTeachId = DB_Copy.getDatas("negdsen_dun", "teacher_id", i).toString();
                    if (teachId.equals(negdsenTeachId)) {

                        retNegdsen += DB_Copy.getDatas("negdsen_dun", "id", i).toString();
                        retNegdsen += "::";
                        retNegdsen += DB_Copy.getDatas("negdsen_dun", "name", i).toString();
                        retNegdsen += "::";
                        retNegdsen += DB_Copy.getDatas("negdsen_dun", "percent", i).toString();
                        retNegdsen += "::";
                        retNegdsen += DB_Copy.getDatas("negdsen_dun", "teacher_id", i).toString();

                        retReal.add(retNegdsen);

                    }
                }

                return retReal;
            }
        }));

        requestLists.add(new RequestProcess("getManagers", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                ArrayList<Object> studentID = DB_Copy.getDatas("manager", "manager_id");
                ArrayList<Object> response = new ArrayList<>();
                String str = "";
                int i = 0;
                for (; i < studentID.size(); i++) {
                    str = DB_Copy.getDatas("manager", "manager_id", i).toString();
                    str += "::";
                    str += DB_Copy.getDatas("manager", "reg_num", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "lastname", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "firstname", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "phone", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "email_address", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "social_address", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "address", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "manager_picture", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "username", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "password", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "del_flag", i);
                    str += "::";
                    str += DB_Copy.getDatas("manager", "status_id", i);
                    response.add(str);
                }

                return response;
            }
        }));

        requestLists.add(new RequestProcess("tailanIlgeeh", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                ArrayList<Object> receiveDatas = (ArrayList<Object>) requestDatas;
                ArrayList<Columns> tailan = (ArrayList<Columns>) receiveDatas.get(0);
                String username = (String) receiveDatas.get(1);
                String title = (String) receiveDatas.get(2);
                System.out.println(tailan);
                System.out.println("*******************************");
                System.out.println(username);
                System.out.println("*******************************");
                System.out.println(title);
                System.out.println("*******************************");
                WriteXML wri = new WriteXML();
                wri.writeXmlFile(tailan, username, title);

                return true;
            }
        }));

        requestLists.add(new RequestProcess("tailanAvah", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                Object tailan = null;
                try {
                    // int teacherID = Integer.parseInt(requestDatas.toString());
                    ReadXML read = new ReadXML();
                    tailan = read.main();

                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(ReqFilter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(ReqFilter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ReqFilter.class.getName()).log(Level.SEVERE, null, ex);
                }
                return tailan;
            }

        }));

        requestLists.add(new RequestProcess("getStudentImage", new ProcessAll() {
            @Override
            public Object run(Object id) {
                String image = "";
                ArrayList<Object> col1 = DB_Copy.getDatas("student", "student_id");

                for (int i = 0; i < col1.size(); i++) {
                    if (DB_Copy.getDatas("student", "student_id", i).toString().equals(id.toString())) {
                        image = DB_Copy.getDatas("student", "student_pic", i).toString();
                        break;
                    }
                }

                return image;
            }
        }));
        requestLists.add(new RequestProcess("getStudentEmail", new ProcessAll() {
            @Override
            public Object run(Object id) {
                String email = "";
                ArrayList<Object> col1 = DB_Copy.getDatas("student", "student_id");

                for (int i = 0; i < col1.size(); i++) {
                    if (DB_Copy.getDatas("student", "student_id", i).toString().equals(id.toString())) {
                        email = DB_Copy.getDatas("student", "email_address", i).toString();
                        break;
                    }
                }

                return email;
            }
        }));
        requestLists.add(new RequestProcess("getTeacherImage", new ProcessAll() {
            @Override
            public Object run(Object id) {
                String image = "";
                ArrayList<Object> col1 = DB_Copy.getDatas("teacher", "teacher_id");

                for (int i = 0; i < col1.size(); i++) {
                    if (DB_Copy.getDatas("teacher", "teacher_id", i).toString().equals(id.toString())) {
                        image = DB_Copy.getDatas("teacher", "teacher_picture", i).toString();
                        break;
                    }
                }

                return image;
            }
        }));
        requestLists.add(new RequestProcess("getManagerImage", new ProcessAll() {
            @Override
            public Object run(Object id) {
                String image = "";
                ArrayList<Object> col1 = DB_Copy.getDatas("manager", "manager_id");

                for (int i = 0; i < col1.size(); i++) {
                    if (DB_Copy.getDatas("manager", "manager_id", i).toString().equals(id.toString())) {
                        image = DB_Copy.getDatas("manager", "manager_picture", i).toString();
                        break;
                    }
                }

                return image;
            }
        }));
        requestLists.add(new RequestProcess("getAdminImage", new ProcessAll() {
            @Override
            public Object run(Object id) {
                String image = "";
                ArrayList<Object> col1 = DB_Copy.getDatas("admin", "admin_id");

                for (int i = 0; i < col1.size(); i++) {
                    if (DB_Copy.getDatas("admin", "admin_id", i).toString().equals(id.toString())) {
                        image = DB_Copy.getDatas("admin", "admin_picture", i).toString();
                        break;
                    }
                }

                return image;
            }
        }));

        requestLists.add(new RequestProcess("updateTeacher", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                System.out.println("datas : " + datas.length);
                System.out.println("if ees omno");
                if (db.updateTeacher(datas[0], datas[1], datas[2], datas[3], datas[4],
                        datas[5], datas[6], datas[7], datas[8], datas[9], datas[10], datas[11], datas[12], datas[13])) {
                    System.out.println("daraaa");
                    String query = "select * from teacher where teacher_id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                            data.add(rs.getString(5));
                            data.add(rs.getString(6));
                            data.add(rs.getString(7));
                            data.add(rs.getString(8));
                            data.add(rs.getString(9));
                            data.add(rs.getString(10));
                            data.add(rs.getString(11));
                            data.add(rs.getString(12));
                            data.add(rs.getString(13));
                            data.add(rs.getString(14));

                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("teacher", "teacher_id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("teacher", row, data);

                }
                return true;
            }
        }));
//         requestLists.add(new RequestProcess("insertManager", new ProcessAll() {
//
//            @Override
//            public Object run(Object requestDatas) {
//                String[] datas = requestDatas.toString().split("::");
//                ArrayList<Object> data = new ArrayList<>();
//                Object id = null;
//                if (db.insertIntoManager(datas[0],
//                        datas[1],
//                        datas[2],
//                        datas[3],
//                        datas[4],
//                        datas[5],
//                        datas[6],
//                        datas[7],
//                        datas[8],
//                        datas[9],
//                        datas[10],
//                        datas[11])) {
//
//                    try {
//                        String query = "select*from manager order by manager_id desc limit 1";
//                        ResultSet result = db.runQuery(query);
//
//                        if (result.last()) {
//                            data.add(result.getObject(1));
//                            id = result.getObject(1);
//                            data.add(result.getObject(2));
//                            data.add(result.getObject(3));
//                            data.add(result.getObject(4));
//                            data.add(result.getObject(5));
//                            data.add(result.getObject(7));
//                            data.add(result.getObject(6));
//                            data.add(result.getObject(8));
//                            data.add(result.getObject(9));
//                            data.add(result.getObject(10));
//                            data.add(result.getObject(11));
//                            data.add(result.getObject(12));
//                            data.add(result.getObject(13));
//                        }
//
//                        DB_Copy.insertRow("manager", data);
//
//                    } catch (SQLException ex) {
//                    }
//                }
//                return id;
//            }
//        }));
        requestLists.add(new RequestProcess("insertManager", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                ArrayList<Object> data = new ArrayList<>();
                Object id = null;
                if (db.insertIntoManager(datas[0],
                        datas[1],
                        datas[2],
                        datas[3],
                        datas[4],
                        datas[5],
                        datas[6],
                        datas[7],
                        datas[8],
                        datas[9],
                        datas[10],
                        datas[11])) {

                    try {
                        String query = "select*from manager order by manager_id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getObject(1));
                            id = result.getObject(1);
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            data.add(result.getObject(5));
                            data.add(result.getObject(7));
                            data.add(result.getObject(6));
                            data.add(result.getObject(8));
                            data.add(result.getObject(9));
                            data.add(result.getObject(10));
                            data.add(result.getObject(11));
                            data.add(result.getObject(12));
                            data.add(result.getObject(13));
                        }

                        DB_Copy.insertRow("manager", data);

                    } catch (SQLException ex) {
                    }
                }
                return id;
            }
        }));

        requestLists.add(new RequestProcess("insertTeacher", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                ArrayList<Object> data = new ArrayList<>();
                Object id = null;
                if (db.insertIntoTeacher(datas[0],
                        datas[1],
                        datas[2],
                        datas[3],
                        datas[4],
                        datas[5],
                        datas[6],
                        datas[7],
                        datas[8],
                        datas[9],
                        datas[10],
                        datas[11],
                        datas[12])) {

                    try {
                        String query = "select*from teacher order by teacher_id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getObject(1));
                            id = result.getObject(1);
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            data.add(result.getObject(5));
                            data.add(result.getObject(7));
                            data.add(result.getObject(6));
                            data.add(result.getObject(8));
                            data.add(result.getObject(9));
                            data.add(result.getObject(10));
                            data.add(result.getObject(11));
                            data.add(result.getObject(12));
                            data.add(result.getObject(13));
                            data.add(result.getObject(14));
                        }

                        DB_Copy.insertRow("teacher", data);

                    } catch (SQLException ex) {
                    }
                }
                return id;
            }
        }));

        requestLists.add(new RequestProcess("insertStudent", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String[] bagsh_ids = datas[16].split(",");
                System.out.println(datas[16]);
                String nid = "";
                String snid = "";
                if (db.insertIntoStudent(datas[0],
                        datas[1],
                        datas[2],
                        datas[3],
                        datas[4],
                        datas[5],
                        datas[6],
                        datas[7],
                        datas[8],
                        datas[9],
                        datas[10],
                        datas[11],
                        datas[12],
                        datas[13],
                        datas[14],
                        datas[15])) {
                    try {
                        ArrayList<Object> data = new ArrayList<>();
                        String query = "select*from student order by student_id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getObject(1));
                            nid = result.getObject(1).toString();
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            data.add(result.getObject(5));
                            data.add(result.getObject(7));
                            data.add(result.getObject(6));
                            data.add(result.getObject(8));
                            data.add(result.getObject(9));
                            data.add(result.getObject(10));
                            data.add(result.getObject(11));
                            data.add(result.getObject(12));
                            data.add(result.getObject(13));
                            data.add(result.getObject(14));
                            data.add(result.getObject(15));
                            data.add(result.getObject(16));
                            data.add(result.getObject(17));
                        }

                        DB_Copy.insertRow("student", data);

                    } catch (SQLException ex) {
                    }

                    ArrayList<String> inserted = db.insertIntoStudentTeacher2(nid, bagsh_ids);
                    for (String str : inserted) {
                        ArrayList<Object> del = new ArrayList<>();
                        String[] spl = str.split("::");
                        del.add(spl[0]);
                        del.add(spl[1]);
                        del.add(spl[2]);
                        DB_Copy.insertRow("student_teacher", del);
                    }

//                if(db.insertIntoStudentTeacher(nid,datas[16])){
//                    try {
//                        ArrayList<Object> data = new ArrayList<>();
//                        String query = "select*from student_teacher order by id desc limit 1";
//                        ResultSet result = db.runQuery(query);
//
//                        if (result.last()) {
//                            data.add(result.getObject(1));
//                            snid = result.getObject(1).toString();
//                            data.add(result.getObject(2));
//                            data.add(result.getObject(3));
//                        }
//                
//                
//
//                        DB_Copy.insertRow("student_teacher", data);
//
//                    } catch (SQLException ex) {
//                    }
//                }        
                }
                return nid;
            }
        }));

//        requestLists.add(new RequestProcess("insertStudent", new ProcessAll() {
//
//            @Override
//            public Object run(Object requestDatas) {
//                String[] datas = requestDatas.toString().split("::");
//                System.out.println("Something:....");
//                for (String str : datas) {
//                    System.out.print(str + "::");
//                }
//                System.out.println("");
//                String sid = "";
//                String[] bagsh_ids = datas[9].split(",");
//
//                if (db.insertIntoStudent(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6], datas[7], datas[8],
//                        datas[10], datas[11], datas[12], datas[13], datas[14])) {
//                    datas = null;
//
//                    try {
//                        ArrayList<Object> data = new ArrayList<>();
//                        String query = "select * from student order by student_id desc limit 1";
//                        ResultSet result = db.runQuery(query);
//
//                        if (result.last()) {
//                            data.add(result.getObject(1));
//                            sid = result.getObject(1).toString();
//                            data.add(result.getObject(2));
//                            data.add(result.getObject(3));
//                            data.add(result.getObject(4));
//                            data.add(result.getObject(5));
//                            data.add(result.getObject(7));
//                            data.add(result.getObject(6));
//                            data.add(result.getObject(8));
//                            data.add(result.getObject(9));
//                            data.add(result.getObject(10));
//                            data.add(result.getObject(11));
//                            data.add(result.getObject(12));
//                            data.add(result.getObject(13));
//                            data.add(result.getObject(14));
//                            data.add(result.getObject(15));
//                            data.add(result.getObject(16));
//                            data.add(result.getObject(17));
//                            data.add(result.getObject(18));
//                            data.add(result.getObject(19));
//                        }
//
//                        for (String id : bagsh_ids) {
//                            ArrayList<Object> row1 = new ArrayList<>();
//
//                            System.out.println("data.get(0) " + data.get(0) + "id " + id);
//                            if (db.insertIntoStuTeach(null, data.get(0), id)) {
//                                System.out.println("stuteach db insert daraa");
//
//                                String query1 = "select * from student_teacher order by id desc limit 1";
//                                result = db.runQuery(query1);
//                                row1.add("");
//                                row1.add("");
//                                row1.add("");
//                                while (result.last()) {
//
//                                    row1.set(0, result.getObject(1));
//                                    row1.set(1, result.getObject(2));
//                                    row1.set(2, result.getObject(3));
//                                    break;
//                                }
//                            }
//                            DB_Copy.insertRow("student_teacher", row1);
//                        }
//                        bagsh_ids = null;
//
//                        DB_Copy.insertRow("student", data);
//                        data = null;
//
//                    } catch (SQLException ex) {
//                    }
//                }
//                System.out.println(">>>>>>>>>>>>>>>>>>>>" + sid);
//                return sid;
//            }
//        }));
        requestLists.add(new RequestProcess("getStudentProfile", new ProcessAll() {

            @Override
            public Object run(Object username) {

                ArrayList<String> profile = new ArrayList();

                String studentProfile = "";

                ArrayList<Object> reg_numCol = DB_Copy.getDatas("student", "username");

                int i = 0;
                for (; i < reg_numCol.size(); i++) {
                    if (reg_numCol.get(i).toString().equals(username.toString())) {
                        if (((Boolean) DB_Copy.getDatas("manager", "del_flag", i)) == false) {
                            studentProfile = "";
                            String class_id = "";
                            String teacher_id = "";
                            String teachers = "";
                            String elselt_name = "";
                            String teacherName = "";

                            ArrayList<String> teacher_ids = new ArrayList<>();

                            String student_id = DB_Copy.getDatas("student", "student_id", i).toString();
                            String burtgel_code = DB_Copy.getDatas("student", "code", i).toString();
                            String f_name = DB_Copy.getDatas("student", "firstname", i).toString();
                            String l_name = DB_Copy.getDatas("student", "lastname", i).toString();
                            String status = DB_Copy.getDatas("student", "status_id", i).toString();
                            String phone = DB_Copy.getDatas("student", "phone", i).toString();
                            String email = DB_Copy.getDatas("student", "email_address", i).toString();
                            String social_address = DB_Copy.getDatas("student", "social_address", i).toString();
                            String register_number = DB_Copy.getDatas("student", "reg_num", i).toString();
                            String home_address = DB_Copy.getDatas("student", "address", i).toString();

                            String computer_number = DB_Copy.getDatas("student", "com_num", i).toString();

                            String dropped = DB_Copy.getDatas("student", "del_flag", i).toString();
                            String reason = DB_Copy.getDatas("student", "reason", i).toString();
                            String pic = DB_Copy.getDatas("student", "student_pic", i).toString();

                            ArrayList<Object> studentTeacher_studentId = DB_Copy.getDatas("student_teacher", "student_id");
                            ArrayList<Object> studentTeacher_teacherId = DB_Copy.getDatas("student_teacher", "teacher_id");
                            for (int j = 0; j < studentTeacher_studentId.size(); j++) {
                                if (studentTeacher_studentId.get(j).toString().equals(student_id.toString())) {

                                    teacher_id = studentTeacher_teacherId.get(j).toString();
                                    // teachers += teacher_id;
                                    teacher_ids.add(teacher_id);
                                }
                            }

                            ArrayList<Object> teacher_teacherNames = DB_Copy.getDatas("teacher", "firstname");
                            ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");

                            for (int l = 0; l < teacher_ids.size(); l++) {
                                for (int j = 0; j < teacher_teacherId.size(); j++) {

                                    if (teacher_teacherId.get(j).toString().equals(teacher_ids.get(l).toString())) {
                                        teacherName = teacher_teacherNames.get(j).toString();
                                        teachers += teacherName;
                                        teachers += ",";
                                    }
                                }
                            }

                            ArrayList<Object> elseltiinPlan_Id = DB_Copy.getDatas("Elseltiin_plan", "id");
                            ArrayList<Object> elseltiinPlan_Name = DB_Copy.getDatas("Elseltiin_plan", "name");
                            for (int j = 0; j < elseltiinPlan_Id.size(); j++) {
                                if (elseltiinPlan_Id.get(j).equals(DB_Copy.getDatas("student", "elseltiin_id", i))) {
                                    elselt_name = elseltiinPlan_Name.get(j).toString();
                                }
                            }

                            String status_name = "";
                            ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                            ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                            for (int j = 0; j < statusTorol_statusId.size(); j++) {
                                if (statusTorol_statusId.get(j).toString().equals(status)) {
                                    status_name = statusTorol_statusName.get(j).toString();
                                }
                            }

                            studentProfile += student_id;
                            studentProfile += "::";
                            studentProfile += burtgel_code;
                            studentProfile += "::";
                            studentProfile += f_name;
                            studentProfile += "::";
                            studentProfile += l_name;
                            studentProfile += "::";
                            studentProfile += status_name;
                            studentProfile += "::";
                            studentProfile += phone;
                            studentProfile += "::";
                            studentProfile += email;
                            studentProfile += "::";
                            studentProfile += social_address;
                            studentProfile += "::";
                            studentProfile += register_number;
                            studentProfile += "::";
                            studentProfile += home_address;
                            studentProfile += "::";
                            studentProfile += teachers;
                            studentProfile += "::";
                            studentProfile += computer_number;
                            studentProfile += "::";
                            studentProfile += elselt_name;
                            studentProfile += "::";
                            studentProfile += dropped;
                            studentProfile += "::";
                            studentProfile += reason;
                            studentProfile += "::";
                            studentProfile += pic;

//                        profile.add(studentProfile);
                            System.out.println("reg_num" + register_number);
//                        }else{System.out.println("2dahi if");}   
                            break;
                        }
                    }
                }
                return studentProfile;
            }
        }));
        //---------------REmove-Recover------BEgin-------------------------------------------------------------------------//
        requestLists.add(new RequestProcess("flagStudent", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                String[] datas = requestDatas.toString().split("::");

                ArrayList<Object> data = new ArrayList<>();
                int row = 0;
                if (db.flagStudent(datas[0], datas[1])) {
                    try {
                        String query = "select * from student where  student_id = " + datas[0] + "";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getObject(1));
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            data.add(result.getObject(5));
                            data.add(result.getObject(6));
                            data.add(result.getObject(7));
                            data.add(result.getObject(8));
                            data.add(result.getObject(9));
                            data.add(result.getObject(10));
                            data.add(result.getObject(11));
                            data.add(result.getObject(12));
                            data.add(result.getObject(13));
                            data.add(result.getObject(14));
                            data.add(result.getObject(15));
                            data.add(result.getObject(16));
                            data.add(result.getObject(17));
                        }
                        ArrayList<Object> baganuud = DB_Copy.getDatas("student", "student_id");
                        for (int i = 0; i < baganuud.size(); i++) {
                            if (Integer.parseInt(baganuud.get(i).toString()) == Integer.parseInt(datas[0])) {
                                row = i;
                                break;
                            }
                        }
                        DB_Copy.removeAt("student", row);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                return true;
            }
        }));
        requestLists.add(new RequestProcess("flagTeacher", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                String[] datas = requestDatas.toString().split("::");

                ArrayList<Object> data = new ArrayList<>();
                int row = 0;
                if (db.flagTeacher(datas[0], datas[1])) {
                    try {
                        String query = "select * from teacher where teacher_id= " + datas[0] + "";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getObject(1));
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            data.add(result.getObject(5));
                            data.add(result.getObject(6));
                            data.add(result.getObject(7));
                            data.add(result.getObject(8));
                            data.add(result.getObject(9));
                            data.add(result.getObject(10));
                            data.add(result.getObject(11));
                            data.add(result.getObject(12));
                            data.add(result.getObject(13));
                        }
                        ArrayList<Object> baganuud = DB_Copy.getDatas("teacher", "teacher_id");
                        for (int i = 0; i < baganuud.size(); i++) {
                            if (baganuud.get(i).equals(datas[0])) {
                                row = i;
                                break;
                            }
                        }
                        DB_Copy.removeAt("teacher", row);

                    } catch (SQLException ex) {
                    }
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("flagManager", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                String[] datas = requestDatas.toString().split("::");

                ArrayList<Object> data = new ArrayList<>();
                int row = 0;
                if (db.flagManager(datas[0], datas[1])) {
                    try {
                        String query = "select * from manager where manager_id= " + datas[0] + "";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getObject(1));
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            data.add(result.getObject(5));
                            data.add(result.getObject(6));
                            data.add(result.getObject(7));
                            data.add(result.getObject(8));
                            data.add(result.getObject(9));
                            data.add(result.getObject(10));
                            data.add(result.getObject(11));
                            data.add(result.getObject(12));
                            data.add(result.getObject(13));
                        }
                        ArrayList<Object> baganuud = DB_Copy.getDatas("manager", "manager_id");
                        for (int i = 0; i < baganuud.size(); i++) {
                            if (baganuud.get(i).equals(datas[0])) {
                                row = i;
                                break;
                            }
                        }
                        DB_Copy.removeAt("manager", row);

                    } catch (SQLException ex) {
                    }
                }
                return true;
            }
        }));
        requestLists.add(new RequestProcess("flagAdmin", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                String[] datas = requestDatas.toString().split("::");

                ArrayList<Object> data = new ArrayList<>();
                int row = -1;
                if (db.flagAdmin(datas[0], datas[1])) {
                    try {
                        String query = "select * from admin where admin_id= " + datas[0] + "";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getObject(1));
                            data.add(result.getObject(2));
                            data.add(result.getObject(3));
                            data.add(result.getObject(4));
                            data.add(result.getObject(5));
                            data.add(result.getObject(6));
                            data.add(result.getObject(7));
                            data.add(result.getObject(8));
                            data.add(result.getObject(9));
                            data.add(result.getObject(10));
                            data.add(result.getObject(11));
                            data.add(result.getObject(12));
                            data.add(result.getObject(13));
                        }
                        ArrayList<Object> baganuud = DB_Copy.getDatas("admin", "admin_id");
                        for (int i = 0; i < baganuud.size(); i++) {
                            if (Integer.parseInt(baganuud.get(i).toString()) == Integer.parseInt(datas[0])) {
                                row = i;
                                break;
                            }
                        }
                        DB_Copy.removeAt("admin", row);

                    } catch (SQLException ex) {
                    }
                }
                return true;
            }
        }));

        //---------------REmove-Recover------END-------------------------------------------------------------------------//
        //----------------------DABRAL -------BEGIN--------------------------------------------------------------------
        requestLists.add(new RequestProcess("login", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String username = requestDatas.toString().split("::")[0];
                String password = requestDatas.toString().split("::")[1];
                String clientType = requestDatas.toString().split("::")[2];

                ArrayList<Object> usernames;
                ArrayList<Object> passwords;
                String type;

                switch (clientType) {
                    case "admin":
                        usernames = DB_Copy.getDatas("admin", "username");
                        passwords = DB_Copy.getDatas("admin", "password");

                        type = "admin";

                        for (int i = 0; i < usernames.size(); i++) {
                            if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                                return type + "::true";
                            }
                        }

                        break;
                    case "manager":

                        usernames = DB_Copy.getDatas("manager", "username");
                        passwords = DB_Copy.getDatas("manager", "password");

                        type = "manager";

                        for (int i = 0; i < usernames.size(); i++) {
                            if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                                return type + "::true";
                            }
                        }

                        break;
                    case "teacher":

                        usernames = DB_Copy.getDatas("teacher", "username");
                        passwords = DB_Copy.getDatas("teacher", "password");

                        type = "teacher";

                        for (int i = 0; i < usernames.size(); i++) {
                            if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                                return type + "::true";
                            }
                        }

                        break;
                }
                return "::false";
            }
        }));

        requestLists.add(new RequestProcess("updateStudent", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                ArrayList<Object> insertdata = new ArrayList<>();

                if (db.updateStudent(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5],
                        datas[6], datas[7], datas[8], datas[9], datas[10],
                        datas[11], datas[12], datas[13], datas[14], datas[15]
                )) {
                    try {
                        String query = "select * from student where student_id = " + datas[0] + "";
                        ResultSet result = db.runQuery(query);

                        while (result.last()) {
                            insertdata.add(result.getObject(1));
                            insertdata.add(result.getObject(2));
                            insertdata.add(result.getObject(3));
                            insertdata.add(result.getObject(4));
                            insertdata.add(result.getObject(5));
                            insertdata.add(result.getObject(6));
                            insertdata.add(result.getObject(7));
                            insertdata.add(result.getObject(8));
                            insertdata.add(result.getObject(9));
                            insertdata.add(result.getObject(10));
                            insertdata.add(result.getObject(11));
                            insertdata.add(result.getObject(12));
                            insertdata.add(result.getObject(13));
                            insertdata.add(result.getObject(14));
                            insertdata.add(result.getObject(15));
                            insertdata.add(result.getObject(16));
                            insertdata.add(result.getObject(17));
                            break;
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    ArrayList<Object> baganuud = DB_Copy.getDatas("student", "student_id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("student", row, insertdata);
                }

                db.deleteFromStudentTeacher(datas[0]);
                String[] datasTeacherIds = datas[10].split(",");
                ArrayList<String> inserted = db.insertIntoStudentTeacher(datas[0], datasTeacherIds);

                for (Table table : DB_Copy.newTables) {
                    if (table.getTableName().equals("student_teacher")) {
//                        table.setDatas(null);
                        for (Column col : table.getDatas()) {
                            if (col.getColumnName().equals("student_id")) {
                                for (int i = 0; i < col.getDatas().size(); i++) {
                                    if (Integer.parseInt(col.getDatas().get(i).toString()) == Integer.parseInt(datas[0])) {
                                        DB_Copy.removeAt("student_teacher", i);
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                for (String str : inserted) {
                    ArrayList<Object> del = new ArrayList<>();
                    String[] spl = str.split("::");
                    del.add(spl[0]);
                    del.add(spl[1]);
                    del.add(spl[2]);
                    DB_Copy.insertRow("student_teacher", del);
                }

                return true;
            }
        }));
        requestLists.add(new RequestProcess("updateManager", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                System.out.println("manager_id-->" + datas[0]);
                System.out.println("reg_num-->" + datas[1]);
                System.out.println("lastname-->" + datas[2]);
                System.out.println("firstname-->" + datas[3]);
                System.out.println("status-->" + datas[4]);
                System.out.println("phone-->" + datas[5]);
                System.out.println("emailAddress-->" + datas[6]);
                System.out.println("socialAddress-->" + datas[7]);
                System.out.println("address-->" + datas[8]);
                System.out.println("manager_picture-->" + datas[9]);
                System.out.println("username-->" + datas[10]);
                System.out.println("pass-->" + datas[11]);
                System.out.println("delFlag-->" + datas[12]);
                db.updateManager(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5],
                        datas[6], datas[7], datas[8], datas[9], datas[10],
                        datas[11], datas[12]);
                String query = "select * from manager where manager_id = " + datas[0] + "";
                ResultSet rs = null;
                ArrayList<Object> data = new ArrayList<>();
                rs = db.runQuery(query);

                try {
                    while (rs.next()) {
                        data.add(rs.getString(1));
                        data.add(rs.getString(2));
                        data.add(rs.getString(3));
                        data.add(rs.getString(4));
                        data.add(rs.getString(5));
                        data.add(rs.getString(6));
                        data.add(rs.getString(7));
                        data.add(rs.getString(8));
                        data.add(rs.getString(9));
                        data.add(rs.getString(10));
                        data.add(rs.getString(11));
                        data.add(rs.getString(12));
                        data.add(rs.getString(13));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                ArrayList<Object> baganuud = DB_Copy.getDatas("manager", "manager_id");
                int row = 0;
                for (row = 0; row < baganuud.size(); row++) {
                    if (baganuud.get(row).toString().equals(datas[0])) {
                        break;
                    }
                }
                DB_Copy.updateRow("manager", row, data);
                return true;
            }
        }));

        requestLists.add(new RequestProcess("getElseltPlan", new ProcessAll() {
            @Override
            public Object run(Object requestDatas) {
                String query = "select * from elseltiin_plan";
                ResultSet rs = db.runQuery(query);

                ArrayList<String> data = new ArrayList<>();

                ArrayList<Object> idCol = DB_Copy.getDatas("elseltiin_plan", "id");
                String str = "";

                int i = 0;
                for (; i < idCol.size(); i++) {
                    str = DB_Copy.getDatas("elseltiin_plan", "id", i).toString();
                    str += "::";
                    str += DB_Copy.getDatas("elseltiin_plan", "name", i).toString();
                    str += "::";
                    str += DB_Copy.getDatas("elseltiin_plan", "descr", i).toString();
                    str += "::";
                    str += DB_Copy.getDatas("elseltiin_plan", "start_ognoo", i).toString();
                    str += "::";
                    str += DB_Copy.getDatas("elseltiin_plan", "end_ognoo", i).toString();

                    data.add(str);
                }
                return data;
            }
        }));

        requestLists.add(new RequestProcess("updateElseltPlan", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                db.updateElseltPlan(datas[0], datas[1], datas[2], datas[3], datas[4]);
                String query = "select * from elseltiin_plan where id = " + datas[0] + "";
                ResultSet rs = null;
                ArrayList<Object> data = new ArrayList<>();
                rs = db.runQuery(query);

                try {
                    while (rs.next()) {
                        data.add(rs.getString(1));
                        data.add(rs.getString(2));
                        data.add(rs.getString(3));
                        data.add(rs.getString(4));
                        data.add(rs.getString(5));
                    }
                } catch (SQLException ex) {
                }

                ArrayList<Object> baganuud = DB_Copy.getDatas("elseltiin_plan", "id");
                int row = 0;
                for (row = 0; row < baganuud.size(); row++) {
                    if (baganuud.get(row).toString().equals(datas[0])) {
                        break;
                    }
                }

                System.out.println("row-----------------" + row);
                DB_Copy.updateRow("elseltiin_plan", row, data);
                return true;
            }
        }));

        requestLists.add(new RequestProcess("deleteElseltPlan", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                System.out.println("before if>>>>>>>" + o1);
                if (db.deleteElseltPlan(o1)) {
                    System.out.println("after if");
                    ArrayList<Object> row = DB_Copy.getDatas("elseltiin_plan", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("elseltiin_plan", i);
                            break;
                        }
                    }
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("insertStatus", new ProcessAll() {
            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                String o2 = datas[1];

                ArrayList<Object> data = new ArrayList<>();
                String id = "";
                if (db.insertIntoStatus(o1, o2)) {

                    try {
                        String query = "select * from status_torol order by status_id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getString(1));
                            data.add(result.getString(2));
                            data.add(result.getString(3));
                            id = result.getString(1);
                        }
                        DB_Copy.insertRow("status_torol", data);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                return id;
            }
        }));
        requestLists.add(new RequestProcess("insertElseltPlan", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                String o2 = datas[1];
                String o3 = datas[2];
                String o4 = datas[3];

                ArrayList<Object> data = new ArrayList<>();
                String id = "";
                if (db.insertElseltPlan(o1, o2, o3, o4)) {

                    try {
                        String query = "select*from elseltiin_plan order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getString(1));
                            data.add(result.getString(2));
                            data.add(result.getString(3));
                            data.add(result.getString(4));
                            data.add(result.getString(5));
                            id = result.getString(1);
                        }
                        DB_Copy.insertRow("elseltiin_plan", data);
                    } catch (SQLException ex) {
                    }
                }
                return id;
            }
        }));

        //----------------------DABRAL -------END--------------------------------------------------------------------
        //------------------------RAMAL ================== BEGIN ==================================================
        requestLists.add(new RequestProcess("getAllStudentProfile", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                System.out.println("run method starting");
                ArrayList<String> profile = new ArrayList<>();
                String studentProfile = "";

//                ArrayList<Object> first_nameCol = DB_Copy.getDatas("student", "firstname");
                for (int i = 0; i < DB_Copy.getDatas("student", "student_id").size(); i++) {
                    System.out.println("" + DB_Copy.getDatas("student", "del_flag", i).toString());
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", i).toString()) == 0) {
                        studentProfile = "";
                        String class_id = "";
                        String teacher_id = "";
                        String teachers = "";
                        String elselt_name = "";
                        String teacherName = "";

                        ArrayList<String> teacher_ids = new ArrayList<>();

                        String student_id = DB_Copy.getDatas("student", "student_id", i).toString();
                        String burtgel_code = DB_Copy.getDatas("student", "code", i).toString();
                        String f_name = DB_Copy.getDatas("student", "firstname", i).toString();
                        String l_name = DB_Copy.getDatas("student", "lastname", i).toString();
                        String status = DB_Copy.getDatas("student", "status_id", i).toString();
                        String phone = DB_Copy.getDatas("student", "phone", i).toString();
                        String email = DB_Copy.getDatas("student", "email_address", i).toString();
                        String social_address = DB_Copy.getDatas("student", "social_address", i).toString();
                        String register_number = DB_Copy.getDatas("student", "reg_num", i).toString();
                        String home_address = DB_Copy.getDatas("student", "address", i).toString();

                        String computer_number = DB_Copy.getDatas("student", "com_num", i).toString();

                        String dropped = DB_Copy.getDatas("student", "del_flag", i).toString();
                        String reason = DB_Copy.getDatas("student", "reason", i).toString();
                        String pic = DB_Copy.getDatas("student", "student_pic", i).toString();

                        ArrayList<Object> studentTeacher_studentId = DB_Copy.getDatas("student_teacher", "student_id");
                        ArrayList<Object> studentTeacher_teacherId = DB_Copy.getDatas("student_teacher", "teacher_id");
                        for (int j = 0; j < studentTeacher_studentId.size(); j++) {
                            if (studentTeacher_studentId.get(j).toString().equals(student_id.toString())) {

                                teacher_id = studentTeacher_teacherId.get(j).toString();
                                teachers += teacher_id;
                                teachers += ",";
//                                teacher_ids.add(teacher_id);
                            }
                        }

//                        ArrayList<Object> teacher_teacherNames = DB_Copy.getDatas("teacher", "firstname");
//                        ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
//
//                        for (int l = 0; l < teacher_ids.size(); l++) {
//                            for (int j = 0; j < teacher_teacherId.size(); j++) {
//
//                                if (teacher_teacherId.get(j).toString().equals(teacher_ids.get(l).toString())) {
//                                    teacherName = teacher_teacherNames.get(j).toString();
//                                    teachers += teacherName;
//                                    teachers += ",";
//                                }
//                            }
//                        }
                        System.out.println("teacher" + teachers);

                        ArrayList<Object> elseltiinPlan_Id = DB_Copy.getDatas("elseltiin_plan", "id");
                        ArrayList<Object> elseltiinPlan_Name = DB_Copy.getDatas("elseltiin_plan", "name");
                        for (int j = 0; j < elseltiinPlan_Id.size(); j++) {
                            if (elseltiinPlan_Id.get(j).equals(DB_Copy.getDatas("student", "elseltiin_id", i))) {
                                elselt_name = elseltiinPlan_Name.get(j).toString();
                            }
                        }

                        String status_name = "";
                        ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                        ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                        for (int j = 0; j < statusTorol_statusId.size(); j++) {
                            if (statusTorol_statusId.get(j).toString().equals(status)) {
                                status_name = statusTorol_statusName.get(j).toString();
                            }
                        }

                        studentProfile += student_id;
                        studentProfile += "::";
                        studentProfile += burtgel_code;
                        studentProfile += "::";
                        studentProfile += f_name;
                        studentProfile += "::";
                        studentProfile += l_name;
                        studentProfile += "::";
                        studentProfile += status_name;
                        studentProfile += "::";
                        studentProfile += phone;
                        studentProfile += "::";
                        studentProfile += email;
                        studentProfile += "::";
                        studentProfile += social_address;
                        studentProfile += "::";
                        studentProfile += register_number;
                        studentProfile += "::";
                        studentProfile += home_address;
                        studentProfile += "::";
                        studentProfile += teachers;
                        studentProfile += "::";
                        studentProfile += computer_number;
                        studentProfile += "::";
                        studentProfile += elselt_name;
                        studentProfile += "::";
                        studentProfile += dropped;
                        studentProfile += "::";
                        studentProfile += reason;
                        studentProfile += "::";
                        studentProfile += pic;
                        profile.add(studentProfile);
                        System.out.println("studProf" + studentProfile);
                    }
                }

                return profile;

            }

        }));

        requestLists.add(new RequestProcess("getStudentProfile", new ProcessAll() {

            @Override
            public Object run(Object reg_num) {

                ArrayList<String> profile = new ArrayList();

                String studentProfile = "";

                ArrayList<Object> reg_numCol = DB_Copy.getDatas("student", "reg_num");

                int i = 0;
                for (; i < reg_numCol.size(); i++) {

                    if (reg_numCol.get(i).equals(reg_num)) {
                        if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", i).toString()) == 0) {
                            studentProfile = "";
                            String class_id = "";
                            String teacher_id = "";
                            String teachers = "";
                            String elselt_name = "";
                            String teacherName = "";

                            ArrayList<String> teacher_ids = new ArrayList<>();

                            String student_id = DB_Copy.getDatas("student", "student_id", i).toString();
                            String burtgel_code = DB_Copy.getDatas("student", "code", i).toString();
                            String f_name = DB_Copy.getDatas("student", "firstname", i).toString();
                            String l_name = DB_Copy.getDatas("student", "lastname", i).toString();
                            String status = DB_Copy.getDatas("student", "status_id", i).toString();
                            String phone = DB_Copy.getDatas("student", "phone", i).toString();
                            String email = DB_Copy.getDatas("student", "email_address", i).toString();
                            String social_address = DB_Copy.getDatas("student", "social_address", i).toString();
                            String register_number = DB_Copy.getDatas("student", "reg_num", i).toString();
                            String home_address = DB_Copy.getDatas("student", "address", i).toString();

                            String computer_number = DB_Copy.getDatas("student", "com_num", i).toString();

                            String dropped = DB_Copy.getDatas("student", "del_flag", i).toString();
                            String reason = DB_Copy.getDatas("student", "reason", i).toString();
                            String pic = DB_Copy.getDatas("student", "student_pic", i).toString();

                            ArrayList<Object> studentTeacher_studentId = DB_Copy.getDatas("student_teacher", "student_id");
                            ArrayList<Object> studentTeacher_teacherId = DB_Copy.getDatas("student_teacher", "teacher_id");
                            for (int j = 0; j < studentTeacher_studentId.size(); j++) {
                                if (studentTeacher_studentId.get(j).toString().equals(student_id.toString())) {

                                    teacher_id = studentTeacher_teacherId.get(j).toString();
                                    teachers += teacher_id;
                                    teachers += ",";
//                                    teacher_ids.add(teacher_id);
                                }
                            }

//                            ArrayList<Object> teacher_teacherNames = DB_Copy.getDatas("teacher", "firstname");
//                            ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
//
//                            for (int l = 0; l < teacher_ids.size(); l++) {
//                                for (int j = 0; j < teacher_teacherId.size(); j++) {
//
//                                    if (teacher_teacherId.get(j).toString().equals(teacher_ids.get(l).toString())) {
//                                        teacherName = teacher_teacherNames.get(j).toString();
//                                        teachers += teacherName;
//                                        teachers += ",";
//                                    }
//                                }
//                            }
                            ArrayList<Object> elseltiinPlan_Id = DB_Copy.getDatas("elseltiin_plan", "id");
                            ArrayList<Object> elseltiinPlan_Name = DB_Copy.getDatas("elseltiin_plan", "name");
                            for (int j = 0; j < elseltiinPlan_Id.size(); j++) {
                                if (elseltiinPlan_Id.get(j).equals(DB_Copy.getDatas("student", "elseltiin_id", i))) {
                                    elselt_name = elseltiinPlan_Name.get(j).toString();
                                }
                            }

                            String status_name = "";
                            ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                            ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                            for (int j = 0; j < statusTorol_statusId.size(); j++) {
                                if (statusTorol_statusId.get(j).toString().equals(status)) {
                                    status_name = statusTorol_statusName.get(j).toString();
                                }
                            }

                            studentProfile += student_id;
                            studentProfile += "::";
                            studentProfile += burtgel_code;
                            studentProfile += "::";
                            studentProfile += f_name;
                            studentProfile += "::";
                            studentProfile += l_name;
                            studentProfile += "::";
                            studentProfile += status_name;
                            studentProfile += "::";
                            studentProfile += phone;
                            studentProfile += "::";
                            studentProfile += email;
                            studentProfile += "::";
                            studentProfile += social_address;
                            studentProfile += "::";
                            studentProfile += register_number;
                            studentProfile += "::";
                            studentProfile += home_address;
                            studentProfile += "::";
                            studentProfile += teachers;
                            studentProfile += "::";
                            studentProfile += computer_number;
                            studentProfile += "::";
                            studentProfile += elselt_name;
                            studentProfile += "::";
                            studentProfile += dropped;
                            studentProfile += "::";
                            studentProfile += reason;
                            studentProfile += "::";
                            studentProfile += pic;

                            profile.add(studentProfile);
                            System.out.println("reg_num" + register_number);
//                        }else{System.out.println("2dahi if");}   
                        }
                    }
                }
                return profile;
            }
        }));
        requestLists.add(new RequestProcess("getManagerProfile", new ProcessAll() {

            @Override
            public Object run(Object username) {
                ArrayList<String> profile = new ArrayList<>();
                String managerProfile = "";
                System.out.println("Username :: ___ " + username.toString());
                ArrayList<Object> usernameCol = DB_Copy.getDatas("manager", "username");

                for (int i = 0; i < usernameCol.size(); i++) {
                    managerProfile = "";
                    if (usernameCol.get(i).toString().equals(username.toString())) {
                        System.out.println(DB_Copy.getDatas("manager", "del_flag", i));
                        if (Integer.parseInt((DB_Copy.getDatas("manager", "del_flag", i).toString())) == 0) {

                            String manager_id = DB_Copy.getDatas("manager", "manager_id", i).toString();
                            String reg_num = DB_Copy.getDatas("manager", "reg_num", i).toString();
                            String l_name = DB_Copy.getDatas("manager", "lastname", i).toString();
                            String f_name = DB_Copy.getDatas("manager", "firstname", i).toString();
                            String status = DB_Copy.getDatas("manager", "status_id", i).toString();
                            /*bagshiin zaah hicheeliig end bich*/
                            String phone = DB_Copy.getDatas("manager", "phone", i).toString();
                            String email = DB_Copy.getDatas("manager", "email_address", i).toString();
                            String social_address = DB_Copy.getDatas("manager", "social_address", i).toString();
                            String home_address = DB_Copy.getDatas("manager", "address", i).toString();
                            String dropped = DB_Copy.getDatas("manager", "del_flag", i).toString();
                            String pic = DB_Copy.getDatas("manager", "manager_picture", i).toString();
                            String user_name = DB_Copy.getDatas("manager", "username", i).toString();
                            String password = DB_Copy.getDatas("manager", "password", i).toString();

                            String status_name = "";
                            ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                            ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                            for (int j = 0; j < statusTorol_statusId.size(); j++) {
                                if (statusTorol_statusId.get(j).toString().equals(status)) {
                                    status_name = statusTorol_statusName.get(j).toString();
                                }
                            }

                            managerProfile += manager_id;
                            managerProfile += "::";
                            managerProfile += reg_num;
                            managerProfile += "::";
                            managerProfile += l_name;
                            managerProfile += "::";
                            managerProfile += f_name;
                            managerProfile += "::";
                            managerProfile += status_name;
                            managerProfile += "::";
                            managerProfile += phone;
                            managerProfile += "::";
                            managerProfile += email;
                            managerProfile += "::";
                            managerProfile += social_address;
                            managerProfile += "::";
                            managerProfile += home_address;
                            managerProfile += "::";
                            managerProfile += pic;
                            managerProfile += "::";
                            managerProfile += dropped;
                            managerProfile += "::";
                            managerProfile += password;
                            managerProfile += "::";
                            managerProfile += user_name;
                            break;

//                            profile.add(managerProfile);
                        }
                    }
                }
                System.out.println("Manager Profile: ****************");
                System.out.println(managerProfile);
                System.out.println("Manager Profile End");
                return managerProfile;
            }
        }));

        requestLists.add(new RequestProcess("getAllManagerProfile", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                ArrayList<String> profile = new ArrayList<>();
                String managerProfile = "";

//                ArrayList<Object> reg_numCol = DB_Copy.getDatas("manager", "reg_num");
                for (int i = 0; i < DB_Copy.getDatas("manager", "manager_id").size(); i++) {

                    managerProfile = "";

                    if ((DB_Copy.getDatas("manager", "del_flag", i).toString()).equals("false")) {

                        String manager_id = DB_Copy.getDatas("manager", "manager_id", i).toString();
                        String reg_num = DB_Copy.getDatas("manager", "reg_num", i).toString();
                        String l_name = DB_Copy.getDatas("manager", "lastname", i).toString();
                        String f_name = DB_Copy.getDatas("manager", "firstname", i).toString();
                        String status = DB_Copy.getDatas("manager", "status_id", i).toString();
                        String phone = DB_Copy.getDatas("manager", "phone", i).toString();
                        String email = DB_Copy.getDatas("manager", "email_address", i).toString();
                        String social_address = DB_Copy.getDatas("manager", "social_address", i).toString();
                        String home_address = DB_Copy.getDatas("manager", "address", i).toString();
                        String dropped = DB_Copy.getDatas("manager", "del_flag", i).toString();
                        String pic = DB_Copy.getDatas("manager", "manager_picture", i).toString();
                        String user_name = DB_Copy.getDatas("manager", "username", i).toString();
                        String password = DB_Copy.getDatas("manager", "password", i).toString();

                        String status_name = "";
                        ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                        ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                        for (int j = 0; j < statusTorol_statusId.size(); j++) {
                            if (statusTorol_statusId.get(j).toString().equals(status)) {
                                status_name = statusTorol_statusName.get(j).toString();
                            }
                        }

                        managerProfile += manager_id;
                        managerProfile += "::";
                        managerProfile += reg_num;
                        managerProfile += "::";
                        managerProfile += l_name;
                        managerProfile += "::";
                        managerProfile += f_name;
                        managerProfile += "::";
                        managerProfile += status_name;
                        managerProfile += "::";
                        managerProfile += phone;
                        managerProfile += "::";
                        managerProfile += email;
                        managerProfile += "::";
                        managerProfile += social_address;
                        managerProfile += "::";
                        managerProfile += home_address;
                        managerProfile += "::";
                        managerProfile += pic;
                        managerProfile += "::";
                        managerProfile += dropped;
                        managerProfile += "::";
                        managerProfile += user_name;
                        managerProfile += "::";
                        managerProfile += password;
//                        profile.add(managerProfile);

                    }

                }
                return managerProfile;
            }
        }));

        requestLists.add(new RequestProcess("getServerDate", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String datet = "";

                datet = Instant.now().toString();
                System.out.println("sdkjlsdkjdfskjsdfkjl" + datet);

                return datet;
            }
        }));
        requestLists.add(new RequestProcess("getAllTeacherProfile", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                ArrayList<String> profile = new ArrayList<>();

                ArrayList<String> types = new ArrayList<>();
                String teacherProfile = "";
                String names = "";

//                ArrayList<Object> first_nameCol = DB_Copy.getDatas("teacher", "firstname");
                for (int i = 0; i < DB_Copy.getDatas("teacher", "teacher_id").size(); i++) {
                    teacherProfile = "";
                    if (Integer.parseInt(DB_Copy.getDatas("teacher", "del_flag", i).toString()) == 0) {
                        String teacher_id = DB_Copy.getDatas("teacher", "teacher_id", i).toString();
                        String reg_num = DB_Copy.getDatas("teacher", "reg_num", i).toString();
                        String l_name = DB_Copy.getDatas("teacher", "lastname", i).toString();
                        String f_name = DB_Copy.getDatas("teacher", "firstname", i).toString();
                        String status = DB_Copy.getDatas("teacher", "status_id", i).toString();
                        String type = DB_Copy.getDatas("teacher", "class_type", i).toString();
                        String phone = DB_Copy.getDatas("teacher", "phone", i).toString();
                        String email = DB_Copy.getDatas("teacher", "email_address", i).toString();
                        String social_address = DB_Copy.getDatas("teacher", "social_address", i).toString();
                        String home_address = DB_Copy.getDatas("teacher", "address", i).toString();
                        String dropped = DB_Copy.getDatas("teacher", "del_flag", i).toString();
                        String pic = DB_Copy.getDatas("teacher", "teacher_picture", i).toString();
                        String user_name = DB_Copy.getDatas("teacher", "username", i).toString();
                        String password = DB_Copy.getDatas("teacher", "password", i).toString();

                        String status_name = "";
                        ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                        ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                        for (int j = 0; j < statusTorol_statusId.size(); j++) {
                            if (statusTorol_statusId.get(j).toString().equals(status)) {
                                status_name = statusTorol_statusName.get(j).toString();
                            }
                        }

                        teacherProfile = teacher_id;
                        teacherProfile += "::";
                        teacherProfile += reg_num;
                        teacherProfile += "::";
                        teacherProfile += l_name;
                        teacherProfile += "::";
                        teacherProfile += f_name;
                        teacherProfile += "::";
                        teacherProfile += status_name;
                        teacherProfile += "::";
                        teacherProfile += type;
                        teacherProfile += "::";
                        teacherProfile += phone;
                        teacherProfile += "::";
                        teacherProfile += email;
                        teacherProfile += "::";
                        teacherProfile += social_address;
                        teacherProfile += "::";
                        teacherProfile += home_address;
                        teacherProfile += "::";
                        teacherProfile += dropped;
                        teacherProfile += "::";
                        teacherProfile += pic;
                        teacherProfile += "::";
                        teacherProfile += user_name;
                        teacherProfile += "::";
                        teacherProfile += password;
                        profile.add(teacherProfile);
                        System.out.println(">>>>>>>>>>>>>>>>>" + teacherProfile);
                    }
                }
                return profile;
            }
        }));

//        requestLists.add(new RequestProcess("getStatus", new ProcessAll() {
//
//            @Override
//            public Object run(Object requestDatas) {
//                ArrayList<Object> response = new ArrayList<>();
//                ArrayList<Object> idCol = DB_Copy.getDatas("status_torol", "status_id");
//                String str = "";
//                int i = 0;
//                for(;i<idCol.size();i++){
//                    str = DB_Copy.getDatas("status_torol", "status_id", i).toString();
//                    str += "::";
//                    str += DB_Copy.getDatas("status_torol", "status_name", i).toString();
//                    str += "::";
//                    str += DB_Copy.getDatas("status_torol", "type", i).toString();
//                    response.add(str);
//                    System.out.println(">>>>>>>>>>>"+str);
//                }
//                return response;
//            }
//        }));
        requestLists.add(new RequestProcess("updateStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] data = requestDatas.toString().split("::");
                db.updateStatus(data[0], data[1], data[2], data[3]);

                String query = "select * from status_torol where status_id = " + data[3] + "";
                ResultSet rs = null;
                ArrayList<Object> data1 = new ArrayList<>();
                rs = db.runQuery(query);
                try {
                    while (rs.next()) {
                        data1.add(rs.getString(1));
                        data1.add(rs.getString(2));
                        data1.add(rs.getString(3));
                    }
                } catch (SQLException ex) {
                    // Logger.getLogger(ReqFilter.class.getName()).log(Level.SEVERE, null, ex);
                }
                ArrayList<Object> idCol = DB_Copy.getDatas("status_torol", "status_id");
                int i = 0;
                for (i = 0; i < idCol.size(); i++) {
                    if (idCol.get(i).toString().equals(data[3]));
                    break;
                }
                DB_Copy.updateRow("status_torol", i, data1);

                return true;
            }
        }));

        requestLists.add(new RequestProcess("deleteStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String did = requestDatas.toString();

                db.deleteFromStatusTorol(did);

                ArrayList<Object> idCol = DB_Copy.getDatas("status_torol", "status_id");
                int i = 0;
                for (i = 0; i < idCol.size(); i++) {
                    if (idCol.get(i).toString().equals(did));
                    break;
                }
                DB_Copy.removeAt("status_torol", i);

                return true;
            }
        }));

        requestLists.add(new RequestProcess("getStatus", new ProcessAll() {

            @Override
            public Object run(Object status_type) {
                String type = status_type.toString();
                String hi = "";
                int size = DB_Copy.getDatas("status_torol", "status_id").size();
                ArrayList<String> lists = new ArrayList<>();
                switch (type) {

                    case "admin":
                        for (int i = 0; i < size; i++) {
                            if (type.equals(DB_Copy.getDatas("status_torol", "type").get(i).toString())) {
                                String str = DB_Copy.getDatas("status_torol", "status_id").get(i).toString() + "::" + DB_Copy.getDatas("status_torol", "status_name").get(i).toString();
                                lists.add(str);
                            }
                        }
                        return lists;
//                        for (int i = 0; i < lists.size(); i++) {
//                            hi += lists.get(i);
//                            hi += (i + 1 == lists.size()) ? "" : "::";
//                        }

                    case "manager":
                        for (int i = 0; i < size; i++) {
                            if (type.equals(DB_Copy.getDatas("status_torol", "type").get(i).toString())) {
                                String str = DB_Copy.getDatas("status_torol", "status_id").get(i).toString() + "::" + DB_Copy.getDatas("status_torol", "status_name").get(i).toString();
                                lists.add(str);
                            }
                        }
                        return lists;
//                        for (int i = 0; i < lists.size(); i++) {
//                            hi += lists.get(i);
//                            hi += (i + 1 == lists.size()) ? "" : "::";
//                        }
                    case "teacher":
                        for (int i = 0; i < size; i++) {
                            if (type.equals(DB_Copy.getDatas("status_torol", "type").get(i).toString())) {
                                String str = DB_Copy.getDatas("status_torol", "status_id").get(i).toString() + "::" + DB_Copy.getDatas("status_torol", "status_name").get(i).toString();
                                lists.add(str);
                            }
                        }
//                        for (int i = 0; i < lists.size(); i++) {
//                            hi += lists.get(i);
//                            hi += (i + 1 == lists.size()) ? "" : "::";
//                        }
                        return lists;
                    case "student":
                        for (int i = 0; i < size; i++) {
                            if (type.equals(DB_Copy.getDatas("status_torol", "type").get(i).toString())) {
                                String str = DB_Copy.getDatas("status_torol", "status_id").get(i).toString() + "::" + DB_Copy.getDatas("status_torol", "status_name").get(i).toString();
                                lists.add(str);
                            }
                        }
//                        for (int i = 0; i < lists.size(); i++) {
//                            hi += lists.get(i);
//                            hi += (i + 1 == lists.size()) ? "" : "::";
//                        }
                        return lists;
                    default:
                        ArrayList<String> allProfile = new ArrayList<>();
                        int i = 0;
                        ArrayList<Object> idCol = DB_Copy.getDatas("status_torol", "status_id");
                        for (; i < idCol.size(); i++) {
                            String str = "";
                            str += DB_Copy.getDatas("status_torol", "status_id", i).toString();
                            str += "::";
                            str += DB_Copy.getDatas("status_torol", "status_name", i).toString();
                            str += "::";
                            str += DB_Copy.getDatas("status_torol", "type", i).toString();
                            allProfile.add(str);
                        }
                        return allProfile;
                }
            }
        }));
        requestLists.add(new RequestProcess("getTeacherProfile", new ProcessAll() {

            @Override
            public Object run(Object username) {
                ArrayList<String> profile = new ArrayList<>();
                ArrayList<String> class_id = new ArrayList<>();
                ArrayList<String> types = new ArrayList<>();
                String teacherProfile = "";
                String names = "";

                ArrayList<Object> reg_numCol = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < reg_numCol.size(); i++) {
                    teacherProfile = "";
                    if (reg_numCol.get(i).toString().equals(username.toString())) {

                        if (Integer.parseInt((DB_Copy.getDatas("teacher", "del_flag", i)).toString()) == 0) {

                            String teacher_id = DB_Copy.getDatas("teacher", "teacher_id", i).toString();
                            String reg_num = DB_Copy.getDatas("teacher", "reg_num", i).toString();
                            String l_name = DB_Copy.getDatas("teacher", "lastname", i).toString();
                            String f_name = DB_Copy.getDatas("teacher", "firstname", i).toString();
                            String status = DB_Copy.getDatas("teacher", "status_id", i).toString();
                            String type = DB_Copy.getDatas("teacher", "class_type", i).toString();
                            String phone = DB_Copy.getDatas("teacher", "phone", i).toString();
                            String email = DB_Copy.getDatas("teacher", "email_address", i).toString();
                            String social_address = DB_Copy.getDatas("teacher", "social_address", i).toString();
                            String home_address = DB_Copy.getDatas("teacher", "address", i).toString();
                            String dropped = DB_Copy.getDatas("teacher", "del_flag", i).toString();
                            String pic = DB_Copy.getDatas("teacher", "teacher_picture", i).toString();
                            String user_name = DB_Copy.getDatas("teacher", "username", i).toString();
                            String password = DB_Copy.getDatas("teacher", "password", i).toString();

                            String status_name = "";
                            ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                            ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                            for (int j = 0; j < statusTorol_statusId.size(); j++) {
                                if (statusTorol_statusId.get(j).toString().equals(status)) {
                                    status_name = statusTorol_statusName.get(j).toString();
                                }
                            }

                            teacherProfile += teacher_id;
                            teacherProfile += "::";
                            teacherProfile += reg_num;
                            teacherProfile += "::";
                            teacherProfile += l_name;
                            teacherProfile += "::";
                            teacherProfile += f_name;
                            teacherProfile += "::";
                            teacherProfile += status_name;
                            teacherProfile += "::";
                            teacherProfile += type;
                            teacherProfile += "::";
                            teacherProfile += phone;
                            teacherProfile += "::";
                            teacherProfile += email;
                            teacherProfile += "::";
                            teacherProfile += social_address;
                            teacherProfile += "::";
                            teacherProfile += home_address;
                            teacherProfile += "::";
                            teacherProfile += dropped;
                            teacherProfile += "::";
                            teacherProfile += pic;
                            teacherProfile += "::";
                            teacherProfile += user_name;
                            teacherProfile += "::";
                            teacherProfile += password;
//                            profile.add(teacherProfile);
                            break;

                        } else {
                            System.out.println("if ajillhagui bn");
                        }
                    }
                }
                return teacherProfile;
            }
        }));

        /*Irtsiin requests starts************************************************/
//        requestLists.add(new RequestProcess(("getStudentNames"), new ProcessAll() {
//
//            @Override
//            public Object run(Object requestDatas) {
//
//                String names = "";
//                ArrayList<Object> ids = DB_Copy.getDatas("student", "student_id");
//                // String first_name =  DB_Copy.getDatas("student", "firstname").toString();
//                for (int i = 0; i < ids.size(); i++) {
//
//                    names += DB_Copy.getDatas("student", "firstname", i).toString();
//                    names += (i + 1 == ids.size()) ? "" : "::";
//
//                }
//                return names;
//            }
//
//        }));
        requestLists.add(new RequestProcess(("getStudentStatusIrts"), new ProcessAll() {

            @Override
            public Object run(Object teacher_id) {

                ArrayList<String> list = new ArrayList<>();
                ArrayList<Object> teacherId = DB_Copy.getDatas("irts_status", "teacher_id");

                for (int i = 0; i < teacherId.size(); i++) {

                    String names = "";
                    if (teacherId.get(i).toString().equals(teacher_id.toString())) {
                        String status = DB_Copy.getDatas("irts_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("irts_status", "onoo", i).toString();
                        names += status;
                        names += "::";
                        names += onoo;
                        list.add(names);
                    }
                }
                return list;
            }
        }));

        requestLists.add(new RequestProcess("updateNegdsenDun", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] spl = requestDatas.toString().split("::");
                String id = spl[0];
                String name = spl[1];
                String percent = spl[2];
                String teacher = spl[3];

                if (db.updateNegdsenDun(id, name, percent, teacher)) {

                    ArrayList<Object> dbdata = new ArrayList<>();
                    String query = "select * from negdsen_dun where " + id + "";
                    ResultSet result = db.runQuery(query);

                    try {
                        while (result.last()) {
                            dbdata.add(result.getString(1));
                            dbdata.add(result.getString(2));
                            dbdata.add(result.getString(3));
                            dbdata.add(result.getString(4));
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    for (int i = 0; i < dbdata.size(); i++) {
                        DB_Copy.updateRow("negdsen_dun", i, dbdata);
                        break;
                    }
                }
                return true;
            }
        }));
        requestLists.add(new RequestProcess("insertNegdsenDun", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] spl = requestDatas.toString().split("::");
                String id = spl[0];
                String name = spl[1];
                String percent = spl[2];
                String teacher = spl[3];

                if (db.insertNegdsenDun(id, name, percent, teacher)) {

                    ArrayList<Object> dbdata = new ArrayList<>();
                    String query = "select * from negdsen_dun order by desc limit 1";
                    ResultSet result = db.runQuery(query);

                    try {
                        while (result.last()) {
                            dbdata.add(result.getString(1));
                            dbdata.add(result.getString(2));
                            dbdata.add(result.getString(3));
                            dbdata.add(result.getString(4));
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    DB_Copy.insertRow("negdsen_dun", dbdata);
                }

                return true;
            }
        }));
        requestLists.add(new RequestProcess("deleteNegdsenDun", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                if (db.deleteNegdsenDun(requestDatas)) {
                    DB_Copy.removeAt("negdsen_dun", Integer.parseInt(requestDatas.toString()));
                }
                return true;
            }
        }));

        /*Irtsiin requests ends ****************************************/
        requestLists.add(new RequestProcess("getAdminProfile", new ProcessAll() {

            @Override
            public Object run(Object userName) {
                ArrayList<String> profile = new ArrayList<>();
                String adminProfile = "";

                ArrayList<Object> userNameCol = DB_Copy.getDatas("admin", "username");

                int i = 0;
                for (; i < userNameCol.size(); i++) {

                    if (userNameCol.get(i).toString().equals(userName.toString())) {

                        if (DB_Copy.getDatas("admin", "del_flag", i).toString().equals("false")) {

                            String admin_id = DB_Copy.getDatas("admin", "admin_id", i).toString();
                            String reg_num = DB_Copy.getDatas("admin", "reg_num", i).toString();
                            String l_name = DB_Copy.getDatas("admin", "lastname", i).toString();
                            String f_name = DB_Copy.getDatas("admin", "firstname", i).toString();
                            String status = DB_Copy.getDatas("admin", "status_id", i).toString();
                            String phone = DB_Copy.getDatas("admin", "phone", i).toString();
                            String email = DB_Copy.getDatas("admin", "email_address", i).toString();
                            String social_address = DB_Copy.getDatas("admin", "social_address", i).toString();
                            String home_address = DB_Copy.getDatas("admin", "address", i).toString();
                            String dropped = DB_Copy.getDatas("admin", "del_flag", i).toString();
                            String pic = DB_Copy.getDatas("admin", "admin_picture", i).toString();
                            String username = DB_Copy.getDatas("admin", "username", i).toString();
                            String password = DB_Copy.getDatas("admin", "password", i).toString();
                            String status_name = "";

                            ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                            ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");

                            for (int j = 0; j < statusTorol_statusId.size(); j++) {
                                if (statusTorol_statusId.get(j).toString().equals(status)) {
                                    status_name = statusTorol_statusName.get(j).toString();
                                }
                            }

                            adminProfile += admin_id;
                            adminProfile += "::";
                            adminProfile += reg_num;
                            adminProfile += "::";
                            adminProfile += l_name;
                            adminProfile += "::";
                            adminProfile += f_name;
                            adminProfile += "::";
                            adminProfile += status_name;
                            adminProfile += "::";
                            adminProfile += phone;
                            adminProfile += "::";
                            adminProfile += email;
                            adminProfile += "::";
                            adminProfile += social_address;
                            adminProfile += "::";
                            adminProfile += home_address;
                            adminProfile += "::";
                            adminProfile += dropped;
                            adminProfile += "::";
                            adminProfile += pic;
                            adminProfile += "::";
                            adminProfile += username;
                            adminProfile += "::";
                            adminProfile += password;

                            profile.add(adminProfile);

                        }
                    }
                }
                return adminProfile;
            }
        }));
        requestLists.add(new RequestProcess("getAllAdminProfile", new ProcessAll() {

            @Override
            public Object run(Object userName) {
                ArrayList<String> profile = new ArrayList<>();
                String adminProfile = "";

                ArrayList<Object> userNameCol = DB_Copy.getDatas("admin", "username");

                int i = 0;
                for (; i < userNameCol.size(); i++) {
                    adminProfile = "";
                    String status_name = "";
                    if (Integer.parseInt(DB_Copy.getDatas("admin", "del_flag", i).toString()) == 0) {

                        adminProfile = DB_Copy.getDatas("admin", "admin_id", i).toString();
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "reg_num", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "lastname", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "firstname", i);
                        adminProfile += "::";
                        String status = DB_Copy.getDatas("admin", "status_id", i).toString();
                        ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                        ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");
                        for (int j = 0; j < statusTorol_statusId.size(); j++) {
                            if (statusTorol_statusId.get(j).toString().equals(status)) {
                                status_name = statusTorol_statusName.get(j).toString();
                                break;
                            }
                        }
                        adminProfile += status_name;
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "phone", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "email_address", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "social_address", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "address", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "del_flag", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "admin_picture", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "username", i);
                        adminProfile += "::";
                        adminProfile += DB_Copy.getDatas("admin", "password", i);

                        profile.add(adminProfile);

                    }

                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("insertAdminProfile", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                String o2 = datas[1];
                String o3 = datas[2];
                String o4 = datas[3];
                String o5 = datas[4];
                String o6 = datas[5];
                String o7 = datas[6];
                String o8 = datas[7];
                String o9 = datas[8];
                String o10 = datas[9];
                String o11 = datas[10];
                String o12 = datas[11];

                ArrayList<Object> data = new ArrayList<>();
                String id = "";
                System.out.println("ifees omno ");
                if (db.insertAdminProfile(o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12)) {
                    System.out.println("if iin daraa");
                    try {
                        String query = "select * from admin order by admin_id desc limit 1";
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
                            data.add(result.getString(9));
                            data.add(result.getString(10));
                            data.add(result.getString(11));
                            data.add(result.getString(12));
                            data.add(result.getString(13));

                            id = result.getString(1);
                        }
                        System.out.println(">>>>>>>>" + data);
                        DB_Copy.insertRow("admin", data);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                return id;
            }
        }));

        requestLists.add(new RequestProcess("deleteAdminProfile", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                System.out.println("before if>>>>>>>" + o1);
                if (db.deleteAdminProfile(o1)) {
                    System.out.println("after if");
                    ArrayList<Object> row = DB_Copy.getDatas("admin", "admin_id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("admin", i);
                            break;
                        }
                    }
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("updateAdminProfile", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                db.updateAdminProfile(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5],
                        datas[6], datas[7], datas[8], datas[9], datas[10],
                        datas[11], datas[12], datas[0]);

                String query = "select * from admin where admin_id = " + datas[0] + "";
                ResultSet rs = null;
                ArrayList<Object> data = new ArrayList<>();
                rs = db.runQuery(query);
                Object stID = null;
                Object clID = null;
                try {
                    while (rs.next()) {
                        data.add(rs.getString(1));
                        stID = rs.getString(1);
                        data.add(rs.getString(2));
                        data.add(rs.getString(3));
                        data.add(rs.getString(4));
                        data.add(rs.getString(5));
                        data.add(rs.getString(6));
                        data.add(rs.getString(7));
                        data.add(rs.getString(8));
                        data.add(rs.getString(9));
                        data.add(rs.getString(10));
                        clID = rs.getString(10);
                        data.add(rs.getString(11));
                        data.add(rs.getString(12));
                        data.add(rs.getString(13));
                    }
                } catch (SQLException ex) {
                }

                ArrayList<Object> baganuud = DB_Copy.getDatas("admin", "admin_id");
                int row = 0;
                for (row = 0; row < baganuud.size(); row++) {
                    if (baganuud.get(row).toString().equals(datas[0])) {
                        break;
                    }
                }
                DB_Copy.updateRow("admin", row, data);
                data.clear();
//            **********************************************************************

                return true;
            }
        }));

        //*************************************Status husnegtuudiin requestuud ehelj baina*********************************************
        requestLists.add(new RequestProcess("getAllDaalgavarStatus", new ProcessAll() {
            public Object run(Object id) {
                ArrayList<String> profile = new ArrayList<>();
                String daalgavar = "";
                String teacherUsername = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("daalgavar_status", "id");
                int i = 0;
                for (; i < idCol.size(); i++) {
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", i).toString()) == 0) {
                        daalgavar = "";
                        String daalgavar_id = DB_Copy.getDatas("daalgavar_status", "id", i).toString();
                        String name = DB_Copy.getDatas("daalgavar_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("daalgavar_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("daalgavar_status", "teacher_id", i).toString();

                        ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                        ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                        for (int j = 0; j < teacher_teacherId.size(); j++) {
                            daalgavar = "";
                            if (teacher_teacherId.get(j).toString().equals(teacher_id)) {
                                teacherUsername = teacher_username.get(j).toString();

                                daalgavar += daalgavar_id;
                                daalgavar += "::";
                                daalgavar += name;
                                daalgavar += "::";
                                daalgavar += onoo;
                                daalgavar += "::";
                                daalgavar += teacherUsername;
                                profile.add(daalgavar);
                            }
                        }
                    }
                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("getDaalgavarStatus", new ProcessAll() {
            public Object run(Object username) {
                ArrayList<String> profile = new ArrayList<>();
                String daalgavar = "";
                String teacher = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("daalgavar_status", "teacher_id");

                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(username)) {
                        teacher = teacher_teacherId.get(i).toString();
                    }
                }

                int i = 0;
                for (; i < idCol.size(); i++) {

                    if (idCol.get(i).toString().equals(teacher)) {
                        daalgavar = "";
                        String daalgavar_id = DB_Copy.getDatas("daalgavar_status", "id", i).toString();
                        String name = DB_Copy.getDatas("daalgavar_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("daalgavar_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("daalgavar_status", "teacher_id", i).toString();

                        daalgavar += daalgavar_id;
                        daalgavar += "::";
                        daalgavar += name;
                        daalgavar += "::";
                        daalgavar += onoo;
                        profile.add(daalgavar);
                    }

                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("getAllIrtsStatus", new ProcessAll() {
            public Object run(Object id) {
                ArrayList<String> profile = new ArrayList<>();
                String irts = "";
                String teacherUsername = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("irts_status", "id");
                int i = 0;
                for (; i < idCol.size(); i++) {
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", i).toString()) == 0) {
                        irts = "";

                        String irts_id = DB_Copy.getDatas("irts_status", "id", i).toString();
                        String name = DB_Copy.getDatas("irts_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("irts_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("irts_status", "teacher_id", i).toString();

                        ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                        ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                        for (int j = 0; j < teacher_teacherId.size(); j++) {

                            if (teacher_teacherId.get(j).toString().equals(teacher_id)) {
                                teacherUsername = teacher_username.get(j).toString();
                            }
                        }

                        irts += irts_id;
                        irts += "::";
                        irts += name;
                        irts += "::";
                        irts += onoo;
                        irts += "::";
                        irts += teacherUsername;
                        profile.add(irts);

                    }
                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("getIrtsStatus", new ProcessAll() {
            public Object run(Object username) {
                ArrayList<String> profile = new ArrayList<>();
                String irts = "";
                String teacher = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("irts_status", "teacher_id");

                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(username)) {
                        teacher = teacher_teacherId.get(i).toString();
                    }
                }

                int i = 0;
                for (; i < idCol.size(); i++) {

                    if (idCol.get(i).toString().equals(teacher)) {
                        irts = "";
                        String irts_id = DB_Copy.getDatas("irts_status", "id", i).toString();
                        String name = DB_Copy.getDatas("irts_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("irts_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("irts_status", "teacher_id", i).toString();

                        irts += irts_id;
                        irts += "::";
                        irts += name;
                        irts += "::";
                        irts += onoo;
                        profile.add(irts);
                    }

                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("getAllIdevhStatus", new ProcessAll() {
            public Object run(Object id) {
                ArrayList<String> profile = new ArrayList<>();
                String idevh = "";
                String teacherUsername = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("idevh_status", "id");
                int i = 0;
                for (; i < idCol.size(); i++) {
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", i).toString()) == 0) {
                        idevh = "";

                        String idevh_id = DB_Copy.getDatas("idevh_status", "id", i).toString();
                        String name = DB_Copy.getDatas("idevh_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("idevh_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("idevh_status", "teacher_id", i).toString();

                        ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                        ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                        for (int j = 0; j < teacher_teacherId.size(); j++) {

                            if (teacher_teacherId.get(j).toString().equals(teacher_id)) {
                                teacherUsername = teacher_username.get(j).toString();
                            }
                        }

                        idevh += idevh_id;
                        idevh += "::";
                        idevh += name;
                        idevh += "::";
                        idevh += onoo;
                        idevh += "::";
                        idevh += teacherUsername;
                        profile.add(idevh);
                    }
                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("getIdevhStatus", new ProcessAll() {
            public Object run(Object username) {
                ArrayList<String> profile = new ArrayList<>();
                String idevh = "";
                String teacher = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("idevh_status", "teacher_id");

                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(username)) {
                        teacher = teacher_teacherId.get(i).toString();
                    }
                }

                int i = 0;
                for (; i < idCol.size(); i++) {

                    if (idCol.get(i).toString().equals(teacher)) {
                        idevh = "";
                        String idevh_id = DB_Copy.getDatas("idevh_status", "id", i).toString();
                        String name = DB_Copy.getDatas("idevh_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("idevh_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("idevh_status", "teacher_id", i).toString();

                        idevh += idevh_id;
                        idevh += "::";
                        idevh += name;
                        idevh += "::";
                        idevh += onoo;
                        profile.add(idevh);
                    }

                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("getAllShalgaltStatus", new ProcessAll() {
            public Object run(Object id) {
                ArrayList<String> profile = new ArrayList<>();
                String shalgalt = "";
                String teacherUsername = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("shalgalt_status", "id");
                int i = 0;
                for (; i < idCol.size(); i++) {
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", i).toString()) == 0) {
                        shalgalt = "";
                        String shalgalt_id = DB_Copy.getDatas("shalgalt_status", "id", i).toString();
                        String name = DB_Copy.getDatas("shalgalt_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("shalgalt_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("shalgalt_status", "teacher_id", i).toString();

                        ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                        ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                        for (int j = 0; j < teacher_teacherId.size(); j++) {
                            shalgalt = "";
                            if (teacher_teacherId.get(j).toString().equals(teacher_id)) {
                                teacherUsername = teacher_username.get(j).toString();

                                shalgalt += shalgalt_id;
                                shalgalt += "::";
                                shalgalt += name;
                                shalgalt += "::";
                                shalgalt += onoo;
                                shalgalt += "::";
                                shalgalt += teacherUsername;
                                profile.add(shalgalt);
                            }
                        }
                    }
                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("getShalgaltStatus", new ProcessAll() {
            public Object run(Object username) {
                ArrayList<String> profile = new ArrayList<>();
                String shalgalt = "";
                String teacher = "";
                ArrayList<Object> idCol = DB_Copy.getDatas("shalgalt_status", "teacher_id");

                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(username)) {
                        teacher = teacher_teacherId.get(i).toString();
                    }
                }

                int i = 0;
                for (; i < idCol.size(); i++) {

                    if (idCol.get(i).toString().equals(teacher)) {
                        shalgalt = "";
                        String shalgalt_id = DB_Copy.getDatas("shalgalt_status", "id", i).toString();
                        String name = DB_Copy.getDatas("shalgalt_status", "status", i).toString();
                        String onoo = DB_Copy.getDatas("shalgalt_status", "onoo", i).toString();
                        String teacher_id = DB_Copy.getDatas("shalgalt_status", "teacher_id", i).toString();

                        shalgalt += shalgalt_id;
                        shalgalt += "::";
                        shalgalt += name;
                        shalgalt += "::";
                        shalgalt += onoo;
                        profile.add(shalgalt);
                    }

                }
                return profile;
            }
        }));

        requestLists.add(new RequestProcess("deleteIrtsStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                if (db.deleteIrtsStatus(o1).equals("true")) {
                    ArrayList<Object> row = DB_Copy.getDatas("irts_status", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("irts_status", i);
                            break;
                        }
                    }
                } else {
                    return "error";
                }
                return "true";
            }
        }));
        requestLists.add(new RequestProcess("deleteIdevhStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                if (db.deleteIdevhStatus(o1).equals("true")) {
                    ArrayList<Object> row = DB_Copy.getDatas("idevh_status", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("idevh_status", i);
                            break;
                        }
                    }
                } else {
                    return "error";
                }
                return "true";
            }
        }));

        requestLists.add(new RequestProcess("deleteDaalgavarStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                if (db.deleteFromDaalgavarStatus(o1).equals("true")) {
                    ArrayList<Object> row = DB_Copy.getDatas("daalgavar_status", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("daalgavar_status", i);
                            break;
                        }
                    }
                } else {
                    return false;
                }
                return true;
            }
        }));
        requestLists.add(new RequestProcess("deleteShalgaltStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                if (db.deleteFromShalgaltStatus(o1).equals("true")) {
                    ArrayList<Object> row = DB_Copy.getDatas("shalgalt_status", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("shalgalt_status", i);
                            break;
                        }
                    }
                } else {
                    return false;
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("updateIrtsStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");

                String teacher_id = "";
                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(datas[3])) {
                        teacher_id = teacher_teacherId.get(i).toString();
                    }
                }

                if (db.updateIrtsStatus(datas[0], datas[1], datas[2], teacher_id, datas[0])) {
                    String query = "select * from irts_status where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                        }
                    } catch (SQLException ex) {
                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("irts_status", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("irts_status", row, data);
                    data.clear();
                }
//            **********************************************************************

                return true;
            }
        }));

        requestLists.add(new RequestProcess("updateIdevhStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");

                String teacher_id = "";
                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(datas[3])) {
                        teacher_id = teacher_teacherId.get(i).toString();
                    }
                }

                if (db.updateIdevhStatus(datas[0], datas[1], datas[2], teacher_id, datas[0])) {

                    String query = "select * from idevh_status where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                        }
                    } catch (SQLException ex) {
                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("idevh_status", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("idevh_status", row, data);
                    data.clear();
//            **********************************************************************

                }

                return true;
            }
        }));

        requestLists.add(new RequestProcess("updateShalgaltStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");

                String teacher_id = "";
                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(datas[3])) {
                        teacher_id = teacher_teacherId.get(i).toString();
                    }
                }

                if (db.updateShalgaltStatus(datas[0], datas[1], datas[2], teacher_id, datas[0])) {

                    String query = "select * from shalgalt_status where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                        }
                    } catch (SQLException ex) {
                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("shalgalt_status", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("shalgalt_status", row, data);
                    data.clear();
//            **********************************************************************

                }

                return true;
            }
        }));

        requestLists.add(new RequestProcess("updateDaalgavarStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");

                String teacher_id = "";
                ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                for (int i = 0; i < teacher_teacherId.size(); i++) {

                    if (teacher_username.get(i).toString().equals(datas[3])) {
                        teacher_id = teacher_teacherId.get(i).toString();
                    }
                }

                if (db.updateDaalgavarStatus(datas[0], datas[1], datas[2], teacher_id, datas[0])) {

                    String query = "select * from daalgavar_status where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                        }
                    } catch (SQLException ex) {
                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("daalgavar_status", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("daalgavar_status", row, data);
                    data.clear();
//            **********************************************************************

                }

                return true;
            }
        }));

        requestLists.add(new RequestProcess("insertDaalgavarStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String teacher_id = "";
                try {

                    ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                    ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                    for (int i = 0; i < teacher_teacherId.size(); i++) {

                        if (teacher_username.get(i).toString().equals(datas[2])) {
                            teacher_id = teacher_teacherId.get(i).toString();
                        }
                    }

                    if (db.insertDaalgavarStatus(null, datas[0], datas[1], teacher_id)) {
                        ArrayList<Object> da = new ArrayList<>();

                        String query = "select * from daalgavar_status order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        while (result.last()) {
                            da.add(result.getString(1));
                            da.add(result.getString(2));
                            da.add(result.getString(3));
                            da.add(result.getString(4));

                            break;
                        }

                        DB_Copy.insertRow("daalgavar_status", da);
                    }
                } catch (Exception ex) {
                    return false;
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("insertIrtsStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String teacher_id = "";
                try {

                    ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                    ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                    for (int i = 0; i < teacher_teacherId.size(); i++) {

                        if (teacher_username.get(i).toString().equals(datas[2])) {
                            teacher_id = teacher_teacherId.get(i).toString();
                        }
                    }

                    if (db.insertIrtsStatus(null, datas[0], datas[1], teacher_id)) {
                        ArrayList<Object> da = new ArrayList<>();

                        String query = "select * from irts_status order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        while (result.last()) {
                            da.add(result.getString(1));
                            da.add(result.getString(2));
                            da.add(result.getString(3));
                            da.add(result.getString(4));

                            break;
                        }

                        DB_Copy.insertRow("irts_status", da);
                    }
                } catch (Exception ex) {
                    return false;
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("insertIdevhStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String teacher_id = "";
                try {

                    ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                    ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                    for (int i = 0; i < teacher_teacherId.size(); i++) {

                        if (teacher_username.get(i).toString().equals(datas[2])) {
                            teacher_id = teacher_teacherId.get(i).toString();
                        }
                    }

                    if (db.insertIdevhStatus(null, datas[0], datas[1], teacher_id)) {
                        ArrayList<Object> da = new ArrayList<>();

                        String query = "select * from idevh_status order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        while (result.last()) {
                            da.add(result.getString(1));
                            da.add(result.getString(2));
                            da.add(result.getString(3));
                            da.add(result.getString(4));

                            break;
                        }

                        DB_Copy.insertRow("idevh_status", da);
                    }
                } catch (Exception ex) {
                    return false;
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("insertShalgaltStatus", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String teacher_id = "";
                try {

                    ArrayList<Object> teacher_teacherId = DB_Copy.getDatas("teacher", "teacher_id");
                    ArrayList<Object> teacher_username = DB_Copy.getDatas("teacher", "username");

                    for (int i = 0; i < teacher_teacherId.size(); i++) {

                        if (teacher_username.get(i).toString().equals(datas[2])) {
                            teacher_id = teacher_teacherId.get(i).toString();
                        }
                    }

                    if (db.insertShalgaltStatus(null, datas[0], datas[1], teacher_id)) {
                        ArrayList<Object> da = new ArrayList<>();

                        String query = "select * from shalgalt_status order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        while (result.last()) {
                            da.add(result.getString(1));
                            da.add(result.getString(2));
                            da.add(result.getString(3));
                            da.add(result.getString(4));

                            break;
                        }

                        DB_Copy.insertRow("shalgalt_status", da);
                    }
                } catch (Exception ex) {
                    return false;
                }
                return true;
            }
        }));

//        requestLists.add(new RequestProcess(("getSuraltsajBaigaaStudentIrts"), new ProcessAll() {
//
//            @Override
//            public Object run(Object requestDatas) {
//
//                ArrayList<String> retList = new ArrayList<>();
//
//                ArrayList<Object> students_name = DB_Copy.getDatas("student", "firstname");
//                ArrayList<Object> students_id = DB_Copy.getDatas("student", "student_id");
//                ArrayList<Object> students_status = DB_Copy.getDatas("student", "status_id");
//
//                ArrayList<Object> dun_irts_student_id = DB_Copy.getDatas("dun_irts", "student_id");
//                ArrayList<Object> dun_irts_irts_status = DB_Copy.getDatas("dun_irts", "irts_statusid");
//                ArrayList<Object> dun_irts_ognoo = DB_Copy.getDatas("dun_irts", "ognoo");
//
//                ArrayList<Object> irts_status_id = DB_Copy.getDatas("irts_status", "id");
//                ArrayList<Object> irts_status_status = DB_Copy.getDatas("irts_status", "status");
//
//                ArrayList<String> avsan_names = new ArrayList<>();
//                ArrayList<String> avsan_irts_status = new ArrayList<>();
//                ArrayList<String> avsan_ognoo = new ArrayList<>();
//
//                String id = "";
//
//                ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");
//                ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
//
//                for (int i = 0; i < statusTorol_statusId.size(); i++) {
//                    if (statusTorol_statusName.get(i).toString().equals("суралцаж байгаа")) {
//                        id = statusTorol_statusId.get(i).toString();
//                        break;
//                    }
//                }
//
//                for (int i = 0; i < students_id.size(); i++) {
//                    if (Integer.parseInt(students_status.get(i).toString()) == Integer.parseInt(id)) {
//                        for (int j = 0; j < dun_irts_student_id.size(); j++) {
//                            if (Integer.parseInt(students_id.get(i).toString()) == Integer.parseInt(dun_irts_student_id.get(j).toString())) {
//                                avsan_irts_status.add(dun_irts_irts_status.get(j).toString());
//                                avsan_ognoo.add(dun_irts_ognoo.get(j).toString());
//                                avsan_names.add(students_name.get(i).toString());
//                            }
//                        }
//                    }
//                }
//
//                ArrayList<String> avsan_status = new ArrayList<>();
//                for (int i = 0; i < avsan_irts_status.size(); i++) {
//                    for (int j = 0; j < irts_status_id.size(); j++) {
//                        if (Integer.parseInt(avsan_irts_status.get(i).toString()) == Integer.parseInt(irts_status_id.get(j).toString())) {
//                            avsan_status.add(irts_status_status.get(j).toString());
//                        }
//                    }
//                }
//
//                System.out.println("avsan_names : " + avsan_names.size());
//                System.out.println("avsan_ognoo : " + avsan_ognoo.size());
//                System.out.println("avsan_status : " + avsan_status.size());
//
//                for (int i = 0; i < avsan_names.size(); i++) {
//                    String name = avsan_names.get(i);
//                    String status = avsan_status.get(i);
//                    String ognoo = avsan_ognoo.get(i);
//                    retList.add("" + name + "::" + status + "::" + ognoo);
//                }
//
//                return retList;
//            }
//        }));
//        
        requestLists.add(new RequestProcess(("getSuraltsajBaigaaStudentIrts"), new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                ArrayList<String> retList = new ArrayList<>();

                ArrayList<Object> students_name = DB_Copy.getDatas("student", "firstname");
                ArrayList<Object> students_id = DB_Copy.getDatas("student", "student_id");
                ArrayList<Object> students_status = DB_Copy.getDatas("student", "status_id");

                ArrayList<Object> dun_irts_student_id = DB_Copy.getDatas("dun_irts", "student_id");
                ArrayList<Object> dun_irts_irts_status = DB_Copy.getDatas("dun_irts", "irts_statusid");
                ArrayList<Object> dun_irts_ognoo = DB_Copy.getDatas("dun_irts", "ognoo");

                ArrayList<Object> irts_status_id = DB_Copy.getDatas("irts_status", "id");
                ArrayList<Object> irts_status_status = DB_Copy.getDatas("irts_status", "status");

                ArrayList<String> avsan_names = new ArrayList<>();
                ArrayList<String> avsan_irts_status = new ArrayList<>();
                ArrayList<String> avsan_ognoo = new ArrayList<>();

                String id = "";

                ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");
                ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
                for (int d = 0; d < DB_Copy.getDatas("student", "student_id").size(); d++) {
                    System.out.println("" + DB_Copy.getDatas("student", "del_flag", d).toString());
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", d).toString()) == 0) {
                        for (int i = 0; i < statusTorol_statusId.size(); i++) {
                            if (statusTorol_statusName.get(i).toString().equals("суралцаж байгаа")) {
                                id = statusTorol_statusId.get(i).toString();
                                break;
                            }
                        }

                        for (int i = 0; i < students_id.size(); i++) {
                            if (Integer.parseInt(students_status.get(i).toString()) == Integer.parseInt(id)) {
                                for (int j = 0; j < dun_irts_student_id.size(); j++) {
                                    if (Integer.parseInt(students_id.get(i).toString()) == Integer.parseInt(dun_irts_student_id.get(j).toString())) {
                                        avsan_irts_status.add(dun_irts_irts_status.get(j).toString());
                                        avsan_ognoo.add(dun_irts_ognoo.get(j).toString());
                                        avsan_names.add(students_name.get(i).toString());
                                    }
                                }
                            }
                        }

                        ArrayList<String> avsan_status = new ArrayList<>();
                        for (int i = 0; i < avsan_irts_status.size(); i++) {
                            for (int j = 0; j < irts_status_id.size(); j++) {
                                if (Integer.parseInt(avsan_irts_status.get(i).toString()) == Integer.parseInt(irts_status_id.get(j).toString())) {
                                    avsan_status.add(irts_status_status.get(j).toString());
                                }
                            }
                        }

                        System.out.println("avsan_names : " + avsan_names.size());
                        System.out.println("avsan_ognoo : " + avsan_ognoo.size());
                        System.out.println("avsan_status : " + avsan_status.size());

                        for (int i = 0; i < avsan_names.size(); i++) {
                            String name = avsan_names.get(i);
                            String status = avsan_status.get(i);
                            String ognoo = avsan_ognoo.get(i);
                            retList.add("" + name + "::" + status + "::" + ognoo);
                        }
                    }
                }
                return retList;
            }
        }));

        requestLists.add(new RequestProcess(("getSuraltsajBaigaaStudentIdevh"), new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                ArrayList<String> retList = new ArrayList<>();

                ArrayList<Object> students_name = DB_Copy.getDatas("student", "firstname");
                ArrayList<Object> students_id = DB_Copy.getDatas("student", "student_id");
                ArrayList<Object> students_status = DB_Copy.getDatas("student", "status_id");

                ArrayList<Object> dun_idevh_student_id = DB_Copy.getDatas("dun_udevh", "student_id");
                ArrayList<Object> dun_idevh_idevh_status = DB_Copy.getDatas("dun_udevh", "idevh_statusid");
                ArrayList<Object> dun_idevh_ognoo = DB_Copy.getDatas("dun_udevh", "ognoo");

                ArrayList<Object> idevh_status_id = DB_Copy.getDatas("idevh_status", "id");
                ArrayList<Object> idevh_status_status = DB_Copy.getDatas("idevh_status", "status");

                ArrayList<String> avsan_names = new ArrayList<>();
                ArrayList<String> avsan_idevh_status = new ArrayList<>();
                ArrayList<String> avsan_ognoo = new ArrayList<>();

                String id = "";

                ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");
                ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
           for (int d = 0; d < DB_Copy.getDatas("student", "student_id").size(); d++) {
                    System.out.println("" + DB_Copy.getDatas("student", "del_flag", d).toString());
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", d).toString()) == 0) {
                for (int i = 0; i < statusTorol_statusId.size(); i++) {
                    if (statusTorol_statusName.get(i).toString().equals("суралцаж байгаа")) {
                        id = statusTorol_statusId.get(i).toString();
                        break;
                    }
                }

                for (int i = 0; i < students_id.size(); i++) {
                    if (Integer.parseInt(students_status.get(i).toString()) == Integer.parseInt(id)) {
                        for (int j = 0; j < dun_idevh_student_id.size(); j++) {
                            if (Integer.parseInt(students_id.get(i).toString()) == Integer.parseInt(dun_idevh_student_id.get(j).toString())) {
                                avsan_idevh_status.add(dun_idevh_idevh_status.get(j).toString());
                                avsan_ognoo.add(dun_idevh_ognoo.get(j).toString());
                                avsan_names.add(students_name.get(i).toString());
                            }

                        }
                    }
                }

                ArrayList<String> avsan_status = new ArrayList<>();
                for (int i = 0; i < avsan_idevh_status.size(); i++) {
                    for (int j = 0; j < idevh_status_id.size(); j++) {
                        if (Integer.parseInt(avsan_idevh_status.get(i).toString()) == Integer.parseInt(idevh_status_id.get(j).toString())) {
                            avsan_status.add(idevh_status_status.get(j).toString());
                        }
                    }
                }

                System.out.println("avsan_names : " + avsan_names.size());
                System.out.println("avsan_ognoo : " + avsan_ognoo.size());
                System.out.println("avsan_status : " + avsan_status.size());

                for (int i = 0; i < avsan_names.size(); i++) {
                    String name = avsan_names.get(i);
                    String status = avsan_status.get(i);
                    String ognoo = avsan_ognoo.get(i);
                    retList.add("" + name + "::" + status + "::" + ognoo);
                }
                    }}
                return retList;
            }
        }));

        requestLists.add(new RequestProcess(("getSuraltsajBaigaaStudentDaalgavar"), new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                ArrayList<String> retList = new ArrayList<>();

                ArrayList<Object> students_name = DB_Copy.getDatas("student", "firstname");
                ArrayList<Object> students_id = DB_Copy.getDatas("student", "student_id");
                ArrayList<Object> students_status = DB_Copy.getDatas("student", "status_id");

                ArrayList<Object> dun_irts_student_id = DB_Copy.getDatas("dun_daalgavar", "student_id");
                ArrayList<Object> dun_irts_irts_status = DB_Copy.getDatas("dun_daalgavar", "daalgavar_statusid");
                ArrayList<Object> dun_irts_ognoo = DB_Copy.getDatas("dun_daalgavar", "daalgavar_ner");
                ArrayList<Object> dun_irts_id = DB_Copy.getDatas("dun_daalgavar", "id");

                ArrayList<Object> irts_status_id = DB_Copy.getDatas("daalgavar_status", "id");
                ArrayList<Object> irts_status_status = DB_Copy.getDatas("daalgavar_status", "status");

                ArrayList<String> avsan_names = new ArrayList<>();
                ArrayList<String> avsan_irts_status = new ArrayList<>();
                ArrayList<String> avsan_ognoo = new ArrayList<>();
                ArrayList<String> avsan_id1 = new ArrayList<>();

                String id = "";

                ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");
                ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
           for (int d = 0; d < DB_Copy.getDatas("student", "student_id").size(); d++) {
                    System.out.println("" + DB_Copy.getDatas("student", "del_flag", d).toString());
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", d).toString()) == 0) {
                for (int i = 0; i < statusTorol_statusId.size(); i++) {
                    if (statusTorol_statusName.get(i).toString().equals("суралцаж байгаа")) {
                        id = statusTorol_statusId.get(i).toString();
                        break;
                    }
                }

                for (int i = 0; i < students_id.size(); i++) {
                    if (Integer.parseInt(students_status.get(i).toString()) == Integer.parseInt(id)) {
                        for (int j = 0; j < dun_irts_student_id.size(); j++) {
                            if (Integer.parseInt(students_id.get(i).toString()) == Integer.parseInt(dun_irts_student_id.get(j).toString())) {
                                avsan_irts_status.add(dun_irts_irts_status.get(j).toString());
                                avsan_ognoo.add(dun_irts_ognoo.get(j).toString());
                                avsan_names.add(students_name.get(i).toString());
                                avsan_id1.add(dun_irts_id.get(j).toString());
                            }
                        }
                    }
                }

                ArrayList<String> avsan_status = new ArrayList<>();
                for (int i = 0; i < avsan_irts_status.size(); i++) {
                    for (int j = 0; j < irts_status_id.size(); j++) {
                        if (Integer.parseInt(avsan_irts_status.get(i).toString()) == Integer.parseInt(irts_status_id.get(j).toString())) {
                            avsan_status.add(irts_status_status.get(j).toString());
                        }
                    }
                }

                System.out.println("avsan_names : " + avsan_names.size());
                System.out.println("avsan_ognoo : " + avsan_ognoo.size());
                System.out.println("avsan_status : " + avsan_status.size());

                for (int i = 0; i < avsan_names.size(); i++) {
                    String name = avsan_names.get(i);
                    String status = avsan_status.get(i);
                    String ognoo = avsan_ognoo.get(i);
                    String id1 = avsan_id1.get(i);
                    retList.add("" + name + "::" + status + "::" + ognoo + "::" + id1);
                }
                    }}
                return retList;
            }
        }));

        requestLists.add(new RequestProcess(("getSuraltsajBaigaaStudentShalgalt"), new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                ArrayList<String> retList = new ArrayList<>();

                ArrayList<Object> students_name = DB_Copy.getDatas("student", "firstname");
                ArrayList<Object> students_id = DB_Copy.getDatas("student", "student_id");
                ArrayList<Object> students_status = DB_Copy.getDatas("student", "status_id");

                ArrayList<Object> dun_shalgalt_id = DB_Copy.getDatas("dun_shaglalt", "id");
                ArrayList<Object> dun_shalgalt_student_id = DB_Copy.getDatas("dun_shaglalt", "student_id");
                ArrayList<Object> dun_shalgalt_shalgalt_status = DB_Copy.getDatas("dun_shaglalt", "shalgalt_statusid");
                ArrayList<Object> dun_shalgalt_ognoo = DB_Copy.getDatas("dun_shaglalt", "ognoo");

                ArrayList<Object> shalgalt_status_id = DB_Copy.getDatas("shalgalt_status", "id");
                ArrayList<Object> shalgalt_status_status = DB_Copy.getDatas("shalgalt_status", "status");
                ArrayList<Object> shalgalt_status_onoo = DB_Copy.getDatas("shalgalt_status", "onoo");
                ArrayList<Object> shalgalt_status_ognoo = DB_Copy.getDatas("shalgalt_status", "ognoo");

                ArrayList<String> avsan_names = new ArrayList<>();
                ArrayList<String> avsan_shalgalt_status = new ArrayList<>();
                ArrayList<String> avsan_ognoo = new ArrayList<>();
                ArrayList<String> avsan_onoo = new ArrayList<>();
                ArrayList<String> avsan_id = new ArrayList<>();

                String id = "";

                ArrayList<Object> statusTorol_statusName = DB_Copy.getDatas("status_torol", "status_name");
                ArrayList<Object> statusTorol_statusId = DB_Copy.getDatas("status_torol", "status_id");
           for (int d = 0; d < DB_Copy.getDatas("student", "student_id").size(); d++) {
                    System.out.println("" + DB_Copy.getDatas("student", "del_flag", d).toString());
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", d).toString()) == 0) {
                for (int i = 0; i < statusTorol_statusId.size(); i++) {
                    if (statusTorol_statusName.get(i).toString().equals("суралцаж байгаа")) {
                        id = statusTorol_statusId.get(i).toString();
                        break;
                    }
                }

                for (int i = 0; i < students_id.size(); i++) {
                    if (Integer.parseInt(students_status.get(i).toString()) == Integer.parseInt(id)) {
                        for (int j = 0; j < dun_shalgalt_student_id.size(); j++) {
                            if (Integer.parseInt(students_id.get(i).toString()) == Integer.parseInt(dun_shalgalt_student_id.get(j).toString())) {
                                avsan_shalgalt_status.add(dun_shalgalt_shalgalt_status.get(j).toString());
                                avsan_ognoo.add(dun_shalgalt_ognoo.get(j).toString());
                                avsan_names.add(students_name.get(i).toString());
                                avsan_id.add(dun_shalgalt_id.get(j).toString());

                            }
                        }
                    }
                }

                ArrayList<String> avsan_status = new ArrayList<>();
                for (int i = 0; i < avsan_shalgalt_status.size(); i++) {
                    for (int j = 0; j < shalgalt_status_id.size(); j++) {
                        if (Integer.parseInt(avsan_shalgalt_status.get(i).toString()) == Integer.parseInt(shalgalt_status_id.get(j).toString())) {
                            avsan_status.add(shalgalt_status_status.get(j).toString());
                            avsan_onoo.add(shalgalt_status_onoo.get(j).toString());
                        }
                    }
                }

                System.out.println("avsan_names : " + avsan_names.size());
                System.out.println("avsan_onoo : " + avsan_onoo.size());
                System.out.println("avsan_status : " + avsan_status.size());

                for (int i = 0; i < avsan_names.size(); i++) {
                    String name = avsan_names.get(i);
                    String status = avsan_status.get(i);
                    String onoo = avsan_onoo.get(i);
                    String ognoo = avsan_ognoo.get(i);
                    String shalgalt_id = avsan_id.get(i);
                    retList.add("" + name + "::" + status + "::" + onoo + "::" + ognoo + "::" + shalgalt_id);
                }
                    }}
                return retList;
            }
        }));

        requestLists.add(new RequestProcess("insertDunIrts", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                String o2 = datas[1];
                String o3 = datas[2];

                ArrayList<Object> data = new ArrayList<>();
                String id = "";
                if (db.insertDunIrts(o1, o2, o3).equals("true")) {

                    try {
                        String query = "select*from dun_irts order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getString(1));
                            data.add(result.getString(2));
                            data.add(result.getString(3));
                            data.add(result.getString(4));
                            id = result.getString(1);
                        }
                        DB_Copy.insertRow("dun_irts", data);
                    } catch (SQLException ex) {
                    }
                } else {
                    id = "Irts_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
                }
                return id;
            }
        }));

        requestLists.add(new RequestProcess("insertDunIdevh", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                String o2 = datas[1];
                String o3 = datas[2];

                ArrayList<Object> data = new ArrayList<>();
                String id = "";
                if (db.insertDunIdevh(o1, o2, o3).equals("true")) {

                    try {
                        String query = "select*from dun_udevh order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getString(1));
                            data.add(result.getString(2));
                            data.add(result.getString(3));
                            data.add(result.getString(4));
                            id = result.getString(1);
                        }
                        DB_Copy.insertRow("dun_udevh", data);
                    } catch (SQLException ex) {
                    }
                } else {
                    id = "Idevh_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
                }
                return id;
            }
        }));

        requestLists.add(new RequestProcess("insertDunShalgalt", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                String o2 = datas[1];
                String o3 = datas[2];
                String o4 = datas[3];
                String o5 = datas[4];

                ArrayList<Object> data = new ArrayList<>();
                String id = "";
                if (db.insertDunShalgalt(o1, o2, o3, o4, o5).equals("true")) {

                    try {
                        String query = "select*from dun_shaglalt order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getString(1));
                            data.add(result.getString(2));
                            data.add(result.getString(3));
                            data.add(result.getString(4));
                            data.add(result.getString(5));
                            data.add(result.getString(6));
                            id = result.getString(1);
                        }
                        DB_Copy.insertRow("dun_shaglalt", data);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    id = "shalgalt_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
                }
                return id;
            }
        }));

        requestLists.add(new RequestProcess("insertDunDaalgavar", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                String o2 = datas[1];
                String o3 = datas[2];
                String o4 = datas[3];
                String o5 = datas[4];

                ArrayList<Object> data = new ArrayList<>();
                String id = "";
                if (db.insertDunDaalgavar(o1, o2, o3, o4, o5).equals("true")) {

                    try {
                        String query = "select*from dun_daalgavar order by id desc limit 1";
                        ResultSet result = db.runQuery(query);

                        if (result.last()) {
                            data.add(result.getString(1));
                            data.add(result.getString(2));
                            data.add(result.getString(3));
                            data.add(result.getString(4));
                            data.add(result.getString(5));
                            data.add(result.getString(6));
                            id = result.getString(1);
                        }
                        DB_Copy.insertRow("dun_daalgavar", data);
                    } catch (SQLException ex) {
                    }
                } else {
                    id = "daalgavar_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
                }
                return id;
            }
        }));

        requestLists.add(new RequestProcess("getTeacherStudentProfile", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {

                String[] datas = requestDatas.toString().split("::");
                String tid = "";
                ArrayList<Object> teacherCol = DB_Copy.getDatas("teacher", "username");
                for (int i = 0; i < teacherCol.size(); i++) {
                    if (teacherCol.get(i).toString().equals(datas[0])) {
                        tid = DB_Copy.getDatas("teacher", "teacher_id", i).toString();
                    }
                }

                ArrayList<Object> teacherIDC = DB_Copy.getDatas("student_teacher", "teacher_id");
                ArrayList<Object> studentIDs = new ArrayList<>();

                for (int i = 0; i < teacherIDC.size(); i++) {
                    if (teacherIDC.get(i).toString().equals(tid)) {
                        studentIDs.add(DB_Copy.getDatas("student_teacher", "student_id", i));
                    }
                }

                ArrayList<Object> studentNames = new ArrayList<>();
                ArrayList<Object> studentIDC = DB_Copy.getDatas("student", "student_id");
                String str = "";
                for (int i = 0; i < studentIDs.size(); i++) {
                    if (Integer.parseInt(DB_Copy.getDatas("student", "del_flag", i).toString()) == 0) {

                        for (int j = 0; j < studentIDC.size(); j++) {
                            if (studentIDs.get(i).equals(studentIDC.get(j))) {
                                str = DB_Copy.getDatas("student", "student_id", j).toString();
                                str += "::";
                                str += DB_Copy.getDatas("student", "code", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "lastname", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "firstname", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "phone", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "email_address", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "social_address", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "reg_num", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "address", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "com_num", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "elseltiin_id", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "del_flag", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "reason", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "student_pic", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "elselt_onoo", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "yriltslaga", j);
                                str += "::";
                                str += DB_Copy.getDatas("student", "status_id", j);
                                studentNames.add(str);
                            }
                        }
                    }
                }

                return studentNames;
            }
        }));

        requestLists.add(new RequestProcess("deleteDunIrts", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                System.out.println("before if>>>>>>>" + o1);
                if (db.deleteDunIrts(o1)) {
                    System.out.println("after if");
                    ArrayList<Object> row = DB_Copy.getDatas("dun_irts", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("dun_irts", i);
                            break;
                        }
                    }
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("deleteDunIdevh", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                System.out.println("before if>>>>>>>" + o1);
                if (db.deleteDunIdevh(o1)) {
                    System.out.println("after if");
                    ArrayList<Object> row = DB_Copy.getDatas("dun_udevh", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("dun_udevh", i);
                            break;
                        }
                    }
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("deleteDunShalgalt", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                System.out.println("before if>>>>>>>" + o1);
                if (db.deleteDunShalgalt(o1)) {
                    System.out.println("after if");
                    ArrayList<Object> row = DB_Copy.getDatas("dun_shaglalt", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("dun_shaglalt", i);
                            break;
                        }
                    }
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("deleteDunDaalgavar", new ProcessAll() {

            @Override
            public Object run(Object requestDatas) {
                String[] datas = requestDatas.toString().split("::");
                String o1 = datas[0];
                System.out.println("before if>>>>>>>" + o1);
                if (db.deleteDunDaalgavar(o1)) {
                    System.out.println("after if");
                    ArrayList<Object> row = DB_Copy.getDatas("dun_daalgavar", "id");
                    for (int i = 0; i < row.size(); i++) {
                        if (Integer.parseInt(o1) == Integer.parseInt(row.get(i).toString())) {
                            DB_Copy.removeAt("dun_daalgavar", i);
                            break;
                        }
                    }
                }
                return true;
            }
        }));

        requestLists.add(new RequestProcess("updateDunIrts", new ProcessAll() {

            public Object run(Object requestDatas) {
                String str = "";
                String[] datas = requestDatas.toString().split("::");
                if (db.update_DunIrts(datas[0], datas[1], datas[2], datas[3], datas[0]).equals("true")) {

                    String query = "select * from dun_irts where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                        }
                    } catch (SQLException ex) {

                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("dun_irts", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("dun_irts", row, data);
                    data.clear();

                    str = "true";
                } else {
                    str = "Irts_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
                }

                return str;
            }
        }));

        requestLists.add(new RequestProcess("updateDunIdevh", new ProcessAll() {

            public Object run(Object requestDatas) {
                String str = "";
                String[] datas = requestDatas.toString().split("::");
                if (db.update_DunIdevh(datas[0], datas[1], datas[2], datas[3], datas[0]).equals("true")) {

                    String query = "select * from dun_udevh where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                        }
                    } catch (SQLException ex) {

                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("dun_udevh", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("dun_udevh", row, data);
                    data.clear();

                    str = "true";
                } else {
                    str = "Idevh_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id байна!!";
                }

                return str;
            }
        }));

        requestLists.add(new RequestProcess("updateDunShalgalt", new ProcessAll() {

            public Object run(Object requestDatas) {
                String str = "";
                String[] datas = requestDatas.toString().split("::");
                if (db.update_DunShalgalt(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[0]).equals("true")) {

                    String query = "select * from dun_shaglalt where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                            data.add(rs.getString(5));
                            data.add(rs.getString(6));
                        }
                    } catch (SQLException ex) {

                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("dun_shaglalt", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("dun_shaglalt", row, data);
                    data.clear();

                    str = "true";
                } else {
                    str = "shalgalt_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
                }

                return str;
            }
        }));

        requestLists.add(new RequestProcess("updateDunDaalgavar", new ProcessAll() {

            public Object run(Object requestDatas) {
                String str = "";
                String[] datas = requestDatas.toString().split("::");
                if (db.update_DunDaalgavar(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[0]).equals("true")) {

                    String query = "select * from dun_daalgavar where id = " + datas[0] + "";
                    ResultSet rs = null;
                    ArrayList<Object> data = new ArrayList<>();
                    rs = db.runQuery(query);

                    try {
                        while (rs.next()) {
                            data.add(rs.getString(1));
                            data.add(rs.getString(2));
                            data.add(rs.getString(3));
                            data.add(rs.getString(4));
                            data.add(rs.getString(5));
                            data.add(rs.getString(6));
                        }
                    } catch (SQLException ex) {

                    }

                    ArrayList<Object> baganuud = DB_Copy.getDatas("dun_daalgavar", "id");
                    int row = 0;
                    for (row = 0; row < baganuud.size(); row++) {
                        if (baganuud.get(row).toString().equals(datas[0])) {
                            break;
                        }
                    }
                    DB_Copy.updateRow("dun_daalgavar", row, data);
                    data.clear();

                    str = "true";
                } else {
                    str = "daalgavar_status хүснэгтэд бүртгэгдээгүй status_id, эсвэл student хүснэгтэд бүртгэгдээгүй student_id, эсвэл subject хүснэгтэд бүртгэгдээгүй subject_id байна!!";
                }

                return str;
            }
        }));

    }

    public static Object ReqFilters(String request, Object requestDatas) {
        ///-------------------------ProcessRequest-----------------///---------------------------------//
        Object response = null;

        for (RequestProcess processes : requestLists) {
            if (processes.requestName.equals(request)) {
                if (processes.type.equals(ProcessType.ALL)) {
                    response = processes.all.run(requestDatas);
                }
            }
        }
        return response;
    }

    public static void main(String args[]) {
        int i = 0;
        ReqFilter.InitializeRequest();
        ArrayList<RequestProcess> lists = requestLists;
        lists.sort(new Comparator<RequestProcess>() {

            @Override
            public int compare(RequestProcess o1, RequestProcess o2) {
                return o1.requestName.compareTo(o2.requestName);
            }
        });
        for (RequestProcess a : lists) {
            i++;
            System.out.println(i + "-" + a.requestName);
        }
    }
}
