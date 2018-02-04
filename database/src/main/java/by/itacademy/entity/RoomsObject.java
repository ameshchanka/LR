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
@ToString(exclude = {"info", "rooms", "roomsObjectImages"})
@Entity
@Table(name = "lr_roomsobjects")
public class RoomsObject extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lat")
    Float lat;

    @Column(name = "lng")
    Float lng;

    @OneToOne
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address address;

    @OneToOne(mappedBy = "roomsObject", fetch = FetchType.LAZY)
    private RoomsObjectInformation info;

    @OneToMany(mappedBy = "roomsObject", fetch = FetchType.LAZY)
    private Set<Room> rooms = new HashSet<Room>();

    @OneToMany(mappedBy = "roomsObject", fetch = FetchType.LAZY)
    private Set<RoomsObjectImage> roomsObjectImages = new HashSet<RoomsObjectImage>();

    public RoomsObject(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public RoomsObject(String name, Float lat, Float lng, Address address) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }
}
