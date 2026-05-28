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
import com.ruoyi.system.domain.Teacher;
import com.ruoyi.system.service.ITeacherService;
import com.ruoyi.system.service.IDepartmentService;

/**
 * 教师管理
 */
@Controller
@RequestMapping("/admin/teacher")
public class TeacherController extends BaseController
{
    private String prefix = "admin/teacher";

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IDepartmentService departmentService;

    @RequiresPermissions("admin:teacher:view")
    @GetMapping()
    public String teacher()
    {
        return prefix + "/teacher";
    }

    @RequiresPermissions("admin:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Teacher teacher)
    {
        List<Teacher> list = teacherService.selectTeacherList(teacher);
        return getDataTable(list);
    }

    /**
     * 新增教师
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("departments", departmentService.selectDepartmentList(null));
        return prefix + "/add";
    }

    @Log(title = "教师管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("admin:teacher:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Teacher teacher)
    {
        if (!teacherService.checkTnoUnique(teacher))
        {
            return error("新增教师'" + teacher.getTno() + "'失败，教师号已存在");
        }
        return toAjax(teacherService.insertTeacher(teacher));
    }

    /**
     * 修改教师
     */
    @RequiresPermissions("admin:teacher:edit")
    @GetMapping("/edit/{tno}")
    public String edit(@PathVariable("tno") String tno, ModelMap mmap)
    {
        mmap.put("teacher", teacherService.selectTeacherById(tno));
        mmap.put("departments", departmentService.selectDepartmentList(null));
        return prefix + "/edit";
    }

    @Log(title = "教师管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("admin:teacher:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Teacher teacher)
    {
        return toAjax(teacherService.updateTeacher(teacher));
    }

    /**
     * 删除教师
     */
    @Log(title = "教师管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("admin:teacher:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(teacherService.deleteTeacherById(ids));
    }

    /**
     * 校验教师号
     */
    @PostMapping("/checkTnoUnique")
    @ResponseBody
    public boolean checkTnoUnique(Teacher teacher)
    {
        return teacherService.checkTnoUnique(teacher);
    }
}
