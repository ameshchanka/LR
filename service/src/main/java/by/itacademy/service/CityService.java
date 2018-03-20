package by.itacademy.service;

import by.itacademy.dto.CityDto;
import by.itacademy.entity.City;

public interface CityService {

    CityDto makeModelForCityPage();
    void save(City item);
    void update(City item);
    void delete(long id);
}
