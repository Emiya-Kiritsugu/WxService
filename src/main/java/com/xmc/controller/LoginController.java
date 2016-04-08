package com.xmc.controller;

import com.xmc.entity.Clock;
import com.xmc.entity.Student;
import com.xmc.service.LoginService;
import com.xmc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2015/12/4.
 */

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    StudentService studentService;

    @RequestMapping("/login")
    public String login(ModelMap modelMap){
        modelMap.put("test", "test");
        return "pages/Test";
    }

    @RequestMapping("/rest")
    public void restFul(ModelMap modelMap){
        modelMap.put("name", "xmc1993");
    }

    @RequestMapping("clock")
    public String getClockInfo(ModelMap modelMap){
        Clock clock = loginService.getClockById(1);
        modelMap.put("clock", clock);
        return "pages/Test";
    }

    @RequestMapping("student")
    public String testStudentDao(){
        Student student = studentService.getStudentById(1);
        List<Student> studentList = studentService.getAllStudents();
        student.setGrade("幼儿园");
        studentService.updateStudent(student);
        return "pages/Test";
    }
}
