package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Class;

public interface IClassService
{
    public List<Class> selectClassList(Class clazz);
    public Class selectClassById(String tno, String cno);
    public int insertClass(Class clazz);
    public int updateClass(Class clazz);
    public int deleteClassById(String tno, String cno);
}
