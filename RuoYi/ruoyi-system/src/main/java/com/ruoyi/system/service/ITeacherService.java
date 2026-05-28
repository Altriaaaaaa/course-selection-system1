package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Teacher;

/**
 * 教师管理 服务层
 */
public interface ITeacherService
{
    public List<Teacher> selectTeacherList(Teacher teacher);

    public Teacher selectTeacherById(String tno);

    public int insertTeacher(Teacher teacher);

    public int updateTeacher(Teacher teacher);

    public int deleteTeacherById(String tno);

    public boolean checkTnoUnique(Teacher teacher);
}
