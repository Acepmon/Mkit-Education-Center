package student.model;

public class Java {
    
    private String ovog;
    private String name;
    private String uzuulelt;
    private String bair;

    public Java(String ovog, String name, String uzuulelt, String bair) {
        this.ovog = ovog;
        this.name = name;
        this.uzuulelt = uzuulelt;
        this.bair = bair;
    }

    public String getOvog() {
        return ovog;
    }

    public void setOvog(String ovog) {
        this.ovog = ovog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUzuulelt() {
        return uzuulelt;
    }

    public void setUzuulelt(String uzuulelt) {
        this.uzuulelt = uzuulelt;
    }

    public String getBair() {
        return bair;
    }

    public void setBair(String bair) {
        this.bair = bair;
    }
    
}

