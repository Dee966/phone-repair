package tech.yxing.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.yxing.phone.pojo.dto.PhoneInfoDto;
import tech.yxing.phone.pojo.po.Phone;
import tech.yxing.phone.pojo.po.Type;
import tech.yxing.phone.pojo.vo.PhoneInfoVo;
import tech.yxing.phone.pojo.vo.TypeVo;
import tech.yxing.phone.result.Result;
import tech.yxing.phone.service.PhoneService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    /**
     * @param keyword
     * @return tech.yxing.phone.result.Result<tech.yxing.phone.pojo.dto.PhoneInfoDto>
     * @desc
     * @author Joe
     * @date 2020/1/15 14:42
     */
    @GetMapping("/search/{keyword}")
    public Result<PhoneInfoDto> search(@PathVariable String keyword){
        return Result.success(phoneService.search(keyword));
    }

    /**
     * @param
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.po.Type>>
     * @desc 获取所有手机品牌分类
     * @author Joe
     * @date 2020/1/15 9:19
     */
    @GetMapping("/type")
    public Result<List<Type>> listType(){
        return Result.success(phoneService.listType());
    }

    /**
     * @param typeVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 添加手机品牌分类
     * @author Joe
     * @date 2020/1/15 9:21
     */
    @PostMapping("/type")
    public Result<Object> addType(@RequestBody TypeVo typeVo){
        phoneService.addType(typeVo);
        return Result.success(null);
    }

    /**
     * @param typeId
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 根据typeId删除某个手机品牌
     * @author Joe
     * @date 2020/1/15 9:23
     */
    @DeleteMapping("/type/{typeId}")
    public Result<Object> deleteType(@PathVariable int typeId){
        phoneService.deleteType(typeId);
        return Result.success(null);
    }

    /**
     * @param typeId
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.dto.PhoneInfoDto>>
     * @desc 根据typeId把该分类下的手机查询出来
     * @author Joe
     * @date 2020/1/15 9:26
     */
    @GetMapping("/get_type/{typeId}")
    public Result<List<Phone>> getPhoneByTypeId(@PathVariable int typeId){
        return Result.success(phoneService.getPhoneByTypeId(typeId));
    }

    /**
     * @param phoneId
     * @return tech.yxing.phone.result.Result<tech.yxing.phone.pojo.dto.PhoneInfoDto>
     * @desc 根据phoneId查询出手机的信息
     * @author Joe
     * @date 2020/1/15 9:28
     */
    @GetMapping("/phone/{phoneId}")
    public Result<PhoneInfoDto> getPhoneByPhoneId(@PathVariable int phoneId){
        return Result.success(phoneService.getPhoneByPhoneId(phoneId));
    }

    /**
     * @param picture
     * @return tech.yxing.phone.result.Result<java.lang.String>
     * @desc 上传手机图片，写入磁盘
     * @author Joe
     * @date 2020/1/15 9:32
     */
    @PostMapping("/phone_upload")
    public Result<String> uploadPhoneImg(@RequestParam("img") MultipartFile picture) throws IOException {
        return Result.success(phoneService.uploadPhoneImg(picture));
    }

    /**
     * @param phoneInfoVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 添加新手机信息
     * @author Joe
     * @date 2020/1/15 9:36
     */
    @PostMapping("/phone")
    public Result<Object> addPhone(@RequestBody PhoneInfoVo phoneInfoVo){
        phoneService.addPhone(phoneInfoVo);
        return null;
    }

    /**
     * @param phoneId
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 根据phoneId删除某个手机型号及其信息
     * @author Joe
     * @date 2020/1/15 9:37
     */
    @DeleteMapping("/phone/{phoneId}")
    public Result<Object> deletePhone(@PathVariable int phoneId){
        phoneService.deletePhone(phoneId);
        return Result.success(null);
    }
}
