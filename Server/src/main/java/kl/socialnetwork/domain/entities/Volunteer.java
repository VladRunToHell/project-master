package kl.socialnetwork.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "volunteer")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "volunteer")
    private Set<Volunteerfavoritetag> volunteerfavoritetags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "volunteer")
    private Set<Volunteeravailableplace> volunteeravailableplaces = new LinkedHashSet<>();

    @OneToMany(mappedBy = "volunteer")
    private Set<Volunteerevent> volunteerevents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "volunteer")
    private Set<Volunteerreview> volunteerreviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Communitymember> communitymembers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "friend")
    private Set<Friend> friends = new LinkedHashSet<>();

    @OneToMany(mappedBy = "volunteer")
    private Set<Userachievement> userachievements = new LinkedHashSet<>();

    @OneToMany(mappedBy = "volunteer")
    private Set<Volunteerskill> volunteerskills = new LinkedHashSet<>();

    public Set<Volunteerskill> getVolunteerskills() {
        return volunteerskills;
    }

    public void setVolunteerskills(Set<Volunteerskill> volunteerskills) {
        this.volunteerskills = volunteerskills;
    }

    public Set<Userachievement> getUserachievements() {
        return userachievements;
    }

    public void setUserachievements(Set<Userachievement> userachievements) {
        this.userachievements = userachievements;
    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

    public Set<Communitymember> getCommunitymembers() {
        return communitymembers;
    }

    public void setCommunitymembers(Set<Communitymember> communitymembers) {
        this.communitymembers = communitymembers;
    }

    public Set<Volunteerreview> getVolunteerreviews() {
        return volunteerreviews;
    }

    public void setVolunteerreviews(Set<Volunteerreview> volunteerreviews) {
        this.volunteerreviews = volunteerreviews;
    }

    public Set<Volunteerevent> getVolunteerevents() {
        return volunteerevents;
    }

    public void setVolunteerevents(Set<Volunteerevent> volunteerevents) {
        this.volunteerevents = volunteerevents;
    }

    public Set<Volunteeravailableplace> getVolunteeravailableplaces() {
        return volunteeravailableplaces;
    }

    public void setVolunteeravailableplaces(Set<Volunteeravailableplace> volunteeravailableplaces) {
        this.volunteeravailableplaces = volunteeravailableplaces;
    }

    public Set<Volunteerfavoritetag> getVolunteerfavoritetags() {
        return volunteerfavoritetags;
    }

    public void setVolunteerfavoritetags(Set<Volunteerfavoritetag> volunteerfavoritetags) {
        this.volunteerfavoritetags = volunteerfavoritetags;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}