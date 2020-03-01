package tech.yxing.phone.pojo.po;

public class Condition {
    private Integer conditionId;
    private String condition;

    public Condition() {
    }

    public Condition(Integer conditionId, String condition) {
        this.conditionId = conditionId;
        this.condition = condition;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "conditionId=" + conditionId +
                ", condition='" + condition + '\'' +
                '}';
    }
}
