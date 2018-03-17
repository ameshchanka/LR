package by.itacademy.service;

import by.itacademy.dto.StreetDto;
import by.itacademy.entity.Street;

public interface StreetService {

    StreetDto makeModelForStreetPage();
    void save(Street item);
    void update(Street item);
    void delete(long id);
}
