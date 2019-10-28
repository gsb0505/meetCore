package com.kd.core.auto;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kd.core.entity.BaseData;
import com.kd.core.entity.Config;
import com.kd.core.service.impl.common.BaseDataServiceImpl;
import com.kd.core.service.impl.common.ConfigServiceImpl;
import com.kd.core.util.RedisUtil;
import com.kd.core.util.SerializationUtil;

public class autoSearchBaseInfo extends HttpServlet  {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private BaseDataServiceImpl baseDataServiceImpl;
	
	private ConfigServiceImpl configServiceImpl;
	
	public autoSearchBaseInfo(){
		log.debug("自动加载基础数据。。。");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		baseDataServiceImpl = (BaseDataServiceImpl) ac.getBean("baseDataServiceImpl");
		String name="BaseData";
	//	if(!RedisUtil.exists(name.getBytes())){
			List<BaseData> baseDatas=baseDataServiceImpl.searchInfo();
			RedisUtil.del(name);
			RedisUtil.set(name.getBytes(), SerializationUtil.serialize(baseDatas));
	//	}
		
		//自动查询押金并保存到redis中
		configServiceImpl = (ConfigServiceImpl) ac.getBean("configServiceImpl");
		name="deposit";
		if(!RedisUtil.exists(name.getBytes())){
			List<Config> configs=configServiceImpl.getPagedList(null);
			RedisUtil.set(name.getBytes(), SerializationUtil.serialize(configs));
		}
	}
}
