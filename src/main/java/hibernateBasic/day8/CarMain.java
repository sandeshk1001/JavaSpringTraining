package hibernateBasic.day8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CarMain {
    public static void main(String[] args) {
        CarDetails car = new CarDetails(100,220.5,"BMW",10.5f,'o',true,202454543l);
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(CarDetails.class);
        configuration.addResource("day8/CarDetails.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(car);
        transaction.commit();
        session.close();
    }
}
