package by.itacademy.repository;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectImage;
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
public class RoomsObjectImageRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private RoomsObjectImageRepository roomsObjectImageRepository;
    @Autowired
    private RoomsObjectRepository roomsObjectRepository;

    @Test
    public void findById() throws Exception {
        RoomsObjectImage item = roomsObjectImageRepository.findOne(1L);
        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));
    }

    @Test
    public void save() throws Exception {
        RoomsObject roTemp = roomsObjectRepository.findOne(1L);
        RoomsObjectImage item = new RoomsObjectImage("img_sc_zamok002.jpg", roTemp);
        roomsObjectImageRepository.save(item);
        RoomsObjectImage result = roomsObjectImageRepository.findOne(4L);
        if(result == null)
            result = roomsObjectImageRepository.findOne(3L);
        assertThat(result.getPath(), equalTo("img_sc_zamok002.jpg"));

    }
}