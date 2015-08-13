
package teacher.model;

/**
 *
 * @author JAVA M2
 */
public class ShalgaltDunModel {
    
    private String id;
    private String name;
    private String point;
    private String exam;
    private String date;

    public ShalgaltDunModel(String id, String name, String point, String exam, String date) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.exam = exam;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
