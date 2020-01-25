package com.kd.core.enumerate;

/** 消息code枚举
 * @author: latham
 * @Date: 2020/1/23 20:41
 **/
public enum MessageCodeEnum {

    SUCCESS("200","成功"),
    ERROR("500","错误"),
    FAIL("201","失败"),
    FORMATE("700","格式错误"),

    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String desc;

    MessageCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
