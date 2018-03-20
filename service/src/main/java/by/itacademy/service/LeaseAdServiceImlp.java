package by.itacademy.service;

import by.itacademy.dto.LeaseAdDto;
import by.itacademy.entity.LeaseAd;
import by.itacademy.infrastructure.PagingInfo;
import by.itacademy.repository.LeaseAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeaseAdServiceImlp implements LeaseAdService {

    private LeaseAdRepository leaseAdRepository;

    @Autowired
    public void setLeaseAdRepository(LeaseAdRepository leaseAdRepository) {
        this.leaseAdRepository = leaseAdRepository;
    }

    @Override
    public LeaseAdDto makeModelForLeaseAdPage(LeaseAdDto leaseAdDto) {
        LeaseAdDto result = new LeaseAdDto();
        Long countItems = leaseAdRepository.countLeaseAdByModel(leaseAdDto);
        if (countItems > 0) {
            leaseAdDto.setCount(countItems);
            leaseAdDto.setPaging(
                    new PagingInfo(
                            countItems,
                            leaseAdDto.getPaging().getItemsPerPage(),
                            leaseAdDto.getPaging().getCurrentPage()));
            result.setLeaseAds(leaseAdRepository.findLeaseAdByModel(leaseAdDto));
            result.setPaging(leaseAdDto.getPaging());
        }
        result.setFilter(leaseAdDto.getFilter());
        result.setCount(countItems);
        return result;
    }

    @Override
    public void save(LeaseAd item) {

    }

    @Override
    public void update(LeaseAd item) {

    }

    @Override
    public void delete(long id) {
        leaseAdRepository.delete(id);
    }
}
