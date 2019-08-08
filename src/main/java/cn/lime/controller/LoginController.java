package cn.lime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 登录管理控制器
 * @author: Lime
 * @create: 2019-08-08 15:47
 **/
@Controller
public class LoginController
{
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }


}
