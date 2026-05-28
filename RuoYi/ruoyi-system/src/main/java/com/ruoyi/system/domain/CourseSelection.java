package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CourseSelection
{
    private String sno;
    private String cno;
    private String semester;
    private BigDecimal normalScore;
    private BigDecimal testScore;
    private String sname;
    private String cname;
    private String id;

    public String getSno() { return sno; }
    public void setSno(String sno) { this.sno = sno; }

    public String getCno() { return cno; }
    public void setCno(String cno) { this.cno = cno; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public BigDecimal getNormalScore() { return normalScore; }
    public void setNormalScore(BigDecimal normalScore) { this.normalScore = normalScore; }

    public BigDecimal getTestScore() { return testScore; }
    public void setTestScore(BigDecimal testScore) { this.testScore = testScore; }

    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }

    public String getCname() { return cname; }
    public void setCname(String cname) { this.cname = cname; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("sno", getSno())
            .append("cno", getCno())
            .append("semester", getSemester())
            .append("normalScore", getNormalScore())
            .append("testScore", getTestScore())
            .toString();
    }
}
