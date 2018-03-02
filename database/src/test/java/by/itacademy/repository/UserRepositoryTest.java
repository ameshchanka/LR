package by.itacademy.repository;

import by.itacademy.entity.Contact;
import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import by.itacademy.util.BaseRepositoryTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
@RunWith(SpringRunner.class)
public class UserRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findById() throws Exception {
        User item = userRepository.findOne(1L);
        assertThat(item.getEmail(), equalTo("admin@admin.com"));
    }

    @Test
    public void create() throws Exception {
        Role temp = roleRepository.findOne(1L);
        User item = new User("TestAdmin","test@admin.com","123456789",
                new Contact("+375291111111","admin_skype","admin_telegram",
                        "admin_viber"),
                new HashSet<>(Arrays.asList(temp)));
        userRepository.save(item);
        User result = userRepository.findOne(4L);
        assertThat(result.getName(), equalTo("TestAdmin"));
        assertThat(result.getEmail(), equalTo("test@admin.com"));
    }
}