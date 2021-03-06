package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"roomsObjectInformation", "rooms", "roomsObjectImages"})
@Entity
@Table(name = "lr_roomsobjects")
public class RoomsObject extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "lng")
    private Float lng;

    @OneToOne
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address address;

    @OneToOne(mappedBy = "roomsObject", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RoomsObjectInformation roomsObjectInformation;

    @OneToMany(mappedBy = "roomsObject", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Room> rooms = new HashSet<Room>();

    @OneToMany(mappedBy = "roomsObject", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
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
