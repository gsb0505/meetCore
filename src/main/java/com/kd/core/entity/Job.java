package com.kd.core.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="job")
public class Job extends BaseEntity{

    private String jobNo;

    private String name;

    private String remark;


    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo == null ? null : jobNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}