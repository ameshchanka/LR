package by.itacademy.dao;

import by.itacademy.entity.Country;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class CountryDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Country item = DAO.getInstance().getCountryDAO().findById(1L);
        assertThat(item.getName(), equalTo("Belarus"));
    }

    @Test
    public void create() throws Exception {
        Country item = new Country("Ukraine");
        DAO.getInstance().getCountryDAO().save(item);
        Country result = DAO.getInstance().getCountryDAO().findById(2L);
        assertThat(result.getName(), equalTo("Ukraine"));
    }
}
