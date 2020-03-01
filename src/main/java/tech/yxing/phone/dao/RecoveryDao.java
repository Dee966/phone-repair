package tech.yxing.phone.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.yxing.phone.pojo.dto.ConditionDto;
import tech.yxing.phone.pojo.dto.MaReOrderDto;
import tech.yxing.phone.pojo.dto.RODto;
import tech.yxing.phone.pojo.po.RecoveryOrder;

import java.util.List;

@Mapper
@Repository
public interface RecoveryDao {
    @Select("SELECT cp.*,c.condition FROM condition_price cp LEFT JOIN `condition` c ON cp.condition_id = c.condition_id WHERE cp.phone_id = #{phoneId};")
    List<ConditionDto> getConditionByPhoneId(Integer phoneId);

    @Select("SELECT rp.price FROM recovery_price rp WHERE rp.phone_id = #{phoneId}")
    Double getRecoveryPrice(Integer phoneId);

    @Insert("INSERT INTO recovery_order VALUES(null,#{model},#{edition},#{memory},#{screenAppearance},#{phoneAppearance},#{repair}," +
            "#{account},#{other},#{total},#{state},#{name},#{telephone},#{address},#{userId},#{phoneId})")
    @Options(useGeneratedKeys = true,keyProperty = "recoverOrderId",keyColumn = "recover_order_id")
    Integer recoveryOrder(RecoveryOrder recoveryOrder);

    @Select("SELECT ro.recovery_order_id,ro.model,ro.total,ro.state,p.img FROM recovery_order ro LEFT JOIN phone p ON ro.phone_id = p.phone_id WHERE ro.user_id = #{userId}")
    List<RODto> listOrderByUserId(Integer userId);

    @Select("SELECT ro.recovery_order_id,ro.model,ro.total,ro.state,p.img FROM recovery_order ro LEFT JOIN phone p ON ro.phone_id = p.phone_id WHERE ro.user_id = #{userId} AND state = #{state}")
    List<RODto> listOrderByState(@Param("userId") Integer userId,@Param("state") Integer state);

    @Update("UPDATE recovery_order ro SET ro.state = #{state} WHERE ro.recovery_order_id = #{recoveryOrderId}")
    void updateState (@Param("recoveryOrderId") Integer recoveryOrderId, @Param("state") Integer state);

    @Select("SELECT ro.*,p.img FROM recovery_order ro LEFT JOIN phone p ON ro.phone_id = p.phone_id")
    List<MaReOrderDto> listAllOrder();

    @Select("UPDATE user u SET u.balance = u.balance + #{balance} WHERE u.user_id = #{userId}")
    void transfer(@Param("balance") Double balance, @Param("userId") Integer userId);

}
