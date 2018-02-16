package by.itacademy.dto;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.forFilters.LeaseAdFilter;
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
public class LeaseDTO {

    private List<LeaseAd> listLeaseAd = new ArrayList<>();
    private LeaseAdFilter filter = new LeaseAdFilter();
    private Long count;
    private PagingInfo pagingInfo = new PagingInfo();


    //private int s = listLeaseAd.size()
}
