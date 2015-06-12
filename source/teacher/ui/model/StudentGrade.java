package teacher.model;

import java.util.ArrayList;

public class StudentGrade {
    
    private String name;
    
    private Irts irts;
    private Idevhi idevhi;
    private Daalgavar daalgavar;
    private Shalgalt shalgalt;
    private BieDaalt biedaalt;
    private TosolDun tosoldun;


    public StudentGrade(String name, Irts irts, Idevhi idevhi, Daalgavar daalgavar, Shalgalt shalgalt, BieDaalt biedaalt, TosolDun tosoldun) {
        this.name = name;
        this.irts = irts;
        this.idevhi = idevhi;
        this.daalgavar = daalgavar;
        this.shalgalt = shalgalt;
        this.biedaalt = biedaalt;
        this.tosoldun = tosoldun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Irts getIrts() {
        return irts;
    }

    public void setIrts(Irts irts) {
        this.irts = irts;
    }

    public Idevhi getIdevhi() {
        return idevhi;
    }

    public void setIdevhi(Idevhi idevhi) {
        this.idevhi = idevhi;
    }

    public Daalgavar getDaalgavar() {
        return daalgavar;
    }

    public void setDaalgavar(Daalgavar daalgavar) {
        this.daalgavar = daalgavar;
    }

    public Shalgalt getShalgalt() {
        return shalgalt;
    }

    public void setShalgalt(Shalgalt shalgalt) {
        this.shalgalt = shalgalt;
    }

    public BieDaalt getBiedaalt() {
        return biedaalt;
    }

    public void setBiedaalt(BieDaalt biedaalt) {
        this.biedaalt = biedaalt;
    }

    public TosolDun getTosoldun() {
        return tosoldun;
    }

    public void setTosoldun(TosolDun tosoldun) {
        this.tosoldun = tosoldun;
    }

}
