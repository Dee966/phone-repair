package tech.yxing.phone.pojo.dto;

public class ConditionDto {
    private Integer conditionPriceId;
    private Double price;
    private Integer phoneId;
    private Integer conditionId;
    private String condition;

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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
