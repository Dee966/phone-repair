package tech.yxing.phone.pojo.po;

public class Type {
    private Integer typeId;
    private String type;
    private String logo;

    public Type(){}

    public Type(Integer typeId, String type, String logo) {
        this.typeId = typeId;
        this.type = type;
        this.logo = logo;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
