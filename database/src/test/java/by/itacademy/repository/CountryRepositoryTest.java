package by.itacademy.repository;

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
public class CountryRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    public void findById() {
        Country item = countryRepository.findOne(1L);
        assertThat(item.getName(), equalTo("Belarus"));
    }

    @Test
    public void save() {
        Country item = new Country("Ukraine");
        countryRepository.save(item);
        Country result = countryRepository.findOne(2L);
        assertThat(result.getName(), equalTo("Ukraine"));
    }
}
