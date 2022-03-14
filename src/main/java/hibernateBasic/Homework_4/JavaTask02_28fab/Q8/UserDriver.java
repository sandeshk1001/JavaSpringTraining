package hibernateBasic.Homework_4.JavaTask02_28fab.Q8;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

import java.util.List;

public class UserDriver {
    public static void main(String[] args) {

        Session session = Utility.getSession();
//        insertion(session);
        maxUserMessages(session);
    }

    private static void maxUserMessages(Session session) {
        List<Object[]> object= session.createQuery("select id, count(message) from User group by id",Object[].class).getResultList();
        Object[] max = object.get(1);
        for (Object[] obj:object){
            if((Long)max[1] < (Long)obj[1]){
                max = obj;
            }
        }
        System.out.println("User :"+max[0]+" | Message :"+max[1]);
    }

    public static void insertion(Session session){
        Transaction transaction = session.beginTransaction();
        for (int i=0;i<100;i++)
            session.persist(new User((int)(Math.random()*4),"message"+i));
        transaction.commit();
        session.close();
    }
}