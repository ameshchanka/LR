package by.itacademy.service;

import by.itacademy.dto.AddressDto;
import by.itacademy.entity.Address;
import by.itacademy.repository.AddressRepository;
import by.itacademy.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private StreetRepository streetRepository;

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    public void setStreetRepository(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public AddressDto makeModelAddressPage() {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddresses(addressRepository.findAll());
        addressDto.setStreets(streetRepository.findAll());
        return addressDto;
    }

    @Override
    public void save(Address item) {
        addressRepository.save(item);
    }

    @Override
    public void update(Address item) {
        addressRepository.save(item);
    }

    @Override
    public void delete(long id) {
        addressRepository.delete(id);
    }
}
