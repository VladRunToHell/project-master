package kl.socialnetwork.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "userachievements")
public class Userachievement {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "achivment")
    private Achievement achivment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "volunteer", nullable = false)
    private Volunteer volunteer;

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Achievement getAchivment() {
        return achivment;
    }

    public void setAchivment(Achievement achivment) {
        this.achivment = achivment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}