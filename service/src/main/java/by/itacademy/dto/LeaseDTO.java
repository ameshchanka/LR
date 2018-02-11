package by.itacademy.dto;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.forFilters.LeaseAdFilter;
import lombok.*;

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
}
