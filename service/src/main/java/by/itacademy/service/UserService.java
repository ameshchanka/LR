package by.itacademy.service;

import by.itacademy.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(by.itacademy.entity.User user);
    UserDto makeModelForUsersPage();
    void adRole(by.itacademy.entity.User item);
    void delete(long id);
}
