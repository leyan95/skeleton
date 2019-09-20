package org.hunter.demo;

import org.hunter.demo.service.OrderPlusService;
import org.hunter.demo.service.RelevantBillService;
import org.hunter.skeleton.mediator.AbstractMediator;
import org.hunter.skeleton.mediator.Mediator;
import org.springframework.stereotype.Component;

import static org.hunter.demo.constant.DemoMediatorConstant.MEDIATOR_FIND_ORDER_BY_UUID;
import static org.hunter.demo.constant.DemoMediatorConstant.MEDIATOR_UPDATE_RELEVANT_STATUS;

/**
 * @author wujianchuan
 * 负责不同模块间的交互（中介）
 * 通常将同一个流程中涉及到的模块的交互方法注入到中介中
 */
@Component
public class DemoMediator extends AbstractMediator implements Mediator {

    @Override
    protected void init() {
        /*
        更新关联单据状态.
         */
        super.installBusiness(MEDIATOR_UPDATE_RELEVANT_STATUS, RelevantBillService.class, (RelevantBillService service, Object... args) -> {
            service.updateStatus((String) args[0], (boolean) args[1]);
            return null;
        });
        /*
        根据数据标识查询订单.
         */
        super.installBusiness(MEDIATOR_FIND_ORDER_BY_UUID, OrderPlusService.class, (OrderPlusService service, Object... args) -> {
            return service.findOne((String) args[0]);
        });
        // Install other business functions witch you need in the future.
    }

    @Override
    public Object call(String businessName, Object... args) throws Exception {
        return super.apply(businessName, args);
    }
}
