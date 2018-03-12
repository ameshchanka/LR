package by.itacademy.service;

import by.itacademy.entity.Country;

import java.util.List;
import java.util.Locale;

public interface CountryService {

    Iterable<Country> findAll();
    void save(Country item);
    void update(Country item);
    void delete(long id);
}