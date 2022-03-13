package SpringBasic.Day15.tweet_assignment;

import javax.persistence.*;

@Entity(name="user")
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

//    @Column
//    @ElementCollection(targetClass=String.class)
//    private List<String> friendList=new ArrayList<>();

//    @OneToMany(mappedBy = "user")
//    private Set<Tweet> tweet= new HashSet<>();

    public User() {
    }

    public User( String name,String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<String> getFriendList() {
//        return friendList;
//    }
//
//    public void setFriendList(List<String> friendList) {
//        this.friendList = friendList;
//    }

//    public Set<Tweet> getTweet() {
//        return tweet;
//    }
//
//    public void setTweet(Set<Tweet> tweet) {
//        this.tweet = tweet;
//    }
}