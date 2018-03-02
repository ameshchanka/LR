package by.itacademy.dao;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectImage;
import by.itacademy.interfaces.IRoomsObjectDAO;
import by.itacademy.interfaces.IRoomsObjectImageDAO;
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
public class RoomsObjectImageDAOTest extends BaseDAOTest {

    @Autowired
    private IRoomsObjectImageDAO roomsObjectImageDAO;
    @Autowired
    private IRoomsObjectDAO roomsObjectDAO;

    @Test
    public void findById() throws Exception {
        RoomsObjectImage item = roomsObjectImageDAO.findById(1L);
        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));
    }

    @Test
    public void save() throws Exception {
        RoomsObject roTemp = roomsObjectDAO.findById(1L);
        RoomsObjectImage item = new RoomsObjectImage("img_sc_zamok002.jpg", roTemp);
        roomsObjectImageDAO.save(item);
        RoomsObjectImage result = roomsObjectImageDAO.findById(4L);
        if(result == null)
            result = roomsObjectImageDAO.findById(3L);
        assertThat(result.getPath(), equalTo("img_sc_zamok002.jpg"));

    }
}