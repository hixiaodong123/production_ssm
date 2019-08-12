package cn.lime.service.impl;

import cn.lime.entity.user.SysRole;
import cn.lime.entity.user.SysUser;
import cn.lime.mapper.user.SysRoleMapper;
import cn.lime.mapper.user.SysUserMapper;
import cn.lime.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public Map<String, Object> selectAllSysUser(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<SysUser> users = sysUserMapper.selectAllSysUser();
        PageInfo<SysUser> pageInfo = new PageInfo<>(users);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",users);
        return map;
    }

    @Override
    public Map<String, Object> selectAllSysRole(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<SysRole> sysRoles = sysRoleMapper.selectAllSysRole();
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoles);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",sysRoles);
        return map;
    }

    @Override
    public Map<String, Object> likeSelectUserByUserId(String userId,int page,int rows) {
        PageHelper.startPage(page,rows);
        String userId1="%"+userId+"%";
        List<SysUser> sysUsers = sysUserMapper.likeSelectUserByUserId(userId1);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",sysUsers);
        return map;
    }

    @Override
    public Map<String, Object> likeSelectUserByUserName(String userName, int page, int rows) {
        PageHelper.startPage(page,rows);
        String userId1="%"+userName+"%";
        List<SysUser> sysUsers = sysUserMapper.likeSelectUserByUserName(userId1);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",sysUsers);
        return map;
    }

    @Override
    public Map<String, Object> likeSelectUserByRoleName(String roleName, int page, int rows) {
        PageHelper.startPage(page,rows);
        String userId1="%"+roleName+"%";
        List<SysUser> sysUsers = sysUserMapper.likeSelectUserByRoleName(userId1);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",sysUsers);
        return map;
    }

    @Override
    public List<SysRole> selectAllSysRole() {
        return sysRoleMapper.selectAllSysRole();
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }
}
