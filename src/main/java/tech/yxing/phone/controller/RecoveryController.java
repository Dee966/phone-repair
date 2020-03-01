package tech.yxing.phone.controller;

import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.yxing.phone.pojo.dto.ConditionDto;
import tech.yxing.phone.pojo.dto.MaReOrderDto;
import tech.yxing.phone.pojo.dto.RODto;
import tech.yxing.phone.pojo.po.RecoveryOrder;
import tech.yxing.phone.pojo.vo.*;
import tech.yxing.phone.result.CodeMsg;
import tech.yxing.phone.result.Result;
import tech.yxing.phone.service.RecoveryService;

import java.util.List;

@RestController
@RequestMapping("/recovery")
public class RecoveryController {
    @Autowired
    private RecoveryService recoveryService;

    /**
     * @param phoneId
     * @return List<ConditionDto>
     * @desc 用phoneId查机况信息
     * @author Joe
     * @date 2020/2/24 15:02
     */
    @GetMapping("/listCondition/{phoneId}")
    public Result<List<ConditionDto>> getConditionByPhoneId(@PathVariable Integer phoneId){
        return Result.success(recoveryService.getConditionByPhoneId(phoneId));
    }

    /**
     * @param estimateVo
     * @return Double
     * @desc 估价
     * @author Joe
     * @date 2020/2/24 16:00
     */
    @PostMapping("/estimate")
    @RequiresAuthentication//确保登录才能操作
    public Result<Double> estimate(@RequestBody EstimateVo estimateVo){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return Result.success(recoveryService.estimate(estimateVo));
        } else {
            return Result.error(CodeMsg.NOT_LOGIN);
        }

    }

    /**
     * @param recoveryOrder
     * @return null
     * @desc 回收-下单
     * @author Joe
     * @date 2020/2/24 16:01
     */
    @PostMapping("/recoveryOrder")
    public Result<RecoveryOrder> recoveryOrder(@RequestBody RecoveryOrder recoveryOrder){
        return Result.success(recoveryService.recoveryOrder(recoveryOrder));
    }
    
    /**
     * @param userId 
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.dto.RODto>>
     * @desc 查询所有订单
     * @author Joe
     * @date 2020/2/24 17:05
     */
    @GetMapping("/listOrder/{userId}")
    public Result<List<RODto>> listOrderByUserId(@PathVariable Integer userId){
        return Result.success(recoveryService.listOrderByUserId(userId));
    }

    /**
     * @param userId,state
     * @return tech.yxing.phone.result.Result<java.util.List<tech.yxing.phone.pojo.dto.RODto>>
     * @desc 查询某状态订单
     * @author Joe
     * @date 2020/2/24 17:20
     */
    @GetMapping("/listStateOrder")
    public Result<List<RODto>> listOrderByState(Integer userId,Integer state){
        return Result.success(recoveryService.listOrderByState(userId,state));
    }

    /**
     * @param stateVo
     * @return null
     * @desc 根据状态码和订单id修改订单状态
     * @author Joe
     * @date 2020/2/24 17:24
     */
    @PutMapping("/updateState")
    public Result<Object> updateState(@RequestBody StateVo stateVo){
        recoveryService.updateState(stateVo);
        return Result.success(null);
    }

    @GetMapping("/listAllMaOrder")
    public Result<PageInfo<MaReOrderDto>> listAllOrder(String num){
        Integer page = Integer.valueOf(num);
        return Result.success(recoveryService.listAllOrder(page));
    }

    @PostMapping("/transfer")
    public Result<Object> transfer(@RequestBody TransferVo transferVo){
        recoveryService.transfer(transferVo);
        return Result.success(null);
    }
}
