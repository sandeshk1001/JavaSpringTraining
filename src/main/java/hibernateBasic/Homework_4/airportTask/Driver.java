package hibernateBasic.Homework_4.airportTask;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class Driver {
    public static void main(String[] args) {

        //insertDataPassengerAirtport();
        Session session = Utility.getSession();
        Transaction transaction= session.beginTransaction();
        Passengers passengers =session.get(Passengers.class,1);
        Tickets tickets = new Tickets("Ticket-1",passengers);
        session.persist(tickets);
        transaction.commit();
        session.close();
    }

    private static void insertDataPassengerAirtport() {
        Session session = Utility.getSession();
        Transaction transaction= session.beginTransaction();
        Airport airport = new Airport("Airport-1");
        Passengers passengers = new Passengers("passenger-1",airport);
        session.persist(airport);
        session.persist(passengers);
        transaction.commit();
        session.close();
    }
}
