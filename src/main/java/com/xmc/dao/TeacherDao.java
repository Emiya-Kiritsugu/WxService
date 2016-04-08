package com.xmc.dao;

import com.xmc.annotation.MybatisComponent;
import com.xmc.entity.Student;

/**
 * Created by xmc1993 on 16/4/8.
 */
@MybatisComponent
public interface TeacherDao {

    int insert(Student student);

    int deleteById(int id);

    int updateById(Student student);

    int getTeacherById(int id);

    int getAllTeachers();
}
