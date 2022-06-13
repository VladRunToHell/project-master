package kl.socialnetwork.domain.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "inn", length = 20)
    private String inn;

    @OneToMany(mappedBy = "organizer")
    private Set<Event> events = new LinkedHashSet<>();

    @OneToMany(mappedBy = "organization")
    private Set<Organizationpopulartag> organizationpopulartags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "organization")
    private Set<Organizationreview> organizationreviews = new LinkedHashSet<>();

    public Set<Organizationreview> getOrganizationreviews() {
        return organizationreviews;
    }

    public void setOrganizationreviews(Set<Organizationreview> organizationreviews) {
        this.organizationreviews = organizationreviews;
    }

    public Set<Organizationpopulartag> getOrganizationpopulartags() {
        return organizationpopulartags;
    }

    public void setOrganizationpopulartags(Set<Organizationpopulartag> organizationpopulartags) {
        this.organizationpopulartags = organizationpopulartags;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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