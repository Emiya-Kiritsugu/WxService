//package com.xmc.controller;
//
//import com.xmc.entity.Clock;
//import com.xmc.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * Created by Administrator on 2015/12/4.
// */
//
//@Controller
//@RequestMapping("/user")
//public class LoginController {
//
//    @Autowired
//    LoginService loginService;
//
//    @RequestMapping("/login")
//    public String login(ModelMap modelMap){
//        modelMap.put("test", "test");
//        return "index";
//    }
//
//    @RequestMapping("/rest")
//    public void restFul(ModelMap modelMap){
//        modelMap.put("name", "xmc1993");
//    }
//
//    @RequestMapping("clock")
//    public String getClockInfo(ModelMap modelMap){
//        Clock clock = loginService.getClockById(1);
//        modelMap.put("clock", clock);
//        return "index";
//    }
//}
