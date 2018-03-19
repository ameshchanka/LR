package by.itacademy.dto;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RoomDto {

    private List<Room> rooms = new ArrayList<>();
    private Iterable<RoomsObject> roomsObjects;
    private User user = new User();
}
