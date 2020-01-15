package tech.yxing.phone.pojo.po;

public class Hitch {
    private Integer hitchId;
    private String hitch;
    private Double price;
    private Integer phoneId;

    public Hitch(){}

    public Hitch(Integer hitchId, String hitch, Double price, Integer phoneId) {
        this.hitchId = hitchId;
        this.hitch = hitch;
        this.price = price;
        this.phoneId = phoneId;
    }

    public Integer getHitchId() {
        return hitchId;
    }

    public void setHitchId(Integer hitchId) {
        this.hitchId = hitchId;
    }

    public String getHitch() {
        return hitch;
    }

    public void setHitch(String hitch) {
        this.hitch = hitch;
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

    @Override
    public String toString() {
        return "Hitch{" +
                "hitchId=" + hitchId +
                ", hitch='" + hitch + '\'' +
                ", price=" + price +
                ", phoneId=" + phoneId +
                '}';
    }
}
