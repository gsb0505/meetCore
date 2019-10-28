/**
 * 
 */
package com.kd.core.base;

import java.util.List;

import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;


/**
 * 
 * @类名称：BaseClient.java
 * @类描述：http请求客户端

 * @创建时间：2015年1月22日-上午11:21:31
 * @修改备注:
 * @version
 */
public class BaseClient {


	private static JerseyClient jerseyClient = JerseyClientBuilder
			.createClient();

	public static JerseyWebTarget getWebTarget(String URL) {

		JerseyWebTarget target = jerseyClient.target(URL).register(
				HttpAuthenticationFeature.basicBuilder()
						.credentials("test", "testtest11").build());


		return target;
	}

	

}
