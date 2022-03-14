package hibernateBasic.day9.hqlexample;

import jakarta.persistence.*;

@Entity
@Table(name = "tweet_record")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "tweet")
    private String tweet;

    public Tweet() {
    }

    public Tweet(Integer userId, String tweet) {
        this.userId = userId;
        this.tweet = tweet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", userId=" + userId +
                ", tweet='" + tweet + '\'' +
                '}';
    }

}
