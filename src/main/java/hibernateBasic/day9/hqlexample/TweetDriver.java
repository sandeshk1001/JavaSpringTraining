package hibernateBasic.day9.hqlexample;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.Utility;

import java.util.List;

public class TweetDriver {
    public static void main(String[] args) {
//        Insertion();
        numberOfUserCountTweetsUsingGroupBy();
    }

    private static void numberOfUserCountTweetsUsingGroupBy() {
        Session session = Utility.getSession();
        Query query =session.createQuery("select tweet,count(userId) from Tweet GROUP BY tweet");
        List<Object[]> objectList = query.getResultList();
        System.out.println("Tweets  |  Number of users");
        for(Object[] user: objectList)
        {
            System.out.println((String)user[0]+"       "+ (Long)user[1]);
        }
    }

    private static void Insertion() {
        Session session = Utility.getSession();
        Transaction transaction = session.beginTransaction();
        String[] tweets = new String[]{"tweet-1","tweet-2","tweet-3","tweet-4"};
        int[] userid = new int[]{101,102,103,104,105,106,107,108,109,200};
        for (int i=0;i<100;i++){
            session.persist(new Tweet(userid[(int)(Math.random()*10)], tweets[(int)(Math.random()*4)]));
        }
        transaction.commit();
        session.close();
    }
}
