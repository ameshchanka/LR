package by.itacademy.repository;

import by.itacademy.entity.Role;
import by.itacademy.util.BaseRepositoryTest;
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
public class RoleRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findById() {
        Role item = roleRepository.findOne(1L);
        assertThat(item.getRole(), equalTo("admin"));
    }

    @Test
    public void save() {
        Role item = new Role("moderator");
        roleRepository.save(item);
        Role result = roleRepository.findOne(4L);
        assertThat(result.getRole(), equalTo("moderator"));
    }
}