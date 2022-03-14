package Assigments.SpringTask_12March.FacebookAPI.ModelClasses;

import Assigments.SpringTask_12March.FacebookAPI.ModelClasses.FbUser;

import javax.persistence.*;

@Entity(name = "add_friend")
@Table(name = "friends")
public class FbAddFriend {

    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private FbUser fbUser;

    @Column(updatable = true)
    private boolean isBlocked = false;

}
