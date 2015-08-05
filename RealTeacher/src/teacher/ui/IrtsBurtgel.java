package teacher.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.util.StringConverter;
import teacher.controller.ServerConnection;
import teacher.model.Columns;
import teacher.model.CustomTable2;
import teacher.model.DunOruulahModel;

public class IrtsBurtgel {

    public static final ObservableList<FlowPane> oyutan = FXCollections.observableArrayList();
    private TableView table;
    private FlowPane irts;
    private CustomTable2 customT;

//    private String[] mass;
    private ObservableList<DunOruulahModel> responseData;
    Node getContainer;
        private final String pattern = "yyyy/MM/dd";
        
     private ObservableList<String> resd;
        
    class Nerniid {

        String ner;
        ArrayList<String> data = new ArrayList<>();
    }

    static class Row {

        private String[] data1;

        private String name;
        static int index = 0;

        public Row(String name, String[] data1) {
            this.data1 = data1;
        }

        public String getData1(int index) {
            return data1[index];
        }

        public void setData1(String[] data1) {
            this.data1 = data1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public IrtsBurtgel() {
//        ArrayList<String> resd = (ArrayList<String>) ClientTest.RequestAjluulah("getClassIrts",CustomerLogin.getTmp_username());

//        ObservableList<String> responseData =(ObservableList<String>) ClientTest.RequestAjluulah("getClassIrts",CustomerLogin.getTmp_username());
//        System.out.println("a asd ="+resd);
//        if (!resd.equals("") && resd == null) {
//            for (String str : resd) {
//                System.out.println(str);
//            }
//        }
        resd = FXCollections.observableArrayList();

        resd.add("mongol::harisan::2015/05/01");
        resd.add("sugra::ovchtei::2015/04/01");
        resd.add("sugra::tasalsan::2015/04/02");
        resd.add("zorigo::irsen::2015/04/01");
        resd.add("bat::tasalsan::2015/01/12");
        resd.add("bold::irsen::2015/03/02");
        resd.add("bold::yavsan::2015/03/03");

        ObservableList<Row> datas = FXCollections.observableArrayList();

        irts = new FlowPane();
        irts.setPrefSize(1100, 700);
        irts.setStyle("-fx-background-color: #F6F6F7");

        BorderPane topBf = new BorderPane();
        topBf.setPrefSize(1100, 60);
        topBf.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        Label nameLbl = new Label("Ирц оруулах");
        nameLbl.setStyle("-fx-background-color: #E6E6E6; -fx-padding: 10px;");
        nameLbl.setAlignment(Pos.CENTER);
        nameLbl.setPrefSize(200, 60);
        nameLbl.setFont(javafx.scene.text.Font.font("Arial", 18));

        FlowPane btnFl = new FlowPane(10, 10);
        btnFl.setAlignment(Pos.CENTER);
        btnFl.setPrefSize(600, 60);

ObservableList<String> options = 
    FXCollections.observableArrayList();
        ArrayList<String> students = (ArrayList<String>) ServerConnection.RequestAjluulah("getAllStudentProfile", null);
        for (String student : students) {
            String[] spl = student.split("::");
            String ovog = spl[2];
            String ner = spl[3];
            String name = ovog + " "+ ner;
            options.add(name);
            
            System.out.println(student);
        }

ObservableList<String> statusOptions
                = FXCollections.observableArrayList();
        String option1 = "Ирсэн      \t"+"("+5+")";
        String option2 = "Тасалсан    \t"+"("+0+")";
        String option3 = "Өвчтэй     \t"+"("+4+")";
        String option4 = "Чөлөөтэй     \t"+"("+4+")";
        
        statusOptions.addAll(option1,option2,option3,option4);
        
        ComboBox comboBox = new ComboBox(options);
        comboBox.setMinWidth(100);
        comboBox.setMaxWidth(100);
        comboBox.setItems(options);
        comboBox.getSelectionModel().select(0);

        
        ComboBox comboBox2 = new ComboBox(statusOptions);
        comboBox2.setMinWidth(100);
        comboBox2.setMaxWidth(100);
        comboBox2.setValue("Ирсэн");

//ComboBox comboBox = new ComboBox(options);
//comboBox.setItems(options);
////comboBox.setValue("Болд");
//ComboBox comboBox2 = new ComboBox(statusOptions);
//comboBox2.setItems(statusOptions);
//comboBox2.setValue("Ирсэн");
       DatePicker checkInDatePicker = new DatePicker();
       checkInDatePicker.setValue(LocalDate.now());
               StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = 
                DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };             
        checkInDatePicker.setConverter(converter);
        checkInDatePicker.setPromptText(pattern.toLowerCase());
       
        final Button addButton = new Button("  Нэмэх  ");
                addButton.setId("green");
        addButton.setOnAction((ActionEvent e) -> {
            
            String comboBox2Value = comboBox2.getValue().toString();
            comboBox2Value = comboBox2Value.split("\t")[0];
            String comb1 = comboBox.getValue().toString();
            String comb2 = comboBox2Value;
            String onsarudur = checkInDatePicker.getValue().toString();
            onsarudur = onsarudur.replaceAll("-", "/");
            
//            String comb1 = comboBox.getValue().toString();
//            String comb2 = comboBox2.getValue().toString();
//            String onsarudur = checkInDatePicker.getValue().toString();
//            onsarudur = onsarudur.replaceAll("-", "/");
            
            String total = ""+comb1+"::"+comb2+"::"+onsarudur;
//            System.out.println(total);
            
//            resd.stream().forEach((str) -> System.out.println(str));
//            System.out.println("asno fbasdof gsbdo");
            resd.add(total);
            
//            resd.stream().forEach((str) -> System.out.println(str));
            refreshTable();
        });

        //
        
                btnFl.getChildren().addAll(comboBox,comboBox2,checkInDatePicker,addButton);

        topBf.setLeft(nameLbl);
        topBf.setRight(btnFl);

        //////////////////////////////// 
        customT = new CustomTable2();
        customT.setCol_width(150);
        table = customT.getTable();
        table.setEditable(true);
        table.setItems(datas);
        table.setStyle("-fx-alignment: CENTER;");
        table.setPrefSize(1020, 645);
        
        
        resd.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] day1split = o1.split("::");
                String[] day2split = o2.split("::");
                
                int year1int = Integer.parseInt(day1split[2].split("/")[0]);
                int year2int = Integer.parseInt(day2split[2].split("/")[0]);

                int month1int = Integer.parseInt(day1split[2].split("/")[1]);
                int month2int = Integer.parseInt(day2split[2].split("/")[1]);
                
                int day1int = Integer.parseInt(day1split[2].split("/")[2]);
                int day2int = Integer.parseInt(day2split[2].split("/")[2]);
                
                if (year1int == year2int) {
                    if (month1int == month2int) {
                        if (day1int == day2int) {
                            return 0;
                        } else if (day1int > day2int) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if (month1int > month2int) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (year1int > year2int) {
                    return 1;
                } else {
                    return -1;
                }

            }
        });
        ArrayList<ArrayList<String>> tableMedeelel = tableMedeelel(resd);
//        System.out.println(tableMedeelel);
        ArrayList<Columns> customTableData = new ArrayList<>();
        
        for (int j = 0; j < tableMedeelel.get(0).size(); j++) {
            String colName = tableMedeelel.get(0).get(j);

            ArrayList<Object> colDatas = new ArrayList<>();
            for (int i = 1; i < tableMedeelel.size(); i++) {
                colDatas.add(tableMedeelel.get(i).get(j));
            }

            customTableData.add(new Columns(colName, colDatas));
        }
        Columns[] columns = new Columns[customTableData.size()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = customTableData.get(i);
        }
        customT.addColumns(columns);
        

        irts.getChildren().addAll(topBf, table);

    }

    public FlowPane getContainer() {
        return this.irts;
    }

    private ArrayList<String> resdeesNerSalgah(ObservableList<String> resd) {
        ArrayList<String> ners = new ArrayList<>();
        for (String res : resd) {
            String[] split = res.split("::");
            boolean davhard = false;
            for (String ner : ners) {
                if (ner.equals(split[0])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                ners.add(split[0]);
            }
//            System.out.print(ners);
        }
        return ners;
    }

    private ArrayList<String> resdeesOgnooSalgah(ObservableList<String> resd) {
        ArrayList<String> ognoo = new ArrayList<>();
        for (String res1 : resd) {
            String[] split = res1.split("::");
            boolean davhard = false;
            for (String ognoo1 : ognoo) {
                if (ognoo1.equals(split[2])) {
                    davhard = true;
                }
            }
            if (davhard == false) {
                ognoo.add(split[2]);
            }
        }
        return ognoo;
    }

    private ArrayList<Nerniid> nereesUtgaSalgah(ObservableList<String> resd) {
        ArrayList<Nerniid> nerniiduud = new ArrayList<>();
        ArrayList<String> ners = resdeesNerSalgah(resd);
        for (String ner : ners) {
            Nerniid nerniid = new Nerniid();
            nerniid.ner = ner;
            for (String orig : resd) {
                String[] split = orig.split("::");
                if (ner.equals(split[0])) {
                    String data = split[1] + "::" + split[2];
                    nerniid.data.add(data);
                }
            }
            nerniiduud.add(nerniid);
        }
        return nerniiduud;
    }

    private ArrayList<ArrayList<String>> tableMedeelel(ObservableList<String> resd) {
        ArrayList<ArrayList<String>> medeelelList = new ArrayList<>();

        ArrayList<Nerniid> nerniid = nereesUtgaSalgah(resd);
        ArrayList<String> ognoo = resdeesOgnooSalgah(resd);

//        medeelelList.get(0).add("Ners");
//        for (String ogn : ognoo) {
//            medeelelList.get(0).add(ogn);
//        }
        ArrayList<String> medeelel0 = new ArrayList<>();
        medeelel0.add("Нэрс");
        for (String ogn : ognoo) {
            medeelel0.add(ogn);
        }
        medeelelList.add(medeelel0);

        for (Nerniid nern : nerniid) {

            ArrayList<String> medeelel = new ArrayList<>();
            medeelel.add(nern.ner);
            // Hooson utga medeeld oruulah
            for (String ogn : ognoo) {
                medeelel.add("-");
            }
            // ************************

            for (String data : nern.data) {
                String[] split = data.split("::");
                String status = split[0];
                String on = split[1];

                for (int i = 0; i < ognoo.size(); i++) {
                    if (ognoo.get(i).equals(on)) {
                        medeelel.set(i + 1, status);
                    }
                }
            }

            medeelelList.add(medeelel);
        }

        return medeelelList;
    }
    
    
    private void refreshTable() {
        customT.clearTable();
        
        resd.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String[] day1split = o1.split("::");
                String[] day2split = o2.split("::");
                
                int year1int = Integer.parseInt(day1split[2].split("/")[0]);
                int year2int = Integer.parseInt(day2split[2].split("/")[0]);

                int month1int = Integer.parseInt(day1split[2].split("/")[1]);
                int month2int = Integer.parseInt(day2split[2].split("/")[1]);
                
                int day1int = Integer.parseInt(day1split[2].split("/")[2]);
                int day2int = Integer.parseInt(day2split[2].split("/")[2]);
                
                if (year1int == year2int) {
                    if (month1int == month2int) {
                        if (day1int == day2int) {
                            return 0;
                        } else if (day1int > day2int) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if (month1int > month2int) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (year1int > year2int) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        ArrayList<ArrayList<String>> tableMedeelel = tableMedeelel(resd);
//        System.out.println(tableMedeelel);
        ArrayList<Columns> customTableData = new ArrayList<>();
        for (int j = 0; j < tableMedeelel.get(0).size(); j++) {
            String colName = tableMedeelel.get(0).get(j);

            ArrayList<Object> colDatas = new ArrayList<>();
            for (int i = 1; i < tableMedeelel.size(); i++) {
                colDatas.add(tableMedeelel.get(i).get(j));
            }

            customTableData.add(new Columns(colName, colDatas));
        }
        Columns[] columns = new Columns[customTableData.size()];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = customTableData.get(i);
        }
        customT.addColumns(columns);
    }

}
