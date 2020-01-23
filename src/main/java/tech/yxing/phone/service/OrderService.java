package tech.yxing.phone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.yxing.phone.dao.OrderDao;
import tech.yxing.phone.exception.GlobleException;
import tech.yxing.phone.pojo.dto.OrderAndImgDto;
import tech.yxing.phone.pojo.po.Order;
import tech.yxing.phone.pojo.po.User;
import tech.yxing.phone.pojo.vo.OrderVo;
import tech.yxing.phone.pojo.vo.PayVo;
import tech.yxing.phone.pojo.vo.StateVo;
import tech.yxing.phone.result.CodeMsg;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    /**
     * @param orderVo
     * @return void
     * @desc 添加订单
     * @author Joe
     * @date 2020/1/15 17:33
     */
    public Order addOrder(OrderVo orderVo){
        Order order = new Order(orderVo);
        Integer num = orderDao.addOrder(order);
        orderDao.markOrderTime(new Date(),order.getOrderId());
        return order;

    }

    /**
     * @param payVo
     * @return void
     * @desc 支付
     * @author Joe
     * @date 2020/1/15 17:42
     */
    public void pay(PayVo payVo){
        orderDao.pay(payVo.getTotal(),payVo.getUserId());
        orderDao.markPayTime(new Date(),payVo.getOrderId());
        orderDao.changePayState(payVo.getOrderId());
    }

    /**
     * @param userId
     * @return java.util.List<tech.yxing.phone.pojo.po.Order>
     * @desc 查询用户所有订单
     * @author Joe
     * @date 2020/1/15 20:09
     */
    public List<OrderAndImgDto> listOrder(int userId){
        List<OrderAndImgDto> orders = orderDao.listOrder(userId);
        if (orders.isEmpty()){
            throw new GlobleException(CodeMsg.ORDER_NULL);
        }
        return orders;
    }

    /**
     * @param userId
	 * @param state
     * @return java.util.List<tech.yxing.phone.pojo.po.Order>
     * @desc 根据userId和state查询符合的订单
     * @author Joe
     * @date 2020/1/15 20:52
     */
    public List<OrderAndImgDto> listStateOrder(int userId,int state){
        List<OrderAndImgDto> orders = orderDao.listStateOrder(userId, state);
        if (orders.isEmpty()){
            throw new GlobleException(CodeMsg.STATE_ORDER_NULL);
        }
        return orders;
    }

    /**
     * @param stateVo
     * @return void
     * @desc 根据状态码修改订单状态
     * @author Joe
     * @date 2020/1/15 21:07
     */
    public void updateOrderState(StateVo stateVo){
        if (stateVo.getState() == 1){//如果状态码是1，说明此操作要把状态改为2：维修中 商家已收取要维修的手机进行维修
            orderDao.changeRepair(stateVo.getOrderId());
            orderDao.addRepairTime(new Date(),stateVo.getOrderId());
        } else if (stateVo.getState() == 2){//如果状态码是2，说明此操作要把状态改为3：待收货 上架已维修完成，将手机寄出
            orderDao.changeSend(stateVo.getOrderId());
            orderDao.addSendTime(new Date(),stateVo.getOrderId());
        } else if (stateVo.getState() == 3){//如果状态码是3，说明此操作要把状态改为4：已收货 用户已收货
            orderDao.changeGot(stateVo.getOrderId());
            orderDao.addGotTime(new Date(),stateVo.getOrderId());
        } else {
            throw new GlobleException(CodeMsg.SERVER_ERROR);
        }
    }

    public List<OrderAndImgDto> listAllOrder(){
        return orderDao.listAllOrder();
    }

}
