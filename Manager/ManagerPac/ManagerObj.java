package ManagerPac;

public class ManagerObj {
    private String id;
    private String surname;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String status;
    private String picture;

    public ManagerObj(String id, String surname, String name, String phone, String address, String email, String status, String picture) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.status = status;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    
}
