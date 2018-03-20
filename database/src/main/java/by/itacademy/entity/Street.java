package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"addresses"})
@Entity
@Table(
        name = "addr_streets",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"name", "city_id"})
)
public class Street extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "street", cascade = {CascadeType.PERSIST})
    private Set<Address> addresses = new HashSet<Address>();

    public Street(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
