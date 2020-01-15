package tech.yxing.phone.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.yxing.phone.pojo.po.Order;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface OrderDao {
    @Insert("insert into `order` values(null,#{name},#{telephone},#{address},#{model},#{color},#{hitch},#{remarks},#{total},0,#{userId},#{phoneId})")
    @Options(useGeneratedKeys = true,keyProperty = "orderId",keyColumn = "order_id")
    Integer addOrder(Order order);

    @Insert("insert into log values(null,#{orderTime},null,null,null,null,#{orderId},null)")
    void markOrderTime(Date orderTime,int orderId);

    @Update("update user set balance=balance-#{total} where user_id=#{userId}")
    void pay(@Param("total") Double total,@Param("userId") int userId);

    @Update("update log set pay_time=#{payTime} where order_id=#{orderId}")
    void markPayTime(Date payTime,int orderId);

    @Update("update `order` set state=1 where order_id=#{orderId}")
    void changePayState(int orderId);

    @Select("select * from `order` where user_id=#{userId}")
    List<Order> listOrder(int userId);

    @Select("select * from `order` where user_id=#{userId} and state=#{state}")
    List<Order> listStateOrder(int userId,int state);

    @Update("update `order` set state=2 where order_id=#{orderId}")
    void changeRepair(int orderId);
    @Update("update log set repair_time=#{repairTime} where order_id=#{orderId}")
    void addRepairTime(Date repairTime,int orderId);

    @Update("update `order` set state=3 where order_id=#{orderId}")
    void changeSend(int orderId);
    @Update("update log set send_time=#{sendTime} where order_id=#{orderId}")
    void addSendTime(Date sendTime,int orderId);

    @Update("update `order` set state=4 where order_id=#{orderId}")
    void changeGot(int orderId);
    @Update("update log set got_time=#{gotTime} where order_id=#{orderId}")
    void addGotTime(Date gotTime,int orderId);

    @Select("select * from `order`")
    List<Order> listAllOrder();
}
