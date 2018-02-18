package by.itacademy.dao;

import by.itacademy.entity.Room;
import by.itacademy.interfaces.IRoomDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@Repository
public class RoomDAO extends BaseDAO<Room> implements IRoomDAO {
}
