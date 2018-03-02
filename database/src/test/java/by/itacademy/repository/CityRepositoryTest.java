package by.itacademy.repository;

import by.itacademy.entity.City;
import by.itacademy.entity.Country;
import by.itacademy.util.BaseRepositoryTest;
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
public class CityRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void findById() {
        City item = cityRepository.findOne(1L);
        assertThat(item.getName(), equalTo("Minsk"));
    }

    @Test
    public void save() {
        Country temp = countryRepository.findOne(1L);
        City item = new City("Gomel", temp);
        cityRepository.save(item);
        City result = cityRepository.findOne(2L);
        assertThat(result.getName(), equalTo("Gomel"));
    }
}
