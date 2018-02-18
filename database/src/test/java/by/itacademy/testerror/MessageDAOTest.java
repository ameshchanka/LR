package by.itacademy.testerror;

import by.itacademy.entity.Message;
import by.itacademy.interfaces.ILeaseAdDAO;
import by.itacademy.interfaces.IMessageDAO;
import by.itacademy.interfaces.IUserDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class MessageDAOTest extends BaseDAOTest {

    @Autowired
    private IMessageDAO messageDAO;
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private ILeaseAdDAO leaseAdDAO;

    @Test
    public void findById() throws Exception {
        Message item = messageDAO.findById(1L);
        assertThat(item.getRecipient().getName(), equalTo("NameManager"));
        assertThat(item.getText(), equalTo("Hi, where i can get your phone number?"));
    }

//    @Test
//    public void save() throws Exception {
//        User sender = userDAO.findById(2L);
//        User recirient = userDAO.findById(3L);
//        LeaseAd la = leaseAdDAO.findById(1L);
//        Message item = new Message("+375292222222",
//                LocalDateTime.now(), sender, recirient, la);
//        messageDAO.save(item);
//        Message result = messageDAO.findById(2L);
//        assertThat(result.getSender().getName(), equalTo("NameManager"));
//        assertThat(result.getText(), equalTo("+375292222222"));
//    }
}