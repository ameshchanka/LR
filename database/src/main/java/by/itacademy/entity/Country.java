package by.itacademy.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "addr_countries")
public class Country extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<City> cities = new HashSet<City>();

    public Country(String name) {
        this.name = name;
    }
}
