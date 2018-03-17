package by.itacademy.dto;

import by.itacademy.entity.Address;
import by.itacademy.entity.Room;
import by.itacademy.entity.RoomsObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RoomDto {

    Iterable<Room> rooms;
    Iterable<Address> addresses;
}
