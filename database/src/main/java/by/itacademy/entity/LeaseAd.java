package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"messages"})
@Entity
@Table(
        name = "lr_leaseads",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"dateStopLease", "room_id"})
)
public class LeaseAd extends BaseEntity {

    @Column(name = "price")
    private Float price;

    @Column(name = "dateStartLease")
    private LocalDateTime dateStartLease;

    @Column(name = "dateStopLease")
    private LocalDateTime dateStopLease;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "leaseAd")
    private Set<Message> messages = new HashSet<Message>();

}
