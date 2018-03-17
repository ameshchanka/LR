package by.itacademy.repository;

import by.itacademy.entity.Address;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectInformation;
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
public class RoomsObjectRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private RoomsObjectRepository roomsObjectRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void findById() throws Exception {
        RoomsObject item = roomsObjectRepository.findOne(1L);
        assertThat(item.getName(), equalTo("Zamok"));
    }

    @Test
    public void create() throws Exception {
        Address temp = addressRepository.findOne(4L);
        RoomsObject item = new RoomsObject("Skala", temp);
        item.setRoomsObjectInformation(
                new RoomsObjectInformation("DADADA", item));
        roomsObjectRepository.save(item);
        RoomsObject result = roomsObjectRepository.findOne(4L);
        System.out.println(result.getRoomsObjectInformation().getDescription());
        System.out.println(result.getRoomsObjectInformation().getId());
        assertThat(result.getName(), equalTo("Skala"));
    }
}