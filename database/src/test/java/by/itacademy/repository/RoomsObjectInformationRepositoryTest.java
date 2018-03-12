package by.itacademy.repository;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectInformation;
import by.itacademy.security.BaseRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@RunWith(SpringRunner.class)
public class RoomsObjectInformationRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private RoomsObjectInformationRepository roomsObjectInformationRepository;
    @Autowired
    private RoomsObjectRepository roomsObjectRepository;

    @Test
    public void get() {
        RoomsObjectInformation item =
                roomsObjectInformationRepository.findOne(1L);
        assertThat(item.getRoomsObject().getName(), equalTo("Zamok"));
    }

    @Test
    public void create() {
        RoomsObject temp = roomsObjectRepository.findOne( 3L);
        RoomsObjectInformation item = new RoomsObjectInformation(
                "Многофункциональный торгово-развлекательный комплекс, " +
                        "современный формат которого позволяет объединить возможности " +
                        "для комфортного шопинга и насыщенного досуга.", temp);
        roomsObjectInformationRepository.save(item);
        RoomsObjectInformation result = roomsObjectInformationRepository.findOne(3L);
        assertThat(result.getRoomsObject().getName(), equalTo("Galileo"));
    }
}