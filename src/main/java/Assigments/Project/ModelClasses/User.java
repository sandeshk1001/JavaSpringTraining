package Assigments.Project.ModelClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "fb_user")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_visibility")
    private String visibility;
//
//    @OneToMany(mappedBy = "fbpost", cascade = CascadeType.REMOVE)
//    private Set<FbPost> posts= new HashSet<>();
//
//    public Set<FbPost> getPosts() {
//        return posts;
//    }
//    @OneToMany(mappedBy = "fbUser", cascade = CascadeType.REMOVE)
//    private Set<Post> posts = new HashSet<>();

//    @OneToMany(mappedBy = "fbfriendUser", cascade = CascadeType.REMOVE)
//    private Set<FbAddFriend> addFriends = new HashSet<>();
//    @OneToMany(mappedBy = "fbUser", cascade = CascadeType.REMOVE)
//    private Set<FbAddFriend> fbuser = new HashSet<>();

    public User() {
    }

    public User(String name, String email, String password, String visibility) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.visibility = visibility;
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
