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
        name = "addr_cities",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"name", "country_id"})
)
public class City extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "country_id", nullable = false)
    Country country;

    @OneToMany(mappedBy = "city")
    private Set<Street> streets = new HashSet<Street>();

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
