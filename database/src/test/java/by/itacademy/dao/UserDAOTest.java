package by.itacademy.dao;

import by.itacademy.entity.Contact;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
public class UserDAOTest extends BaseDAOTest {

    @Test
    public void get() throws Exception {
        User item = DAO.getInstance().getUserDAO().findById(1L);
        assertThat(item.getEmail(), equalTo("admin@admin.com"));
    }

    @Test
    public void create() throws Exception {
        Role temp = DAO.getInstance().getRoleDAO().findById(1L);
        User item = new User("TestAdmin","test@admin.com","123456789",
                new Contact("+375291111111","admin_skype","admin_telegram",
                        "admin_viber"),
                new HashSet<Role>(Arrays.asList(temp)));
        DAO.getInstance().getUserDAO().save(item);
        User result = DAO.getInstance().getUserDAO().findById(4L);
        assertThat(result.getName(), equalTo("TestAdmin"));
        assertThat(result.getEmail(), equalTo("test@admin.com"));
    }
}