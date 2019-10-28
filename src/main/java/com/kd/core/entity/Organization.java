package com.kd.core.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="organization")
public class Organization extends BaseEntity{

    private String agencyNo;

    private String name;

    private String remark;


    public String getAgencyNo() {
        return agencyNo;
    }

    public void setAgencyNo(String agencyNo) {
        this.agencyNo = agencyNo == null ? null : agencyNo.trim();
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