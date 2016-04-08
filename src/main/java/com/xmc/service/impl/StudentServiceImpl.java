package com.xmc.service.impl;

import com.xmc.dao.StudentDao;
import com.xmc.entity.Student;
import com.xmc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int stuNo) {
        return studentDao.getStudentById(stuNo);
    }

    public void deleteStudentById(int stuNo) {
        studentDao.deleteById(stuNo);
    }

    public void updateStudent(Student student) {
        studentDao.updateById(student);
    }

    public void insertStudent(Student student) {
        studentDao.insert(student);
    }
}
