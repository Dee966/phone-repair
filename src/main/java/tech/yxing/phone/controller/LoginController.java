package tech.yxing.phone.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.yxing.phone.config.UserContext;
import tech.yxing.phone.pojo.po.Manager;
import tech.yxing.phone.pojo.po.User;
import tech.yxing.phone.pojo.vo.LoginVo;
import tech.yxing.phone.pojo.vo.TokenId;
import tech.yxing.phone.result.CodeMsg;
import tech.yxing.phone.result.Result;
import tech.yxing.phone.service.UserService;
import tech.yxing.phone.utils.JWTUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;

    /**
     * @param loginVo
     * @return tech.yxing.phone.result.Result<java.lang.String>
     * @author Joe
     * @date 2020/1/14 22:42
     */
    @PostMapping("/user_login")
    public Result<TokenId> login(@RequestBody LoginVo loginVo){
        User user = userService.getUserByUsername(loginVo.getUsername());
        if (user == null){
            return Result.error(CodeMsg.USER_NULL);
        }
        if (user.getPassword().equals(loginVo.getPassword())){
            String token = jwtUtil.sign(loginVo.getUsername());
            Integer userId = user.getUserId();
            return Result.success(new TokenId(userId,token));
        } else {
            throw new UnauthorizedException();
        }
    }

    @PostMapping("/auto_login")
    @RequiresAuthentication
    public Result<String> autoLogin(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            User user = UserContext.getUser();
            System.out.println(user.toString());
            return Result.success(jwtUtil.sign(user.getUsername()));
        } else {
            return Result.error(CodeMsg.NOT_LOGIN);
        }
    }

    /**
     * @param loginVo
     * @return tech.yxing.phone.result.Result<java.lang.Integer>
     * @author Joe
     * @date 2020/1/14 22:41
     */
    @PostMapping("/user_register")
    public Result<Integer> register(@RequestBody LoginVo loginVo){
        return Result.success(userService.register(loginVo));
    }

    /**
     * @param loginVo
     * @return tech.yxing.phone.result.Result<java.lang.Integer>
     * @author Joe
     * @date 2020/1/14 22:45
     */
    @PostMapping("/manager_login")
    public Result<TokenId> maLogin(@RequestBody LoginVo loginVo){
        Manager manager = userService.getManagerByUsername(loginVo.getUsername());
        if (manager == null){
            return Result.error(CodeMsg.USER_NULL);
        }
        if (manager.getPassword().equals(loginVo.getPassword())){
            String token = jwtUtil.sign(loginVo.getUsername());
            Integer managerId = manager.getManagerId();
            return Result.success(new TokenId(managerId,token));
        } else {
            throw new UnauthorizedException();
        }
    }

}
