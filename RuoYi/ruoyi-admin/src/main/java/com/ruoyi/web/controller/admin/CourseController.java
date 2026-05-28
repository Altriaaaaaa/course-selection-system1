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
import com.ruoyi.system.domain.Course;
import com.ruoyi.system.service.ICourseService;
import com.ruoyi.system.service.IDepartmentService;

@Controller
@RequestMapping("/admin/course")
public class CourseController extends BaseController
{
    private String prefix = "admin/course";

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IDepartmentService departmentService;

    @RequiresPermissions("admin:course:view")
    @GetMapping()
    public String course()
    {
        return prefix + "/course";
    }

    @RequiresPermissions("admin:course:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Course course)
    {
        List<Course> list = courseService.selectCourseList(course);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("departments", departmentService.selectDepartmentList(null));
        return prefix + "/add";
    }

    @Log(title = "课程管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("admin:course:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Course course)
    {
        if (!courseService.checkCnoUnique(course))
        {
            return error("新增课程'" + course.getCno() + "'失败，课程号已存在");
        }
        if (!courseService.checkCnameUnique(course))
        {
            return error("新增课程'" + course.getCname() + "'失败，课程名已存在");
        }
        return toAjax(courseService.insertCourse(course));
    }

    @RequiresPermissions("admin:course:edit")
    @GetMapping("/edit/{cno}")
    public String edit(@PathVariable("cno") String cno, ModelMap mmap)
    {
        mmap.put("course", courseService.selectCourseById(cno));
        mmap.put("departments", departmentService.selectDepartmentList(null));
        return prefix + "/edit";
    }

    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("admin:course:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Course course)
    {
        if (!courseService.checkCnameUnique(course))
        {
            return error("修改课程'" + course.getCname() + "'失败，课程名已存在");
        }
        return toAjax(courseService.updateCourse(course));
    }

    @Log(title = "课程管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("admin:course:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(courseService.deleteCourseById(ids));
    }

    @PostMapping("/checkCnoUnique")
    @ResponseBody
    public boolean checkCnoUnique(Course course)
    {
        return courseService.checkCnoUnique(course);
    }

    @PostMapping("/checkCnameUnique")
    @ResponseBody
    public boolean checkCnameUnique(Course course)
    {
        return courseService.checkCnameUnique(course);
    }
}
