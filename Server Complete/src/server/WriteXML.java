package Server;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import teacher.model.Columns;

public class WriteXML {
    
public static DatabaseTools db;
public void writeXmlFile(ArrayList<Columns> list, String username, String title) {
    db = new DatabaseTools();
    String xmlFileName = "tailan--"+((Math.random()*100)+1)+".xml";
//    DB_Copy copy = new DB_Copy();
    try {

        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        Document doc = build.newDocument();

        Element root = doc.createElement("Tailan");
        doc.appendChild(root);


        for (Columns col : list) {
            
            Element column = doc.createElement("column");
            root.appendChild(column);
            
            Element name = doc.createElement("columnName");
            name.appendChild(doc.createTextNode(String.valueOf(col.getColumnName())));
            column.appendChild(name);
            
            Element type = doc.createElement("columnType");
            type.appendChild(doc.createTextNode(String.valueOf(col.getColumnType())));
            column.appendChild(type);
            
            Element datas = doc.createElement("datas");
            column.appendChild(datas);
            
            
            for (Object obj : col.getData()) {
                Element data = doc.createElement("data");
                data.appendChild(doc.createTextNode(String.valueOf(obj)));
                datas.appendChild(data);
            }
            
        }
        
        // Save the document to the disk files
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();

        // format the XML nicely
        aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        aTransformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        try {
            // location and name of XML file you can change as per need
            

            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf = 
            new java.text.SimpleDateFormat("yyyy-MM-dd");

            String currentTime = sdf.format(dt);
            String userName= username;
            ArrayList<Object> nameCol = DB_Copy.getDatas("teacher", "username");
            String fndTeacherAccID = "";
            int i = 0;
            for(;i<nameCol.size();i++){
                if(nameCol.get(i).toString().equals(userName)){
                 fndTeacherAccID = DB_Copy.getDatas("teacher", "teacher_id", i).toString();
                    System.out.println("teacherID--->"+fndTeacherAccID);
                 break;
                }
            }
        
            System.out.println(">>>>>>>>>>>>>"+fndTeacherAccID);
            
            String query = "insert into tailan  (tailan_name, teacher_id, ognoo) values ('"+xmlFileName+"',"+fndTeacherAccID+","+currentTime+")";
            String query2 = "insert into tailan (tailan_name, teacher_id, ognoo, tailan_title) values (?, ?, ?, ?)";
            PreparedStatement ps = db.connection.prepareStatement(query2);
            ps.setString(1, xmlFileName);
            ps.setInt(2, Integer.parseInt(fndTeacherAccID));
            ps.setString(3, currentTime);
            ps.setString(4, title);
            ps.executeUpdate();
            
            
            String query1 = "select*from tailan  order by tailan_id desc limit 1";
            ResultSet results = db.runQuery(query1);
            
            ArrayList<Object> data = new ArrayList<>();
               while(results.next()){
                    data.add(results.getString(1));
                    data.add(results.getString(2));
                    data.add(results.getString(3));
                    data.add(results.getString(4));
                    data.add(results.getString(5));
                    break;
                }
            
            DB_Copy.insertRow("tailan", data);
            FileWriter fos = new FileWriter("E:\\ServerFiles\\Tailan\\"+xmlFileName);
            
            System.out.println("Tailanguud DB_COpy..."+DB_Copy.getDatas("tailan"));
            System.out.println(currentTime);
            
            StreamResult result = new StreamResult(fos);
            aTransformer.transform(source, result);

        }catch (IOException | SQLException e) {

            e.printStackTrace();
        }

    } catch (TransformerException ex) {
        System.out.println("Error outputting document");

    } catch (ParserConfigurationException ex) {
        System.out.println("Error building document");
    }
  }
}
