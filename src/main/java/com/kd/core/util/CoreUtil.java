package com.kd.core.util;

import java.lang.reflect.Field;
import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.kd.core.entity.PageCount;
import com.kd.core.reflect.ReflectHelper;


public class CoreUtil {

	
	/**
	 *@描述：赋值pagecount
	
	 *@创建时间：2015年1月28日 下午2:38:11
	 *@修改人：
	 *@修改时间：
	 *@修改描述：
	 */
	public static PageCount setpagevalue (@Context UriInfo info){
		PageCount pageCount = new PageCount();
		int  currentPage = Integer.valueOf(info.getQueryParameters().getFirst("currentPage"));
		int  showCount = Integer.valueOf(info.getQueryParameters().getFirst("showCount"));
		String  sortName = info.getQueryParameters().getFirst("sortName");
		String  sortOrder = info.getQueryParameters().getFirst("sortOrder");
		pageCount.setCurrentPage(currentPage);
		pageCount.setShowCount(showCount);
		pageCount.setSortName(sortName);
		pageCount.setSortOrder(sortOrder);
		return pageCount;
	}
	
}
