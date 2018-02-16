package by.itacademy.dao;

import by.itacademy.entity.City;
import by.itacademy.entity.Street;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class StreetDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Street item = DAO.getInstance().getStreetDAO().findById(1L);
        assertThat(item.getName(), equalTo("Prititskogo"));
    }

    @Test
    public void create() throws Exception {
        City temp = DAO.getInstance().getCityDAO().findById(1L);
        Street item = new Street("P.Brovki", temp);
        DAO.getInstance().getStreetDAO().save(item);
        Street result = DAO.getInstance().getStreetDAO().findById(5L);
        assertThat(result.getName(), equalTo("P.Brovki"));
    }
}