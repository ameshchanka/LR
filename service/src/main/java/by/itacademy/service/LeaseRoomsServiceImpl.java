package by.itacademy.service;

import by.itacademy.aspects.LoggerMethod;
import by.itacademy.dto.LeaseRoomsDto;
import by.itacademy.infrastructure.PagingInfo;
import by.itacademy.repository.LeaseAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LeaseRoomsServiceImpl implements LeaseRoomsService {

    private LeaseAdRepository leaseAdRepository;

    @Autowired
    public void setLeaseAdDAO(LeaseAdRepository leaseAdRepository) {
        this.leaseAdRepository = leaseAdRepository;
    }

    @Override
    @LoggerMethod
    public LeaseRoomsDto makeModelForLeaseRoomsPage(LeaseRoomsDto leaseRoomsDto) {
        LeaseRoomsDto result = new LeaseRoomsDto();
        Long countItems = leaseAdRepository.countLeaseRoomsByModel(leaseRoomsDto);
        if (countItems > 0) {
            leaseRoomsDto.setCount(countItems);
            leaseRoomsDto.setPaging(
                    new PagingInfo(
                            countItems,
                            leaseRoomsDto.getPaging().getItemsPerPage(),
                            leaseRoomsDto.getPaging().getCurrentPage()));
            result.setLeaseAds(leaseAdRepository.findLeaseRoomsByModel(leaseRoomsDto));
            result.setPaging(leaseRoomsDto.getPaging());
        }
        result.setFilter(leaseRoomsDto.getFilter());
        result.setCount(countItems);
        return result;
    }
}
