package admin.ui;

import static admin.ui.Account.tableAcc;
import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import login.ui.ServerConnection;
/**
 *
 * @author JAVA M2
 */
public class EditAccount {
    
    String AccTypes = "";
    String selectedName = "";
    
    private ObservableList<AccountObj> dataNew = FXCollections.observableArrayList();
    
    public void start(Stage editAccountStage, AccountObj datas) throws Exception{
                
        editAccountStage.setTitle("Хэрэглэгч засах хэсэг");
        FlowPane editPane = new FlowPane(20, 20);
        editPane.setAlignment(Pos.CENTER);
        Scene editScene = new Scene(editPane, 400, 350);
        
        ComboBox<String> cbSelAccount, cbAccNameSel;
        
        String idNew = datas.getId();        
        String uname = datas.getUsername();
        String pass = datas.getPassword();
        String type = datas.getAccType();
        String selAcc = datas.getSelectedAcc();
        
        Label idLabel = new Label("id:");
        idLabel.setFont(Font.font("Verdina", 14));
        idLabel.setPrefSize(150, 20);
        
        TextField idText = new TextField();
        idText.setPrefSize(150, 20);
        idText.setText(idNew);
        
        Label username = new Label("Хэрэглэгчийн нэр:");
        username.setFont(Font.font("Verdina", 14));
        username.setPrefSize(150, 20);
        
        TextField usernameText = new TextField();
        usernameText.setPrefSize(150, 20);
        usernameText.setText(uname);
        
        Label password = new Label("Нууц үг:");
        password.setFont(Font.font("Verdina", 14));
        password.setPrefSize(150, 20);
        
        TextField passText = new TextField();
        passText.setPrefSize(150, 20);
        passText.setText(pass);
                
        Label accountType = new Label("Төрөл:");
        accountType.setFont(Font.font("Verdina", 14));
        accountType.setPrefSize(150, 20);      
                        
        ObservableList<String> accTypeSel = FXCollections.observableArrayList("Student", "Teacher", "Manager", "Admin");
        cbSelAccount = new ComboBox<String>(accTypeSel);
        cbSelAccount.setPrefSize(150, 20);
        cbSelAccount.setValue(type);
        
        TextField cbSelAccountTxt = new TextField();
        cbSelAccountTxt.setText(type);
        cbSelAccountTxt.setFont(Font.font("Verdina", 14));
        cbSelAccountTxt.setPrefSize(150, 20);  
        
        Label accountSelOne = new Label("Акаунт сонгох:");
        accountSelOne.setFont(Font.font("Verdina", 14));
        accountSelOne.setPrefSize(150, 20);  
//        cbSelAccount.setValue("Choose Type");
        
        ObservableList<String> accNameSel = FXCollections.observableArrayList();
        cbAccNameSel = new ComboBox<>(accNameSel);
        cbAccNameSel.setPrefSize(150, 20);  
        
        cbAccNameSel.setValue("нэр сонгоно уу..");
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
        TextField cbAccNameSelTxt = new TextField();
        cbAccNameSelTxt.setText(selAcc);
        cbAccNameSelTxt.setFont(Font.font("Verdina", 14));
        cbAccNameSelTxt.setPrefSize(150, 20);
        
        Label idError = new Label("***");
        idError.setPrefSize(20, 20);
        idError.setStyle("-fx-text-fill: red"); 
        idError.setVisible(false);
        
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
        btnRegister.setFont(Font.font("Verdina", 14));
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
        btnRegister.setOnAction(ae -> {  
            
            selectedName = cbAccNameSel.getValue();
            String idNews = datas.getId();
            
            String usernameNew = usernameText.getText();
            String passwordNew = passText.getText();
//            String repassNew = repassText.getText();
            String typeNew =  cbSelAccount.getSelectionModel().getSelectedItem();
            int typeIndex = cbSelAccount.getSelectionModel().getSelectedIndex()+1;
            String selectedNameNew = selectedName.split("::")[0];
            System.out.println("USerName-->"+usernameNew);
            System.out.println("Password--->"+passwordNew);
            System.out.println("TypeIndex>"+typeIndex);
            System.out.println("TypeNew-->"+AccTypes);
            System.out.println("nameindex-->"+selectedNameNew);
            
            String updateProfile = ""+idNews+"::"+usernameNew+"::"+passwordNew+"::"+typeIndex+"::"+selectedNameNew+"::"+typeNew+"";
            
            System.out.println("edit account is -->"+updateProfile);
            
            System.out.println("req--->"+ServerConnection.RequestAjluulah("updateAcc", updateProfile));
            
                                    
            dataNew.add(new AccountObj(idNews, usernameNew, passwordNew, AccTypes));

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
            
            if(usernameText.getText().equals("")||passText.getText().equals("")){
                error.setVisible(true);      
            }else{
                error.setVisible(false);
            }  
            editAccountStage.close();
        });
        
        Button btnCancel = new Button("Болих");
        btnCancel.setFont(Font.font("Verdina", 14));
        btnCancel.setPrefSize(120, 20);
        btnCancel.setStyle("-fx-background-color: \n" +
                            "#3c7fb1,\n" +
                            "linear-gradient(#fafdfe, #e8f5fc),\n" +
                            "linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);\n" +
                            "-fx-background-insets: 0,1,2;\n" +
                            "-fx-background-radius: 3,2,1;\n" +
                            "-fx-padding: 3 30 3 30;\n" +
                            "-fx-text-fill: black;\n" +
                            "-fx-font-size: 12px;");
        btnCancel.setOnAction(ae -> {
            editAccountStage.close();
        });
        
        editPane.getChildren().addAll(
                idLabel,
                idText,
                idError,
                username, 
                usernameText, 
                usernameError, 
                password, 
                passText, 
                passwordError, 
                accountType, 
                cbSelAccount,
                typeError,
                accountSelOne,
                cbAccNameSel,
                selectError,
                btnRegister,
                btnCancel,
                error
        );        
        editAccountStage.setScene(editScene);
        editAccountStage.show();   
//        editAccountStage.setResizable(false);        
    }    
    
    public Object AccReq(){
        Object list = ServerConnection.RequestAjluulah("firstNamesOnType", ""+AccTypes+"");
        return list;
    }
    
}
