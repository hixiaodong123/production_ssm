package cn.lime.interceptor;

import cn.lime.entity.login.SystemUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 登录权限拦截器
 * @author: Lime
 * @create: 2019-08-08 23:40
 **/

public class LoginInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {

        try
        {
            SystemUser user = ((SystemUser) request.getSession().getAttribute("activeUser"));
            if (user != null)
            {
                //说明登录了,直接放行
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //不管是类型转换异常还是其他,都不应该放行
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        //如果没有拿到session，也说明未登录
        request.setAttribute("result","0");
        request.getRequestDispatcher("/login").forward(request,response);
        //response.sendRedirect(request.getContextPath() + "/user/login");
        return false;
    }
}
