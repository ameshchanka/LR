package by.itacademy.service;

import by.itacademy.entity.Country;

public interface CountryService {

    Iterable<Country> findAll();
    void save(Country item);
    void update(Country item);
    void delete(long id);
}