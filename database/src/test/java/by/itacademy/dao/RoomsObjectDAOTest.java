package by.itacademy.dao;

import by.itacademy.entity.Address;
import by.itacademy.entity.RoomsObject;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        RoomsObject item = DAO.getInstance().getRoomsObjectDAO().findById(1L);
        assertThat(item.getName(), equalTo("Zamok"));
    }

    @Test
    public void create() throws Exception {
        Address temp = DAO.getInstance().getAddressDAO().findById(4L);
        RoomsObject item = new RoomsObject("Skala", temp);
        DAO.getInstance().getRoomsObjectDAO().save(item);
        RoomsObject result = DAO.getInstance().getRoomsObjectDAO().findById(4L);
        assertThat(result.getName(), equalTo("Skala"));
    }
}