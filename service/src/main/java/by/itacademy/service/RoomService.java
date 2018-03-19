package by.itacademy.service;

import by.itacademy.dto.RoomDto;
import by.itacademy.entity.Room;

public interface RoomService {

    RoomDto makeModelForRoomsPage(RoomDto roomDto);
    void save(Room item);
    void update(Room item);
    void delete(long id);
    void startlease(long id);
    void stoplease(long id);
}
