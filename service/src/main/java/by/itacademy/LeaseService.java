package by.itacademy;

import by.itacademy.dao.DAO;
import by.itacademy.dto.LeaseDTO;

public class LeaseService {

    public LeaseDTO findLeaseByFilter(LeaseDTO leaseDTO) {

        LeaseDTO result = new LeaseDTO();
        result.setCount(DAO.getInstance().getLeaseAdDAO().countLeaseByFilter(leaseDTO.getFilter()));
        if (result.getCount() > 0) {
            result.setListLeaseAd(DAO
                    .getInstance()
                    .getLeaseAdDAO()
                    .findLeaseByFilter(leaseDTO.getFilter()));
        }
        result.setFilter(leaseDTO.getFilter());
        return result;
    }
}
