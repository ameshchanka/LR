package by.itacademy;

import by.itacademy.dao.DAO;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by a.meshchenko on 21.01.2018.
 */
public class UserExample {

    public User getFirstUser() {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User item = DAO.getInstance().userDAO.get(session, 1L);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return item;
    }
}
