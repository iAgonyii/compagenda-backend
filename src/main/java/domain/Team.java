package domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String name;

    @OneToMany(targetEntity = User.class)
    private List<User> teamMembers;

    public Team(String name) {
        this.name = name;
    }

    public Team() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List teamMembers) {
        this.teamMembers = teamMembers;
    }
}
