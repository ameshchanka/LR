package by.itacademy.service;

import by.itacademy.dto.RoomsObjectDto;
import by.itacademy.entity.RoomsObject;

public interface RoomsObjectService {

    RoomsObjectDto makeModelForRoomsObjectPage();
    void save(RoomsObject item);
    void update(RoomsObject item);
    void delete(long id);
    RoomsObject findById(Long id);
}
