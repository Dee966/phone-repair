package tech.yxing.phone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.yxing.phone.dao.BannerDao;
import tech.yxing.phone.exception.GlobleException;
import tech.yxing.phone.pojo.po.Banner;
import tech.yxing.phone.pojo.vo.BannerVo;
import tech.yxing.phone.result.CodeMsg;
import tech.yxing.phone.utils.MyUpload;

import java.io.IOException;
import java.util.List;

@Service
public class BannerService {
    @Autowired
    private BannerDao bannerDao;

    /**
     * @param
     * @return java.util.List<tech.yxing.phone.pojo.po.Banner>
     * @desc 获取所有轮播图
     * @author Joe
     * @date 2020/1/15 11:42
     */
    public List<Banner> listBanner(){
        List<Banner> banners = bannerDao.listBanner();
        if (banners.isEmpty()){
            throw new GlobleException(CodeMsg.BANNER_NULL);
        }
        return banners;
    }

    /**
     * @param bannerId
     * @return void
     * @desc 删除轮播图
     * @author Joe
     * @date 2020/1/15 14:15
     */
    public void deleteBanner(int bannerId){
        bannerDao.deleteBanner(bannerId);
    }

    /**
     * @param picture
     * @return java.lang.String
     * @desc 轮播图写入磁盘
     * @author Joe
     * @date 2020/1/15 14:17
     */
    public String uploadBanner(MultipartFile picture) throws IOException {
        return MyUpload.pictureUpload(picture);
    }

    public void addBanner(BannerVo bannerVo){
        bannerDao.addBanner(new Banner(bannerVo));
    }
}
