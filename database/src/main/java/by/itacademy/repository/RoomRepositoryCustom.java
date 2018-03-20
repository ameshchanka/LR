package by.itacademy.repository;

import by.itacademy.entity.Room;

import java.util.List;

public interface RoomRepositoryCustom {

    List<Room> findRoomsByUserEmail(String email);
    List<Room> findByRoomsObject(Long id);
}
