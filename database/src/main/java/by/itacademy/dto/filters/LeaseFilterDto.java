package by.itacademy.dto.filters;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeaseFilterDto {

    private Float priceMin;
    private Float priceMax;
    private Float squareMin;
    private Float squareMax;
    private Float pm2Min;
    private Float pm2Max;

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

}
