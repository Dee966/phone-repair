package tech.yxing.phone.pojo.dto;

public class OrderAndImgDto {
    private String img;
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
    private String mode;
    private Integer userId;
    private Integer phoneId;

    public OrderAndImgDto(){}

    public OrderAndImgDto(String img, Integer orderId, String name, String telephone, String address, String model, String color, String hitch, String remarks, Double total, Integer state, String mode, Integer userId, Integer phoneId) {
        this.img = img;
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
        this.mode = mode;
        this.userId = userId;
        this.phoneId = phoneId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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
        return "OrderAndImgDto{" +
                "img='" + img + '\'' +
                ", orderId=" + orderId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", hitch='" + hitch + '\'' +
                ", remarks='" + remarks + '\'' +
                ", total=" + total +
                ", state=" + state +
                ", mode='" + mode + '\'' +
                ", userId=" + userId +
                ", phoneId=" + phoneId +
                '}';
    }
}
