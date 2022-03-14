package hibernateBasic.day8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ShowDataFromTable {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addResource("day8/Student.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Student> studentList = session.createQuery("from Student",Student.class).getResultList();
        System.out.println(studentList);
    }
}
