package hibernateBasic.utils;

import Homework_4.JavaTask02_28fab.Q10.Product;
import Homework_4.JavaTask02_28fab.Q10.Store;
import Homework_4.JavaTask02_28fab.Q7.ProductIncri;
import Homework_4.JavaTask02_28fab.Q7.Sequence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
    public static Session getSession(String hibernetMappingFileName) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addResource(hibernetMappingFileName);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
    public static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure();
//        configuration.addAnnotatedClass(Airport.class);
        //configuration.addAnnotatedClass(ProductSequenceId.class);
        configuration.addAnnotatedClass(ProductIncri.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
    public static Session getSessionid() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Sequence.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }

    public static Session getSessionAnotation() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Store.class);
        configuration.addAnnotatedClass(Product.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
