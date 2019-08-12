package cn.lime.controller.system;

import cn.lime.entity.material.OperateResponse;
import cn.lime.entity.system.Employee;
import cn.lime.entity.system.EmployeeJson;
import cn.lime.service.system.EmployeeService;
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
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("find")
    public String findPage() {
        return "employee_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> listEmployee(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<EmployeeJson> employeeJsonList = employeeService.listEmployees();
        return returnInfo(employeeJsonList);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public EmployeeJson[] getData() {
        List<EmployeeJson> employeeList = employeeService.listEmployees();
        EmployeeJson[] employees =employeeList.toArray(new EmployeeJson[0]);
        return employees;
    }
    
    @RequestMapping("get/{empId}")
    @ResponseBody
    public EmployeeJson getEmployee(@PathVariable("empId") String empId) {
        return employeeService.listEmployeeById(empId);
    }

    @RequestMapping("search_employee_by_employeeId")
    @ResponseBody
    public Map<String, Object> listEmployeeById(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<EmployeeJson> employees = employeeService.listEmployeesByLikeId(searchValue);
        return returnInfo(employees);
    }

    @RequestMapping("search_employee_by_employeeName")
    @ResponseBody
    public Map<String, Object> listEmployeeByEmployeeName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<EmployeeJson> employees = employeeService.listEmployeesByLikeEmpName(searchValue);
        return returnInfo(employees);
    }

    @RequestMapping("search_employee_by_departmentName")
    @ResponseBody
    public Map<String, Object> listEmployeeByDepartmentName(int page, int rows, String searchValue) {
        PageHelper.startPage(page, rows);
        List<EmployeeJson> employees = employeeService.listEmployeesByLikeDepName(searchValue);
        return returnInfo(employees);
    }

    private Map<String, Object> returnInfo(List<EmployeeJson> employeeJsonList) {
        PageInfo<EmployeeJson> pageInfo = new PageInfo<>(employeeJsonList);
        long total = pageInfo.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", employeeJsonList);
        return map;
    }

    //需要增加权限65001
    @RequestMapping({"add_judge","edit_judge","delete_judge"})
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "employee_add";
    }



    @RequestMapping("edit")
    public String edit() {
        return "employee_edit";
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
    public OperateResponse insert(Employee employee) {
        boolean flag = employeeService.insertEmployee(employee);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("存在相同的员工编号，新增失败");
        return operateResponse;
    }

    //更新部门信息
    @RequestMapping("update_all")
    @ResponseBody
    public OperateResponse UpdateAll(Employee employee) {
        boolean flag = employeeService.updateEmployee(employee);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("更新员工信息失败");
        return operateResponse;
    }

    //删除部门信息
    @RequestMapping("delete_batch")
    @ResponseBody
    public OperateResponse deleteBatch(String[] ids) {
        boolean flag = employeeService.deleteEmployeeByIds(ids);
        if (flag) {
            return successOperate();
        }
        OperateResponse operateResponse = failOperate();
        operateResponse.setMsg("批次删除部门信息失败，请重试");
        return operateResponse;
    }

}

