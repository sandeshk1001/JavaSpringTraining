package SpringBasic.Day18;

import SpringBasic.Day18.Dao.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public static Session getSession() {
        org.hibernate.cfg.Configuration configuration=new org.hibernate.cfg.Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Tweet.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
