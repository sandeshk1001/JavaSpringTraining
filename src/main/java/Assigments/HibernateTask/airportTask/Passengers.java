package Assigments.HibernateTask.airportTask;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
design tables
airport(id, name)
passengers(id,name,airport_id)
tickets(id,number,passenger_id)

So the Airport class will contain a @OneToMany(mappedBy="airport") on Set<Passenger>
Passenger class will contain a ManyToOne on airport and OneToMany on tickets
and ticket class will contain manytoOne on passenger

there could be many passengers in the passenger table.
And each will be mapped to an airport having a particular ticket

We will have three classes here Airport, Passenger, Ticket

I have created a new folder on GitHub called homework_4 inside it there are two different tasks.
you can try it over weekend or whenever you are free.

I will push the solution in the same folder in 1-2 days

If you have any doubts you can email me on expert@codageaider.com
We will connect next week to cover Spring.
There are few small topics still left in hibernate as we had a day less for hibernate.
I will try to cover it next week

 */

@Entity
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private int id;

    @Column(name = "passenger_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AIRPORT_ID")
    private Airport airport;

    @OneToMany(mappedBy = "passengers")
    private List<Tickets> tickets = new ArrayList<>();

    public List<Tickets> getTickets() { return tickets; }

    public Passengers() { }

    public Passengers(String name, Airport airport) {
        this.name = name;
        this.airport = airport;
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

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
