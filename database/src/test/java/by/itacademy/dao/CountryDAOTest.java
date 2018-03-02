package by.itacademy.dao;

import by.itacademy.config.TestDatabaseConfig;
import by.itacademy.entity.Country;
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
public class CountryDAOTest extends BaseDAOTest {

    @Autowired
    private ICountryDAO countryDAO;

    @Test
    public void findById() {
        Country item = countryDAO.findById(1L);
        assertThat(item.getName(), equalTo("Belarus"));
    }

    @Test
    public void save() {
        Country item = new Country("Ukraine");
        countryDAO.save(item);
        Country result = countryDAO.findById(2L);
        assertThat(result.getName(), equalTo("Ukraine"));
    }
}
