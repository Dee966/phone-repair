package tech.yxing.phone.pojo.po;

public class Address {
    private Integer addressId;
    private String address;
    private Integer userId;

    public Address(){}

    public Address(Integer addressId, String address, Integer userId) {
        this.addressId = addressId;
        this.address = address;
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}
