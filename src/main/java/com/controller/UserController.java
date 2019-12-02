package com.controller;


import com.github.pagehelper.PageHelper;
import com.pojo.PageBean;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 控制层
 * 针对用户进行的一系列操作
 */

@Controller
@RequestMapping("/con")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/test")
    public ModelAndView test(){
        List<User> list = userService.selectUser();//查询对象

        ModelAndView mav = new ModelAndView();

        mav.addObject("list",list);//把查询的结果集存进域对象
        mav.setViewName("show");
        return mav;

    }
    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mav){
        mav.setViewName("add");
        return mav;

    }

    
    @RequestMapping("/append")
    public String append(User user) throws IOException {
       /* String name = user.getUser_name();
        String addr = user.getUser_addr();
        Date date = user.getCreate_date();
        String num = user.getUser_num();
        int id = user.getUser_id();
        if (name==null||addr==null||date==null||num==null||id==null){

        }*/
       /* String regex1 = "^[A-Za-z0-9\u4e00-\u9fa5]+$";
        boolean flag1 = name.matches(regex);*/

        userService.insertUser(user);
        return "redirect:/con/main";

    }

    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id){

            int i = userService.deleteById(id);
            return "redirect:/con/main";
        }

    @RequestMapping("/main")
    public String  main(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage, Model model) {
        model.addAttribute("pagemsg", userService.findByPage(currentPage));//回显分页数据
        return "show";
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable String id,Model m) {
        User user = userService.get(Integer.parseInt(id));
        m.addAttribute("user",user);
        return "update";

    }

    @RequestMapping("/edit")
    public String edit(User user) {

            int i=userService.edit(user);
            return "redirect:/con/main";//去main方法 重查
        }




}
