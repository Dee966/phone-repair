package tech.yxing.phone.pojo.dto;

public class RODto {
    private Integer recoveryOrderId;
    private String model;
    private String img;
    private Integer state;
    private Double total;

    public Integer getRecoveryOrderId() {
        return recoveryOrderId;
    }

    public void setRecoveryOrderId(Integer recoveryOrderId) {
        this.recoveryOrderId = recoveryOrderId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
