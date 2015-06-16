package ManagerPac;

public class TeacherObj {
    
    private String id;
    private String surname;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String className;
    private String computer;
    private String status;

    public TeacherObj(String id, String surname, String name, String phone, String address, String email, String className, String computer, String status) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.className = className;
        this.computer = computer;
        this.status = status;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
