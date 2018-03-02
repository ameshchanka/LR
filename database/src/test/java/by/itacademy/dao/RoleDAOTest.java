package by.itacademy.dao;

import by.itacademy.entity.Role;
import by.itacademy.interfaces.IRoleDAO;
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
public class RoleDAOTest extends BaseDAOTest {

    @Autowired
    private IRoleDAO roleDAO;

    @Test
    public void findById() {
        Role item = roleDAO.findById(1L);
        assertThat(item.getRole(), equalTo("admin"));
    }

    @Test
    public void save() {
        Role item = new Role("moderator");
        roleDAO.save(item);
        Role result = roleDAO.findById(4L);
        assertThat(result.getRole(), equalTo("moderator"));
    }
}