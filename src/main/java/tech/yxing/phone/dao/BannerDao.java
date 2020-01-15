package tech.yxing.phone.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.yxing.phone.pojo.po.Banner;

import java.util.List;

@Mapper
@Repository
public interface BannerDao {
    @Select("select * from banner")
    List<Banner> listBanner();

    @Delete("delete from banner where banner_id=#{bannerId}")
    void deleteBanner(int bannerId);

    @Insert("insert into banner values(null,#{img},#{link},#{managerId})")
    void addBanner(Banner banner);
}
