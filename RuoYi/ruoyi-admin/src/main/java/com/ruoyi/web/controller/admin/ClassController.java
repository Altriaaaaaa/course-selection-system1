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
import com.ruoyi.system.domain.Class;
import com.ruoyi.system.service.IClassService;
import com.ruoyi.system.service.ITeacherService;
import com.ruoyi.system.service.ICourseService;

@Controller
@RequestMapping("/admin/class")
public class ClassController extends BaseController
{
    private String prefix = "admin/class";

    @Autowired
    private IClassService classService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private ICourseService courseService;

    @RequiresPermissions("admin:class:view")
    @GetMapping()
    public String clazz() { return prefix + "/class"; }

    @RequiresPermissions("admin:class:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Class clazz)
    {
        return getDataTable(classService.selectClassList(clazz));
    }

    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("teachers", teacherService.selectTeacherList(null));
        mmap.put("courses", courseService.selectCourseList(null));
        return prefix + "/add";
    }

    @Log(title = "授课管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("admin:class:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Class clazz)
    {
        return toAjax(classService.insertClass(clazz));
    }

    @RequiresPermissions("admin:class:edit")
    @GetMapping("/edit/{tno}/{cno}")
    public String edit(@PathVariable("tno") String tno, @PathVariable("cno") String cno, ModelMap mmap)
    {
        mmap.put("class", classService.selectClassById(tno, cno));
        mmap.put("teachers", teacherService.selectTeacherList(null));
        mmap.put("courses", courseService.selectCourseList(null));
        return prefix + "/edit";
    }

    @Log(title = "授课管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("admin:class:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Class clazz)
    {
        return toAjax(classService.updateClass(clazz));
    }

    @Log(title = "授课管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("admin:class:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String[] arr = ids.split(",");
        return toAjax(classService.deleteClassById(arr[0], arr[1]));
    }
}
