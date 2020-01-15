package tech.yxing.phone.pojo.po;

public class Manager {
    private Integer managerId;
    private String username;
    private String password;

    public Manager(){}

    public Manager(Integer managerId, String username, String password) {
        this.managerId = managerId;
        this.username = username;
        this.password = password;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
