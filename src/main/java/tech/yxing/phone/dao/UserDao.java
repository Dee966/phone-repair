package tech.yxing.phone.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.yxing.phone.pojo.po.Address;
import tech.yxing.phone.pojo.po.Manager;
import tech.yxing.phone.pojo.po.User;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    @Insert("insert into address values(null,#{address},#{userId})")
    void addAddress(@Param("userId") int userId,@Param("address") String address);

    @Delete("delete from address where address_id=#{addressId}")
    void deleteAddress(int addressId);

    @Select("select * from address where user_id=#{userId}")
    List<Address> listAddress(int userId);

    @Update("update address set address=#{address} where address_id=#{addressId}")
    void updateAddress(@Param("addressId") int addressId,@Param("address") String address);

    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    @Insert("insert into user values(null,#{username},#{password},null,null,null,2000)")
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "user_id")
    Integer register(User user);

    @Select("select * from manager where username=#{username}")
    Manager getManagerByUsername(String username);

    @Update("update user set name=#{name},telephone=#{telephone},wechat=#{wechat} where user_id=#{userId}")
    void updateInfo(User user);

    @Select("select * from user where user_id=#{userId}")
    User getUser(int userId);

    @Select("select balance from user where user_id=#{userId}")
    Double getBalance(int userId);
}
