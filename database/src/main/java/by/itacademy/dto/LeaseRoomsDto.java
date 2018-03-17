package by.itacademy.dto;

import by.itacademy.entity.LeaseAd;
import by.itacademy.dto.filters.LeaseFilterDto;
import by.itacademy.infrastructure.PagingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeaseRoomsDto {

    private List<LeaseAd> leaseAds = new ArrayList<LeaseAd>();
    private LeaseFilterDto filter = new LeaseFilterDto();
    private Long count;
    private PagingInfo paging = new PagingInfo();


    //private int s = leaseAds.size()
}
