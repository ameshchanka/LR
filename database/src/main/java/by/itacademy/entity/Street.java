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
@Table(
        name = "addr_streets",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"name", "city_id"})
)
public class Street extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "street")
    private Set<Address> addresses = new HashSet<Address>();
}