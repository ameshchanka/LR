package by.itacademy;

import by.itacademy.dao.DAO;
import by.itacademy.dto.LeaseDTO;
import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.forFilters.LeaseAdFilter;

import java.util.List;

public class LeaseService {

    public Long CountItems() {
        return null;
    }

    public LeaseDTO findLeaseByFilter(LeaseDTO leaseDTO) {

        LeaseDTO result = new LeaseDTO();
        result.setCount(DAO.getInstance().leaseAdDAO.countLeaseByFilter(leaseDTO.getFilter()));
        if (result.getCount() > 0)
            result.setListLeaseAd(DAO
                    .getInstance()
                    .leaseAdDAO
                    .findLeaseByFilter(leaseDTO.getFilter()));
        result.setFilter(leaseDTO.getFilter());
        return result;
    }
}
