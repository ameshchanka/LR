package by.itacademy.dao;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Message;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class MessageDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Message item = DAO.getInstance().messageDAO.get(session, 1L);
        assertThat(item.getRecipient().getName(), equalTo("NameManager"));
        assertThat(item.getText(), equalTo("Hi, where i can get your phone number?"));

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void create() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User sender = session.get(User.class, 2L);
        User recirient = session.get(User.class, 3L);
        LeaseAd la = session.get(LeaseAd.class, 1L);
        Message item = new Message("+375292222222",
                LocalDateTime.now(), sender, recirient, la);
        DAO.getInstance().messageDAO.create(session, item);
        Message result = session.get(Message.class, 2L);
        assertThat(result.getSender().getName(), equalTo("NameManager"));
        assertThat(result.getText(), equalTo("+375292222222"));

        session.getTransaction().commit();
        session.close();
    }
}