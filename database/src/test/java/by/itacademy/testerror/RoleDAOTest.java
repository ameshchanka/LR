package by.itacademy.testerror;

import by.itacademy.entity.Role;
import by.itacademy.interfaces.IRoleDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
public class RoleDAOTest extends BaseDAOTest {

    @Autowired
    private IRoleDAO roleDAO;

    @Test
    public void findById() throws Exception {
        Role item = roleDAO.findById(1L);
        assertThat(item.getRole(), equalTo("admin"));
    }

//    @Test
//    public void save() throws Exception {
//        Role item = new Role("moderator");
//        roleDAO.save(item);
//        Role result = DAO.getInstance().getRoleDAO().findById(4L);
//        assertThat(result.getRole(), equalTo("moderator"));
//    }
}