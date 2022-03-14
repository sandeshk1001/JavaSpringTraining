package Assigments.SpringTask_12March.FacebookAPI.Dao;

import Assigments.SpringTask_12March.FacebookAPI.FbPost;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class FbPostImplement implements Dao<FbPost> {
    @Autowired
    private Session session;

    @Override
    public List<FbPost> readAll() {
        return session.createQuery("from fb_post", FbPost.class).getResultList();
    }

    @Override
    public void create(FbPost entity) {
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
    }

    @Override
    public FbPost readById(int id) {
        return session.createQuery("from fb_post where id="+id,FbPost.class).getSingleResult();
    }

    @Override
    public Boolean update(FbPost entity) {
        session.beginTransaction();
        Query query = session.createQuery("UPDATE fb_post SET post=:post, type=:type  WHERE id=:id");
        query.setParameter("id",entity.getId());
        query.setParameter("post",entity.getPost());
        query.setParameter("type",entity.getType());
        int rr = query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("rr :"+rr);
        if (rr !=0)
            return true;
        return false;
    }

    @Override
    public void delete(FbPost entity) {
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
    }

    @Override
    public FbPost readByEmail(String entity) {
        return null;
    }

}
