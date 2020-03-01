package tech.yxing.phone.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tech.yxing.phone.pojo.dto.PhoneInfoDto;
import tech.yxing.phone.pojo.po.Color;
import tech.yxing.phone.pojo.po.Hitch;
import tech.yxing.phone.pojo.po.Phone;
import tech.yxing.phone.pojo.po.Type;

import java.util.List;

@Mapper
@Repository
public interface PhoneDao {
    @Select("SELECT * FROM phone WHERE model LIKE CONCAT(CONCAT('%',#{keyWord},'%')) LIMIT 1")
    @Results({
            @Result(property = "phoneId", column = "phone_id"),
            @Result(property = "colors", column = "phone_id", many = @Many(select = "tech.yxing.phone.dao.PhoneDao.listColor")),
            @Result(property = "hitches", column = "phone_id", many = @Many(select = "tech.yxing.phone.dao.PhoneDao.listHitch"))
    })
    PhoneInfoDto search(String keyword);

    @Select("select * from color where phone_id=#{phoneId}")
    List<Color> listColor(int phoneId);

    @Select("select * from hitch where phone_id=#{phoneId}")
    List<Hitch> listHitch(int phoneId);

    @Select("select * from type")
    List<Type> listType();

    @Insert("insert into type values(null,#{type})")
    void addType(String type);

    @Delete("delete from type where type_id=#{typeId}")
    void deleteType(int typeId);

    @Select("select * from phone where type_id=#{typeId}")
    List<Phone> getPhoneByTypeId(int typeId);

    @Select("select * from phone where phone_id=#{phoneId}")
    @Results({
            @Result(property = "phoneId", column = "phone_id"),
            @Result(property = "colors",
                    column = "phone_id", many = @Many(select = "tech.yxing.phone.dao.PhoneDao.listColor")),
            @Result(property = "hitches", column = "phone_id", many = @Many(select = "tech.yxing.phone.dao.PhoneDao.listHitch"))
    })
    PhoneInfoDto getPhoneByPhoneId(int phoneId);

    @Insert("insert into phone values(null,#{model},#{img},#{typeId})")
    @Options(useGeneratedKeys = true,keyProperty = "phoneId",keyColumn = "phone_id")
    Integer addPhone(Phone phone);

    @Insert("insert into color values(null,#{color},#{phoneId})")
    void addColor(@Param("color") String color,@Param("phoneId")Integer phoneId);

    @Insert("insert into hitch value(null,#{hitch},#{price},#{phoneId})")
    void addHitch(@Param("hitch") String hitch,@Param("price") Double price,@Param("phoneId") Integer phoneId);

    @Delete("delete from phone where phone_id=#{phoneId}")
    void deletePhone(int phoneId);

    @Delete("delete from color where phone_id=#{phoneId}")
    void deleteColor(int phoneId);

    @Delete("delete from hitch where phone_id=#{phoneId}")
    void deleteHitch(int phoneId);

    @Insert("INSERT INTO condition_price VALUES(null,#{price},#{phoneId},#{conditionId})")
    void addConditionPrice(@Param("price") Double price, @Param("phoneId") Integer phoneId, @Param("conditionId") Integer conditionId);
}
