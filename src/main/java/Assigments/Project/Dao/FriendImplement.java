package Assigments.Project.Dao;

import Assigments.Project.ModelClasses.AddFriend;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendImplement implements Dao {
    @Autowired
    Session session;
    @Override
    public List<AddFriend> readAll() {
        return session.createQuery("from AddFriend", AddFriend.class).getResultList();
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
