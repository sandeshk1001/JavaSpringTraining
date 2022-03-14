package hibernateBasic.day9.anotationexample;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Person_Detail")
public class Person {
    @Id
    //@GeneratedValue
    //@GeneratedValue (strategy = GenerationType.SEQUENCE)
    @GeneratedValue(generator = "custum-generater")
    @GenericGenerator(name = "custum-generater" ,strategy = "day8.CustumIdGenerater")
    @Column(name="person_id")
    private int id;

    @Column(name="person_name", nullable = false , length = 200)
    private String name;

    @Column(name = "HiredStatus", columnDefinition = "boolean default false" )
    private Boolean isHired=false;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Boolean isHired) {
        this.name = name;
        this.isHired = isHired;
    }


    public Boolean getisHired() {return isHired;}

    public void setisHired(Boolean hired) {isHired = hired;}


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
