package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.Class;
import com.ruoyi.system.mapper.ClassMapper;
import com.ruoyi.system.service.IClassService;

@Service("classService")
public class ClassServiceImpl implements IClassService
{
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<Class> selectClassList(Class clazz) { return classMapper.selectClassList(clazz); }
    @Override
    public Class selectClassById(String tno, String cno) { return classMapper.selectClassById(tno, cno); }
    @Override
    public int insertClass(Class clazz) { return classMapper.insertClass(clazz); }
    @Override
    public int updateClass(Class clazz) { return classMapper.updateClass(clazz); }
    @Override
    public int deleteClassById(String tno, String cno) { return classMapper.deleteClassById(tno, cno); }
}
