package kl.socialnetwork.domain.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "achievement")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "points", nullable = false)
    private Integer points;

    @Column(name = "uniqueOrNot")
    private Boolean uniqueOrNot;

    @Lob
    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "achivment")
    private Set<Userachievement> userachievements = new LinkedHashSet<>();

    public Set<Userachievement> getUserachievements() {
        return userachievements;
    }

    public void setUserachievements(Set<Userachievement> userachievements) {
        this.userachievements = userachievements;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getUniqueOrNot() {
        return uniqueOrNot;
    }

    public void setUniqueOrNot(Boolean uniqueOrNot) {
        this.uniqueOrNot = uniqueOrNot;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}