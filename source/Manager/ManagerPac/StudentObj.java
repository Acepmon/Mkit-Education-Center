package ManagerPac;

public class StudentObj {
    private String id;
    private String code;
    private String lastName;
    private String firstName;
    private String status;
    private String phone;
    private String email;
    private String social;
    private String registration;
    private String address;
    private String teachers;
    private String comNum;
    private String admission;
    private String deleteFlag;
    private String reason;
    private String picture;

    public StudentObj(String id, String code, String lastName, String firstName, String status, String phone, String email, String social, String registration, String address, String teachers, String comNum, String admission, String deleteFlag, String reason, String picture) {
        this.id = id;
        this.code = code;
        this.lastName = lastName;
        this.firstName = firstName;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.social = social;
        this.registration = registration;
        this.address = address;
        this.teachers = teachers;
        this.comNum = comNum;
        this.admission = admission;
        this.deleteFlag = deleteFlag;
        this.reason = reason;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public String getComNum() {
        return comNum;
    }

    public void setComNum(String comNum) {
        this.comNum = comNum;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}