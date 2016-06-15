package com.xmc.controller;

import com.xmc.entity.Student;
import com.xmc.entity.Teacher;
import com.xmc.entity.Video;
import com.xmc.enums.Grade;
import com.xmc.enums.Subject;
import com.xmc.service.NoticeService;
import com.xmc.service.StudentService;
import com.xmc.service.TeacherService;
import com.xmc.service.VideoService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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
import java.util.*;

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
    @Autowired
    VideoService videoService;
    @Autowired
    NoticeService noticeService;

    @RequestMapping("/test")
    public String test(){
        return "pages/Test";
    }

    @RequestMapping("/showSenior")
    public String showGaozhong(){
        return "pages/template/showgaozhong";
    }

    @RequestMapping("/showPrimary")
    public String showXiaoxue(){
        return "pages/template/showxiaoxue";
    }

    @RequestMapping("/managecourse")
    public String course(){
        return "pages/template/course";
    }

    @RequestMapping("/addnotice")
    public String addNotice(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        String content = request.getParameter("content");
        noticeService.add(content);
        return "pages/template/notice";
    }
    @RequestMapping("/managenotice")
    public String manageNotice(){
        return "pages/template/notice";
    }
    @RequestMapping("/showJunior")
    public String showChuzhong(){
        return "pages/template/showchuzhong";
    }
    @RequestMapping("/showNotice")
    public String shownotice(ModelMap modelMap){
        String content = noticeService.getContent();
        return "pages/template/shownotice";
    }

    @RequestMapping("/course")
    public String course(@RequestParam("course") MultipartFile file,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException {
        String grade=request.getParameter("grade");

        String logoPathDir = "/staticSource/upload/";
        String logoRealPathDir = request.getSession().getServletContext()
                .getRealPath(logoPathDir);
        File targetDir = new File(logoRealPathDir);
        if(!targetDir.exists()){
            targetDir.mkdir();
        }
        String fileName = grade;

        File tempFile = new File(logoRealPathDir, String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        System.out.println(logoPathDir + fileName);

        return "pages/template/course";
    }



    @RequestMapping("/changeTeacher")
    public String changeTeacher(@RequestParam("id") String id,ModelMap modelMap){
        System.out.println("id:" + id);
        int _id = Integer.parseInt(id);
        Teacher teacher = teacherService.getTeacherById(_id);
        modelMap.put("teacher",teacher);
        return "pages/template/details";
    }

    @RequestMapping("/changeStudent")
    public String changeStudent(@RequestParam("id") String id,ModelMap modelMap){
        System.out.println("id:" + id);
        int _id = Integer.parseInt(id);
        Student student = studentService.getStudentById(_id);
        modelMap.put("student",student);
        return "pages/template/details_stu";
    }

    @RequestMapping("/allteacher")
    public String allTeacher(ModelMap modelMap){
        System.out.println("allTeacher");
        List<Teacher> allTeacher = teacherService.getAllTeachers();
        modelMap.put("title","孺子牛老师风采");
        modelMap.put("allTeacher",allTeacher);
        return "pages/template/teacher";
    }

    @RequestMapping("/allstudent")
    public String allStudent(ModelMap modelMap){
        System.out.println("allStudent");
        List<Student> allStudent = studentService.getAllStudents();
        modelMap.put("title","孺子牛学生风采");
        modelMap.put("allStudent",allStudent);
        return "pages/template/student";
    }

    @RequestMapping("/updateteacher")
    public String updateteacher(@RequestParam("teacherPhoto") MultipartFile file,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("teacherNo:"+request.getParameter("teachNo"));
        if(request.getParameter("teachNo") != null && !request.getParameter("teachNo").equals("")) {
            System.out.println("updateTeacher");
            String teacherProfile = request.getParameter("profile");

            String teacherAchieve = request.getParameter("achieve");
            System.out.println("profile"+teacherProfile+";"+teacherAchieve);
            int teacherNo = Integer.parseInt(request.getParameter("teachNo"));
            String name = "未命名";
            name = request.getParameter("name");
            Teacher teacher = teacherService.getTeacherById(teacherNo);
            teacher.setAchievement(teacherAchieve);
            teacher.setProfile(teacherProfile);
            teacher.setName(name);
            String url = uploadPic(file,request,response);
            teacher.setPhotoUrl(url);
            teacherService.updateTeacher(teacher);
            List<Teacher> allTeacher = teacherService.getAllTeachers();

            modelMap.put("title", "孺子牛老师风采");
            modelMap.put("allTeacher", allTeacher);
            return "pages/template/teacher";
        }else{
            System.out.println("addTeacher");
            String teacherProfile = request.getParameter("profile");
            String teacherAchieve = request.getParameter("achieve");
            String teacherName = request.getParameter("name");
            Teacher teacher = new Teacher();
            teacher.setAchievement(teacherAchieve);
            teacher.setProfile(teacherProfile);
            teacher.setName(teacherName);
            String url = uploadPic(file,request,response);
            teacher.setPhotoUrl(url);
            teacherService.insertTeacher(teacher);
            List<Teacher> allTeacher = teacherService.getAllTeachers();
            modelMap.put("title", "孺子牛老师风采");
            modelMap.put("allTeacher", allTeacher);
            return "pages/template/teacher";
        }
    }

    @RequestMapping("/updatestudent")
    public String updatestudent(@RequestParam("studentPhoto") MultipartFile file,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException {
        request.setCharacterEncoding("utf8");
        if(request.getParameter("studentNo") != null && !request.getParameter("studentNo").equals("")) {
            System.out.println("updateStudent");
            String teacherAchieve = request.getParameter("achieve");
            int studentNo = Integer.parseInt(request.getParameter("studentNo"));
            String grade = request.getParameter("grade");
            String name="未命名";
            name = request.getParameter("name");
            Student student = studentService.getStudentById(studentNo);
            student.setAchievement(teacherAchieve);
            String photoUrl = uploadPic(file, request, response);
            student.setPhotoUrl(photoUrl);
            student.setName(name);
            student.setGrade(grade);
            studentService.updateStudent(student);
            List<Student> allStudent = studentService.getAllStudents();
            modelMap.put("title", "孺子牛学生风采");
            modelMap.put("allStudent", allStudent);
            return "pages/template/student";
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
            return "pages/template/student";
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
        return "pages/template/showstudent";
    }

    @RequestMapping("/showteacher")
    public String showteacher(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        System.out.println("allTeacher");
        List<Teacher> allTeacher = teacherService.getAllTeachers();
        modelMap.put("title","孺子牛老师风采");
        modelMap.put("allTeacher",allTeacher);
        return "pages/template/showteacher";
    }

    @RequestMapping("/showvideo")
    public String showvideo(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        System.out.println("allvideo");
        List<Video> videoList = videoService.getAllVideos();
        modelMap.put("title","孺子牛老师风采");
        modelMap.put("allVideo",videoList);
        return "pages/showvideo";
    }

    @RequestMapping("/addvideo")
    public String addvideo(@RequestParam("video") MultipartFile file ,@RequestParam("grade") Grade grade ,
                            @RequestParam("name") String name, @RequestParam("desc") String desc ,
                            @RequestParam("subject") Subject subject,
                           HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws IOException {
        Video video = new Video();
        video.setDescription(desc);
        video.setName(name);
        video.setSubject(subject);
        String url = uploadVideo(file,request,response,grade.toString(),subject.toString());
        video.setGrade(grade);
        video.setName(name);
        video.setDescription(desc);
        video.setUrl(url);
        videoService.insertVideo(video);
        List<Video> videoList = videoService.getVideosByGrade(Grade.JUNIOR_THREE);
        Map<String,List<Video>> videoMap = new HashMap<String, List<Video>>();
        for(Video v : videoList){
            if(videoMap.containsKey(v.toString())){
                videoMap.get(v.toString()).add(v);
            }else{
                List<Video> videos = new ArrayList<Video>();
                videos.add(v);
                videoMap.put(v.toString()
                , videos);
            }
        }

        modelMap.put("title", "孺子牛老师风采");
        modelMap.put("allVideo", videoMap);
        return "pages/video";
    }

    @RequestMapping("/allVideo")
    public String gradeVide(@RequestParam("grade") Grade grade,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
        if(grade == null){
            grade = Grade.JUNIOR_THREE;
        }
        List<Video> videoList = videoService.getVideosByGrade(grade);
        Map<String,List<Video>> videoMap = new TreeMap<String, List<Video>>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(Video v : videoList){
            if(videoMap.containsKey(v.toString())){
                videoMap.get(v.getSubject().toString()).add(v);
            }else{
                List<Video> videos = new ArrayList<Video>();
                videos.add(v);
                videoMap.put(v.getSubject().toString()
                        , videos);
            }
        }

        modelMap.put("title", "孺子牛老师风采");
        modelMap.put("allVideo", videoMap);
        modelMap.put(grade.toString(),"active");
        return "pages/video";
    }

    @RequestMapping("/deleteVideo")
    public void deleteVideo(@RequestParam("id") int id,HttpServletResponse response,ModelMap modelMap){

        videoService.deleteVideoById(id);
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
        System.out.println(logoPathDir + fileName);
        return logoPathDir+fileName;
    }
    private String uploadVideo( MultipartFile file, HttpServletRequest request, HttpServletResponse response,String grade,String subject) throws IOException {
        String logoPathDir = "/staticSource/upload/";
        String logoRealPathDir = request.getSession().getServletContext()
                .getRealPath(logoPathDir);
        File targetDir = new File(logoRealPathDir);
        if(!targetDir.exists()){
            targetDir.mkdir();
        }
        String fileName= grade+"/"+subject+"/"+file.getOriginalFilename();
        File tempFile = new File(logoRealPathDir, String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        System.out.println(logoPathDir + fileName);
        return logoPathDir+fileName;
    }
}
