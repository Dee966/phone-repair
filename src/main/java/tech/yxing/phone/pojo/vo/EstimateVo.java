package tech.yxing.phone.pojo.vo;

import java.util.List;

public class EstimateVo {
    private List<Double> prices;
    private Integer phoneId;

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }
}
