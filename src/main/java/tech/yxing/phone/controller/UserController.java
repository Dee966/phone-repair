package tech.yxing.phone.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.yxing.phone.pojo.po.Address;
import tech.yxing.phone.pojo.vo.AddressVo;
import tech.yxing.phone.pojo.dto.UserDto;
import tech.yxing.phone.pojo.vo.UserVo;
import tech.yxing.phone.result.CodeMsg;
import tech.yxing.phone.result.Result;
import tech.yxing.phone.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param userId
	 * @param userVo
     * @return tech.yxing.phone.result.Result<java.lang.Integer>
     * @author Joe
     * @date 2020/1/14 22:51
     */
    @PutMapping("/info/{userId}")
    public Result<Object> updateInfo(@PathVariable int userId,@RequestBody UserVo userVo){
        userService.updateInfo(userId,userVo);
        return Result.success(null);
    }

    /**
     * @param userId
     * @return tech.yxing.phone.result.Result<tech.yxing.phone.pojo.dto.UserDto>
     * @author Joe
     * @date 2020/1/14 22:53
     */
    @GetMapping("/info/{userId}")
    @RequiresAuthentication//确保登录才能操作
    public Result<UserDto> getUser(@PathVariable int userId){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            return Result.success(userService.getUser(userId));
        }else {
            return Result.error(CodeMsg.NOT_LOGIN);
        }
    }

    /**
     * @param userId
     * @return tech.yxing.phone.result.Result<java.lang.String>
     * @author Joe
     * @date 2020/1/14 22:55
     */
    @GetMapping("/balance/{userId}")
    public Result<String> getBalance(@PathVariable int userId){
        return Result.success(userService.getBalance(userId));
    }

    /**
     * @param userId
	 * @param addressVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 添加地址
     * @author Joe
     * @date 2020/1/14 23:00
     */
    @PostMapping("/address/{userId}")
    public Result<Object> addAddress(@PathVariable int userId,@RequestBody AddressVo addressVo){
        userService.addAddress(userId,addressVo.getAddress());
        return Result.success(null);
    }

    /**
     * @param addressId
	 * @param addressVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 根据addressId修改地址
     * @author Joe
     * @date 2020/1/14 23:01
     */
    @PutMapping("/address/{addressId}")
    public Result<Object> updateAddress(@PathVariable int addressId,@RequestBody AddressVo addressVo){
        userService.updateAddress(addressId,addressVo.getAddress());
        return Result.success(null);
    }

    /**
     * @param addressId
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 根据addressId删除该地址
     * @author Joe
     * @date 2020/1/14 23:06
     */
    @DeleteMapping("address/{addressId}")
    public Result<Object> deleteAddress(@PathVariable int addressId){
        userService.deleteAddress(addressId);
        return Result.success(null);
    }

    /**
     * @param userId
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.po.Address>>
     * @desc 根据userId获取该用户所有地址
     * @author Joe
     * @date 2020/1/14 23:03
     */
    @GetMapping("/address/{userId}")
    public Result<List<Address>> listAddress(@PathVariable int userId){
        return Result.success(userService.listAddress(userId));
    }
}
