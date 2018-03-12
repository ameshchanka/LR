package by.itacademy.repository;

import by.itacademy.entity.City;
import by.itacademy.entity.Street;
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
public class StreetRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private StreetRepository streetRepository;
    @Autowired
    private CityRepository cityRepository;

    @Test
    public void findById() throws Exception {
        Street item = streetRepository.findOne(1L);
        assertThat(item.getName(), equalTo("Prititskogo"));
    }

    @Test
    public void create() throws Exception {
        City temp = cityRepository.findOne(1L);
        Street item = new Street("P.Brovki", temp);
        streetRepository.save(item);
        Street result = streetRepository.findOne(5L);
        assertThat(result.getName(), equalTo("P.Brovki"));
    }
}