package by.itacademy.service;

import by.itacademy.dto.UserDto;
import by.itacademy.entity.Role;
import by.itacademy.repository.RoleRepository;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(by.itacademy.entity.User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDto makeModelForUsersPage() {
        UserDto dto = new UserDto();
        dto.setUsers(userRepository.findAll());
        roleRepository.findAll().forEach(dto.getRoles() :: add);
        return dto;
    }

    @Override
    public void adRole(by.itacademy.entity.User item) {
        by.itacademy.entity.User user = userRepository.findOne(item.getId());
        Role r = roleRepository.findByRole(item.getRoles().stream().findFirst().get().getRole());
        user.getRoles().add(r);
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        by.itacademy.entity.User systemUser = userRepository.findByEmail(email);
        if (systemUser == null) {
            throw new UsernameNotFoundException("User doesn't exist!");
        }
        return new User(email, systemUser.getPassword(),
                generateAuthorities(systemUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> generateAuthorities(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
