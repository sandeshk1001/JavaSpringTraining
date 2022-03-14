package hibernateBasic.day8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainCRUD {

    public static void main(String[] args) {
        /*
            CRUD Operation
         */

        //insertion();
        //Read();
        //update();
        //delete();
    }

    private static void delete() {
        Session session = getSession();
        Transaction transaction =session.beginTransaction();
        Student student = session.get(Student.class,99919);
        session.remove(student);
        transaction.commit();
        session.close();
    }

    private static void update() {
        Session session = getSession();
        Transaction transaction =session.beginTransaction();
        Student student = session.get(Student.class,99919);
        student.setUniversity("U-updated");
        session.persist(student);
        transaction.commit();
        session.close();
    }

    private static void Read() {
        Session session = getSession();
        List<Student> studentList = session.createQuery("from Student",Student.class).getResultList();
        System.out.println(studentList);
        session.close();
    }

    private static void insertion() {
        Session session = getSession();
        Transaction transaction =session.beginTransaction();
        for (int i=0;i<5;i++)
           session.persist(new Student("student-"+i,100+i,"u-"+i));
        transaction.commit();
        session.close();
    }

    private static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Student.class);
        configuration.addResource("day8/Student.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
 /*
                    student marks
         */
//        StudentMarks studentMarks = new StudentMarks();
//        studentMarks.setId(2);
//        studentMarks.setMarks("1,2,3,4,5");
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        configuration.addAnnotatedClass(StudentMarks.class);
//        configuration.addResource("day8/StudentMarks.hbm.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
////        Transaction transaction =session.beginTransaction();
////        session.persist(studentMarks);
////        transaction.commit();
//
//        List<StudentMarks> studentList = session.createQuery("from StudentMarks",StudentMarks.class).getResultList();
//        System.out.println(studentList);
