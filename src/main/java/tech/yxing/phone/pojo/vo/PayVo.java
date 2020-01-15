package tech.yxing.phone.pojo.vo;

public class PayVo {
    private Integer userId;
    private Double total;
    private Integer orderId;

    public PayVo(){}

    public PayVo(Integer userId, Double total, Integer orderId) {
        this.userId = userId;
        this.total = total;
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "PayVo{" +
                "userId=" + userId +
                ", total=" + total +
                ", orderId=" + orderId +
                '}';
    }
}
