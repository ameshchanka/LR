package by.itacademy.services;

import by.itacademy.dto.LeaseDTO;
import by.itacademy.repository.LeaseAdRepository;
import by.itacademy.interfaces.ILeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeaseService implements ILeaseService {

    private LeaseAdRepository leaseAdDAO;

    @Autowired
    public LeaseService(LeaseAdRepository leaseAdDAO) {
        this.leaseAdDAO = leaseAdDAO;
    }

    @Override
    public LeaseDTO findLeaseByFilter(LeaseDTO leaseDTO) {

        LeaseDTO result = new LeaseDTO();
        result.setCount(leaseAdDAO.countLeaseByFilter(leaseDTO.getFilter()));
//        result.setCount(DAO.getInstance().getLeaseAdDAO().countLeaseByFilter(leaseDTO.getFilter()));
        if (result.getCount() > 0) {
//            result.setListLeaseAd(DAO
//                    .getInstance()
//                    .getLeaseAdDAO()
//                    .findLeaseByFilter(leaseDTO.getFilter()));
            result.setListLeaseAd(leaseAdDAO.findLeaseByFilter(leaseDTO.getFilter()));
        }
        result.setFilter(leaseDTO.getFilter());
        //result.setPagingInfo(leaseDTO.getPagingInfo());
        return result;
    }
}
