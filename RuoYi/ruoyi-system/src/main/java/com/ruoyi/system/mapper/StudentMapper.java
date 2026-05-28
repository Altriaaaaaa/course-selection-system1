package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Student;

/**
 * 学生管理 数据层
 */
public interface StudentMapper
{
    public List<Student> selectStudentList(Student student);

    public Student selectStudentById(String sno);

    public int insertStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudentById(String sno);

    public Student checkSnoUnique(String sno);
}
