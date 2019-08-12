package cn.lime.service;

import cn.lime.entity.user.SysRole;
import cn.lime.entity.user.SysUser;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, Object> selectAllSysUser(int page, int rows);

    Map<String, Object> selectAllSysRole(int page, int rows);

    Map<String, Object> likeSelectUserByUserId(String userId, int page, int rows);

    Map<String, Object> likeSelectUserByUserName(String userName, int page, int rows);

    Map<String, Object> likeSelectUserByRoleName(String roleName, int page, int rows);

    List<SysRole> selectAllSysRole();

    int insert(SysUser record);

    int updateByPrimaryKeySelective(SysUser record);

    int deleteByPrimaryKey(String id);


}
