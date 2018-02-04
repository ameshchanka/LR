package by.itacademy.dao;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Room;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class LeaseAdDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        LeaseAd item = DAO.getInstance().leaseAdDAO.get(session, 1L);
        assertThat(item.getRoom().getName(), equalTo("A24"));
        assertThat(item.getPrice(), equalTo(1200.0F));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Room temp = session.get(Room.class, 2L);
        LeaseAd item = new LeaseAd(800.0F, temp);
        DAO.getInstance().leaseAdDAO.create(session, item);
        LeaseAd result = session.get(LeaseAd.class, 3L);
        assertThat(result.getRoom().getName(), equalTo("B67"));
        assertThat(result.getPrice(), equalTo(800.0F));

        session.getTransaction().commit();
        session.close();
    }
}