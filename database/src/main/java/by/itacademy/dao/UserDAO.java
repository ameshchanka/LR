package by.itacademy.dao;

import by.itacademy.entity.User;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class UserDAO {

    public User get(Session session, long id) {
        return session.get(User.class, id);
    }

    public void create (Session session, User item) {
        session.save(item);
    }
}
