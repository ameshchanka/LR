package by.itacademy.dto;

import by.itacademy.entity.Role;
import by.itacademy.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {

    private Iterable<User> users;
    private List<Role> roles = new ArrayList<>();
}
