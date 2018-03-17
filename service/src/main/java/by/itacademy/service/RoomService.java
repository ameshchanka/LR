package by.itacademy.service;

import by.itacademy.entity.Room;

public interface RoomService {

    void save(Room item);
    void update(Room item);
    void delete(long id);
}
