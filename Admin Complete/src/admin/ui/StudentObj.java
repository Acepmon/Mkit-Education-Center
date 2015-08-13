package admin.ui;

/* ene class ni database-ees irj bui utguudiig awch String huwisagchuudad onooj ugch baina */

public class StudentObj {
    
    private String id;
    private String bcode; // burtgeliin kod
    private String lastname;
    private String firstname;
    private String status;
    private String phonenum;
    private String email;
    private String social;
    private String register;
    private String address;
    private String classname; //bagsh songolt
    private String comnum;
    private String numstart; // eelj
    private String deleteFlag;
    private String reason;
    private String picture;
//    private String username;
//    private String password;
    
    
    public StudentObj(String id, 
                    String bcode, 
                    String firstname, 
                    String lastname,
                    String status, 
                    String phonenum, 
                    String email, 
                    String social,
                    String register, 
                    String address, 
                    String classname, 
                    String comnum, 
                    String numstart,
                    String deleteFlag, 
                    String reason, 
                    String picture 
//                    String username, 
//                    String password
    ){
        this.id = id;
        this.bcode = bcode;
        this.lastname = lastname;
        this.firstname = firstname;
        this.status = status;  
        this.phonenum = phonenum;
        this.email = email;
        this.social = social;
        this.register = register;
        this.address = address;
        this.classname = classname;
        this.comnum = comnum;
        this.numstart = numstart;
//        this.username = username;
//        this.password = password;
        this.deleteFlag = deleteFlag;
        this.reason = reason;
        this.picture = picture;
    }
    /* edgeer n getter setter functionuud ba getId() functioniig duudah uyd hargalzah utgaa butsaah bolno.*/

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the numberList
     */
    public String getBcode() {
        return bcode;
    }

    /**
     * @param numberList the numberList to set
     */
    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    /**
     * @return the lastName
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstName
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the phoneNum
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the social
     */
    public String getSocial() {
        return social;
    }

    /**
     * @param social the social to set
     */
    public void setSocial(String social) {
        this.social = social;
    }

    /**
     * @return the register
     */
    public String getRegister() {
        return register;
    }

    /**
     * @param register the register to set
     */
    public void setRegister(String register) {
        this.register = register;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the className
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param className the className to set
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     * @return the comNum
     */
    public String getComnum() {
        return comnum;
    }

    /**
     * @param comNum the comNum to set
     */
    public void setComnum(String comnum) {
        this.comnum = comnum;
    }

    /**
     * @return the numStart
     */
    public String getNumstart() {
        return numstart;
    }

    /**
     * @param numStart the numStart to set
     */
    public void setNumstart(String numstart) {
        this.numstart = numstart;
    }

    /**
     * @return the username
     */
//    public String getUsername() {
//        return username;
//    }

//    /**
//     * @param username the username to set
//     */
//    public void setUsername(String username) {
//        this.username = username;
//    }

    /**
     * @return the password
     */
//    public String getPassword() {
//        return password;
//    }

    /**
     * @param password the password to set
     */
//    public void setPassword(String password) {
//        this.password = password;
//    }

    /**
     * @return the deleteFlag
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag the deleteFlag to set
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the image to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
     public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    
}
