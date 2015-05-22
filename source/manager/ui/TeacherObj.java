package ManagerPac;

public class TeacherObj {
    private String id;
    private String firstName;
    private String className;
    private String mobile;

    public TeacherObj(String id, String firstName, String className, String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.className = className;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
}
