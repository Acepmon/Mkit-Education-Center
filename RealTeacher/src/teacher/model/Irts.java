package teacher.model;

public class Irts {
    
    private Columns dun;
    private Columns date;

    public Irts(Columns dun, Columns date) {
        this.dun = dun;
        this.date = date;
    }

    public Columns getDun() {
        return dun;
    }

    public void setDun(Columns dun) {
        this.dun = dun;
    }

    public Columns getDate() {
        return date;
    }

    public void setDate(Columns date) {
        this.date = date;
    }
    
}
