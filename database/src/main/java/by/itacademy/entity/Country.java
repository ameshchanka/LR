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
@ToString(exclude = {"cities"})
@Entity
@Table(name = "addr_countries")
public class Country extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<City> cities = new HashSet<City>();

    public Country(String name) {
        this.name = name;
    }
}
