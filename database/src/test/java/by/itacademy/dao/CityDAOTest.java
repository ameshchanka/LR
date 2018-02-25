package by.itacademy.dao;

import by.itacademy.config.TestDatabaseConfig;
import by.itacademy.entity.City;
import by.itacademy.entity.Country;
import by.itacademy.interfaces.ICityDAO;
import by.itacademy.interfaces.ICountryDAO;
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
 * Created by a.meshchanka on 04.02.2018.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDatabaseConfig.class)
@Transactional
public class CityDAOTest extends BaseDAOTest {

    @Autowired
    private ICityDAO cityDAO;
    @Autowired
    private ICountryDAO countryDAO;

    @Test
    public void findById() throws Exception {
        City item = cityDAO.findById(1L);
        assertThat(item.getName(), equalTo("Minsk"));
    }

    @Test
    public void save() throws Exception {
        Country temp = countryDAO.findById(1L);
        City item = new City("Gomel", temp);
        cityDAO.save(item);
        City result = cityDAO.findById(2L);
        assertThat(result.getName(), equalTo("Gomel"));
    }
}
