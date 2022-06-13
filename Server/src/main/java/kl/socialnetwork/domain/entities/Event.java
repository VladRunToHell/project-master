package kl.socialnetwork.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizer", nullable = false)
    private Organization organizer;

    @Lob
    @Column(name = "intro", nullable = false)
    private String intro;

    @Column(name = "ageMin")
    private Integer ageMin;

    @Column(name = "ageMax")
    private Integer ageMax;

    @Column(name = "attednadcyMethod", nullable = false)
    private String attednadcyMethod;

    @Column(name = "city")
    private String city;

    @Column(name = "disctrict")
    private String disctrict;

    @Column(name = "street")
    private String street;

    @Column(name = "metro")
    private String metro;

    @Column(name = "beginDate", nullable = false)
    private LocalDate beginDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name = "beginTime")
    private LocalTime beginTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    @OneToMany(mappedBy = "event")
    private Set<Requirement> requirements = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<Volunteerevent> volunteerevents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<Eventtag> eventtags = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<Review> reviews = new LinkedHashSet<>();

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Eventtag> getEventtags() {
        return eventtags;
    }

    public void setEventtags(Set<Eventtag> eventtags) {
        this.eventtags = eventtags;
    }

    public Set<Volunteerevent> getVolunteerevents() {
        return volunteerevents;
    }

    public void setVolunteerevents(Set<Volunteerevent> volunteerevents) {
        this.volunteerevents = volunteerevents;
    }

    public Set<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(Set<Requirement> requirements) {
        this.requirements = requirements;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDisctrict() {
        return disctrict;
    }

    public void setDisctrict(String disctrict) {
        this.disctrict = disctrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAttednadcyMethod() {
        return attednadcyMethod;
    }

    public void setAttednadcyMethod(String attednadcyMethod) {
        this.attednadcyMethod = attednadcyMethod;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Organization getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organization organizer) {
        this.organizer = organizer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}