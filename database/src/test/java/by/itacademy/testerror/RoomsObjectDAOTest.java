package by.itacademy.testerror;

import by.itacademy.entity.RoomsObject;
import by.itacademy.interfaces.IAddressDAO;
import by.itacademy.interfaces.IRoomsObjectDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectDAOTest extends BaseDAOTest {

    @Autowired
    private IRoomsObjectDAO roomsObjectDAO;
    @Autowired
    private IAddressDAO addressDAO;

    @Test
    public void findById() throws Exception {
        RoomsObject item = roomsObjectDAO.findById(1L);
        assertThat(item.getName(), equalTo("Zamok"));
    }

//    @Test
//    public void create() throws Exception {
//        Address temp = addressDAO.findById(4L);
//        RoomsObject item = new RoomsObject("Skala", temp);
//        roomsObjectDAO.save(item);
//        RoomsObject result = roomsObjectDAO.findById(4L);
//        assertThat(result.getName(), equalTo("Skala"));
//    }
}