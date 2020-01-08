package com.kd.core.resource.report;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.entity.SystemTReport;
import com.kd.core.entity.GoodsDetailSReport;
import com.kd.core.service.report.SystemTReportService;
import com.kd.core.service.report.GoodsDetailSReportService;

@Path("/report")
public class ReportResource {
	
	
	@Autowired
	private SystemTReportService systemTReportService;
	
	@Autowired
	private GoodsDetailSReportService goodsDetailSReportService;
	
	
	
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
	
	
	@GET
	@Path("/queryGoodsDetailReport")
	public List<GoodsDetailSReport> queryGoodsDetailReport(@QueryParam("goodsDetailReport")String  goodsDetailReport ){
		GoodsDetailSReport gdReport = new Gson().fromJson(goodsDetailReport.replace("+", " "),GoodsDetailSReport.class);
		List<GoodsDetailSReport> list =  goodsDetailSReportService.getPagedList(gdReport);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(gdReport.pageCount);
		}
		return list;
	}
	
	@GET
	@Path("/queryGoodsDetailReportList")
	public List<GoodsDetailSReport> queryGoodsDetailReportList(@QueryParam("goodsDetailReport")String  goodsDetailReport ){
		GoodsDetailSReport gdReport = new Gson().fromJson(goodsDetailReport.replace("+", " "),GoodsDetailSReport.class);
		return goodsDetailSReportService.getModelList(gdReport);
	}
	
	
}
