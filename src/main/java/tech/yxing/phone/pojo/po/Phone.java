package tech.yxing.phone.pojo.po;

public class Phone {
    private Integer phoneId;
    private String model;
    private String img;
    private Integer typeId;

    public Phone(){}

    public Phone(Integer phoneId, String model, String img, Integer typeId) {
        this.phoneId = phoneId;
        this.model = model;
        this.img = img;
        this.typeId = typeId;
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

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", model='" + model + '\'' +
                ", img='" + img + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
