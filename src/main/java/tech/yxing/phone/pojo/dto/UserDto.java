package tech.yxing.phone.pojo.dto;

public class UserDto {
    private String name;
    private String telephone;
    private String wechat;
    private Double balance;

    public UserDto(){}

    public UserDto(String name, String telephone, String wechat, Double balance) {
        this.name = name;
        this.telephone = telephone;
        this.wechat = wechat;
        this.balance = balance;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", balance=" + balance +
                '}';
    }
}
