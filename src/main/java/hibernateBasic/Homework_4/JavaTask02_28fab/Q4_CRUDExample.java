package hibernateBasic.Homework_4.JavaTask02_28fab;

import Homework_4.JavaTask02_28fab.Q3.Student_Anotation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

import java.util.List;

/*
    CRUD - C stands for create means insertion
           R stands for read data
           U stands for update
           D stands for delete
    this are the main common operation
 */
public class Q4_CRUDExample {
    public static void main(String[] args) {
        // all operation are perform on the Q3 StudentAnnotation class
//        insertion();
//        Read();
//        update();
//        delete();
//        List<Student_Anotation> studentAnotations=Student_Anotation.CreateRoster();
//        for(Student_Anotation studentAnotatione :roster)

    }
    private static void delete() {
        Session session = Utility.getSession();
        Transaction transaction =session.beginTransaction();
        Student_Anotation student = session.get(Student_Anotation.class,1);
        session.remove(student);
        transaction.commit();
        session.close();
    }

    private static void update() {
        Session session = Utility.getSession();
        Transaction transaction =session.beginTransaction();
        Student_Anotation student = session.get(Student_Anotation.class,1);
        student.setName("Student-updated");
        session.persist(student);
        transaction.commit();
        session.close();
    }

    private static void Read() {
        Session session = Utility.getSession();
        List<Student_Anotation> studentList = session.createQuery("from Student",Student_Anotation.class).getResultList();
        System.out.println(studentList);
        session.close();
    }

    private static void insertion() {
        Session session = Utility.getSession();
        Transaction transaction =session.beginTransaction();
        for (int i=0;i<5;i++)
            session.persist(new Student_Anotation("student-"+i));
        transaction.commit();
        session.close();
    }

}
