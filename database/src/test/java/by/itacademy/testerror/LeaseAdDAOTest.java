package by.itacademy.testerror;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Room;
import by.itacademy.interfaces.ILeaseAdDAO;
import by.itacademy.interfaces.IRoomDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class LeaseAdDAOTest extends BaseDAOTest {

    @Autowired
    private ILeaseAdDAO leaseAdDAO;
    @Autowired
    private IRoomDAO roomDAO;

    @Test
    public void findById() throws Exception {
        LeaseAd item = leaseAdDAO.findById(1L);
        assertThat(item.getRoom().getName(), equalTo("A24"));
        assertThat(item.getPrice(), equalTo(1200.0F));
    }

//    @Test
//    public void save() throws Exception {
//        Room temp = roomDAO.findById(2L);
//        LeaseAd item = new LeaseAd(800.0F, temp);
//        leaseAdDAO.save(item);
//        LeaseAd result = leaseAdDAO.findById(3L);
//        assertThat(result.getRoom().getName(), equalTo("B67"));
//        assertThat(result.getPrice(), equalTo(800.0F));
//    }
}