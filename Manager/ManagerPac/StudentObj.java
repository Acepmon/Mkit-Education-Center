package ManagerPac;

public class StudentObj {
    String code;
    String name;
    String className;
    String comNumber;

    public StudentObj(String code, String name, String className, String comNumber) {
        this.code = code;
        this.name = name;
        this.className = className;
        this.comNumber = comNumber;
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

    public String getComNumber() {
        return comNumber;
    }

    public void setComNumber(String comNumber) {
        this.comNumber = comNumber;
    }
}
