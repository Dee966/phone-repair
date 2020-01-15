package tech.yxing.phone.pojo.po;

public class Color {
    private Integer colorId;
    private String color;
    private Integer phoneId;

    public Color(){}

    public Color(Integer colorId, String color, Integer phoneId) {
        this.colorId = colorId;
        this.color = color;
        this.phoneId = phoneId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    @Override
    public String toString() {
        return "Color{" +
                "colorId=" + colorId +
                ", color='" + color + '\'' +
                ", phoneId=" + phoneId +
                '}';
    }
}
