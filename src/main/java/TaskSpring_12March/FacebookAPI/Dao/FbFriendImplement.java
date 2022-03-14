package TaskSpring_12March.FacebookAPI.Dao;

import TaskSpring_12March.FacebookAPI.FbUser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FbFriendImplement implements Dao{
    @Autowired
    Session session;
    @Override
    public List readAll() {
        return session.createQuery("from fb_user", FbUser.class).getResultList();
    }

    @Override
    public void create(Object entity) {
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
    }

    @Override
    public Object readById(int id) {
        return null;
    }

    @Override
    public Boolean update(Object entity) {
        return null;
    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public Object readByEmail(String entity) {
        return null;
    }
}
