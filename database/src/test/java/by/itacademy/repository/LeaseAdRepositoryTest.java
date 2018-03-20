package by.itacademy.repository;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Room;
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
public class LeaseAdRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private LeaseAdRepository leaseAdRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void findById() {
        LeaseAd item = leaseAdRepository.findOne(1L);
        assertThat(item.getRoom().getName(), equalTo("A24"));
        assertThat(item.getPrice(), equalTo(1200.0F));
    }

    @Test
    public void save() {
        Room temp = roomRepository.findOne(2L);
        LeaseAd item = new LeaseAd(800.0F, temp);
        leaseAdRepository.save(item);
        LeaseAd result = leaseAdRepository.findOne(3L);
        assertThat(result.getRoom().getName(), equalTo("B67"));
        assertThat(result.getPrice(), equalTo(800.0F));
    }
}