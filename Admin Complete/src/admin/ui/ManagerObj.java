package admin.ui;

/* ene class ni database-ees irj bui utguudiig awch String huwisagchuudad onooj ugch baina */

public class ManagerObj {
    private String id;
    private String register;
    private String lastName;
    private String firstName;
    private String status;
    private String phoneNum;
    private String email;
    private String social;
    private String address;
    private String picture;
    private String deleteFlag;
    private String username;
    private String password;
        
    
    public ManagerObj(String id, 
            String register, 
            String lastName, 
            String firstName,
            String phoneNum,
            String email, 
            String social, 
            String address, 
            String picture,             
            String username, 
            String password,
            String deleteFlag, 
            String status
            
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
        this.picture = picture;
        this.username = username;
        this.password = password;
        this.deleteFlag = deleteFlag;
        
    }

    ManagerObj(String IDstr, String registerNew, String lastNameNew, String firstNameNew, int statusNew, int phoneNumNew, String emailNew, String socialNew, String addressNew, String picture, int delNew, String userNew, String passNew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* edgeer n getter setter functionuud ba getId() functioniig duudah uyd hargalzah utgaa butsaah bolno.*/
    
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
    
    public String getPicture(){
        return picture;
    }
    public void setPicture(String picture){
        this.picture = picture;
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
    
}
