package by.itacademy.repository;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.forFilters.LeaseAdFilter;

import java.util.List;

public interface LeaseAdRepositoryCustom {

    List<LeaseAd> findLeaseByFilter(LeaseAdFilter filter);
    Long countLeaseByFilter(LeaseAdFilter filter);
}
