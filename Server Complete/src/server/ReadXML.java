package Server;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import teacher.model.Columns;

public class ReadXML {

    static Document doc;
    static File fXmlFile;
    static NodeList nList;

    public static Object main() throws ParserConfigurationException, SAXException, IOException {
          
        ArrayList<Object> tailans = new ArrayList<>();
        
        ArrayList<Object> tailanTeahcerIDCol = DB_Copy.getDatas("tailan", "teacher_id");
        ArrayList<Object> tailanTitles = DB_Copy.getDatas("tailan", "tailan_title");

        for (int i = 0; i < tailanTeahcerIDCol.size(); i++) {

//            if (tailanTeahcerIDCol.get(i).equals(teacherID)) {
             //   System.out.println(tailanTeahcerIDCol.get(i));
                try {
                    ArrayList<Columns> tailan = new ArrayList<>();
                    String tailan_names = DB_Copy.getDatas("tailan", "tailan_name", i).toString();
                    fXmlFile = new File("E:\\ServerFiles\\Tailan\\" + tailan_names);
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    doc = dBuilder.parse(fXmlFile);
                    doc.getDocumentElement().normalize();

                    nList = doc.getElementsByTagName("column");
                    
                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            String colName = eElement.getElementsByTagName("columnName").item(0).getTextContent();
                            String colType = eElement.getElementsByTagName("columnType").item(0).getTextContent();
                            NodeList datas = eElement.getElementsByTagName("datas").item(0).getChildNodes();
                            ArrayList<Object> dataList = new ArrayList<>();

                            for (int ba = 0; ba < datas.getLength(); ba++) {
                                Node nd = datas.item(ba);
                                if (nd.getNodeType() == Node.ELEMENT_NODE) {
                                    dataList.add(nd.getTextContent());
                                }
                            }

                            Columns col = new Columns(colName, colType, dataList);
                            
                            tailan.add(col);
//                            System.out.println("tailan--->" + tailan);
                        }
                    }
                    tailans.add(tailanTitles.get(i));
                    tailans.add(tailan);

                } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
                    e.printStackTrace();
                }
            }
        return tailans;
    }
}
