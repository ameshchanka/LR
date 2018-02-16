package by.itacademy.entity.forFilters;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class LeaseAdFilter {

    private final Long countInit = 5L;
    private Float priceMin;
    private Float priceMax;
    private Float squareMin;
    private Float squareMax;
    private Float pm2Min;
    private Float pm2Max;
    private Long countItems;
    private Long firstItems = 0L;

    public Float getPriceMin() {
        return priceMin;
    }

    public Float getPriceMax() {
        return priceMax;
    }

    public Float getSquareMin() {
        return squareMin;
    }

    public Float getSquareMax() {
        return squareMax;
    }

    public Float getPm2Min() {
        return pm2Min;
    }

    public Float getPm2Max() {
        return pm2Max;
    }

    public Long getCountItems() {
        return countItems;
    }

    public Long getFirstItems() {
        return firstItems;
    }

    public void setPriceMin(Float priceMin) {
        this.priceMin = priceMin;
    }

    public void setPriceMax(Float priceMax) {
        this.priceMax = priceMax;
    }

    public void setSquareMin(Float squareMin) {
        this.squareMin = squareMin;
    }

    public void setSquareMax(Float squareMax) {
        this.squareMax = squareMax;
    }

    public void setPm2Min(Float pm2Min) {
        this.pm2Min = pm2Min;
    }

    public void setPm2Max(Float pm2Max) {
        this.pm2Max = pm2Max;
    }

    public void setCountItems(Long countItems) {
        this.countItems = countItems;
    }

    public void setFirstItems(Long firstItems) {
        this.firstItems = (firstItems - 1) * countItems;
    }

    public LeaseAdFilter() {
        this.countItems = this.countInit;
    }
}
