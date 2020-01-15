package tech.yxing.phone.pojo.vo;

import tech.yxing.phone.pojo.po.Color;
import tech.yxing.phone.pojo.po.Hitch;

import java.util.List;

public class PhoneInfoVo {
    private String model;
    private String img;
    private Integer typeId;
    private List<Color> colors;
    private List<Hitch> hitches;

    public PhoneInfoVo(){}

    public PhoneInfoVo(String model, String img, Integer typeId, List<Color> colors, List<Hitch> hitches) {
        this.model = model;
        this.img = img;
        this.typeId = typeId;
        this.colors = colors;
        this.hitches = hitches;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Hitch> getHitches() {
        return hitches;
    }

    public void setHitches(List<Hitch> hitches) {
        this.hitches = hitches;
    }

    @Override
    public String toString() {
        return "PhoneInfoVo{" +
                "model='" + model + '\'' +
                ", img='" + img + '\'' +
                ", typeId=" + typeId +
                ", colors=" + colors +
                ", hitches=" + hitches +
                '}';
    }
}
