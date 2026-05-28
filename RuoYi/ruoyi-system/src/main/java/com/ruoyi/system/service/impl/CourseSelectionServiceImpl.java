package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.CourseSelection;
import com.ruoyi.system.mapper.CourseSelectionMapper;
import com.ruoyi.system.service.ICourseSelectionService;

@Service("courseSelectionService")
public class CourseSelectionServiceImpl implements ICourseSelectionService
{
    @Autowired
    private CourseSelectionMapper courseSelectionMapper;

    @Override
    public List<CourseSelection> selectCourseSelectionList(CourseSelection cs) { return courseSelectionMapper.selectCourseSelectionList(cs); }
    @Override
    public CourseSelection selectCourseSelectionById(String sno, String cno) { return courseSelectionMapper.selectCourseSelectionById(sno, cno); }
    @Override
    public int insertCourseSelection(CourseSelection cs) { return courseSelectionMapper.insertCourseSelection(cs); }
    @Override
    public int updateCourseSelection(CourseSelection cs) { return courseSelectionMapper.updateCourseSelection(cs); }
    @Override
    public int deleteCourseSelectionById(String sno, String cno) { return courseSelectionMapper.deleteCourseSelectionById(sno, cno); }
}
