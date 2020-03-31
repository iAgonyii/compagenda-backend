package domain;

import org.eclipse.persistence.annotations.PrimaryKey;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.naming.Name;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {

    @Id @GeneratedValue
    private Long id;
    private String category;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private Long userId;

    public Activity(String category, LocalDateTime starttime, LocalDateTime endtime, Long userId) {
        this.category = category;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatStartTime = starttime.format(formatter);
        String formatEndTime = endtime.format(formatter);

        this.starttime = LocalDateTime.parse(formatStartTime, formatter);
        this.endtime = LocalDateTime.parse(formatEndTime, formatter);
        this.userId = userId;
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

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
