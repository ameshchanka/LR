package by.itacademy.interfaces;

import by.itacademy.dto.LeaseDTO;

public interface ILeaseService {

    LeaseDTO findLeaseByFilter(LeaseDTO leaseDTO);
}
