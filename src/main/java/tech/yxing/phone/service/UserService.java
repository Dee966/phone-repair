package tech.yxing.phone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.yxing.phone.dao.UserDao;
import tech.yxing.phone.exception.GlobleException;
import tech.yxing.phone.pojo.dto.UserDto;
import tech.yxing.phone.pojo.po.Address;
import tech.yxing.phone.pojo.po.Manager;
import tech.yxing.phone.pojo.po.User;
import tech.yxing.phone.pojo.vo.LoginVo;
import tech.yxing.phone.pojo.vo.UserVo;
import tech.yxing.phone.result.CodeMsg;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @param username
     * @return tech.yxing.phone.pojo.po.User
     * @desc 通过用户名查询用户
     * @author Joe
     * @date 2020/1/15 10:25
     */
    public User getUserByUsername(String username){
        return userDao.getUserByUsername(username);
    }

    /**
     * @param loginVo
     * @return java.lang.Integer
     * @desc 注册
     * @author Joe
     * @date 2020/1/15 10:28
     */
    public Integer register(LoginVo loginVo){
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        //判断用户名是否已存在
        if (userDao.getUserByUsername(loginVo.getUsername()) != null){
            throw new GlobleException(CodeMsg.USER_EXIST);
        }
        User user = new User(new LoginVo(username,password));
        userDao.register(user);
        return user.getUserId();
    }

    /**
     * @param username
     * @return tech.yxing.phone.pojo.po.Manager
     * @desc 通过用户名查询管理员
     * @author Joe
     * @date 2020/1/15 10:48
     */
    public Manager getManagerByUsername(String username){
        return userDao.getManagerByUsername(username);
    }

    /**
     * @param userId
	 * @param userVo
     * @return void
     * @desc 更新用户信息
     * @author Joe
     * @date 2020/1/15 11:03
     */
    public void updateInfo(int userId, UserVo userVo){
        userDao.updateInfo(new User(userId,userVo));
    }

    /**
     * @param userId
     * @return tech.yxing.phone.pojo.dto.UserDto
     * @desc 根据userId获取User
     * @author Joe
     * @date 2020/1/15 11:14
     */
    public UserDto getUser(int userId){
        User user = userDao.getUser(userId);
        return new UserDto(user.getName(),user.getTelephone(),user.getWechat(),user.getBalance());
    }

    /**
     * @param userId
     * @return java.lang.String
     * @desc 余额查询
     * @author Joe
     * @date 2020/1/15 11:32
     */
    public String getBalance(int userId){
        Double balance = userDao.getBalance(userId);
        if (balance == null){
            balance = 0.0;
        }
        return String.valueOf(balance);
    }

    public void addAddress(int userId,String address){
        userDao.addAddress(userId,address);
    }

    public void deleteAddress(int addressId){
        userDao.deleteAddress(addressId);
    }

    public List<Address> listAddress(int userId){
        List<Address> addresses = userDao.listAddress(userId);
        if (addresses.isEmpty()){
            throw new GlobleException(CodeMsg.ADDRESS_NULL);
        }
        return addresses;
    }

    public void updateAddress(int addressId,String address){
        userDao.updateAddress(addressId,address);
    }
}
