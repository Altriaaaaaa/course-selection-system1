package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Department;

/**
 * 院系管理 服务层
 */
public interface IDepartmentService
{
    public List<Department> selectDepartmentList(Department department);

    public Department selectDepartmentById(Integer deptId);

    public int insertDepartment(Department department);

    public int updateDepartment(Department department);

    public int deleteDepartmentById(Integer deptId);

    public boolean checkDeptNameUnique(Department department);
}
