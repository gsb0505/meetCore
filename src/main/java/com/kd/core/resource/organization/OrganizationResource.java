package com.kd.core.resource.organization;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.kd.core.dto.ODJDto;
import com.kd.core.entity.OrgDepartmentJob;
import com.kd.core.entity.Organization;
import com.kd.core.service.organization.OrganizationService;



@Path("/organization")
public class OrganizationResource {
	@Autowired
	private OrganizationService organizationService;
	
	
	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}


	@GET
	@Path("query")
	public List<Organization> query(@QueryParam("organization") String organization ) throws Exception {
		Organization u = new Gson().fromJson(organization, Organization.class);
		List<Organization> list  = organizationService.getPagedList(u);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(u.pageCount);
		}
		return list;
	}
	
	/**
	 * 新增
	 * @param Organization
	 * @throws Exception
	 */
	@POST
	@Path("add")
	public boolean add(Organization Organization) throws Exception {
		return organizationService.insert(Organization);
	}
	
	@GET
	@Path("queryModel")
	public Organization queryModel(@QueryParam("organization") String organization) throws Exception {
		Organization u = new Gson().fromJson(organization, Organization.class);
		return 	organizationService.getModel(u);
	}
	
	/**
	 * 修改
	 * @throws Exception
	 */
	@PUT
	@Path("modify")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public boolean modify(Organization organization) throws Exception {
		return organizationService.update(organization);

	}
	
	@DELETE
	@Path("/delete/{orgId}")
	public boolean delete(@PathParam("orgId") String orgId){
		return  organizationService.delete(orgId);
	}
	
	/**
	 * 条件查询
	 * @throws Exception
	 */
	@GET
	@Path("queryDepartsJobsByCondition")
	public List<OrgDepartmentJob> getDepartsJobsByCondition(@QueryParam("orgDepartmentJob")String orgDepartmentJob) throws Exception {
		OrgDepartmentJob u = new Gson().fromJson(orgDepartmentJob, OrgDepartmentJob.class);
		List<OrgDepartmentJob> list  = organizationService.getDepartsJobsByCondition(u);
		return list;
	}
	
	/**
	 * 配置记录查询
	 * @return boolean
	 */
	@GET
	@Path("findRecord")
	public Boolean findRecord(@QueryParam("orgDepartmentJob")String orgDepartmentJob){
		OrgDepartmentJob u = new Gson().fromJson(orgDepartmentJob, OrgDepartmentJob.class);
		
		return organizationService.findRecord(u);
	}
	
	/**
	 * 配置
	 * @throws Exception
	 */
	@POST
	@Path("configOrgDepartmentJob")
	public Boolean configOrgDepartmentJob(OrgDepartmentJob orgDepartmentJob,@QueryParam("type") String type) throws Exception {
		if(type==null){
			return false;
		}else if(type.equals("delRow") && orgDepartmentJob.getOrgId()==0){
			return false;
		}
		Boolean reu = organizationService.configOrgDepartmentJob(orgDepartmentJob,type);
		return reu;
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	@GET
	@Path("getAllOrg")
	public List<Organization> getAllOrg(){
		return organizationService.getAllOrg();
	}
	
	/**
	 * 查询所有配置列表
	 * @return
	 */
	@GET
	@Path("queryODJList")
	public List<ODJDto> queryODJList(@QueryParam("orgDepartmentJob")String orgDepartmentJob){
		OrgDepartmentJob u = new Gson().fromJson(orgDepartmentJob, OrgDepartmentJob.class);
		return organizationService.queryODJList(u);
	}
	
}
