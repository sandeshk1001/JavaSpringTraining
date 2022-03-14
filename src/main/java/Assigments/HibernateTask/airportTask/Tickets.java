package Assigments.HibernateTask.airportTask;

import jakarta.persistence.*;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    @Column(name = "ticket_number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Passengers passengers;

    public Tickets() { }

    public Tickets(String number, Passengers passengers) {
        this.number = number;
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
    }
}
