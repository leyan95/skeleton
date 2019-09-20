package org.hunter.demo.service.impl;

import org.hunter.demo.model.RelevantBill;
import org.hunter.demo.repository.RelevantBillRepository;
import org.hunter.demo.service.RelevantBillService;
import org.hunter.skeleton.annotation.Service;
import org.hunter.skeleton.controller.FilterView;
import org.hunter.skeleton.service.AbstractService;
import org.hunter.skeleton.service.PageList;

import java.sql.SQLException;

import static org.hunter.demo.constant.DemoEvenConstant.EVEN_ORDER_SAVE;
import static org.hunter.demo.constant.DemoEvenConstant.EVEN_ORDER_UPDATE;

/**
 * @author wujianchuan
 * 监听类同服务类组合使用是  前提：{RelevantBillService extends Service, Monitor}
 */
@Service(session = "demo")
public class RelevantBillServiceImpl extends AbstractService implements RelevantBillService {
    private final
    RelevantBillRepository relevantBillRepository;

    public RelevantBillServiceImpl(RelevantBillRepository relevantBillRepository) {
        this.relevantBillRepository = relevantBillRepository;
    }

    @Override
    public int save(RelevantBill relevantBill) throws SQLException, IllegalAccessException {
        return this.relevantBillRepository.saveWithTrack(relevantBill, true, "ADMIN", "保存关联单据");
    }

    @Override
    public int update(RelevantBill relevantBill) throws SQLException, IllegalAccessException {
        return this.relevantBillRepository.updateWithTrack(relevantBill, true, "ADMIN", "更新关联单据");
    }

    @Override
    public RelevantBill findOne(String uuid) throws SQLException {
        return (RelevantBill) this.relevantBillRepository.findOne(uuid);
    }

    @Override
    public PageList loadPageList(FilterView filterView) throws SQLException {
        return this.relevantBillRepository.loadPage(filterView);
    }

    @Override
    public int updateStatus(String uuid, boolean newStatus) throws SQLException {
        return this.relevantBillRepository.updateStatus(uuid, newStatus);
    }

    @Override
    public String[] evenSourceIds() {
        return new String[]{EVEN_ORDER_SAVE, EVEN_ORDER_UPDATE};
    }

    @Override
    public void execute(Object... args) throws SQLException {
        System.out.println(String.format("I'm %s I see you. I see you. Come out guy, ha ha ha.", this.getClass().getName()));
        System.out.println(String.format("Give me %s biscuits", args[0]));
        RelevantBill relevantBill = this.findOne("10130");
        System.out.println(String.format("Relevant Bill Code Is: %s", relevantBill.getCode()));
    }
}
