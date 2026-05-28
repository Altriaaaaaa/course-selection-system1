package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CourseSelection;

public interface CourseSelectionMapper
{
    public List<CourseSelection> selectCourseSelectionList(CourseSelection cs);

    public CourseSelection selectCourseSelectionById(String sno, String cno);

    public int insertCourseSelection(CourseSelection cs);

    public int updateCourseSelection(CourseSelection cs);

    public int deleteCourseSelectionById(String sno, String cno);
}
