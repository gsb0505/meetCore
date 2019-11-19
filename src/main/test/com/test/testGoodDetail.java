package com.test;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kd.core.entity.GoodsDetail;
import com.kd.core.entity.GoodsInfo;

public class testGoodDetail {
	
	private static String serverUri = "http://localhost:8082/meetCore/goodsDetail";

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
		GoodsDetail goodsDetail=new GoodsDetail();
		goodsDetail.setId("1231231234");
		goodsDetail.setGoodsName("asdada");
		goodsDetail.setAmount(100);
		WebTarget target = client.target(serverUri + "/add");
		Response res = target.request().post(
				Entity.entity(goodsDetail, MediaType.APPLICATION_XML));
		String value = res.readEntity(String.class);
		
		System.out.println(value);
	} 
}
