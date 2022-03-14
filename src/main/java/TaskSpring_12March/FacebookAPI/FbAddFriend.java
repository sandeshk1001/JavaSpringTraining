package TaskSpring_12March.FacebookAPI;

import javax.persistence.*;

@Entity(name = "add_friend")
@Table(name = "friends")
public class FbAddFriend {
    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private FbUser fbUser;

    @ManyToOne(cascade = CascadeType.ALL)
    private FbUser fbfriendUser;

    public FbAddFriend(FbUser fbUser, FbUser fbfriendUser) {
        this.fbUser = fbUser;
        this.fbfriendUser = fbfriendUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FbUser getFbUser() {
        return fbUser;
    }

    public void setFbUser(FbUser fbUser) {
        this.fbUser = fbUser;
    }

    public FbUser getFbfriendUser() {
        return fbfriendUser;
    }

    public void setFbfriendUser(FbUser fbfriendUser) {
        this.fbfriendUser = fbfriendUser;
    }

    @Override
    public String toString() {
        return "FbAddFriend{" +
                "id=" + id +
                ", fbUser=" + fbUser +
                ", fbfriendUser=" + fbfriendUser +
                '}';
    }
}
