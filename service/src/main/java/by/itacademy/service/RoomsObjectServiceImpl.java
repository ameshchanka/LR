package by.itacademy.service;

import by.itacademy.dto.RoomsObjectDto;
import by.itacademy.entity.RoomsObject;
import by.itacademy.repository.AddressRepository;
import by.itacademy.repository.RoomsObjectInformationRepository;
import by.itacademy.repository.RoomsObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomsObjectServiceImpl implements RoomsObjectService {

    private RoomsObjectRepository roomsObjectRepository;
    private RoomsObjectInformationRepository roomsObjectInformationRepository;
    private AddressRepository addressRepository;

    @Autowired
    public void setRoomsObjectRepository(RoomsObjectRepository roomsObjectRepository) {
        this.roomsObjectRepository = roomsObjectRepository;
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    public void setRoomsObjectInformationRepository(RoomsObjectInformationRepository roomsObjectInformationRepository) {
        this.roomsObjectInformationRepository = roomsObjectInformationRepository;
    }

    @Override
    public RoomsObjectDto makeModelForRoomsObjectPage() {
        RoomsObjectDto dto = new RoomsObjectDto();
        dto.setRoomsObjects(roomsObjectRepository.findAll());
        dto.setAddresses(addressRepository.findAll());
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
