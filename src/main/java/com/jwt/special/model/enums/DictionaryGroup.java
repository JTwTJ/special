package com.jwt.special.model.enums;

/**
 * @author jiangwentao
 * @date 2019/1/23 0023 上午 11:39
 */
public enum DictionaryGroup {

    companyName("companyName","公司名称"),
    transDepartMent("transDepartMent","流转部门"),
    warnMark("warnMark","预警标记"),
    reviewStatus("reviewStatus","审核状态"),
    companyDepartMent("companyDepartMent","部门"),
    currency("currency","货币"),
    expensesType("expensesType","费用种类"),
    plate("plate","板块"),
    abilityCenter("abilityCenter","职能中心");

    // 成员变量
    private String groupCode;
    private String groupName;

    DictionaryGroup(String groupCode,String groupName){
        this.groupCode = groupCode;
        this.groupName = groupName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
