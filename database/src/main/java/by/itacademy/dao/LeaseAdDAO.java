package by.itacademy.dao;

import by.itacademy.entity.LeaseAd;
import org.hibernate.Session;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class LeaseAdDAO {

    public LeaseAd get(Session session, long id) {
        return session.get(LeaseAd.class, id);
    }

    public void create (Session session, LeaseAd item) {
        session.save(item);
    }
}
