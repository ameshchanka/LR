package by.itacademy.dao;

import by.itacademy.entity.Address;
import by.itacademy.entity.Street;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class AddressDAOTest extends BaseDAOTest {

    @Test
    public void findById() throws Exception {
        Address item = DAO.getInstance().getAddressDAO().findById(1L);
        assertThat(item.getObjectNumberStr(), equalTo("65"));
    }

    @Test
    public void save() throws Exception {
        Street temp = DAO.getInstance().getStreetDAO().findById(2L);
        Address item = new Address("38-79", temp);
        DAO.getInstance().getAddressDAO().save(item);
        Address result = DAO.getInstance().getAddressDAO().findById(5L);
        assertThat(result.getObjectNumberStr(), equalTo("38-79"));
    }
}