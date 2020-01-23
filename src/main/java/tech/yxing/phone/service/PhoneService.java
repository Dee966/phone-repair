package tech.yxing.phone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.yxing.phone.dao.PhoneDao;
import tech.yxing.phone.exception.GlobleException;
import tech.yxing.phone.pojo.dto.PhoneInfoDto;
import tech.yxing.phone.pojo.po.Color;
import tech.yxing.phone.pojo.po.Hitch;
import tech.yxing.phone.pojo.po.Phone;
import tech.yxing.phone.pojo.po.Type;
import tech.yxing.phone.pojo.vo.PhoneInfoVo;
import tech.yxing.phone.pojo.vo.TypeVo;
import tech.yxing.phone.result.CodeMsg;
import tech.yxing.phone.utils.MyUpload;

import java.io.IOException;
import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneDao phoneDao;

    /**
     * @param keyword
     * @return tech.yxing.phone.pojo.dto.PhoneInfoDto
     * @desc
     * @author Joe
     * @date 2020/1/15 15:31
     */
    public PhoneInfoDto search(String keyword){
        PhoneInfoDto phoneInfoDto = phoneDao.search(keyword);
        if (phoneInfoDto == null){
            throw new GlobleException(CodeMsg.SEARCH_NULL);
        }
        return phoneInfoDto;
    }

    /**
     * @param
     * @return java.util.List<tech.yxing.phone.pojo.po.Type>
     * @desc 获取所有手机品牌分类
     * @author Joe
     * @date 2020/1/15 15:36
     */
    public List<Type> listType(){
        return phoneDao.listType();
    }

    /**
     * @param typeVo
     * @return void
     * @desc 添加手机品牌分类
     * @author Joe
     * @date 2020/1/15 15:44
     */
    public void addType(TypeVo typeVo){
        phoneDao.addType(typeVo.getType());
    }

    /**
     * @param typeId
     * @return void
     * @desc 删除某手机品牌分类
     * @author Joe
     * @date 2020/1/15 15:47
     */
    public void deleteType(int typeId){
        phoneDao.deleteType(typeId);
    }

    /**
     * @param typeId
     * @return java.util.List<tech.yxing.phone.pojo.po.Phone>
     * @desc 获取某手机品牌下的全部手机信息
     * @author Joe
     * @date 2020/1/15 15:48
     */
    public List<Phone> getPhoneByTypeId(int typeId){
        return phoneDao.getPhoneByTypeId(typeId);
    }

    /**
     * @param phoneId
     * @return tech.yxing.phone.pojo.dto.PhoneInfoDto
     * @desc
     * @author Joe
     * @date 2020/1/15 16:08
     */
    public PhoneInfoDto getPhoneByPhoneId(int phoneId){
        PhoneInfoDto phoneInfoDto = phoneDao.getPhoneByPhoneId(phoneId);
        for (Hitch hitch : phoneInfoDto.getHitches()) {
            hitch.setHitch("{\"hitch\":\""+hitch.getHitch()+"\","+"\"price\":\""+hitch.getPrice()+"\"}");
        }
        for (Hitch hitch : phoneInfoDto.getHitches()) {
            System.out.println("see:"+hitch.getHitch());
        }
        return phoneInfoDto;
    }

    /**
     * @param picture
     * @return java.lang.String
     * @desc 把手机图片写入磁盘
     * @author Joe
     * @date 2020/1/15 16:12
     */
    public String uploadPhoneImg(MultipartFile picture) throws IOException {
        return MyUpload.pictureUpload(picture);
    }

    /**
     * @param phoneInfoVo
     * @return void
     * @desc 添加手机
     * @author Joe
     * @date 2020/1/15 16:19
     */
    public void addPhone(PhoneInfoVo phoneInfoVo){
        Phone phone = new Phone(null, phoneInfoVo.getModel(), phoneInfoVo.getImg(), phoneInfoVo.getTypeId());
        Integer num = phoneDao.addPhone(phone);
        for (Color color : phoneInfoVo.getColors()) {
            phoneDao.addColor(color.getColor(),phone.getPhoneId());
        }
        for (Hitch hitch : phoneInfoVo.getHitches()) {
            phoneDao.addHitch(hitch.getHitch(),hitch.getPrice(),phone.getPhoneId());
        }
    }

    /**
     * @param phoneId
     * @return void
     * @desc 删除手机及其信息
     * @author Joe
     * @date 2020/1/15 17:07
     */
    public void deletePhone(int phoneId){
        phoneDao.deleteColor(phoneId);
        phoneDao.deleteHitch(phoneId);
        phoneDao.deletePhone(phoneId);
    }
}
