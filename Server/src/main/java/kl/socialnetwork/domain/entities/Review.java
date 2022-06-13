package kl.socialnetwork.domain.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event")
    private Event event;

    @Lob
    @Column(name = "review", nullable = false)
    private String review;

    @OneToMany(mappedBy = "review")
    private Set<Volunteerreview> volunteerreviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "review")
    private Set<Organizationreview> organizationreviews = new LinkedHashSet<>();

    public Set<Organizationreview> getOrganizationreviews() {
        return organizationreviews;
    }

    public void setOrganizationreviews(Set<Organizationreview> organizationreviews) {
        this.organizationreviews = organizationreviews;
    }

    public Set<Volunteerreview> getVolunteerreviews() {
        return volunteerreviews;
    }

    public void setVolunteerreviews(Set<Volunteerreview> volunteerreviews) {
        this.volunteerreviews = volunteerreviews;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}