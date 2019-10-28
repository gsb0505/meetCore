/**
 * 
 */
package com.kd.core.service.impl.core;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

/**
 * 
 * @类名称：CoreAccessDecisionManager.java
 * @类描述：

 * @创建时间：2015年1月21日-上午10:59:06
 * @修改备注:
 * @version
 */
public class CoreAccessDecisionManager implements AccessDecisionManager {

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;
		}

		// 所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			// 访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();
//			System.out.println("needPermission is " + needPermission);
//			System.out.println("current Author:"+ authentication.getAuthorities());
			if (needPermission.contains(authentication.getAuthorities()
					.toString())) {
				return;
			}
		}
		// 没有权限让我们去捕捉
		throw new AccessDeniedException("Sorry,You have no No Permission.");
	}

	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}