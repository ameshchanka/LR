package by.itacademy.dto;

import by.itacademy.entity.Address;
import by.itacademy.entity.Street;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddressDto {

    private Iterable<Address> addresses;
    private Iterable<Street> streets;
}
