package by.itacademy.repository;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.User;
import by.itacademy.security.BaseRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@RunWith(SpringRunner.class)
public class RoomRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomsObjectRepository roomsObjectRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findById() {
        Room item = roomRepository.findOne(1L);
        assertThat(item.getName(), equalTo("A24"));
    }

    @Test
    public void save() {
        User user = userRepository.findOne(2L);
        RoomsObject temp = roomsObjectRepository.findOne(1L);
        Room item = new Room("J35", 540.4F, temp, user);
        roomRepository.save(item);
        Room result = roomRepository.findOne(5L);
        assertThat(result.getRoomsObject().getName(), equalTo("Zamok"));
        assertThat(result.getName(), equalTo("J35"));
    }

}