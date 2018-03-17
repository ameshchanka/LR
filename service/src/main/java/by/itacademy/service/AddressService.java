package by.itacademy.service;

import by.itacademy.dto.AddressDto;
import by.itacademy.entity.Address;

public interface AddressService {

    AddressDto makeModelForAddressPage();
    void save(Address item);
    void update(Address item);
    void delete(long id);
}
