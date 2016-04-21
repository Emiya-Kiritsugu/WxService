package com.xmc.controller;

import com.xmc.entity.Student;
import com.xmc.entity.Teacher;
import com.xmc.service.StudentService;
import com.xmc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
@Controller
@RequestMapping("/view")
public class ShowController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/test")
    public String test(){
        return "pages/Test";
    }

    @RequestMapping("/allteacher")
    public String allTeacher(ModelMap modelMap){
        System.out.println("allTeacher");
        List<Teacher> allTeacher = teacherService.getAllTeachers();
        modelMap.put("title","孺子牛老师风采");
        modelMap.put("allTeacher",allTeacher);
        return "pages/teacher";
    }

    @RequestMapping("/allstudent")
    public String allStudent(ModelMap modelMap){
        System.out.println("allStudent");
        List<Student> allStudent = studentService.getAllStudents();
        modelMap.put("title","孺子牛学生风采");
        modelMap.put("allStudent",allStudent);
        return "pages/student";
    }

    @RequestMapping("/updateteacher")
    public String updateteacher(@RequestParam("teacherPhoto") MultipartFile file,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException {

        if(request.getParameter("teachNo") != null && !request.getParameter("teachNo").equals("")) {
            System.out.println("updateTeacher");
            String teacherProfile = request.getParameter("profile");
            String teacherAchieve = request.getParameter("achieve");
            int teacherNo = Integer.parseInt(request.getParameter("teachNo"));
            Teacher teacher = teacherService.getTeacherById(teacherNo);
            teacher.setAchievement(teacherAchieve);
            teacher.setProfile(teacherProfile);
            teacherService.updateTeacher(teacher);
            List<Teacher> allTeacher = teacherService.getAllTeachers();
            uploadPic(file,request,response);
            modelMap.put("title", "孺子牛老师风采");
            modelMap.put("allTeacher", allTeacher);
            return "pages/teacher";
        }else{
            System.out.println("addTeacher");
            String teacherProfile = request.getParameter("profile");
            String teacherAchieve = request.getParameter("achieve");
            String teacherName = request.getParameter("name");
            Teacher teacher = new Teacher();
            teacher.setAchievement(teacherAchieve);
            teacher.setProfile(teacherProfile);
            teacher.setName(teacherName);
            teacherService.insertTeacher(teacher);
            List<Teacher> allTeacher = teacherService.getAllTeachers();
            uploadPic(file,request,response);
            modelMap.put("title", "孺子牛老师风采");
            modelMap.put("allTeacher", allTeacher);
            return "pages/teacher";
        }
    }

    @RequestMapping("/updatestudent")
    public String updatestudent(@RequestParam("studentPhoto") MultipartFile file,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException {
        if(request.getParameter("studentNo") != null && !request.getParameter("studentNo").equals("")) {
            System.out.println("updateStudent");
            String teacherAchieve = request.getParameter("achieve");
            int studentNo = Integer.parseInt(request.getParameter("studentNo"));
            Student student = studentService.getStudentById(studentNo);
            student.setAchievement(teacherAchieve);
            String photoUrl = uploadPic(file, request, response);
            student.setPhotoUrl(photoUrl);
            studentService.updateStudent(student);
            List<Student> allStudent = studentService.getAllStudents();
            modelMap.put("title", "孺子牛学生风采");
            modelMap.put("allStudent", allStudent);
            return "pages/student";
        }else{
            System.out.println("addStudent");
            String studentAchieve = request.getParameter("achieve");
            String school = request.getParameter("school");
            String grade = request.getParameter("grade");
            boolean sex = Boolean.getBoolean(request.getParameter("sex"));
            String studentName = request.getParameter("name");
            Student student = new Student();
            student.setAchievement(studentAchieve);
            student.setName(studentName);
            student.setGrade(grade);
            student.setSex(sex);
            student.setSchool(school);
            String photoUrl= uploadPic(file, request, response);
            student.setPhotoUrl(photoUrl);
            studentService.insertStudent(student);
            List<Student> allStudent = studentService.getAllStudents();
            System.out.println(allStudent.get(0).getName());
            modelMap.put("title", "孺子牛老师风采");
            modelMap.put("allStudent", allStudent);
            return "pages/student";
        }
    }

    @RequestMapping("/deleteteacher")
    public String deleteteacher(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        int teacherNo = Integer.parseInt(request.getParameter("teachNo"));
        System.out.println("deleteTeacher:"+teacherNo);
        teacherService.deleteTeacherById(teacherNo);
        List<Teacher> allTeacher = teacherService.getAllTeachers();
        modelMap.put("title","孺子牛老师风采");
        modelMap.put("allTeacher",allTeacher);
        return "pages/teacher";
    }

    @RequestMapping("/deletestudent")
    public String deletestudent(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        int studentNo = Integer.parseInt(request.getParameter("studentNo"));
        System.out.println("deleteStudent:"+studentNo);
        studentService.deleteStudentById(studentNo);
        List<Student> allStudent = studentService.getAllStudents();
        modelMap.put("title","孺子牛学生风采");
        modelMap.put("allTeacher",allStudent);
        return "pages/student";
    }

    @RequestMapping("/showstudent")
    public String showstudent(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        System.out.println("allStudent");
        List<Student> allStudent = studentService.getAllStudents();
        modelMap.put("title","孺子牛学生风采");
        modelMap.put("allStudent",allStudent);
        return "pages/showstudent";
    }

    @RequestMapping("/showteacher")
    public String showteacher(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        System.out.println("allTeacher");
        List<Teacher> allTeacher = teacherService.getAllTeachers();
        modelMap.put("title","孺子牛老师风采");
        modelMap.put("allTeacher",allTeacher);
        return "pages/showteacher";
    }

    private String uploadPic( MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String logoPathDir = "/staticSource/upload/";
        String logoRealPathDir = request.getSession().getServletContext()
                .getRealPath(logoPathDir);
        File targetDir = new File(logoRealPathDir);
        if(!targetDir.exists()){
            targetDir.mkdir();
        }
        String fileName = new Date().getTime() + file.getOriginalFilename();

        File tempFile = new File(logoRealPathDir, String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        System.out.println( logoPathDir+fileName);
        return logoPathDir+fileName;
    }
}
