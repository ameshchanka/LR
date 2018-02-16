package by.itacademy.dao;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectImage;
import org.hibernate.Session;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoomsObjectImageDAOTest extends BaseDAOTest {

    @Test
    public void findById() throws Exception {
        RoomsObjectImage item = DAO.getInstance()
                .getRoomsObjectImageDAO().findById(1L);
        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));
    }

    @Test
    public void save() throws Exception {
        //File f = IMPORTER.createFile("img_sc_zamok002.jpg");
        RoomsObject roTemp = DAO.getInstance().getRoomsObjectDAO().findById(1L);
        RoomsObjectImage item = new RoomsObjectImage("img_sc_zamok002.jpg", roTemp);
        DAO.getInstance().getRoomsObjectImageDAO().save(item);
        RoomsObjectImage result = DAO.getInstance().getRoomsObjectImageDAO().findById(4L);
        if(result == null)
            result = DAO.getInstance().getRoomsObjectImageDAO().findById(3L);
        //assertThat(result.getRoomsObject().getName(), equalTo("Zamok"));
        assertThat(result.getPath(), equalTo("img_sc_zamok002.jpg"));

    }
}