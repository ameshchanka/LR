package by.itacademy.service;

import by.itacademy.dto.RoomDto;
import by.itacademy.dto.RoomsObjectDto;
import by.itacademy.entity.RoomsObject;
import by.itacademy.repository.AddressRepository;
import by.itacademy.repository.RoomRepository;
import by.itacademy.repository.RoomsObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@Transactional
public class RoomsObjectServiceImpl implements RoomsObjectService {

    private RoomsObjectRepository roomsObjectRepository;
    private RoomRepository roomRepository;
    private AddressRepository addressRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Autowired
    public void setRoomsObjectRepository(RoomsObjectRepository roomsObjectRepository) {
        this.roomsObjectRepository = roomsObjectRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public RoomsObjectDto makeModelForRoomsObjectPage() {
        RoomsObjectDto dto = new RoomsObjectDto();
        dto.setRoomsObjects(roomsObjectRepository.findAll());
        dto.setAddresses(addressRepository.findAll());
        return dto;
    }

    @Override
    public RoomsObjectDto makeModelForIndexPage() {
        RoomsObjectDto dto = new RoomsObjectDto();
        dto.setRoomsObjects(roomsObjectRepository.findAllWithRooms());
        for (RoomsObject obj : dto.getRoomsObjects()) {
            obj.setRooms(new HashSet<>(roomRepository.findByRoomsObject(obj.getId())));
        }
        return dto;
    }

    @Override
    public RoomDto makeModelForHomeRoomsOblectPage(Long id) {
        RoomDto dto = new RoomDto();
        dto.setRooms(roomRepository.findByRoomsObject(id));
        return dto;
    }

    @Override
    public void save(RoomsObject item) {
        if (item.getRoomsObjectInformation() != null) {
            item.getRoomsObjectInformation()
                    .setRoomsObject(item);
        }
        roomsObjectRepository.save(item);

    }

    @Override
    public void update(RoomsObject item) {
        if (item.getRoomsObjectInformation() != null) {
            item.getRoomsObjectInformation()
                    .setId(item.getId());
        }
        roomsObjectRepository.save(item);
    }

    @Override
    public void delete(long id) {
        roomsObjectRepository.delete(id);
    }

    @Override
    public RoomsObject findById(Long id) {
        return roomsObjectRepository.findOne(id);
    }
}
