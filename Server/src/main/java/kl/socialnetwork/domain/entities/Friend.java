package kl.socialnetwork.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend")
    private Volunteer friend;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user", nullable = false)
    private Volunteer user;

    public Volunteer getUser() {
        return user;
    }

    public void setUser(Volunteer user) {
        this.user = user;
    }

    public Volunteer getFriend() {
        return friend;
    }

    public void setFriend(Volunteer friend) {
        this.friend = friend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}