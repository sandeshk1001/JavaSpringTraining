package Assigments.Project.Dao;

import Assigments.Project.ModelClasses.Tweet;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TweetImplement implements Dao<Tweet> {
    @Autowired
    private Session session;

    @Override
    public List<Tweet> readAll() {
        return session.createQuery("from Tweet", Tweet.class).getResultList();
    }

    @Override
    public void create(Tweet entity) {
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
    }

    @Override
    public Tweet readById(int id) {
        return session.createQuery("from tweet where id="+id, Tweet.class).getSingleResult();
    }

    @Override
    public Boolean update(Tweet entity) {
        return null;
    }

//    @Override
//    public Boolean update(Post entity) {
//        session.beginTransaction();
//        Query query = session.createQuery("UPDATE fb_post SET post=:post, type=:type  WHERE id=:id");
//        query.setParameter("id",entity.getId());
//        query.setParameter("post",entity.getPost());
//        query.setParameter("type",entity.getType());
//        int rr = query.executeUpdate();
//        session.getTransaction().commit();
//        System.out.println("rr :"+rr);
//        if (rr !=0)
//            return true;
//        return false;
//    }

    @Override
    public void delete(Tweet entity) {
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
    }

    @Override
    public Tweet readByEmail(String entity) {

        return null;
    }

    public List<Tweet> readByEmailallpost(int entity) {
        System.out.println("id :"+entity);
//        try {
//            List<Post> postList=session.createQuery("from post where user_id='"+entity+"'",Post.class).getResultList();
//            return postList;
//        }catch (Exception ex){
//            System.out.println("Exceptionnsssss :"+ex);
//            return null;
//        }
        List<Tweet> postList = readAll().stream().filter(post -> post.getFbUser().getId()==entity).collect(Collectors.toList());
        return postList;
    }
}
