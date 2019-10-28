package com.kd.core.util;

import java.util.Iterator;
import java.util.List;

import com.kd.core.entity.BaseData;

public class BaseDataUtil {
	
	public static List<BaseData> findByBaseDataCode(String _mate_code){
		
		 byte[] ar=RedisUtil.get("BaseData".getBytes());
		 List<BaseData> baseDatas=(List<BaseData>) SerializationUtil.deserialize(ar);
		 for(Iterator it = baseDatas.iterator(); it.hasNext(); ) {
			 BaseData baseData=(BaseData) it.next();
			 if(!baseData.getCode().contains(_mate_code)){
					it.remove();
				}
		 }
		return baseDatas;
	}
}	
