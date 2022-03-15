package Assigments.Project.ModelClasses;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tweet")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tweet_id")
    private int id;
    @Column(name="tweet")
    private String tweetMessage;
    @Column(name="tweet_time")
    private LocalDateTime localDateTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User fbUser;

    public Tweet(String post, LocalDateTime localDateTime, User fbUser) {
        this.tweetMessage =post;
        this.localDateTime = localDateTime;
        this.fbUser = fbUser;
    }

    public Tweet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public User getFbUser() {
        return fbUser;
    }

    public void setFbUser(User fbUser) {
        this.fbUser = fbUser;
    }

    public String getTweetMessage() {
        return tweetMessage;
    }

    public void setTweetMessage(String post) {
        this.tweetMessage = post;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", post='" + tweetMessage + '\'' +
                ", localDateTime=" + localDateTime +
                ", fbUser=" + fbUser +
                '}';
    }
}
