package com.liwei.modules.sys.controller;


import com.liwei.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("hello")
    @ResponseBody
    public String allUser(Long id){
        return userService.queryObject(id).toString();
    }
    @GetMapping("index")
    public ModelAndView hello(){
        ModelAndView model=new ModelAndView();
        model.addObject("name","liwei");
        model.setViewName("index");
        return model;
    }


}
