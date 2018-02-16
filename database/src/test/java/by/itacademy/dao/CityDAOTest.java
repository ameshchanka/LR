package by.itacademy.dao;

import by.itacademy.entity.City;
import by.itacademy.entity.Country;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class CityDAOTest extends BaseDAOTest {

    @Test
    public void findById() throws Exception {
        City item = DAO.getInstance().getCityDAO().findById(1L);
        assertThat(item.getName(), equalTo("Minsk"));
    }

    @Test
    public void save() throws Exception {
        Country temp = DAO.getInstance().getCountryDAO().findById(1L);
        City item = new City("Gomel", temp);
        DAO.getInstance().getCityDAO().save(item);
        City result = DAO.getInstance().getCityDAO().findById(2L);
        assertThat(result.getName(), equalTo("Gomel"));
    }
}
