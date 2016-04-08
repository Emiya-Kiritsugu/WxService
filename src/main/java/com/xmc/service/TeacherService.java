package com.xmc.service;
import com.xmc.entity.Teacher;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
public interface TeacherService {

    /**
     * 获得所有教师列表
     * @return
     */
    List<Teacher> getAllTeachers();

    /**
     * 根据id获得教师信息
     * @param teaNo
     * @return
     */
    Teacher getTeacherById(int teaNo);

    /**
     * 删除某个学生信息
     * @param teaNo
     */
    void deleteTeacherById(int teaNo);

    /**
     * 更新学生信息
     * @param teacher
     */
    void updateTeacher(Teacher teacher);

    /**
     * 增加学生信息
     * @param teacher
     */
    void insertTeacher(Teacher teacher);
}
