package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 教师表 teacher
 */
public class Teacher
{
    private String tno;
    private String tname;
    private String sex;
    private Date birth;
    private String rank;
    private BigDecimal salary;
    private String passwordHash;
    private Integer status;
    private Integer deptId;
    private String createdBy;

    // 非数据库字段，用于列表展示院系名称
    private String deptName;

    public String getTno() { return tno; }
    public void setTno(String tno) { this.tno = tno; }

    public String getTname() { return tname; }
    public void setTname(String tname) { this.tname = tname; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public Date getBirth() { return birth; }
    public void setBirth(Date birth) { this.birth = birth; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

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
            .append("tno", getTno())
            .append("tname", getTname())
            .append("sex", getSex())
            .append("birth", getBirth())
            .append("rank", getRank())
            .append("salary", getSalary())
            .append("status", getStatus())
            .append("deptId", getDeptId())
            .append("createdBy", getCreatedBy())
            .toString();
    }
}
