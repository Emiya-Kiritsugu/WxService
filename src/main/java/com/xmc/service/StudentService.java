package com.xmc.service;

import com.xmc.entity.Student;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
public interface StudentService {

    /**
     * 获得所有学生列表
     * @return
     */
    List<Student> getAllStudents();

    /**
     * 根据id获得学生信息
     * @param stuNo
     * @return
     */
    Student getStudentById(int stuNo);

    /**
     * 删除某个学生信息
     * @param stuNo
     */
    void deleteStudentById(int stuNo);

    /**
     * 更新学生信息
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 增加学生信息
     * @param student
     */
    void insertStudent(Student student);
}
