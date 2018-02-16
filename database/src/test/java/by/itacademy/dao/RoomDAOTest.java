package by.itacademy.dao;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Room item = DAO.getInstance().getRoomDAO().findById(1L);
        assertThat(item.getName(), equalTo("A24"));
    }

    @Test
    public void create() throws Exception {
        User user = DAO.getInstance().getUserDAO().findById(2L);
        RoomsObject temp = DAO.getInstance().getRoomsObjectDAO().findById(1L);
        Room item = new Room("J35", 540.4F, temp, user);
        DAO.getInstance().getRoomDAO().save(item);
        Room result = DAO.getInstance().getRoomDAO().findById(5L);
        assertThat(result.getRoomsObject().getName(), equalTo("Zamok"));
        assertThat(result.getName(), equalTo("J35"));
    }

}