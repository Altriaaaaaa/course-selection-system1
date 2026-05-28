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
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.service.IStudentService;
import com.ruoyi.system.service.IDepartmentService;

/**
 * 学生管理
 */
@Controller
@RequestMapping("/admin/student")
public class StudentController extends BaseController
{
    private String prefix = "admin/student";

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IDepartmentService departmentService;

    @RequiresPermissions("admin:student:view")
    @GetMapping()
    public String student()
    {
        return prefix + "/student";
    }

    @RequiresPermissions("admin:student:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Student student)
    {
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    /**
     * 新增学生
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("departments", departmentService.selectDepartmentList(null));
        return prefix + "/add";
    }

    @Log(title = "学生管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("admin:student:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Student student)
    {
        if (!studentService.checkSnoUnique(student))
        {
            return error("新增学生'" + student.getSno() + "'失败，学号已存在");
        }
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改学生
     */
    @RequiresPermissions("admin:student:edit")
    @GetMapping("/edit/{sno}")
    public String edit(@PathVariable("sno") String sno, ModelMap mmap)
    {
        mmap.put("student", studentService.selectStudentById(sno));
        mmap.put("departments", departmentService.selectDepartmentList(null));
        return prefix + "/edit";
    }

    @Log(title = "学生管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("admin:student:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Student student)
    {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除学生
     */
    @Log(title = "学生管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("admin:student:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentService.deleteStudentById(ids));
    }

    /**
     * 校验学号
     */
    @PostMapping("/checkSnoUnique")
    @ResponseBody
    public boolean checkSnoUnique(Student student)
    {
        return studentService.checkSnoUnique(student);
    }
}
