package tech.yxing.phone.pojo.po;

public class RecoveryPrice {
    private Integer recoveryId;
    private Double price;
    private Integer phoneId;

    public RecoveryPrice() {
    }

    public RecoveryPrice(Integer recoveryId, Double price, Integer phoneId) {
        this.recoveryId = recoveryId;
        this.price = price;
        this.phoneId = phoneId;
    }

    public Integer getRecoveryId() {
        return recoveryId;
    }

    public void setRecoveryId(Integer recoveryId) {
        this.recoveryId = recoveryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RecoveryPrice{" +
                "recoveryId=" + recoveryId +
                ", price=" + price +
                ", phoneId=" + phoneId +
                '}';
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }
}
