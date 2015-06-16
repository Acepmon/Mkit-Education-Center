package student.model;

public class StudentPro {
    
        private String ovogner;
        private String stucode;
        private String utas;
        private String hayag;
        private String pcdugar;

    public StudentPro(String ovoglbl, String dugarlbl, String utaslbl, String hayglbl, String comlbl) {
        this.ovogner = ovoglbl;
        this.stucode = dugarlbl;
        this.utas = utaslbl;
        this.hayag = hayglbl;
        this.pcdugar = comlbl;
    }

    public String getOvogner() {
        return ovogner;
    }

    public void setOvogner(String ovogner) {
        this.ovogner = ovogner;
    }

    public String getStucode() {
        return stucode;
    }

    public void setStucode(String stucode) {
        this.stucode = stucode;
    }

    public String getUtas() {
        return utas;
    }

    public void setUtas(String utas) {
        this.utas = utas;
    }

    public String getHayag() {
        return hayag;
    }

    public void setHayag(String hayag) {
        this.hayag = hayag;
    }

    public String getPcdugar() {
        return pcdugar;
    }

    public void setPcdugar(String pcdugar) {
        this.pcdugar = pcdugar;
    }
    
}
