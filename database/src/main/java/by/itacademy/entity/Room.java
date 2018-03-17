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
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"leaseAds", "roomImages"})
@Entity
@Table(
        name = "lr_rooms",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"name", "roomsobject_id"})
)
public class Room extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "square")
    private Float square;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "roomsobject_id")
    private RoomsObject roomsObject;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private Set<LeaseAd> leaseAds = new HashSet<LeaseAd>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private Set<RoomImage> roomImages = new HashSet<RoomImage>();

    public Room(String name, Float square, RoomsObject roomsObject, User user) {
        this.name = name;
        this.square = square;
        this.roomsObject = roomsObject;
        this.user = user;
    }
}
