package by.itacademy.dao;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomImage;
import by.itacademy.interfaces.IRoomDAO;
import by.itacademy.interfaces.IRoomImageDAO;
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
public class RoomImageDAOTest extends BaseDAOTest {

    @Autowired
    private IRoomImageDAO roomImageDAO;
    @Autowired
    private IRoomDAO roomDAO;

    @Test
    public void findById() {
        RoomImage item = roomImageDAO.findById(2L);
        assertThat(item.getRoom().getName(), equalTo("A24"));
        assertThat(item.getPath(), equalTo("img_sc_zamok_room001.jpg"));
    }

    @Test
    public void create() {
        Room rTemp = roomDAO.findById(1L);
        RoomImage item = new RoomImage("img_sc_zamok_room002.jpg", rTemp);
        roomImageDAO.save(item);
        RoomImage result = roomImageDAO.findById(3L);
        assertThat(result.getRoom().getName(), equalTo("A24"));
        assertThat(result.getPath(), equalTo("img_sc_zamok_room002.jpg"));
    }
}