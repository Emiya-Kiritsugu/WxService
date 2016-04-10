package com.xmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xmc1993 on 16/4/8.
 */
@Controller
@RequestMapping("/view")
public class ShowController {

    @RequestMapping("/test")
    public String test(){
        return "pages/Test";
    }

}
