package com.xmc.dao;

import com.xmc.annotation.MybatisComponent;
import com.xmc.entity.Student;
import com.xmc.entity.Teacher;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
@MybatisComponent
public interface TeacherDao {

    void insert(Teacher teacher);

    void deleteById(int teaNo);

    void updateById(Teacher teacher);

    Teacher getTeacherById(int teaNo);

    List<Teacher> getAllTeachers();
}
