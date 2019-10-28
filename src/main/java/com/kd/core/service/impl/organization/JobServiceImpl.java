package com.kd.core.service.impl.organization;

import java.util.List;

import com.kd.core.base.BaseServiceImpl;
import com.kd.core.dao.organization.JobDao;
import com.kd.core.entity.Job;
import com.kd.core.entity.OrgDepartmentJob;
import com.kd.core.service.organization.JobService;

public class JobServiceImpl extends BaseServiceImpl<Job, JobDao> implements
		JobService {

	@Override
	public List<Job> findJobsByOrgDeparts(OrgDepartmentJob odj) {
		return dao.findJobsByOrgDeparts(odj);
	}

	@Override
	public Integer countByJobId(String jobIds) {
		return dao.countByJobId(jobIds);
	}

}
