package by.itacademy.testerror;

import by.itacademy.entity.User;
import by.itacademy.interfaces.IRoleDAO;
import by.itacademy.interfaces.IUserDAO;
import by.itacademy.util.BaseDAOTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class UserDAOTest extends BaseDAOTest {

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IRoleDAO roleDAO;

    @Test
    public void findById() throws Exception {
        User item = userDAO.findById(1L);
        assertThat(item.getEmail(), equalTo("admin@admin.com"));
    }

//    @Test
//    public void create() throws Exception {
//        Role temp = roleDAO.findById(1L);
//        User item = new User("TestAdmin","test@admin.com","123456789",
//                new Contact("+375291111111","admin_skype","admin_telegram",
//                        "admin_viber"),
//                new HashSet<>(Arrays.asList(temp)));
//        userDAO.save(item);
//        User result = userDAO.findById(4L);
//        assertThat(result.getName(), equalTo("TestAdmin"));
//        assertThat(result.getEmail(), equalTo("test@admin.com"));
//    }
}