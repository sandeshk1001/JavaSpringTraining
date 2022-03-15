package Assigments.HibernateTask.airportTask;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Airport {
    @Id
    @GeneratedValue(generator = "custum-generater")
    @GenericGenerator(name = "custum-generater" ,strategy = "day8.CustumIdGenerater")
    @Column(name = "airport_id")
    private int id;

    @Column(name = "airport_name")
    private String name;

    @OneToMany(mappedBy = "airport")
    private Set<Passengers> Passengers= new HashSet<>();

    public Set<Passengers> getPassengers() { return Passengers; }

    public Airport(String name) {
        this.name = name;
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
