package cn.lime.mapper.user;

import cn.lime.entity.user.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectAllSysUser();

    List<SysUser> likeSelectUserByUserId(String userId);

    List<SysUser> likeSelectUserByUserName(String userName);

    List<SysUser> likeSelectUserByRoleName(String roleName);
}