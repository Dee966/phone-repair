package tech.yxing.phone.pojo.dto;

import tech.yxing.phone.pojo.po.Color;
import tech.yxing.phone.pojo.po.Hitch;
import tech.yxing.phone.pojo.vo.PhoneInfoVo;

import java.util.List;

public class PhoneInfoDto {
    private Integer phoneId;
    private String model;
    private String img;
    private Integer typeId;
    private List<Color> colors;
    private List<Hitch> hitches;

    public PhoneInfoDto(){}

    public PhoneInfoDto(PhoneInfoVo phoneInfoVo){
        this.model = phoneInfoVo.getModel();
        this.img = phoneInfoVo.getImg();
        this.typeId = phoneInfoVo.getTypeId();
        this.colors = phoneInfoVo.getColors();
        this.hitches = phoneInfoVo.getHitches();
    }

    public PhoneInfoDto(Integer phoneId, String model, String img, Integer typeId, List<Color> colors, List<Hitch> hitches) {
        this.phoneId = phoneId;
        this.model = model;
        this.img = img;
        this.typeId = typeId;
        this.colors = colors;
        this.hitches = hitches;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
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
        return "PhoneInfoDto{" +
                "phoneId=" + phoneId +
                ", model='" + model + '\'' +
                ", img='" + img + '\'' +
                ", typeId=" + typeId +
                ", colors=" + colors +
                ", hitches=" + hitches +
                '}';
    }
}
