package by.itacademy.dao;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.User;
import by.itacademy.interfaces.IRoomDAO;
import by.itacademy.interfaces.IRoomsObjectDAO;
import by.itacademy.interfaces.IUserDAO;
import by.itacademy.util.BaseDAOTest;
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
public class RoomDAOTest extends BaseDAOTest {

    @Autowired
    private IRoomDAO roomDAO;
    @Autowired
    private IRoomsObjectDAO roomsObjectDAO;
    @Autowired
    private IUserDAO userDAO;

    @Test
    public void findById() {
        Room item = roomDAO.findById(1L);
        assertThat(item.getName(), equalTo("A24"));
    }

    @Test
    public void save() {
        User user = userDAO.findById(2L);
        RoomsObject temp = roomsObjectDAO.findById(1L);
        Room item = new Room("J35", 540.4F, temp, user);
        roomDAO.save(item);
        Room result = roomDAO.findById(5L);
        assertThat(result.getRoomsObject().getName(), equalTo("Zamok"));
        assertThat(result.getName(), equalTo("J35"));
    }

}