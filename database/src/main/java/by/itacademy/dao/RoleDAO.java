package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class RoleDAO {

    public Role get(Session session, long id) {
        return session.get(Role.class, id);
    }

    public void create (Session session, Role item) {
        session.save(item);
    }
}
