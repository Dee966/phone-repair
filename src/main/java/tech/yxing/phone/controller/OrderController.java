package tech.yxing.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.yxing.phone.pojo.po.Order;
import tech.yxing.phone.pojo.vo.OrderVo;
import tech.yxing.phone.pojo.vo.PayVo;
import tech.yxing.phone.pojo.vo.StateVo;
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
    public Result<Object> addOrder(@RequestBody OrderVo orderVo){
        orderService.addOrder(orderVo);
        return Result.success(null);
    }

    /**
     * @param payVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 根据userId去扣该用户的钱
     * @author Joe
     * @date 2020/1/15 9:42
     */
    @PutMapping("/pay")
    public Result<Object> pay(@RequestBody PayVo payVo){
        orderService.pay(payVo);
        return Result.success(null);
    }

    /**
     * @param userId
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.po.Order>>
     * @desc
     * @author Joe
     * @date 2020/1/15 9:45
     */
    @GetMapping("/{userId}")
    public Result<List<Order>> listOrder(@PathVariable int userId){
        return Result.success(orderService.listOrder(userId));
    }

    /**
     * @param userId
	 * @param state
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.po.Order>>
     * @desc 根据状态码和userId查询某状态的订单
     * @author Joe
     * @date 2020/1/15 9:47
     */
    @GetMapping("/state")
    public Result<List<Order>> listStateOrder(int userId,int state){
        return Result.success(orderService.listStateOrder(userId,state));
    }

    /**
     * @param stateVo
     * @return tech.yxing.phone.result.Result<java.lang.Object>
     * @desc 跟状态码修改不同的订单状态
     * @author Joe
     * @date 2020/1/15 9:50
     */
    @PutMapping("/state")
    public Result<Object> updateOrderState(@RequestBody StateVo stateVo){
        orderService.updateOrderState(stateVo);
        return Result.success(null);
    }

    /**
     * @param
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.po.Order>>
     * @desc 管理员查询所有订单
     * @author Joe
     * @date 2020/1/15 9:52
     */
    @GetMapping("/all")
    public Result<List<Order>> listAllOrder(){
        orderService.listAllOrder();
        return Result.success(null);
    }
}
