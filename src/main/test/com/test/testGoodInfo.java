package com.test;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kd.core.entity.GoodsInfo;

public class testGoodInfo {
	
	private static String serverUri = "http://localhost:8082/meetCore/goodsInfo";

	public static void main(String[] args) {
		
		try {
			
			add();
			
			//update();
			
			//getModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void add(){
		
		Client client = ClientBuilder.newClient();
		
		GoodsInfo goodsInfo=new GoodsInfo();
		goodsInfo.setGoodsName("美食咖啡");
		goodsInfo.setStoreCode("coffee");
		goodsInfo.setTypeCode("6450");
		goodsInfo.setPrice(20);
		goodsInfo.setOrderNum(100);
		goodsInfo.setCount(50);
		goodsInfo.setStatus("1");
		
		WebTarget target = client.target(serverUri + "/add");
		Response res = target.request().post(
				Entity.entity(goodsInfo, MediaType.APPLICATION_XML));
		String value = res.readEntity(String.class);
		
		System.out.println(value);
	} 
}
