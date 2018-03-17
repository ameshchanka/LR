package by.itacademy.dto;

import by.itacademy.entity.City;
import by.itacademy.entity.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CityDto {

    private Iterable<City> cities;
    private Iterable<Country> countries;
}
