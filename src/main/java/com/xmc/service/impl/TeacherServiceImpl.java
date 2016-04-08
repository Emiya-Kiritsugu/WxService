package com.xmc.service.impl;

import com.xmc.dao.TeacherDao;
import com.xmc.entity.Teacher;
import com.xmc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    public Teacher getTeacherById(int teaNo) {
        return teacherDao.getTeacherById(teaNo);
    }

    public void deleteTeacherById(int teaNo) {
        teacherDao.deleteById(teaNo);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDao.updateById(teacher);
    }

    public void insertTeacher(Teacher teacher) {
        teacherDao.insert(teacher);
    }
}
