package tech.yxing.phone.pojo.vo;

public class StateVo {
    private Integer orderId;
    private Integer state;

    public StateVo(){}

    public StateVo(Integer orderId, Integer state) {
        this.orderId = orderId;
        this.state = state;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StateVo{" +
                "orderId=" + orderId +
                ", state=" + state +
                '}';
    }
}
