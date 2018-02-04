package by.itacademy.dao;

import by.itacademy.entity.Address;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class AddressDAO {

    public Address get(Session session, long id) {
        return session.get(Address.class, id);
    }

    public void create (Session session, Address item) {
        session.save(item);
    }
}
