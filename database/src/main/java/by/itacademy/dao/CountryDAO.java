package by.itacademy.dao;

import by.itacademy.entity.Country;
import by.itacademy.interfaces.ICountryDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by a.meshchanka on 04.02.2018.
 */
@Repository
public class CountryDAO extends BaseDAO<Country> implements ICountryDAO {

}
