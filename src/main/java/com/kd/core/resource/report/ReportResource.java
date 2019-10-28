package com.kd.core.resource.report;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.entity.SystemTReport;
import com.kd.core.service.report.SystemTReportService;

@Path("/report")
public class ReportResource {
	
	
	@Autowired
	private SystemTReportService systemTReportService;
	
	
	@GET
	@Path("/querySystemTReport")
	public List<SystemTReport> querySystemTReport(@QueryParam("systemTReport")String  systemTReport ){
		SystemTReport sTReport = new Gson().fromJson(systemTReport.replace("+", " "),SystemTReport.class);
		systemTReportService.insert(sTReport);
		List<SystemTReport> list =  systemTReportService.getPagedList(sTReport);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(sTReport.pageCount);
		}
		return list;
	}
	
	@GET
	@Path("/querySystemTReportList")
	public List<SystemTReport> querySystemTReportList(@QueryParam("systemTReport")String  systemTReport ){
		SystemTReport sTReport = new Gson().fromJson(systemTReport.replace("+", " "),SystemTReport.class);
		systemTReportService.insert(sTReport);
		return systemTReportService.getModelList(sTReport);
	}
	
	

}
