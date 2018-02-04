package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"roomsObject"})
@Entity
@Table(
        name = "addr_addresses",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"objectNumberStr", "street_id"})
)
public class Address extends BaseEntity {

    @Column(name = "objectNumberStr", nullable = false)
    private String objectNumberStr;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private RoomsObject roomsObject;

    public Address(String objectNumberStr, Street street) {
        this.objectNumberStr = objectNumberStr;
        this.street = street;
    }
}
