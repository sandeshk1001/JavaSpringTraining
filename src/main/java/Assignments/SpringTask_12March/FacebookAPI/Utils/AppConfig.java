package Assigments.SpringTask_12March.FacebookAPI.Utils;

import Assigments.SpringTask_12March.FacebookAPI.ModelClasses.FbAddFriend;
import Assigments.SpringTask_12March.FacebookAPI.ModelClasses.FbPost;
import Assigments.SpringTask_12March.FacebookAPI.ModelClasses.FbUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Session getSession(){
        org.hibernate.cfg.Configuration configuration= new org.hibernate.cfg.Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(FbUser.class);
        configuration.addAnnotatedClass(FbPost.class);
        configuration.addAnnotatedClass(FbAddFriend.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
