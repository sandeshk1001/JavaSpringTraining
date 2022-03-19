package Assigments.HibernateTask.JavaTask02_28fab.Q7;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sequence {
    @Id
    private int id;

    public Sequence() {
    }

    public Sequence(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
