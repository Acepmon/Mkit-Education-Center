package ManagerPac;

public class TeacherObj {
    
    private String id;
    private String registration;
    private String lastName;
    private String firstName;
    private String status;
    private String lesson;
    private String phone;
    private String email;
    private String social;
    private String address;
    private String deleteFlag;
    private String picture;
    private String username;
    private String password;

    public TeacherObj(String id, String registration, String lastName, String firstName, String status, String lesson, String phone, String email, String social, String address, String deleteFlag, String picture, String username, String password) {
        this.id = id;
        this.registration = registration;
        this.lastName = lastName;
        this.firstName = firstName;
        this.status = status;
        this.lesson = lesson;
        this.phone = phone;
        this.email = email;
        this.social = social;
        this.address = address;
        this.deleteFlag = deleteFlag;
        this.picture = picture;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
