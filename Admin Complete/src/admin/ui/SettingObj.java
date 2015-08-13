package admin.ui;

/**
 *
 * @author JAVA M2
 */
public class SettingObj {
    private String id;
    private String name;
    private String desc;
    private String startDate;
    private String finishDate;
    
    public SettingObj(String id, String name, String desc, String sdate,  String fdate){
    
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.startDate = sdate;
        this.finishDate = fdate;
        
    }
    
    public String getId(){
        return id;
    }
    public void SetId (String id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name = name;
    }
    
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    
    public String getSdate(){
        return startDate;
    }
    public void setSdate(String sdate){
        this.startDate = sdate;
    }
    
    public String getFdate(){
        return finishDate;
    }
    public void setFdate(String fdate){
        this.finishDate = fdate;
    }
    
}
