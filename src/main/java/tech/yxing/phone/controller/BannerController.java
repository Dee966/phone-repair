package tech.yxing.phone.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.yxing.phone.pojo.po.Banner;
import tech.yxing.phone.pojo.vo.BannerVo;
import tech.yxing.phone.result.Result;
import tech.yxing.phone.service.BannerService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * @param
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.po.Banner>>
     * @desc 获取所有轮播图
     * @author Joe
     * @date 2020/1/14 23:38
     */
    @GetMapping("/list")
    public Result<List<Banner>> listBanner(){
        return Result.success(bannerService.listBanner());
    }

    /**
     * @param picture
     * @return tech.yxing.phone.result.Result<java.lang.String>
     * @desc 轮播图写入磁盘
     * @author Joe
     * @date 2020/1/14 23:43
     */
    @PostMapping("/upload")
    public Result<String> uploadBanner(@RequestParam("img") MultipartFile picture) throws IOException {
        return Result.success(bannerService.uploadBanner(picture));
    }

    /**
     * @param bannerVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 新添加的轮播图信息写入数据库
     * @author Joe
     * @date 2020/1/14 23:48
     */
    @PostMapping("/info")
    public Result<Object> addBanner(@RequestBody BannerVo bannerVo){
        bannerService.addBanner(bannerVo);
        return Result.success(null);
    }

    /**
     * @param bannerId
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 删除轮播图
     * @author Joe
     * @date 2020/1/14 23:49
     */
    @DeleteMapping("delete/{bannerId}")
    public Result<Object> deleteBanner(@PathVariable int bannerId){
        bannerService.deleteBanner(bannerId);
        return Result.success(null);
    }
}
