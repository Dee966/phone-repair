package tech.yxing.phone.pojo.po;

import java.util.Date;

public class Log {
    private Integer logId;
    private Date orderTime;
    private Date payTime;
    private Date repairTime;
    private Date sendTime;
    private Date gotTime;
    private Integer orderId;
    private Integer managerId;

    public Log(){}

    public Log(Integer logId, Date orderTime, Date payTime, Date repairTime, Date sendTime, Date gotTime, Integer orderId, Integer managerId) {
        this.logId = logId;
        this.orderTime = orderTime;
        this.payTime = payTime;
        this.repairTime = repairTime;
        this.sendTime = sendTime;
        this.gotTime = gotTime;
        this.orderId = orderId;
        this.managerId = managerId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getGotTime() {
        return gotTime;
    }

    public void setGotTime(Date gotTime) {
        this.gotTime = gotTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", repairTime=" + repairTime +
                ", sendTime=" + sendTime +
                ", gotTime=" + gotTime +
                ", orderId=" + orderId +
                ", managerId=" + managerId +
                '}';
    }
}
