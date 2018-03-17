package by.itacademy.repository;

import by.itacademy.dto.LeaseAdDto;
import by.itacademy.dto.LeaseRoomsDto;
import by.itacademy.entity.LeaseAd;

import java.util.List;

public interface LeaseAdRepositoryCustom {

    List<LeaseAd> findLeaseRoomsByModel(LeaseRoomsDto leaseRoomsDto);
    Long countLeaseRoomsByModel(LeaseRoomsDto leaseRoomsDto);
    Iterable<LeaseAd> findLeaseAdByModel(LeaseAdDto leaseAdDto);
    Long countLeaseAdByModel(LeaseAdDto leaseAdDto);
}
