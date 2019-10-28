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
import com.kd.core.entity.Department;
import com.kd.core.service.organization.DepartmentService;
import com.kd.core.util.StringUtil;



@Path("/department")
public class DepartmentResource {
	@Autowired
	private DepartmentService departmentService;
	
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


	@GET
	@Path("query")
	public List<Department> query(@QueryParam("department") String department ) throws Exception {
		Department u = new Gson().fromJson(department, Department.class);
		List<Department> list  = departmentService.getPagedList(u);
		if(list!=null&&list.size()>0){
			list.get(0).setPageCount(u.pageCount);
		}
		return list;
	}
	
	@GET
	@Path("queryList")
	public List<Department> queryList(@QueryParam("department") String department ) throws Exception {
		Department u = new Gson().fromJson(department, Department.class);
		List<Department> list  = departmentService.getModelList(u);
		return list;
	}
	
	/**
	 * 新增
	 * @param Department
	 * @throws Exception
	 */
	@POST
	@Path("add")
	public boolean add(Department department) throws Exception {
		return departmentService.insert(department);
	}
	
	@GET
	@Path("queryModel")
	public Department queryModel(@QueryParam("department") String department) throws Exception {
		Department u = new Gson().fromJson(department, Department.class);
		return 	departmentService.getModel(u);
	}
	
	/**
	 * 修改
	 * @throws Exception
	 */
	@PUT
	@Path("modify")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public boolean modify(Department department) throws Exception {
		return departmentService.update(department);

	}
	
	@DELETE
	@Path("/delete/{orgId}")
	public boolean delete(@PathParam("orgId") String orgId){
		return  departmentService.delete(orgId);
	}
	
	/**
	 * 根据机构id查询部门
	 * @throws Exception
	 */
	@GET
	@Path("queryDepartsByOrg")
	public List<Department> findDepartsByOrg(@QueryParam("orgId") String orgId) throws Exception {
		if(!StringUtil.iStr(orgId)){
			return null;
		}
		return 	departmentService.findDepartsByOrg(orgId);
	}
	
	
	
}
