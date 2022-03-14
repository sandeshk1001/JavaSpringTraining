package hibernateBasic.day10;

import day9.hqlexample.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import utils.Utility;

public class CriteriaAPIExample {
    public static void main(String[] args) {
        Session session = Utility.getSession();
        CriteriaQuery<Student> criteriaobj = showAllData(session);
        System.out.println(session.createQuery(criteriaobj).getResultList());
        //CriteriaQuery<Student> criteriaQuery =showAllData(session);
//        CriteriaQuery<Double> criteriaQuery =avgMarks(session);
//        System.out.println(session.createQuery(criteriaQuery).getSingleResult());
        /*
                goupby example
         */
//        CriteriaQuery<Object[]> criteriaQuery =groupby(session);
//        List<Object[]> objectList=session.createQuery(criteriaQuery).getResultList();
//        for(Object[] user: objectList)
//        {
//            System.out.println((String)user[0]+"       "+ (Integer)user[1]);
//        }
//        CriteriaQuery<Object[]> criteriaQuery =groupbyname(session);
//        List<Object[]> objectList=session.createQuery(criteriaQuery).getResultList();
//        for(Object[] user: objectList)
//        {
//            System.out.println((String)user[0]+"       "+ (Long)user[1]);
//        }
    }

    private static CriteriaQuery<Object[]> groupbyname(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.multiselect(root.get("name"),criteriaBuilder.count(root.get("name"))).groupBy(root.get("name"));
        return criteriaQuery;
    }

    private static CriteriaQuery<Object[]> groupby(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.multiselect(root.get("name"),criteriaBuilder.sum(root.get("marks"))).groupBy(root.get("name"));
        return criteriaQuery;
    }

    private static CriteriaQuery<Double> avgMarks(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(criteriaBuilder.avg(root.get("marks")));
        return criteriaQuery;
    }

    private static CriteriaQuery<Integer> sumMarks(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        criteriaQuery.select(criteriaBuilder.sum(root.get("marks")));
        return criteriaQuery;
    }

    private static CriteriaQuery<Student> showname(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        return criteriaQuery.select(root).where(criteriaBuilder.between(root.get("name"),"student-1","student-2"));
    }

    private static CriteriaQuery<Student> showMarkesless10(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        return criteriaQuery.select(root).where(criteriaBuilder.le(root.get("marks"),10));
    }

    private static CriteriaQuery<Student> showMarkesGreater40(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        return criteriaQuery.select(root).where();
    }

    private static CriteriaQuery<Student> showAllData(Session session) {

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        return criteriaQuery.select(root);
    }
}
