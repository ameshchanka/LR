package by.itacademy.repository;

import by.itacademy.entity.Address;
import by.itacademy.entity.Street;
import by.itacademy.security.BaseRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
@RunWith(SpringRunner.class)
public class AddressRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StreetRepository streetRepository;

    @Test
    public void findById() {
        Address item = addressRepository.findOne(1L);
        assertThat(item.getObjectNumberStr(), equalTo("65"));
    }

    @Test
    public void save() {
        Street temp = streetRepository.findOne(2L);
        Address item = new Address("38-79", temp);
        addressRepository.save(item);
        Address result = addressRepository.findOne(5L);
        assertThat(result.getObjectNumberStr(), equalTo("38-79"));
    }
}