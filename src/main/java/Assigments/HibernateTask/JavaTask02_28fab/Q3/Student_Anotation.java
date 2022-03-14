package Assigments.HibernateTask.JavaTask02_28fab.Q3;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student_Anotation {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_name")
    private String name;

    public Student_Anotation(String name) {
        this.name = name;
    }

    public Student_Anotation() {
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

}
