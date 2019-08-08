package cn.lime.service.impl;

import cn.lime.entity.SystemUser;
import cn.lime.mapper.SystemUserMapper;
import cn.lime.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 系统管理员用户业务层实现类
 * @author: Lime
 * @create: 2019-08-08 19:58
 **/

@Service
public class SystemUserServiceImpl implements SystemUserService
{

    private final SystemUserMapper systemUserMapper;

    @Autowired
    public SystemUserServiceImpl(SystemUserMapper systemUserMapper)
    {
        this.systemUserMapper = systemUserMapper;
    }

    @Override
    public List<SystemUser> findByUsername(String loginUsername)
    {
        return systemUserMapper.findByUsername(loginUsername);
    }

    @Override
    public SystemUser findBySystemUser(SystemUser user)
    {
        return systemUserMapper.findBySystemUser(user);

    }
}
