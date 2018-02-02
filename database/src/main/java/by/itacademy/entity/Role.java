package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "crm_roles")
public class Role extends BaseEntity {

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();
}
