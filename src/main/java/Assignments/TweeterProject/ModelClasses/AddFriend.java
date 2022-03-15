package Assignments.TweeterProject.ModelClasses;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class AddFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "friend_id")
    private int friendId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User fbUser;

    @Column(updatable = true)
    private boolean isBlocked = false;

    public AddFriend() {
    }

    public AddFriend(int friend_id, User fbUser, boolean isBlocked) {
        this.friendId = friend_id;
        this.fbUser = fbUser;
        this.isBlocked = isBlocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public User getFbUser() {
        return fbUser;
    }

    public void setFbUser(User fbUser) {
        this.fbUser = fbUser;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
