package hibernateBasic.day9.hqlexample;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class HQLExample {
    public static void main(String[] args) {
        //Insertion();
        //showAllStudentList();
        //sumOfAllMarks();
        passingMarksNoOfRow();
    }

    private static void passingMarksNoOfRow() {
        Session session = Utility.getSession();
        System.out.println(session.createQuery("Select count(*) from Student where marks >40",Long.class).getSingleResult());
    }

    private static void sumOfAllMarks() {
        Session session = Utility.getSession();
        System.out.println(session.createQuery("Select sum(marks) from Student",Long.class).getSingleResult());
    }

    private static void showAllStudentList() {
        Session session = Utility.getSession();
        System.out.println(session.createQuery("from Student",Student.class).getResultList());
    }

    private static void Insertion() {
        Session session= Utility.getSession();
        Transaction transaction= session.beginTransaction();
        String[] names = new String[]{"student-1","student-2","student-3","student-4"};
        for(int i=0;i<100;i++){
            Student student = new Student();
            student.setName(names[(int)(Math.random()*4)]);
            student.setMarks((int)(Math.random()*100));
            session.persist(student);
        }
        transaction.commit();
        session.close();
    }
}
