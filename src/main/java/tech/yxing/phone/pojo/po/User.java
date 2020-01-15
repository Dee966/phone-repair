package tech.yxing.phone.pojo.po;

import tech.yxing.phone.pojo.vo.LoginVo;
import tech.yxing.phone.pojo.vo.UserVo;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private String name;
    private String telephone;
    private String wechat;
    private Double balance;

    public User(){}

    public User(int userId, UserVo userVo){
        this.userId = userId;
        this.name = userVo.getName();
        this.telephone = userVo.getTelephone();
        this.wechat = userVo.getWechat();
    }

    public User(LoginVo loginVo){
        this.username = loginVo.getUsername();
        this.password = loginVo.getPassword();
    }

    public User(Integer userId, String username, String password, String name, String telephone, String wechat, Double balance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.wechat = wechat;
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", balance=" + balance +
                '}';
    }
}
