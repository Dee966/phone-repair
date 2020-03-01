package tech.yxing.phone.controller;

import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.yxing.phone.pojo.dto.OrderAndImgDto;
import tech.yxing.phone.pojo.po.Order;
import tech.yxing.phone.pojo.vo.OrderVo;
import tech.yxing.phone.pojo.vo.PayVo;
import tech.yxing.phone.pojo.vo.StateVo;
import tech.yxing.phone.result.CodeMsg;
import tech.yxing.phone.result.Result;
import tech.yxing.phone.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * @param orderVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 添加订单
     * @author Joe
     * @date 2020/1/15 9:40
     */
    @PostMapping("/insert")
    @RequiresAuthentication//确保登录才能操作
    public Result<Order> addOrder(@RequestBody OrderVo orderVo) {
//        orderService.addOrder(orderVo);
//        return Result.success(null);
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            Order order = orderService.addOrder(orderVo);
            System.out.println(order.toString());
            return Result.success(order);
        } else {
            return Result.error(CodeMsg.NOT_LOGIN);
        }
    }

    /**
     * @param payVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 根据userId去扣该用户的钱
     * @author Joe
     * @date 2020/1/15 9:42
     */
    @PutMapping("/pay")
    public Result<Object> pay(@RequestBody PayVo payVo) {
        orderService.pay(payVo);
        return Result.success(null);
    }

    /**
     * @param userId
     * @return tech.yxing.phone.result.Result<java.util.List < tech.yxing.phone.pojo.po.Order>>
     * @desc
     * @author Joe
     * @date 2020/1/15 9:45
     */
    @GetMapping("/{userId}")
    @RequiresAuthentication//确保登录才能操作
    public Result<List<OrderAndImgDto>> listOrder(@PathVariable int userId) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return Result.success(orderService.listOrder(userId));
        } else {
            return Result.error(CodeMsg.NOT_LOGIN);
        }

    }

    /**
     * @param userId
     * @param state
     * @return tech.yxing.phone.result.Result<java.util.List < tech.yxing.phone.pojo.po.Order>>
     * @desc 根据状态码和userId查询某状态的订单
     * @author Joe
     * @date 2020/1/15 9:47
     */
    @GetMapping("/state")
    public Result<List<OrderAndImgDto>> listStateOrder(int userId, int state) {
        return Result.success(orderService.listStateOrder(userId, state));
    }

    /**
     * @param stateVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 跟状态码修改不同的订单状态
     * @author Joe
     * @date 2020/1/15 9:50
     */
    @PutMapping("/state")
    public Result<Object> updateOrderState(@RequestBody StateVo stateVo) {
        orderService.updateOrderState(stateVo);
        return Result.success(null);
    }

    /**
     * @param
     * @return tech.yxing.phone.result.Result<java.util.List < tech.yxing.phone.pojo.po.Order>>
     * @desc 管理员查询所有订单
     * @author Joe
     * @date 2020/1/15 9:52
     */
    @GetMapping("/all")
    public Result<PageInfo<OrderAndImgDto>> listAllOrder(String num) {
        Integer page = Integer.valueOf(num);
        return Result.success(orderService.listAllOrder(page));
    }
}
