package hibernateBasic.day10.associationWithAnotation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class AssociationAnotationDriver {

    public static void main(String[] args) {
        //deleteData();
        deleteData();
    }

    private static void deleteData() {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        Person person =session.get(Person.class,2);
        session.remove(person);
        transaction.commit();
        session.close();
    }

    private static void insertNewPhoneNumber() {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class,4);
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhone("999999");
        phoneNumber.setProvider("airtel");
        phoneNumber.setPerson(person);
        session.persist(phoneNumber);
        transaction.commit();
        session.close();
    }

    private static void addPerson() {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person();
        person.setName("name-1");
        session.persist(person);
        transaction.commit();
        session.close();
    }

    private static void firstInsertion() {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person();
        PhoneNumber phoneNumber = new PhoneNumber();
        person.setName("name-1");
        phoneNumber.setPhone("123456");
        phoneNumber.setProvider("Jio");
        phoneNumber.setPerson(person);
        session.persist(person);
        session.persist(phoneNumber);
        transaction.commit();
        session.close();
    }
}
