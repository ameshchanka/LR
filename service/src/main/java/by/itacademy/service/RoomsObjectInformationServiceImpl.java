package by.itacademy.service;

import by.itacademy.entity.RoomsObject;
import by.itacademy.entity.RoomsObjectInformation;
import by.itacademy.repository.RoomsObjectInformationRepository;
import by.itacademy.repository.RoomsObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomsObjectInformationServiceImpl implements RoomsObjectInformationService {

    private RoomsObjectRepository roomsObjectRepository;
    private RoomsObjectInformationRepository repository;

    @Autowired
    public void setRepository(RoomsObjectInformationRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setRoomsObjectRepository(RoomsObjectRepository roomsObjectRepository) {
        this.roomsObjectRepository = roomsObjectRepository;
    }

    @Override
    public void update(RoomsObjectInformation item) {
        RoomsObject roomsObject = roomsObjectRepository.findOne(item.getId());
        item.setRoomsObject(roomsObject);
        repository.save(item);
    }
}
