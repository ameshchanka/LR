package by.itacademy.interfaces;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.forFilters.LeaseAdFilter;

import java.util.List;

public interface ILeaseAdDAO extends IBaseDAO<LeaseAd> {

    List<LeaseAd> findLeaseByFilter(LeaseAdFilter filter);
    Long countLeaseByFilter(LeaseAdFilter filter);
}
