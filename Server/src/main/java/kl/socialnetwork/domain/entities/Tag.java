package kl.socialnetwork.domain.entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<Volunteerfavoritetag> volunteerfavoritetags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tag")
    private Set<Organizationpopulartag> organizationpopulartags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "tag")
    private Set<Eventtag> eventtags = new LinkedHashSet<>();

    public Set<Eventtag> getEventtags() {
        return eventtags;
    }

    public void setEventtags(Set<Eventtag> eventtags) {
        this.eventtags = eventtags;
    }

    public Set<Organizationpopulartag> getOrganizationpopulartags() {
        return organizationpopulartags;
    }

    public void setOrganizationpopulartags(Set<Organizationpopulartag> organizationpopulartags) {
        this.organizationpopulartags = organizationpopulartags;
    }

    public Set<Volunteerfavoritetag> getVolunteerfavoritetags() {
        return volunteerfavoritetags;
    }

    public void setVolunteerfavoritetags(Set<Volunteerfavoritetag> volunteerfavoritetags) {
        this.volunteerfavoritetags = volunteerfavoritetags;
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