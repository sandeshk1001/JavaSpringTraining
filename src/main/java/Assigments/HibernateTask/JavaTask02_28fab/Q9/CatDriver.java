package Assigments.HibernateTask.JavaTask02_28fab.Q9;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Utility;

public class CatDriver {
    public static void main(String[] args) {
        Session session = Utility.getSessionAnotation();
        //insertion(session);
        CriteriaQuery<Cat> catlist = showAllData(session);
        System.out.println(session.createQuery(catlist).getResultList());
    }

    private static CriteriaQuery<Cat> showAllData(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Cat.class);
        Root<Cat> root = criteriaQuery.from(Cat.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("catAge")));
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.like(root.get("catName"),"m%")),(criteriaBuilder.gt(root.get("catWeight"),2)));
        return criteriaQuery;
    }

    private static void insertion(Session session) {
        Transaction transaction = session.beginTransaction();
        for (int i=0;i<10;i++){
            session.persist(new Cat("mCat-"+i,Math.random()*50,(int)(Math.random()*20)));
        }
        transaction.commit();
        session.close();
    }

}
