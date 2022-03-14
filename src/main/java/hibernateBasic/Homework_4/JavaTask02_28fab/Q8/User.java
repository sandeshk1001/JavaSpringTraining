package hibernateBasic.Homework_4.JavaTask02_28fab.Q8;

import jakarta.persistence.*;
@Entity
public class User {

    @Id
    private String message;
@Column(name = "id")
    private int id;

    public User() {
    }

    public User(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public User(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }

}
