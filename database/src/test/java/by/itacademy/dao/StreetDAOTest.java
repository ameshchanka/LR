package by.itacademy.dao;

import by.itacademy.entity.City;
import by.itacademy.entity.Street;
import by.itacademy.interfaces.ICityDAO;
import by.itacademy.interfaces.IStreetDAO;
import by.itacademy.util.BaseDAOTest;
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
public class StreetDAOTest extends BaseDAOTest {

    @Autowired
    private IStreetDAO streetDAO;
    @Autowired
    private ICityDAO cityDAO;

    @Test
    public void findById() throws Exception {
        Street item = streetDAO.findById(1L);
        assertThat(item.getName(), equalTo("Prititskogo"));
    }

    @Test
    public void create() throws Exception {
        City temp = cityDAO.findById(1L);
        Street item = new Street("P.Brovki", temp);
        streetDAO.save(item);
        Street result = streetDAO.findById(5L);
        assertThat(result.getName(), equalTo("P.Brovki"));
    }
}