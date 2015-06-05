package ManagerPac;

public class TeacherObj {
    String code;
    String name;
    String className;
    String phoneNumber;

    public TeacherObj(String code, String name, String className, String phoneNumber) {
        this.code = code;
        this.name = name;
        this.className = className;
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
