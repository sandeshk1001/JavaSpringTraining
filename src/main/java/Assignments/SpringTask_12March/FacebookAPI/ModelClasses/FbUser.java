package Assigments.SpringTask_12March.FacebookAPI.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "fb_user")
@Table(name = "fb_user")
public class FbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
//
//    @OneToMany(mappedBy = "fbpost", cascade = CascadeType.REMOVE)
//    private Set<FbPost> posts= new HashSet<>();
//
//    public Set<FbPost> getPosts() {
//        return posts;
//    }
    @OneToMany(mappedBy = "fbUser", cascade = CascadeType.REMOVE)
    private Set<FbPost> posts = new HashSet<>();

//    @OneToMany(mappedBy = "fbfriendUser", cascade = CascadeType.REMOVE)
//    private Set<FbAddFriend> addFriends = new HashSet<>();
//    @OneToMany(mappedBy = "fbUser", cascade = CascadeType.REMOVE)
//    private Set<FbAddFriend> fbuser = new HashSet<>();

    public FbUser() {
    }

    public FbUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
