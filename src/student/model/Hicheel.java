package student.model;

public class Hicheel {

    private String name;
    private String irts;
    private String idevhi;
    private String biedaalt;
    private String daalgavar;
    private String shalgalt;
    private String dundaj;

    public Hicheel(String name, String irts, String idevhi, String biedaalt, String daalgavar, String shalgalt, String dundaj) {
        this.name = name;
        this.irts = irts;
        this.idevhi = idevhi;
        this.biedaalt = biedaalt;
        this.daalgavar = daalgavar;
        this.shalgalt = shalgalt;
        this.dundaj = dundaj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIrts() {
        return irts;
    }

    public void setIrts(String irts) {
        this.irts = irts;
    }

    public String getIdevhi() {
        return idevhi;
    }

    public void setIdevhi(String idevhi) {
        this.idevhi = idevhi;
    }

    public String getBiedaalt() {
        return biedaalt;
    }

    public void setBiedaalt(String biedaalt) {
        this.biedaalt = biedaalt;
    }

    public String getDaalgavar() {
        return daalgavar;
    }

    public void setDaalgavar(String daalgavar) {
        this.daalgavar = daalgavar;
    }

    public String getShalgalt() {
        return shalgalt;
    }

    public void setShalgalt(String shalgalt) {
        this.shalgalt = shalgalt;
    }

    public String getDundaj() {
        return dundaj;
    }

    public void setDundaj(String dundaj) {
        this.dundaj = dundaj;
    }
   
    
}
