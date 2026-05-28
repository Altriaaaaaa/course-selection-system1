package com.ruoyi.web.controller.student;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.CourseSelection;
import com.ruoyi.system.domain.Student;
import com.ruoyi.system.service.ICourseService;
import com.ruoyi.system.service.ICourseSelectionService;
import com.ruoyi.system.service.IStudentService;

@Controller
@RequestMapping("/student")
@RequiresRoles("student")
public class StudentBusinessController extends BaseController
{
    @Autowired
    private ICourseService courseService;
    @Autowired
    private ICourseSelectionService courseSelectionService;
    @Autowired
    private IStudentService studentService;

    @GetMapping("/index")
    public String index() { return "student/index"; }

    @GetMapping("/course")
    public String course() { return "student/course/list"; }

    @PostMapping("/course/list")
    @ResponseBody
    public TableDataInfo courseList()
    {
        return getDataTable(courseService.selectCourseList(null));
    }

    @PostMapping("/course/select")
    @ResponseBody
    public AjaxResult selectCourse(String sno, String cno, String semester)
    {
        CourseSelection cs = new CourseSelection();
        cs.setSno(sno);
        cs.setCno(cno);
        cs.setSemester(semester);
        return toAjax(courseSelectionService.insertCourseSelection(cs));
    }

    @GetMapping("/course/my")
    public String myCourse() { return "student/course/my"; }

    @PostMapping("/course/my/list")
    @ResponseBody
    public TableDataInfo myCourseList(String sno)
    {
        CourseSelection cs = new CourseSelection();
        cs.setSno(sno);
        return getDataTable(courseSelectionService.selectCourseSelectionList(cs));
    }

    @PostMapping("/course/drop")
    @ResponseBody
    public AjaxResult dropCourse(String sno, String cno)
    {
        return toAjax(courseSelectionService.deleteCourseSelectionById(sno, cno));
    }

    @PostMapping("/info")
    @ResponseBody
    public AjaxResult info(String sno)
    {
        Student student = studentService.selectStudentById(sno);
        return success().put("data", student);
    }

    @GetMapping("/grade")
    public String grade() { return "student/grade/list"; }

    @PostMapping("/grade/list")
    @ResponseBody
    public TableDataInfo gradeList(String sno)
    {
        CourseSelection cs = new CourseSelection();
        cs.setSno(sno);
        return getDataTable(courseSelectionService.selectCourseSelectionList(cs));
    }
}
