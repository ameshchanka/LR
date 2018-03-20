package by.itacademy.dto;

import by.itacademy.entity.City;
import by.itacademy.entity.Street;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StreetDto {

    private Iterable<City> cities;
    private Iterable<Street> streets;
}
