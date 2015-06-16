package teacher.model;


public class Daalgavar {
    private Column dun;
    private Column date;

    public Daalgavar(Column dun, Column date) {
        this.dun = dun;
        this.date = date;
    }

    public Column getDun() {
        return dun;
    }

    public void setDun(Column dun) {
        this.dun = dun;
    }

    public Column getDate() {
        return date;
    }

    public void setDate(Column date) {
        this.date = date;
    }
           
    
}
