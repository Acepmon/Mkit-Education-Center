package ManagerPac;

class StudentObj {
    private String id;
    private String firstName;
    private String className;
    private String computerName;

    public StudentObj(String id, String firstName, String className, String computerName) {
        this.id = id;
        this.firstName = firstName;
        this.className = className;
        this.computerName = computerName;
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

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    
}
