package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Department;

/**
 * 院系管理 数据层
 */
public interface DepartmentMapper
{
    public List<Department> selectDepartmentList(Department department);

    public Department selectDepartmentById(Integer deptId);

    public int insertDepartment(Department department);

    public int updateDepartment(Department department);

    public int deleteDepartmentById(Integer deptId);

    public Department checkDeptNameUnique(String deptName);
}
