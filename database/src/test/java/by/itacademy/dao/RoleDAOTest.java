package by.itacademy.dao;

import by.itacademy.entity.Role;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoleDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        Role item = DAO.getInstance().getRoleDAO().findById(1L);
        assertThat(item.getRole(), equalTo("admin"));
    }

    @Test
    public void create() throws Exception {
        Role item = new Role("moderator");
        DAO.getInstance().getRoleDAO().save(item);
        Role result = DAO.getInstance().getRoleDAO().findById(4L);
        assertThat(result.getRole(), equalTo("moderator"));
    }
}