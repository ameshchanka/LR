package by.itacademy.service;

import by.itacademy.dto.RoomDto;
import by.itacademy.dto.RoomUpdateDto;
import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Room;
import by.itacademy.repository.LeaseAdRepository;
import by.itacademy.repository.RoomRepository;
import by.itacademy.repository.RoomsObjectRepository;
import by.itacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private RoomsObjectRepository roomsObjectRepository;
    private UserRepository userRepository;
    private LeaseAdRepository leaseAdRepository;

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
    @Autowired
    public void setLeaseAdRepository(LeaseAdRepository leaseAdRepository) {
        this.leaseAdRepository = leaseAdRepository;
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
    public void update(RoomUpdateDto dto) {
        dto.getRoom().setUser(userRepository.findByEmail(dto.getRoom().getUser().getEmail()));
        LeaseAd leaseAdItem = leaseAdRepository.findOne(dto.getLeaseAd().getId());
        if(leaseAdItem != null) {
            leaseAdItem.setPrice(dto.getLeaseAd().getPrice());
        } else {
            leaseAdItem = new LeaseAd();
            leaseAdItem.setRoom(dto.getRoom());
            leaseAdItem.setPrice(dto.getLeaseAd().getPrice());
        }
        leaseAdRepository.save(leaseAdItem);
        roomRepository.save(dto.getRoom());
    }

    @Override
    public void delete(long id) {
        roomRepository.delete(id);
    }

    @Override
    public void startlease(long id) {
        LeaseAd leaseAdItem = leaseAdRepository.findOne(id);
        leaseAdItem.setDateStartLease(LocalDateTime.now());
        leaseAdRepository.save(leaseAdItem);
    }

    @Override
    public void stoplease(long id) {
        LeaseAd leaseAdItem = leaseAdRepository.findOne(id);
        leaseAdItem.setDateStopLease(LocalDateTime.now());
        leaseAdRepository.save(leaseAdItem);
    }
}
