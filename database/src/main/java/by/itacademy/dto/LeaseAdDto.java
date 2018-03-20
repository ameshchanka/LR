package by.itacademy.dto;

import by.itacademy.dto.filters.LeaseAdFilterDto;
import by.itacademy.entity.LeaseAd;
import by.itacademy.infrastructure.OrderModel;
import by.itacademy.infrastructure.PagingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LeaseAdDto {

    private Iterable<LeaseAd> leaseAds;
    private LeaseAdFilterDto filter = new LeaseAdFilterDto();
    private PagingInfo paging = new PagingInfo();
    private OrderModel order = new OrderModel();
    private Long count;
}
