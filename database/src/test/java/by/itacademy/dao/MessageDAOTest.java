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
    public void findById() throws Exception {
        Message item = DAO.getInstance().getMessageDAO().findById(1L);
        assertThat(item.getRecipient().getName(), equalTo("NameManager"));
        assertThat(item.getText(), equalTo("Hi, where i can get your phone number?"));
    }

    @Test
    public void save() throws Exception {
        User sender = DAO.getInstance().getUserDAO().findById(2L);
        User recirient = DAO.getInstance().getUserDAO().findById(3L);
        LeaseAd la = DAO.getInstance().getLeaseAdDAO().findById(1L);
        Message item = new Message("+375292222222",
                LocalDateTime.now(), sender, recirient, la);
        DAO.getInstance().getMessageDAO().save(item);
        Message result = DAO.getInstance().getMessageDAO().findById(2L);
        assertThat(result.getSender().getName(), equalTo("NameManager"));
        assertThat(result.getText(), equalTo("+375292222222"));
    }
}