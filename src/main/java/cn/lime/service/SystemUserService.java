package cn.lime.service;

import cn.lime.entity.SystemUser;

import java.util.List;

/**
 * @description: 系统管理员用户业务层接口
 * @author: Lime
 * @create: 2019-08-08 19:57
 **/

public interface SystemUserService
{

    List<SystemUser> findByUsername(String loginUsername);

    SystemUser findBySystemUser(SystemUser user);

}
