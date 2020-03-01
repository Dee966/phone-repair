package tech.yxing.phone.pojo.po;

public class RecoveryOrder {
    private Integer recoverOrderId;
    private String model;
    private String edition;
    private String memory;
    private String screenAppearance;
    private String phoneAppearance;
    private String repair;
    private String account;
    private String other;
    private Double total;
    private Integer state;
    private String name;
    private String telephone;
    private String address;
    private Integer userId;
    private Integer phoneId;

    public RecoveryOrder() {
    }

    public RecoveryOrder(Integer recoverOrderId, String model, String edition, String memory, String screenAppearance, String phoneAppearance, String repair, String account, String other, Double total, Integer state, String name, String telephone, String address, Integer userId, Integer phoneId) {
        this.recoverOrderId = recoverOrderId;
        this.model = model;
        this.edition = edition;
        this.memory = memory;
        this.screenAppearance = screenAppearance;
        this.phoneAppearance = phoneAppearance;
        this.repair = repair;
        this.account = account;
        this.other = other;
        this.total = total;
        this.state = state;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.userId = userId;
        this.phoneId = phoneId;
    }

    public Integer getRecoverOrderId() {
        return recoverOrderId;
    }

    public void setRecoverOrderId(Integer recoverOrderId) {
        this.recoverOrderId = recoverOrderId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getScreenAppearance() {
        return screenAppearance;
    }

    public void setScreenAppearance(String screenAppearance) {
        this.screenAppearance = screenAppearance;
    }

    public String getPhoneAppearance() {
        return phoneAppearance;
    }

    public void setPhoneAppearance(String phoneAppearance) {
        this.phoneAppearance = phoneAppearance;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    @Override
    public String toString() {
        return "RecoveryOrder{" +
                "recoverOrderId=" + recoverOrderId +
                ", model='" + model + '\'' +
                ", edition='" + edition + '\'' +
                ", memory='" + memory + '\'' +
                ", screenAppearance='" + screenAppearance + '\'' +
                ", phoneAppearance='" + phoneAppearance + '\'' +
                ", repair='" + repair + '\'' +
                ", account='" + account + '\'' +
                ", other='" + other + '\'' +
                ", total=" + total +
                ", state=" + state +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                ", phoneId=" + phoneId +
                '}';
    }
}
