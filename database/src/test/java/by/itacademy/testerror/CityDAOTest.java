package by.itacademy.testerror;

import by.itacademy.entity.City;
import by.itacademy.interfaces.ICityDAO;
import by.itacademy.interfaces.ICountryDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
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

//    @Test
//    public void save() throws Exception {
//        Country temp = countryDAO.findById(1L);
//        City item = new City("Gomel", temp);
//        cityDAO.save(item);
//        City result = cityDAO.findById(2L);
//        assertThat(result.getName(), equalTo("Gomel"));
//    }
}
