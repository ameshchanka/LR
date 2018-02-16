package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by a.meshchanka on 02.02.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lr_roomimages")
@PrimaryKeyJoinColumn(name = "image_id")
public class RoomImage extends Image {

    @ManyToOne(cascade = {CascadeType.ALL})
    private Room room;

    public RoomImage(String path, Room room) {
        super(path);
        this.room = room;
    }
}
