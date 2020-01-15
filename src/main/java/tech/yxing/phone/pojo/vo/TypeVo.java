package tech.yxing.phone.pojo.vo;

public class TypeVo {
    private String type;

    public TypeVo(){}

    public TypeVo(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeVo{" +
                "type='" + type + '\'' +
                '}';
    }
}
