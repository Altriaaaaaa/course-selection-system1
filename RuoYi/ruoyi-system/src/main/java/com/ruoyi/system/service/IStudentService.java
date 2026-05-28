package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Student;

/**
 * 学生管理 服务层
 */
public interface IStudentService
{
    public List<Student> selectStudentList(Student student);

    public Student selectStudentById(String sno);

    public int insertStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudentById(String sno);

    public boolean checkSnoUnique(Student student);
}
