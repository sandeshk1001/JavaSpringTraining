package SpringBasic.FacebookAPI;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "fb_post")
@Table(name = "fb_post")
public class FbPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private int id;
    @Column(name="post")
    private String post;
    @Column(name="post_type")
    private String type;
    @Column(name="post_time")
    private LocalDateTime localDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private FbUser fbUser;

    public FbPost(String post, String type, LocalDateTime localDateTime, FbUser fbUser) {
        this.post = post;
        this.type = type;
        this.localDateTime = localDateTime;
        this.fbUser = fbUser;
    }

    public FbPost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public FbUser getFbUser() {
        return fbUser;
    }

    public void setFbUser(FbUser fbUser) {
        this.fbUser = fbUser;
    }

    @Override
    public String toString() {
        return "FbPost{" +
                "id=" + id +
                ", post='" + post + '\'' +
                ", type='" + type + '\'' +
                ", localDateTime=" + localDateTime +
                ", fbUser=" + fbUser +
                '}';
    }
}
