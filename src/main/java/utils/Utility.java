package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
    public static Session getSessionAnotation(Class anotation) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(anotation);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
