package tech.yxing.phone.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.yxing.phone.dao.RecoveryDao;
import tech.yxing.phone.exception.GlobleException;
import tech.yxing.phone.pojo.dto.ConditionDto;
import tech.yxing.phone.pojo.dto.MaReOrderDto;
import tech.yxing.phone.pojo.dto.RODto;
import tech.yxing.phone.pojo.po.RecoveryOrder;
import tech.yxing.phone.pojo.vo.*;
import tech.yxing.phone.result.CodeMsg;

import java.util.List;

@Service
public class RecoveryService {

    private static final Integer PAGE_SIZE = 5;

    @Autowired
    private RecoveryDao recoveryDao;

    /**
     * @param phoneId
     * @return List<ConditionDto>
     * @desc 用phoneId查机况信息
     * @author Joe
     * @date 2020/2/24 14:56
     */
    public List<ConditionDto> getConditionByPhoneId(Integer phoneId){
        return recoveryDao.getConditionByPhoneId(phoneId);
    }

    /**
     * @param estimateVo
     * @return java.lang.Double
     * @desc
     * @author Joe
     * @date 2020/2/24 16:03
     */
    public Double estimate(EstimateVo estimateVo){
        Double recoveryPrice = recoveryDao.getRecoveryPrice(estimateVo.getPhoneId());
        for (Double price : estimateVo.getPrices()) {
            recoveryPrice = recoveryPrice - price;
        }
        return recoveryPrice;
    }

    public RecoveryOrder recoveryOrder(RecoveryOrder recoveryOrder){
        recoveryOrder.setRecoverOrderId(null);
        Integer num = recoveryDao.recoveryOrder(recoveryOrder);

        return recoveryOrder;
    }

    public List<RODto> listOrderByUserId(Integer userId){
        List<RODto> roDtos = recoveryDao.listOrderByUserId(userId);
        if (roDtos.isEmpty()){
            throw new GlobleException(CodeMsg.ORDER_NULL);
        }
        return roDtos;
    }

    public List<RODto> listOrderByState(Integer userId, Integer state){
        List<RODto> roDtos = recoveryDao.listOrderByState(userId, state);
        if (roDtos.isEmpty()){
            throw new GlobleException(CodeMsg.STATE_ORDER_NULL);
        }
        return roDtos;
    }

    public void updateState(StateVo stateVo){
        int state = 0;
        if (stateVo.getState() == 0){
            state = 1;
        } else if (stateVo.getState() == 1){
            state = 2;
        } else if (stateVo.getState() == 2){
            state = 3;
        }
        recoveryDao.updateState(stateVo.getOrderId(),state);
    }

    public PageInfo<MaReOrderDto> listAllOrder(Integer page){
        // 1.设置分页
        PageHelper.startPage(page, PAGE_SIZE);
        // 2.执行查询
        List<MaReOrderDto> maReOrderDtos = recoveryDao.listAllOrder();
        // 3.获取详细分页信息
        PageInfo<MaReOrderDto> pageInfo = new PageInfo<>(maReOrderDtos);
        return pageInfo;
    }

    public void transfer(TransferVo transferVo){
        StateVo stateVo = new StateVo(transferVo.getOrderId(),transferVo.getState());
        this.updateState(stateVo);
        recoveryDao.transfer(transferVo.getMoney(),transferVo.getUserId());

    }

}
