package by.itacademy.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(by.itacademy.entity.User user);
}
