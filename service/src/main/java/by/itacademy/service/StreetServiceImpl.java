package by.itacademy.service;

import by.itacademy.dto.StreetDto;
import by.itacademy.entity.Street;
import by.itacademy.repository.CityRepository;
import by.itacademy.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StreetServiceImpl implements StreetService {

    private CityRepository cityRepository;
    private StreetRepository streetRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @Autowired
    public void setStreetRepository(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public StreetDto makeModelForStreetPage() {
        StreetDto streetDto = new StreetDto();
        streetDto.setCities(cityRepository.findAll());
        streetDto.setStreets(streetRepository.findAll());
        return streetDto;
    }

    @Override
    public void save(Street item) {
        streetRepository.save(item);
    }

    @Override
    public void update(Street item) {
        streetRepository.save(item);
    }

    @Override
    public void delete(long id) {
        streetRepository.delete(id);
    }
}
