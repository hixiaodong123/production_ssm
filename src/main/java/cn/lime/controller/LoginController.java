package cn.lime.controller;

import cn.lime.entity.SystemUser;
import cn.lime.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 登录管理控制器
 */
@Controller
public class LoginController
{

    private final SystemUserService systemUserService;

    @Autowired
    public LoginController(SystemUserService systemUserService)
    {
        this.systemUserService = systemUserService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/ajaxCheckLogin", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Map<String, Object> ajaxCheckLogin(@RequestBody SystemUser user, HttpSession session)
    {
        Map<String, Object> map = new HashMap<>();

        String randomcode = user.getRandomcode();
        if (randomcode == null || "".equals(randomcode) || randomcode.equalsIgnoreCase((String) session.getAttribute("validateCode")))
        {
            //第一次ajax或者验证码正确的时候
            //获取ajax传来的数据
            String loginUsername = user.getUsername();
            //业务层查询
            List<SystemUser> list = systemUserService.findByUsername(loginUsername);
            //比较
            if (list.size() == 0)
            {
                //说明没有查到,无此账户
                map.put("msg", "account_error");
                return map;
            }
            else
            {
                //说明查到了账户
                //进一步查询密码信息
                SystemUser userInDatabase = systemUserService.findBySystemUser(user);
                if (userInDatabase == null)
                {
                    //说明密码错误
                    map.put("msg", "password_error");
                    return map;
                }
                else
                {
                    //说明密码正确
                    if (Integer.parseInt(userInDatabase.getLocked()) == 0)
                    {
                        //说明没有权限登录
                        map.put("msg", "authentication_error");
                        return map;
                    }
                    //以上情况都没有发生说明登录成功!
                    //直接返回空的map
                    //存入session
                    session.setAttribute("activeUser",userInDatabase);
                    return map;
                }
            }
        }
        else
        {
            //说明验证码输入错误
            map.put("msg", "randomcode_error");
            return map;
        }

    }



    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String getHome()
    {
        return "home";
    }
}