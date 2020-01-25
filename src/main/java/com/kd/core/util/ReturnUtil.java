package com.kd.core.util;

import com.kd.core.dto.MessageDto;

/** 返回结果工具类
 * @author: latham
 * @Date: 2020/1/23 20:38
 **/
public class ReturnUtil {


    public static MessageDto returnJson(String code, String message){
        return new MessageDto(code, message);
    }

}
