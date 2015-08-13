package admin.ui;

public class AdminObj {    
    private String id;
    private String register;
    private String lastName;
    private String firstName;
    private String status;
    private String phoneNum;    
    private String email;
    private String social;
    private String address;
    private String username;
    private String password;
    private String deleteFlag;
    private String picture;
    
    public AdminObj(String id, 
            String register, 
            String lastName, 
            String firstName, 
            String status, 
            String phoneNum, 
            String email, 
            String social, 
            String address, 
            String picture,
            String deleteFlag, 
            String username, 
            String password            
            
    ){
        this.id = id;
        this.register = register;
        this.lastName = lastName;
        this.firstName = firstName;
        this.status = status;  
        this.phoneNum = phoneNum;
        this.email = email;
        this.social = social;
        this.address = address;
        this.username = username;
        this.password = password;
        this.deleteFlag = deleteFlag;
        this.picture = picture;
    }
        
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }   
    
    public String getRegister(){
        return register;
    }
    public void setRegister(String register){
        this.register = register;
    }   
    
    public String getLastName(){
        return lastName;
    }    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getPhoneNum(){
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSocial(){
        return social;
    }
    public void setSocial(String social){
        this.social = social;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
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
    
    public String getDeleteFlag(){
        return deleteFlag;
    }
    public void setDeleteFlag(String deleteFlag){
        this.deleteFlag = deleteFlag;
    }
     
    public String getPicture(){
        return picture;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
    
}
