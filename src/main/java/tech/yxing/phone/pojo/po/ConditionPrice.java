package tech.yxing.phone.pojo.po;

public class ConditionPrice {
    private Integer conditionPriceId;
    private Double price;
    private Integer phoneId;
    private Integer conditionId;

    public ConditionPrice() {
    }

    public ConditionPrice(Integer conditionPriceId, Double price, Integer phoneId, Integer conditionId) {
        this.conditionPriceId = conditionPriceId;
        this.price = price;
        this.phoneId = phoneId;
        this.conditionId = conditionId;
    }

    public Integer getConditionPriceId() {
        return conditionPriceId;
    }

    public void setConditionPriceId(Integer conditionPriceId) {
        this.conditionPriceId = conditionPriceId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    @Override
    public String toString() {
        return "ConditionPrice{" +
                "conditionPriceId=" + conditionPriceId +
                ", price=" + price +
                ", phoneId=" + phoneId +
                ", conditionId=" + conditionId +
                '}';
    }
}
