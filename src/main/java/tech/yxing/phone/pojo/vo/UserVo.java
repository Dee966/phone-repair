package tech.yxing.phone.pojo.vo;

public class UserVo {
    private String name;
    private String telephone;
    private String wechat;

    public UserVo(){}

    public UserVo(String name, String telephone, String wechat) {
        this.name = name;
        this.telephone = telephone;
        this.wechat = wechat;
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

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", wechat='" + wechat + '\'' +
                '}';
    }
}
