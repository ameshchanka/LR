package by.itacademy.testerror;

import by.itacademy.entity.Country;
import by.itacademy.interfaces.ICountryDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class CountryDAOTest extends BaseDAOTest {

    @Autowired
    private ICountryDAO countryDAO;

    @Test
    public void findById() throws Exception {
        Country item = countryDAO.findById(1L);
        assertThat(item.getName(), equalTo("Belarus"));
    }

//    @Test
//    public void save() throws Exception {
//        Country item = new Country("Ukraine");
//        countryDAO.save(item);
//        Country result = countryDAO.findById(2L);
//        assertThat(result.getName(), equalTo("Ukraine"));
//    }
}
