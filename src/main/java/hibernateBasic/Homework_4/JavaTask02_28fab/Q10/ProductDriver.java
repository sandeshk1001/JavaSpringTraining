package hibernateBasic.Homework_4.JavaTask02_28fab.Q10;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class ProductDriver {
    public static void main(String[] args) {
        Session session = Utility.getSessionAnotation();
        firstInsertion(session);
        //insertionOneElement(session);
        deleteStore(session);
    }

    private static void deleteStore(Session session) {
        Transaction transaction = session.beginTransaction();
        Store store = session.get(Store.class,2);
        session.remove(store);
        transaction.commit();
        session.close();
    }

    private static void insertionOneElement(Session session) {
        Transaction transaction = session.beginTransaction();
        Store store =session.get(Store.class,1);
        Product product =new Product("item-2",store);
        session.persist(product);
        transaction.commit();
        session.close();
    }
    private static void firstInsertion(Session session) {
        Transaction transaction = session.beginTransaction();
        Store store =new Store("store-1","Address");
        session.persist(store);
        Product product =new Product("item-1",store);
        session.persist(product);
        transaction.commit();
        session.close();
    }
}
