package com.jwt.special.model;

import com.jwt.special.model.enums.Mark;
import com.jwt.special.model.enums.Sign;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * @author jiangwentao
 * @date 2019/1/2 0002 下午 3:03
 */
@Data
public class Transact implements Serializable {

    private static final long serialVersionUID = -8846924572361528782L;

    /** transact_id : 主键Id**/
    private  Long transactId ;
    /** file_seq : 文件编号后两位**/
    private  int fileSeq ;
    /** module : 板块**/
    private String plate;
    /** company_name : 公司名称**/
    private String companyName;
    /** functions : 职能中心**/
    private String functions;
    /** phone : 电话**/
    private String phone;
    /** receipt time : 接收时间**/
    private Time receiptTime;
    /** file_time : 收文日期**/
    private Date fileTime;
    /** handle_time : 批示日期**/
    private Date handleTime;
    /** file_name : 文件名称**/
    private String fileName;
    /** handle_idea : 杜总批示意见**/
    private String handleIdea;
    /** leader : 流转部门(领导)**/
    private String leader;
    /** handle_number : 董事长批示文号**/
    private String handleNumber;
    /** handle_source_number : 批示来源历史文件编号(CEO办)**/
    private String handleSourceNumber;
    /** handle_source_name : 批示来源历史文件名称**/
    private String handleSourceName;
    /** report : 是否提报**/
    private String report;
    /** finish : 是否完成**/
    private String finish;
    /** mark : 预警标记**/
    private Mark mark;
    /** record : 督办记录提报情况**/
    private String record;
    /** remark : 备注**/
    private String remark;
    /** file_number : 文件编号**/
    private String fileNumber;
    /** back : 是否退回**/
    private String back;
    /** back : 是否回复**/
    private boolean reply;
    /** create_time : 创建时间**/
    private Date createTime;
    /** create_time : 修改时间**/
    private Date updateTime;
    /**sign_img_url 签字图片地址**/
    private String signImgUrl;
    /**sign_date 签字日期**/
    private Date signDate;
    /**sign 是否签字**/
    private Sign sign;
    /**最后一次修改人名字**/
    private String modifyUserName;
}
