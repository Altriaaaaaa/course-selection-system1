package com.ruoyi.web.controller.admin;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Department;
import com.ruoyi.system.service.IDepartmentService;

/**
 * 院系管理
 */
@Controller
@RequestMapping("/admin/department")
public class DepartmentController extends BaseController
{
    private String prefix = "admin/department";

    @Autowired
    private IDepartmentService departmentService;

    @RequiresPermissions("admin:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

    @RequiresPermissions("admin:department:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Department department)
    {
        List<Department> list = departmentService.selectDepartmentList(department);
        return getDataTable(list);
    }

    /**
     * 新增院系
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @Log(title = "院系管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("admin:department:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Department department)
    {
        if (!departmentService.checkDeptNameUnique(department))
        {
            return error("新增院系'" + department.getDeptName() + "'失败，院系名称已存在");
        }
        return toAjax(departmentService.insertDepartment(department));
    }

    /**
     * 修改院系
     */
    @RequiresPermissions("admin:department:edit")
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Integer deptId, ModelMap mmap)
    {
        mmap.put("department", departmentService.selectDepartmentById(deptId));
        return prefix + "/edit";
    }

    @Log(title = "院系管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("admin:department:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Department department)
    {
        if (!departmentService.checkDeptNameUnique(department))
        {
            return error("修改院系'" + department.getDeptName() + "'失败，院系名称已存在");
        }
        return toAjax(departmentService.updateDepartment(department));
    }

    /**
     * 删除院系
     */
    @Log(title = "院系管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("admin:department:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(departmentService.deleteDepartmentById(Integer.valueOf(ids)));
    }

    /**
     * 校验院系名称
     */
    @PostMapping("/checkDeptNameUnique")
    @ResponseBody
    public boolean checkDeptNameUnique(Department department)
    {
        return departmentService.checkDeptNameUnique(department);
    }
}
