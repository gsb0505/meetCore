/**
 * 内容服务平台
 * com.kd.core.service.impl
 * SystemAuthServiceImpl.java
 * 
 * 2015年1月9日-下午1:39:19
 *  2015杭州宽达信息技术有限公司-版权所有
 *
 */
package com.kd.core.service.impl;

import java.util.ArrayList;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * SystemAuthServiceImpl
 * 
 * glt
 * glt
 * 2015年1月9日 下午1:39:19
 * 
 * @version 1.0.0
 *
 */
public class SystemAuthServiceImpl implements UserDetailsService {

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 ArrayList list = new ArrayList();
	        list.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
	        User details = new User("user", "pass", list);
	        return details;
		
	}
//	 @Override
//	    public UserDetails loadUserByUsername(String userName)
//	            throws UsernameNotFoundException {
//	        ArrayList list = new ArrayList();
//	        list.add(new SimpleGrantedAuthority("ROLE_SUPERVISOR"));
//	        User details = new User("user", "pass", list);
//	        return details;
//	    }


}
