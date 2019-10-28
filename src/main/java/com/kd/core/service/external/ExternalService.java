package com.kd.core.service.external;

import java.text.ParseException;

import com.kd.core.dto.ExternalDto;

public interface ExternalService {
	
	/**
	 * 
	* @Title: _recharge_req 
	* @Description: 充值请求业务处理
	* @author GLT
	* @date 2016年10月12日 下午1:13:40 
	* @param @param externalDto
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	byte[] _recharge_req(ExternalDto externalDto)throws Exception;
	
	/**
	 * 
	* @Title: _recharege_confirm 
	* @Description: 充值确认业务处理
	* @author GLT 
	* @date 2016年10月12日 下午1:13:59 
	* @param @param externalDto
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	byte[] _recharege_confirm(ExternalDto externalDto) throws Exception;
	
	/**
	 * 
	* @Title: _sellCard_req 
	* @Description: 售卡请求
	* @author GLT
	* @date 2016年10月14日 上午11:23:04 
	* @param @param externalDto
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	byte[] _sellCard_req(ExternalDto externalDto) throws Exception;
	
	/**
	 * 
	* @Title: _sellCard_confirm 
	* @Description: 售卡确认
	* @author GLT
	* @date 2016年10月14日 上午11:23:23 
	* @param @param externalDto
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	byte[] _sellCard_confirm(ExternalDto externalDto) throws Exception;
	
	/**
	 * 
	* @Title: _tradeDetail_Inquire 
	* @Description: 交易明细查询
	* @author GLT 
	* @date 2016年10月12日 下午1:14:19 
	* @param @param externalDto
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	byte[] _tradeDetail_Inquire(ExternalDto externalDto)throws ParseException;
	
	/**
	 * 
	* @Title: _balance_Inquire 
	* @Description: 余额查询
	* @author GLT
	* @date 2016年10月12日 下午1:14:35 
	* @param @param externalDto
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	byte[] _balance_Inquire(ExternalDto externalDto);
}
