package by.itacademy.service;

import by.itacademy.dto.RoomDto;
import by.itacademy.entity.Room;
import by.itacademy.repository.RoomRepository;
import by.itacademy.repository.RoomsObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private RoomsObjectRepository roomsObjectRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Autowired
    public void setRoomsObjectRepository(RoomsObjectRepository roomsObjectRepository) {
        this.roomsObjectRepository = roomsObjectRepository;
    }

    @Override
    public RoomDto makeModelForRoomsPage(RoomDto roomDto) {
        RoomDto result = new RoomDto();
        result.setRooms(roomRepository.findRoomsByUserEmail(roomDto.getUser().getEmail()));
        result.setRoomsObjects(roomsObjectRepository.findAll());
        return result;
    }

    @Override
    public void save(Room item) {

    }

    @Override
    public void update(Room item) {

    }

    @Override
    public void delete(long id) {

    }
}
