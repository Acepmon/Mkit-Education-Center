package ManagerPac;

public class ManagerObj {
    private String id;
    private String registration;
    private String lastName;
    private String firstName;
    private String status;
    private String phone;
    private String email;
    private String social;
    private String address;
    private String picture;
    private String drop;
    private String username;
    private String password;

    public ManagerObj(String id, String registration, String lastName, String firstName, String status, String phone, String email, String social, String address, String picture, String drop, String username, String password) {
        this.id = id;
        this.registration = registration;
        this.lastName = lastName;
        this.firstName = firstName;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.social = social;
        this.address = address;
        this.picture = picture;
        this.drop = drop;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
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
