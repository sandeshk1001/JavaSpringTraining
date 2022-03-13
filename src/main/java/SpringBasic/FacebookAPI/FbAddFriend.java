package SpringBasic.FacebookAPI;

import javax.persistence.*;

@Entity(name = "add_friend")
@Table(name = "friends")
public class FbAddFriend {
    @Id
    private int id;
    @ManyToMany(cascade = CascadeType.ALL)
    private FbUser fbUser;
    @ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "friend_id")
    private FbUser fbfriendUser;


}
