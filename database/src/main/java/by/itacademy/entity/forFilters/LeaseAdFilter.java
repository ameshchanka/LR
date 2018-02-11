package by.itacademy.entity.forFilters;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeaseAdFilter {

    private Float priceMin = 0F;
    private Float priceMax = Float.MAX_VALUE;
    private Float squareMin = 0F;
    private Float squareMax = Float.MAX_VALUE;
    private Float pm2Min = 0F;
    private Float pm2Max = Float.MAX_VALUE;
    private int maxResult = 5;
    private int firstResult = 1;

}
