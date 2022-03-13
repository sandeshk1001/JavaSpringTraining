package SpringBasic.Day18;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TweetDaoImpl implements Dao<Tweet>{
    @Autowired
    Session session;
    @Override
    public List<Tweet> readAll() {
        return session.createQuery("from tweet",Tweet.class).getResultList();
    }

    @Override
    public void create(Tweet entity) {

    }

    @Override
    public Tweet readById(int id) {
        return null;
    }

    @Override
    public void update(Tweet entity) {

    }

    @Override
    public void delete(Tweet entity) {

    }
}
