package teacher.model;

import javafx.scene.control.TableColumn;

public class MedeelelTest {

    private String nersCol;
    private String paneCol;
    private String nameCol;
    private String genderCol;
    private String numberCol;
    private String typeCol;
    private String paymentCol;
    private String allPaymentCol;

    public MedeelelTest(String nersCol, String paneCol, String nameCol, String genderCol, String numberCol, String typeCol, String paymentCol, String allPaymentCol) {
        this.nersCol = nersCol;
        this.paneCol = paneCol;
        this.nameCol = nameCol;
        this.genderCol = genderCol;
        this.numberCol = numberCol;
        this.typeCol = typeCol;
        this.paymentCol = paymentCol;
        this.allPaymentCol = allPaymentCol;
    }

    public String getNersCol() {
        return nersCol;
    }

    public void setNersCol(String nersCol) {
        this.nersCol = nersCol;
    }

    public String getPaneCol() {
        return paneCol;
    }

    public void setPaneCol(String paneCol) {
        this.paneCol = paneCol;
    }

    public String getNameCol() {
        return nameCol;
    }

    public void setNameCol(String nameCol) {
        this.nameCol = nameCol;
    }

    public String getGenderCol() {
        return genderCol;
    }

    public void setGenderCol(String genderCol) {
        this.genderCol = genderCol;
    }

    public String getNumberCol() {
        return numberCol;
    }

    public void setNumberCol(String numberCol) {
        this.numberCol = numberCol;
    }

    public String getTypeCol() {
        return typeCol;
    }

    public void setTypeCol(String typeCol) {
        this.typeCol = typeCol;
    }

    public String getPaymentCol() {
        return paymentCol;
    }

    public void setPaymentCol(String paymentCol) {
        this.paymentCol = paymentCol;
    }

    public String getAllPaymentCol() {
        return allPaymentCol;
    }

    public void setAllPaymentCol(String allPaymentCol) {
        this.allPaymentCol = allPaymentCol;
    }

        
}