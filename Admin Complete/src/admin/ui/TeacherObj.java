package admin.ui;

public class TeacherObj {
    
    private String id;
    private String register;
    private String lastName;
    private String firstName;
    private String status;
    private String subject;
    private String phoneNum;
    private String social;
    private String address;
    private String email;
    private String username;
    private String password;
    private String deleteFlag;
    private String picture;
    
    
//    public TeacherObj(String id, String lastName, String firstName, String phoneNum, String address, String email, String className, String comNum, String status){
    public TeacherObj(String id, 
            String register, 
            String lastName, 
            String firstName, 
            String status, 
            String subject, 
            String phoneNum, 
            String email, 
            String social, 
            String address, 
            String deleteFlag, 
            String picture, 
            String username, 
            String password
                        
            
    ){
        this.id = id;
        this.register = register;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNum = phoneNum; 
        this.subject = subject;
        this.address = address;
        this.social = social;
        this.email = email;
        this.status = status;  
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
    
    public String getPhoneNum(){
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    
    public String getSubject(){
        return subject;
    }    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getSocial(){
        return social;
    }    
    public void setSocial(String social){
        this.social = social;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getDeleteFlag(){
        return deleteFlag;
    }
    public void setDeleteFlag(String deleteFlag){
        this.deleteFlag = deleteFlag;
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

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getPicture(){
        return picture;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
    
}
