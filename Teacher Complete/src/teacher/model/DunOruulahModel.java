/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher.model;


public class DunOruulahModel {
    private String ner;
    private String bd1;
    private String bd2;
    private String IdCol1;
   

    public DunOruulahModel(String ner, String bd1, String bd2, String IdCol1) {
        this.ner = ner;
        this.bd1 = bd1;
        this.bd2 = bd2;
        this.IdCol1 = IdCol1;
    }
    
    public DunOruulahModel(String ner, String bd1, String bd2) {
        this.ner = ner;
        this.bd1 = bd1;
        this.bd2 = bd2;
        this.IdCol1 = "";
    }

    public String getIdCol1() {
        return IdCol1;
    }

    public void setIdCol1(String IdCol1) {
        this.IdCol1 = IdCol1;
    }


    public String getNer() {
        return ner;
    }

    public void setNer(String ner) {
        this.ner = ner;
    }

    public String getBd1() {
        return bd1;
    }

    public void setBd1(String bd1) {
        this.bd1 = bd1;
    }

    public String getBd2() {
        return bd2;
    }

    public void setBd2(String bd2) {
        this.bd2 = bd2;
    }

    
}
      
    