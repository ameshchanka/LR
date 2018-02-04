package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by a.meshchanka on 03.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lr_roomsobjectimages")
@PrimaryKeyJoinColumn(name = "image_id")
public class RoomsObjectImage extends Image {

    @ManyToOne(cascade = {CascadeType.ALL})
    private RoomsObject roomsObject;
}
