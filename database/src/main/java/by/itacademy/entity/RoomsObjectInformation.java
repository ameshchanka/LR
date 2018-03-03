package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lr_roomsobjectinformations")
public class RoomsObjectInformation {

    @Id
    @GeneratedValue(generator = "infoKeyGenerator")
    @GenericGenerator(
            name = "infoKeyGenerator",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(
                    name = "property", value = "roomsObject"
            )
    )
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "description", length = 4095)
    private String description;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private RoomsObject roomsObject;

    public RoomsObjectInformation(String description, RoomsObject roomsObject) {
        this.description = description;
        this.roomsObject = roomsObject;
    }

    public RoomsObjectInformation(RoomsObject roomsObject) {
        this.roomsObject = roomsObject;
    }
}
