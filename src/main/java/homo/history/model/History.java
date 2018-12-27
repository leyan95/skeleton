package homo.history.model;

import homo.common.model.Entity;

import java.util.Date;

/**
 * @author wujianchuan 2018/12/27
 */
public class History extends Entity {
    private static final long serialVersionUID = -4471597190430423414L;

    private String uuid;
    private String content;
    private String operator;
    private Date operateTime;

    private History(String content, String operator, Date operateTime) {
        this.content = content;
        this.operator = operator;
        this.operateTime = operateTime;
    }

    public static History newInstance(String content, String operator, Date operateTime) {
        return new History(content, operator, operateTime);
    }


    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String getDescribe() {
        return "内容：" + this.getContent() + "\t操作人：" + this.getOperator() + "\t操作时间：" + this.getOperateTime();
    }
}
