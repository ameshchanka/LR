package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "crm_users")
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "crm_usersroles",
            uniqueConstraints =
                    @UniqueConstraint(columnNames = {"user_id", "role_id"}),
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<Role>();

//    `name` VARCHAR(255) NOT NULL,
//  `password` VARCHAR(1023) NOT NULL,
//  `phoneNumber` VARCHAR(255) NULL DEFAULT NULL,
//  `email` VARCHAR(255) NOT NULL,
//  `role_id` BIGINT NULL DEFAULT NULL,
}
