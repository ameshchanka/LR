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
@ToString
@Entity
@Table(name = "lr_roomsobjectinformations")
public class RoomsObjectInformations {

    @Id
    @Column(name = "roomsobject_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "description", length = 4095)
    private String description;

    @MapsId
    @OneToOne
    @JoinColumn(name = "roomsobject_id", unique = true, nullable = false)
    private RoomsObject roomsObject;
}
