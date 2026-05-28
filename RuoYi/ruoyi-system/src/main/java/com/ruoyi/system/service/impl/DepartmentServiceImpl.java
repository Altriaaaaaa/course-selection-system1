package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Department;
import com.ruoyi.system.mapper.DepartmentMapper;
import com.ruoyi.system.service.IDepartmentService;

/**
 * 院系管理 服务实现
 */
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService
{
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectDepartmentList(Department department)
    {
        return departmentMapper.selectDepartmentList(department);
    }

    @Override
    public Department selectDepartmentById(Integer deptId)
    {
        return departmentMapper.selectDepartmentById(deptId);
    }

    @Override
    public int insertDepartment(Department department)
    {
        return departmentMapper.insertDepartment(department);
    }

    @Override
    public int updateDepartment(Department department)
    {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public int deleteDepartmentById(Integer deptId)
    {
        return departmentMapper.deleteDepartmentById(deptId);
    }

    @Override
    public boolean checkDeptNameUnique(Department department)
    {
        Integer deptId = StringUtils.isNull(department.getDeptId()) ? -1 : department.getDeptId();
        Department info = departmentMapper.checkDeptNameUnique(department.getDeptName());
        if (StringUtils.isNotNull(info) && !info.getDeptId().equals(deptId))
        {
            return false;
        }
        return true;
    }
}
