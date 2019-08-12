package cn.lime.controller.system;

import cn.lime.entity.material.OperateResponse;
import cn.lime.entity.system.Department;
import cn.lime.service.system.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("find")
    public String findPage() {
        return "department_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> listDepartment(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Department> departments = departmentService.listDepartments();
        return returnInfo(departments);
    }

    @RequestMapping("search_department_by_departmentId")
    @ResponseBody
    public Map<String, Object> listDepartmentById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<Department> departments;
        departments = departmentService.listDepartmentsByLikeId(searchValue);
        return returnInfo(departments);
    }

    @RequestMapping("search_department_by_departmentName")
    @ResponseBody
    public Map<String, Object> listDepartmentByMaterialId(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<Department> departments = departmentService.listDepartmentsByLikeName(searchValue);
        return returnInfo(departments);
    }

    private Map<String, Object> returnInfo(List<Department> departments) {
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", departments);
        return map;
    }

    //获取表department中全部的信息
    @RequestMapping("get_data")
    @ResponseBody
    public Department[] getData() {
        List<Department> departmentList = departmentService.listDepartments();
        Department[] departments =departmentList.toArray(new Department[0]);
        return departments;
    }

    //获取表department中对应id的数据
    @RequestMapping("get/{departmentId}")
    @ResponseBody
    public Department getDepartmentById(@PathVariable("departmentId") String departMentId) {
        return departmentService.listDepartmentsById(departMentId);
    }

    //需要增加权限65001
    @RequestMapping({"add_judge","edit_judge","delete_judge"})
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "department_add";
    }



    @RequestMapping("edit")
    public String edit() {
        return "department_edit";
    }

    private OperateResponse successOperate() {
        OperateResponse operateResponse = new OperateResponse();
        operateResponse.setStatus(200);
        operateResponse.setMsg("OK");
        operateResponse.setData(null);
        return operateResponse;
    }

    private OperateResponse failOperate() {
        OperateResponse operateResponse = new OperateResponse();
        operateResponse.setStatus(403);
        operateResponse.setData(null);
        return operateResponse;
    }

    //新增部门信息
    @RequestMapping("insert")
    @ResponseBody
    public OperateResponse insert(Department department) {
        boolean flag = departmentService.insertDepartment(department);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("已存在同样的部门编号");
        return operateResponse;
    }

    //更新部门信息
    @RequestMapping("update_all")
    @ResponseBody
    public OperateResponse UpdateAll(Department department) {
        boolean flag = departmentService.updateDepartment(department);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("已存在同样的部门名称");
        return operateResponse;
    }

    //更新部门备注信息
    @RequestMapping("update_note")
    @ResponseBody
    public OperateResponse updateNote(Department department) {
        boolean flag = departmentService.updateDepartmentNote(department);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("更新部门备注信息失败，请重试");
        return operateResponse;
    }

    //删除部门信息
    @RequestMapping("delete_batch")
    @ResponseBody
    public OperateResponse deleteBatch(String[] ids) {
        boolean flag = departmentService.deleteDepartmentByIds(ids);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("批次删除部门信息失败，请重试");
        return operateResponse;
    }

}

