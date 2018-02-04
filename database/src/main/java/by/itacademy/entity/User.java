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
@ToString(exclude = {"rooms", "password"})
@Entity
@Table(name = "crm_users")
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Embedded
    private Contact contact;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "crm_users_roles",
            uniqueConstraints =
                    @UniqueConstraint(columnNames = {"user_id", "role_id"}),
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<Role>();

    @OneToMany(mappedBy = "user")
    private Set<Room> rooms = new HashSet<Room>();

    public User(String name, String email, String password, Contact contact, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.contact = contact;
    }
}
