package cn.lime.mapper;

import cn.lime.entity.SystemUser;

import java.util.List;

public interface SystemUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    List<SystemUser> findByUsername(String loginUsername);

    SystemUser findBySystemUser(SystemUser user);
}