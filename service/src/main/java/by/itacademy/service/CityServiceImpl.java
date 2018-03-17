package by.itacademy.service;

import by.itacademy.dto.CityDto;
import by.itacademy.entity.City;
import by.itacademy.repository.CityRepository;
import by.itacademy.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public CityDto makeModelForCityPage() {
        CityDto cityDto = new CityDto();
        cityDto.setCities(cityRepository.findAll());
        cityDto.setCountries(countryRepository.findAll());
        return cityDto;
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void update(City city) {
        cityRepository.save(city);
    }

    @Override
    public void delete(long id) {
        cityRepository.delete(id);
    }
}
