package by.itacademy.service;


import by.itacademy.dto.LeaseAdDto;
import by.itacademy.entity.LeaseAd;

public interface LeaseAdService {

    LeaseAdDto makeModelForLeaseAdPage(LeaseAdDto leaseAdDto);
    void save(LeaseAd item);
    void update(LeaseAd item);
    void delete(long id);
}
