package by.itacademy.repository;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Message;
import by.itacademy.entity.User;
import by.itacademy.util.BaseRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@RunWith(SpringRunner.class)
public class MessageRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeaseAdRepository leaseAdRepository;

    @Test
    public void findById() {
        Message item = messageRepository.findOne(1L);
        assertThat(item.getRecipient().getName(), equalTo("NameManager"));
        assertThat(item.getText(), equalTo("Hi, where i can get your phone number?"));
    }

    @Test
    public void save() {
        User sender = userRepository.findOne(2L);
        User recirient = userRepository.findOne(3L);
        LeaseAd la = leaseAdRepository.findOne(1L);
        Message item = new Message("+375292222222",
                LocalDateTime.now(), sender, recirient, la);
        messageRepository.save(item);
        Message result = messageRepository.findOne(2L);
        assertThat(result.getSender().getName(), equalTo("NameManager"));
        assertThat(result.getText(), equalTo("+375292222222"));
    }
}