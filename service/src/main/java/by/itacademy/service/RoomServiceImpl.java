package by.itacademy.service;

import by.itacademy.dto.RoomDto;
import by.itacademy.entity.Room;
import by.itacademy.entity.User;
import by.itacademy.repository.RoomRepository;
import by.itacademy.repository.RoomsObjectRepository;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private RoomsObjectRepository roomsObjectRepository;
    private UserRepository userRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Autowired
    public void setRoomsObjectRepository(RoomsObjectRepository roomsObjectRepository) {
        this.roomsObjectRepository = roomsObjectRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        item.setUser(userRepository.findByEmail(item.getUser().getEmail()));
        roomRepository.save(item);
    }

    @Override
    public void update(Room item) {
        item.setUser(userRepository.findByEmail(item.getUser().getEmail()));
        roomRepository.save(item);
    }

    @Override
    public void delete(long id) {
        roomRepository.delete(id);
    }

    @Override
    public void startlease(long id) {

    }

    @Override
    public void stoplease(long id) {

    }
}
