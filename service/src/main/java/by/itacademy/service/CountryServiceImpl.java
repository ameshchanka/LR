package by.itacademy.service;

import by.itacademy.entity.Country;
import by.itacademy.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void update(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void delete(long id) {
        countryRepository.delete(id);
    }
}