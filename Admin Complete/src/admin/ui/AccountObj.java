package admin.ui;
/**
 *
 * @author Teegii
 */
public class AccountObj {
    
    private String id;
    private String username;
    private String password;
    private String accType;
    private String selectedAcc;
    
    public AccountObj(String id, String username, String password,  String accType){
    
        this.id = id;
        this.username = username;
        this.password = password;
        this.accType = accType;
//        this.selectedAcc = selectedAcc;        
    }
    
    public String getId(){
        return id;
    }
    public void setId (String id){
        this.id = id;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getAccType(){
        return accType;
    }
    public void setAccType(String accType){
        this.accType = accType;
    }
    
    public String getSelectedAcc(){
        return selectedAcc;
    }
    public void setSelectedAcc(String selectedAcc){
        this.selectedAcc = selectedAcc;
    }
    
}
