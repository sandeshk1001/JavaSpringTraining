package Assigments.SpringTask_12March.FacebookAPI.ModelClasses;

import javax.persistence.*;

@Entity(name = "friends")
@Table(name = "friends")
public class FbAddFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "friend_id")
    private int friendId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private FbUser fbUser;

    @Column(updatable = true)
    private boolean isBlocked = false;

    public FbAddFriend() {
    }

    public FbAddFriend(int friend_id, FbUser fbUser, boolean isBlocked) {
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

    public FbUser getFbUser() {
        return fbUser;
    }

    public void setFbUser(FbUser fbUser) {
        this.fbUser = fbUser;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
