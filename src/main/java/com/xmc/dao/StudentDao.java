package com.xmc.dao;

import com.xmc.annotation.MybatisComponent;
import com.xmc.entity.Student;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
@MybatisComponent
public interface StudentDao {

    void insert(Student student);

    void deleteById(int stuNo);

    void updateById(Student student);

    Student getStudentById(int stuNo);

    List<Student> getAllStudents();
}
