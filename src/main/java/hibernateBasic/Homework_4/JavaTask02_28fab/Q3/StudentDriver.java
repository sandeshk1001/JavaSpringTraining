package hibernateBasic.Homework_4.JavaTask02_28fab.Q3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class StudentDriver {
    public static void main(String[] args) {
        /*
        hibernate mapping file :- this file is used to instruct - how to map the defined class or classes to the
                                database tables.
         */

        // insert using xml
        Session session = Utility.getSession("Student.hbm.xml");
        Transaction transaction = session.beginTransaction();
        session.persist(new Student("student-1"));
        transaction.commit();
        session.close();

        // insert using annotation
        Session session1 = Utility.getSession();
        Transaction transaction1 = session.beginTransaction();
        session1.persist(new Student("student-2"));
        transaction1.commit();
        session1.close();
    }
}
