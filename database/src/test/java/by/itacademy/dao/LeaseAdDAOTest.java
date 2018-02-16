package by.itacademy.dao;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Room;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class LeaseAdDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        LeaseAd item = DAO.getInstance().getLeaseAdDAO().findById(1L);
        assertThat(item.getRoom().getName(), equalTo("A24"));
        assertThat(item.getPrice(), equalTo(1200.0F));
    }

    @Test
    public void create() throws Exception {
        Room temp = DAO.getInstance().getRoomDAO().findById(2L);
        LeaseAd item = new LeaseAd(800.0F, temp);
        DAO.getInstance().getLeaseAdDAO().save(item);
        LeaseAd result = DAO.getInstance().getLeaseAdDAO().findById(3L);
        assertThat(result.getRoom().getName(), equalTo("B67"));
        assertThat(result.getPrice(), equalTo(800.0F));
    }
}