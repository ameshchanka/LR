package by.itacademy.dao;

import by.itacademy.config.TestDatabaseConfig;
import by.itacademy.entity.Address;
import by.itacademy.entity.Street;
import by.itacademy.interfaces.IAddressDAO;
import by.itacademy.interfaces.IStreetDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
@RunWith(SpringRunner.class)
public class AddressDAOTest extends BaseDAOTest {

    @Autowired
    private IAddressDAO addressDAO;
    @Autowired
    private IStreetDAO streetDAO;

    @Test
    public void findById() {
        Address item = addressDAO.findById(1L);
        assertThat(item.getObjectNumberStr(), equalTo("65"));
    }

    @Test
    public void save() {
        Street temp = streetDAO.findById(2L);
        Address item = new Address("38-79", temp);
        addressDAO.save(item);
        Address result = addressDAO.findById(5L);
        assertThat(result.getObjectNumberStr(), equalTo("38-79"));
    }
}