package by.itacademy.repository;

import by.itacademy.entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long>, RoomRepositoryCustom {

}
