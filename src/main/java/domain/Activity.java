package domain;

import org.eclipse.persistence.annotations.PrimaryKey;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.naming.Name;
import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {

    @Id @GeneratedValue
    private Long id;
    private String category;
    private String starttime;
    private String endtime;
    private Long uid;

    public Activity(String category, String starttime, String endtime, Long uid) {
        this.category = category;
        this.starttime = starttime;
        this.endtime = endtime;
        this.uid = uid;
    }

    public Activity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
