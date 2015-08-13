
package teacher.model;

public class SearchModel {
    
    private String ners;
    private String pane;
    private String date;

    public String getNers() {
        return ners;
    }

    public void setNers(String ners) {
        this.ners = ners;
    }

    public String getPane() {
        return pane;
    }

    public void setPane(String pane) {
        this.pane = pane;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SearchModel(String ners, String pane, String date) {
        this.date=date;
        this.ners=ners;
        this.pane=pane;
    }

    public SearchModel() {
        this.date = "";
        this.ners = "";
        this.pane = "";
    }
    

    

 
 
        
}