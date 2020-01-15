package tech.yxing.phone.pojo.po;

import tech.yxing.phone.pojo.vo.OrderVo;

public class Order {
    private Integer orderId;
    private String name;
    private String telephone;
    private String address;
    private String model;
    private String color;
    private String hitch;
    private String remarks;
    private Double total;
    private Integer state;
    private Integer userId;
    private Integer phoneId;

    public Order(){}

    public Order(OrderVo orderVo){
        this.name = orderVo.getName();
        this.telephone = orderVo.getTelephone();
        this.address = orderVo.getAddress();
        this.model = orderVo.getModel();
        this.color = orderVo.getColor();
        this.hitch = orderVo.getHitch();
        this.remarks = orderVo.getRemarks();
        this.total = orderVo.getTotal();
        this.userId = orderVo.getUserId();
        this.phoneId = orderVo.getPhoneId();
    }

    public Order(Integer orderId, String name, String telephone, String address, String model, String color, String hitch, String remarks, Double total, Integer state, Integer userId, Integer phoneId) {
        this.orderId = orderId;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.model = model;
        this.color = color;
        this.hitch = hitch;
        this.remarks = remarks;
        this.total = total;
        this.state = state;
        this.userId = userId;
        this.phoneId = phoneId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHitch() {
        return hitch;
    }

    public void setHitch(String hitch) {
        this.hitch = hitch;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", hitch='" + hitch + '\'' +
                ", remarks='" + remarks + '\'' +
                ", total=" + total +
                ", state=" + state +
                ", userId=" + userId +
                ", phoneId=" + phoneId +
                '}';
    }
}
