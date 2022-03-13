package SpringBasic.Day18;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements Dao<User>{
    @Autowired
    private Session session;
    @Override
    public List<User> readAll() {
        return session.createQuery("from user",User.class).getResultList();
    }

    @Override
    public User readById(int id) {
        Query query=session.createQuery("from user where id=:id",User.class);
        query.setParameter("id",id);
        return (User) query.getSingleResult();
    }

    @Override
    public void create(User user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        User user1 = session.createQuery("from User where email=:email", User.class).getSingleResult();

        session.beginTransaction();
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        session.persist(user1);
        session.getTransaction();
        session.close();
    }

    @Override
    public void delete(User user) {

    }

}
