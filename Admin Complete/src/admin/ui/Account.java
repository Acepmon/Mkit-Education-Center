package admin.ui;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import login.ui.ServerConnection;

public class Account{
    private Pane pane;    
    
    public static TableView tableAcc = new TableView();
    public static int rowIndex = -1;
    private ObservableList<AccountObj> dataNew = FXCollections.observableArrayList();
    
    String AccTypes = "";
    String selectedName = "";
    String responseData = "";
    String responseDataId = "";
    public Account(){
        
        pane = new Pane();
        ComboBox<String> cbSelAccount, cbAccNameSel;
        
        Label account = new Label("Хэрэглэгч нэмэх хэсэг");
        account.setFont(Font.font(null, FontWeight.BOLD, 16));
        account.setAlignment(Pos.CENTER);
        account.setPrefSize(250, 20);
                      
        Label username = new Label("Хэрэглэгчийн нэр");
        username.setPrefSize(150, 20);
        
        TextField usernameText = new TextField();
        usernameText.setPrefSize(150, 20);
        
        Label password = new Label("Нууц үг");
        password.setPrefSize(150, 20);
        
        PasswordField passText = new PasswordField();
        passText.setPrefSize(150, 20);
        
        Label repass = new Label("Нууц үг давтах");
        repass.setPrefSize(150, 20);
        
        PasswordField repassText = new PasswordField();
        repassText.setPrefSize(150, 20);
        
        Label accountType = new Label("Төрөл");
        accountType.setPrefSize(150, 20);        
        
        ObservableList<String> accTypeSel = FXCollections.observableArrayList("Student", "Teacher", "Manager", "Admin");
        cbSelAccount = new ComboBox<>(accTypeSel);
        cbSelAccount.setPrefSize(150, 20);        
        cbSelAccount.setValue("Төрөл сонгох");        
        
        Label accountSelOne = new Label("Акаунт сонгох");
        accountSelOne.setPrefSize(150, 20);
        
        ObservableList<String> accNameSel = FXCollections.observableArrayList();
        cbAccNameSel = new ComboBox<>(accNameSel);
        cbAccNameSel.setPrefSize(150, 20);  
        
        cbAccNameSel.setValue("нэр сонгох...");
        cbAccNameSel.setOnAction(ae->{            
            System.out.println("Selected name is --> " + cbAccNameSel.getValue());
            
        });        
          
        cbSelAccount.setOnAction(ae->{  
            
            System.out.println("Selected acountType is " + cbSelAccount.getValue());
            accountSelOne.setText(cbSelAccount.getValue() + " name");
            
            if(cbSelAccount.getValue().equals("Student")){
                accNameSel.clear();
                AccTypes = "student";
                ArrayList<String> studentNames = (ArrayList<String>)AccReq();
                System.out.println(studentNames+"sutjdkfjsdfjk");
                for(int i = 0; i<studentNames.size(); i++){
                    
                    accNameSel.add(studentNames.get(i));
                }      
            }
            else if(cbSelAccount.getValue().equals("Teacher")){
               accNameSel.clear();
                AccTypes = "teacher";
                 ArrayList<String> studentNames = (ArrayList<String>)AccReq();
                for(int i = 0; i<studentNames.size(); i++){
                    
                    accNameSel.add(studentNames.get(i));
                }
            }
            else if(cbSelAccount.getValue().equals("Manager")){
               accNameSel.clear();
                AccTypes = "manager";
                System.out.println("managers..."+AccReq());
                 ArrayList<String> studentNames = (ArrayList<String>)AccReq();
                for(int i = 0; i<studentNames.size(); i++){
                    
                    accNameSel.add(studentNames.get(i));
                }
            }
            else if(cbSelAccount.getValue().equals("Admin")){
                accNameSel.clear();
                AccTypes = "admin";
                System.out.println("admins..."+AccReq());
                 ArrayList<String> studentNames = (ArrayList<String>)AccReq();               
                for(int i = 0; i<studentNames.size(); i++){
                    
                    accNameSel.add(studentNames.get(i));
                }
            }            
        });
        
        Label usernameError = new Label("***");
        usernameError.setPrefSize(20, 20);
        usernameError.setStyle("-fx-text-fill: red"); 
        usernameError.setVisible(false);
        
        Label passwordError = new Label("***");
        passwordError.setPrefSize(20, 20);
        passwordError.setStyle("-fx-text-fill: red"); 
        passwordError.setVisible(false);
        
        Label rePassError = new Label("***");
        rePassError.setPrefSize(20, 20);
        rePassError.setStyle("-fx-text-fill: red"); 
        rePassError.setVisible(false);         
        
        Label typeError = new Label("***");
        typeError.setPrefSize(20, 20);
        typeError.setStyle("-fx-text-fill: red"); 
        typeError.setVisible(false);
        
        Label selectError = new Label("***");
        selectError.setPrefSize(20, 20);
        selectError.setStyle("-fx-text-fill: red"); 
        selectError.setVisible(false);
        
        Label error = new Label("Улаанаар тэмдэглэсэн хэсгийг бөглөнө үү !!!");
        error.setPrefSize(300, 20);
        error.setAlignment(Pos.CENTER);
        error.setStyle("-fx-text-fill: red");
        error.setVisible(false);
        
        Button btnRegister = new Button("Бүртгэх");
        btnRegister.setPrefSize(120, 20);
        btnRegister.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");
        btnRegister.setOnAction(ae-> {
            
            selectedName = cbAccNameSel.getValue();
            
            String usernameNew = usernameText.getText();
            String passwordNew = passText.getText();
            String repassNew = repassText.getText();
            String typeNew =  cbSelAccount.getSelectionModel().getSelectedItem();
            int typeIndex = cbSelAccount.getSelectionModel().getSelectedIndex()+1;
            
           
            String selectedNameNew = selectedName.split("::")[0];
            System.out.println("USerName-->"+usernameNew);
            System.out.println("POassword--->"+passwordNew);
            System.out.println("TypeIndex>"+typeIndex);
            System.out.println("TypeNew-->"+AccTypes);
            System.out.println("nameindex-->"+selectedNameNew);
             
            System.out.println("Insert Acocount--->"+ServerConnection.RequestAjluulah("insertAccountAndAnd", ""+usernameNew+"::"+passwordNew+"::"+typeIndex+"::"+selectedNameNew+"::"+typeNew+""));;
             
            System.out.println("id-->"+ServerConnection.RequestAjluulah("insertAccountAndAnd", ""+usernameNew+"::"+passwordNew+"::"+typeIndex+"::"+selectedNameNew+"::"+typeNew+""));
             
            AccountObj acco = (AccountObj) dataNew.get(dataNew.size()-1);
            int dada = (Integer.parseInt(acco.getId())+1);
            String dadanew  = ""+dada+"";
            dataNew.add(new AccountObj(dadanew, usernameNew, passwordNew, typeNew));
             
            if(usernameText.getText().equals("")){
                usernameError.setVisible(true);
            } else{
                usernameError.setVisible(false);
            }
           
            if(passText.getText().equals("")){
                passwordError.setVisible(true);
            } else{
                passwordError.setVisible(false);
            }
             
            if(repassText.getText().equals("")){
                rePassError.setVisible(true);
            } else{
                rePassError.setVisible(false);
            }
              
            if (!passText.getText().equals(repassText.getText())) {
                passwordError.setVisible(true);
                rePassError.setVisible(true);
                passwordError.setStyle("-fx-text-fill: blue"); 
                rePassError.setStyle("-fx-text-fill: blue");
            }
              
            if(usernameText.getText().equals("")||passText.getText().equals("")||repassText.getText().equals("")){
                error.setVisible(true);      
            }else{
                error.setVisible(false);
            }   
             
        });
        
        GridPane centerPart = new GridPane();
        centerPart.setPrefSize(824, 600);
        centerPart.setStyle("-fx-background-color: #E6FFFF");
        centerPart.setMinSize(10, 10);

        FlowPane centerLeftPart = new FlowPane();
        centerLeftPart.setAlignment(Pos.CENTER);
        centerLeftPart.setPrefSize(550, 600);
        centerLeftPart.setStyle("-fx-background-color: #E6FFFF");
        centerLeftPart.setMinWidth(0);

                
        FlowPane rootFlow = new FlowPane(20, 20);
        rootFlow.setAlignment(Pos.CENTER);
        rootFlow.setPrefWidth(400);
        
        FlowPane rootFlow2 = new FlowPane(20, 20);
        rootFlow2.setAlignment(Pos.CENTER);
        rootFlow2.setPrefWidth(400);
        
        centerPart.setVgap(25);
        
//        *********** table ***********
        Label tablename = new Label("Хэрэглэгчийн хүснэгт");
        tablename.setFont(Font.font(null, FontWeight.BOLD, 16));
        tablename.setAlignment(Pos.CENTER);
        tablename.setPrefSize(200, 30);
        
        TableColumn idColumn = new TableColumn("id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("id"));

        TableColumn usernameColumn = new TableColumn("username");
        usernameColumn.setMinWidth(100);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("username"));

        TableColumn passwordColumn = new TableColumn("password");
        passwordColumn.setMinWidth(100);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("password"));


        TableColumn accTypeColumn = new TableColumn("AccountType");
        accTypeColumn.setMinWidth(100);
        accTypeColumn.setCellValueFactory(new PropertyValueFactory<AccountObj, String>("accType"));
        
        tableAcc.getColumns().addAll(
                idColumn,
                usernameColumn,
                passwordColumn,
                accTypeColumn
        );
        tableAcc.setPrefSize(400, 400);
        
//        ArrayList<String> responseData = (ArrayList<String>) ServerConnection.Request("getAllAccounts", null);        
//        System.out.println("---- accounts "+responseData);   
        
//        for(String str : responseData){
//            if (!str.equals("") && str != null) {
//            String[] col = str.split("::");
//            dataNew.addAll(new AccountObj(col[0], col[1], col[2], col[3]));
//            }
//        }
        
        tableAcc.setItems(dataNew);
        
        tableAcc.setOnMouseClicked(ae -> {
            int c = tableAcc.getSelectionModel().getSelectedIndex();
            System.out.println(c);
            rowIndex = c;  
        });
        
        
        Button deleteBtn = new Button("Устгах");
        deleteBtn.setPrefSize(100, 30);
        deleteBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");
        deleteBtn.setOnAction(ae -> {
            
        });        
        Button editBtn = new Button("Засах");        
        editBtn.setPrefSize(100, 30);
        editBtn.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");
        editBtn.setOnAction(ae -> {
//            if(rowIndex!=-1){
                Stage editAccountStage = new Stage();         
                try {
                    new EditAccount().start(editAccountStage, (AccountObj) tableAcc.getSelectionModel().getSelectedItem());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }           
//            }       
        });              
        tableAcc.setItems(dataNew);        
        rootFlow2.getChildren().addAll(tablename, tableAcc, editBtn, deleteBtn);
        
        centerPart.getChildren().addAll(rootFlow, rootFlow2);
        centerPart.setConstraints(rootFlow, 0, 0);
        centerPart.setConstraints(rootFlow2, 1, 0);
        rootFlow.getChildren().addAll(account, accountType, cbSelAccount,typeError,
                accountSelOne, cbAccNameSel,selectError, username, usernameText, usernameError, password, passText,
                passwordError, repass, repassText, rePassError, btnRegister, error);
        
        pane.getChildren().addAll(centerPart);
        pane.setVisible(true);
        
//        *************************************************************************
        
        Label tseejZurag = new Label("Зураг");
        tseejZurag.setPrefSize(180, 150);
        tseejZurag.setPadding(new Insets(20, 60, 0, 60));        
        
    }
    public Object AccReq(){
        Object list = ServerConnection.RequestAjluulah("firstNamesOnType", ""+AccTypes+"");
        return list;
    }
    
    public Pane getContainer() {
        return this.pane;
    }
    
}
