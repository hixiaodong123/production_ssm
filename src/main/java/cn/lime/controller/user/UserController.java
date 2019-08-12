package cn.lime.controller.user;

import cn.lime.entity.user.SysRole;
import cn.lime.entity.user.SysUser;
import cn.lime.service.UserService;
import cn.lime.utils.ControllerMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    //系统管理中的用户管理
    @RequestMapping("user/list")
    @ResponseBody
    public Map<String, Object> returnUserList(int page, int rows){
        return userService.selectAllSysUser(page,rows);
    }

    @RequestMapping("user/find")
    public String goToUserList(HttpServletRequest request)
    {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("user:add");
        strings.add("user:edit");
        strings.add("user:delete");
        request.getSession().setAttribute("sysPermissionList",strings);
        return "user_list";
    }

    //系统管理中的角色管理
    @RequestMapping("role/list")
    @ResponseBody
    public Map<String, Object> returnRoleList(int page, int rows){
        return userService.selectAllSysRole(page,rows);
    }

    @RequestMapping("role/find")
    public String goToRoleList()
    {
        return "";
    }

    //用户管理中的模糊查询 通过用户编号查询
    @GetMapping("user/search_user_by_userId")
    @ResponseBody
    public Map<String,Object> LikeSelectUserByUserId(String searchValue,int page,int rows) {
        return userService.likeSelectUserByUserId(searchValue,page,rows);
    }

    //用户管理中的模糊查询 通过用户名称查询
    @GetMapping("user/search_user_by_userName")
    @ResponseBody
    public Map<String,Object> ikeSelectUserByUserName(String searchValue,int page,int rows) {
        return userService.likeSelectUserByUserName(searchValue,page,rows);
    }

    //用户管理中的模糊查询 通过角色名称查询
    @GetMapping("user/search_user_by_roleName")
    @ResponseBody
    public Map<String,Object> likeSelectUserByRoleName(String searchValue,int page,int rows) {
        return userService.likeSelectUserByRoleName(searchValue,page,rows);
    }

    //系统管理中的 用户管理中的 添加用户弹窗
    @RequestMapping("user/add_judge")
    @ResponseBody
    public void returnUserAddJudge(){
    }

    @RequestMapping("user/add")
    public String goToUserAdd(){
        return "user_add";
    }

    //系统管理中的 用户管理中的 添加用户中的 角色下拉框
    @PostMapping("role/get_data")
    @ResponseBody
    public List<SysRole> returnSysRoleOfUser(){
        List<SysRole> sysRoles = userService.selectAllSysRole();
        return sysRoles;
    }

    //系统管理中的 用户管理中的 用户增加功能
    @PostMapping("user/insert")
    @ResponseBody
    public Map<String, Object> AddUser(SysUser sysUser){
        int i = userService.insert(sysUser);
        return ControllerMapUtil.MapString(i==1);
    }

    //系统管理中的 用户管理中的 用户编辑功能
    @RequestMapping("user/edit_judge")
    @ResponseBody
    public void returnUserEdit(){
    }

    @RequestMapping("user/edit")
    public String GoToUserEdit(){
        return "user_edit";
    }

    @RequestMapping("user/update_all")
    @ResponseBody
    public Map<String, Object> UpdateUserByIdInUserEdit(SysUser sysUser){
        int i = userService.updateByPrimaryKeySelective(sysUser);
        return ControllerMapUtil.MapString(i==1);
    }

    //系统管理中的 用户管理中的 用户删除功能
    @RequestMapping("user/delete_judge")
    @ResponseBody
    public void returnUserDelete(){
    }

    @RequestMapping("user/delete_batch")
    @ResponseBody
    public Map<String,Object> delectUserById(String ids){
        int i = userService.deleteByPrimaryKey(ids);
        return ControllerMapUtil.MapString(i==1);
    }

}
