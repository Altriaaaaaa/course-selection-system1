package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学生表 student
 */
public class Student
{
    private String sno;
    private String sname;
    private String sex;
    private Date birth;
    private String nativePlace;
    private String phone;
    private String passwordHash;
    private Integer status;
    private Integer deptId;
    private String createdBy;

    // 非数据库字段，用于列表展示院系名称
    private String deptName;

    public String getSno() { return sno; }
    public void setSno(String sno) { this.sno = sno; }

    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public Date getBirth() { return birth; }
    public void setBirth(Date birth) { this.birth = birth; }

    public String getNativePlace() { return nativePlace; }
    public void setNativePlace(String nativePlace) { this.nativePlace = nativePlace; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("sno", getSno())
            .append("sname", getSname())
            .append("sex", getSex())
            .append("birth", getBirth())
            .append("nativePlace", getNativePlace())
            .append("phone", getPhone())
            .append("status", getStatus())
            .append("deptId", getDeptId())
            .append("createdBy", getCreatedBy())
            .toString();
    }
}
