package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "roomsobject_id")
    private RoomsObject roomsObject;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private Set<LeaseAd> leaseAds = new HashSet<LeaseAd>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private Set<RoomImage> roomImages = new HashSet<RoomImage>();
}
