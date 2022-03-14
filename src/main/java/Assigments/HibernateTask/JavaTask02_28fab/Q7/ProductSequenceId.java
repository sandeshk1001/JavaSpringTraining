package Assigments.HibernateTask.JavaTask02_28fab.Q7;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.factory.spi.StandardGenerator;
import org.hibernate.query.Query;
import utils.Utility;

public class ProductSequenceId implements StandardGenerator {
    private final String DEFAULT_SEQUENCE_NAME="my_Seq";
    private static int no;
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Session session= Utility.getSessionid();
        Transaction transaction = session.beginTransaction();
        Sequence mySeq =session.get(Sequence.class,1);
        System.out.println(mySeq);
        if(mySeq == null){
            no=1;
            session.persist(new Sequence(1));
        }else
        {
            no=mySeq.getId();
            Query q=session.createQuery("update Sequence set id=:n where id=:i");
            q.setParameter("n",++no);
            q.setParameter("i",mySeq.getId());
            q.executeUpdate();
        }
        transaction.commit();
        session.close();
        return no;
    }
}
