package cn.lime.service.system;


import cn.lime.entity.system.*;
import cn.lime.mapper.system.DepartmentMapper;
import cn.lime.mapper.system.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public boolean insertEmployee(Employee employee) {
        Employee findEmployee = employeeMapper.selectByPrimaryKey(employee.getEmpId());
        if (null == findEmployee) {
            employeeMapper.insert(employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployeeById(String employeeId) {
            return 0 != employeeMapper.deleteByPrimaryKey(employeeId);
    }

    @Override
    public boolean deleteEmployeeByIds(String[] employeeIds) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpIdIn(Arrays.asList(employeeIds));
        return 0 !=employeeMapper.deleteByExample(employeeExample);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Department department = departmentMapper.selectByPrimaryKey(employee.getDepartmentId());
        if (null != department) {
            employeeMapper.updateByPrimaryKey(employee);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeJson> listEmployees() {
        List<Employee> employeeList = employeeMapper.selectByExample(new EmployeeExample());
        return selectEmpJson(employeeList);
    }

    @Override
    public List<EmployeeJson> listEmployeesByLikeId(String employeeId) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeId = "%" + employeeId + "%";
        employeeExample.createCriteria().andEmpIdLike(employeeId);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        return selectEmpJson(employeeList);
    }

    @Override
    public List<EmployeeJson> listEmployeesByLikeEmpName(String employeeName) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeName = "%" + employeeName + "%";
        employeeExample.createCriteria().andEmpNameLike(employeeName);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        return selectEmpJson(employeeList);
    }

    @Override
    public List<EmployeeJson> listEmployeesByLikeDepName(String departmentName) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentName = "%" + departmentName + "%";
        departmentExample.createCriteria().andDepartmentNameLike(departmentName);
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);
        List<Employee> employeeList = new ArrayList<>();
        for (Department department : departmentList) {
            EmployeeExample employeeExample = new EmployeeExample();
            employeeExample.createCriteria().andDepartmentIdEqualTo(department.getDepartmentId());
            List<Employee> employees = employeeMapper.selectByExample(employeeExample);
            employeeList.addAll(employees);
        }
        return selectEmpJson(employeeList);
    }

    @Override
    public EmployeeJson listEmployeeById(String empId) {
        return employeeMapper.selectEmployeeJsonByEmpId(empId);
    }

    private List<EmployeeJson> selectEmpJson(List<Employee> employeeList) {
        List<EmployeeJson> employeeJsonList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeJson employeeJson = employeeMapper.selectEmployeeJsonByEmpId(employee.getEmpId());
            employeeJsonList.add(employeeJson);
        }
        return employeeJsonList;
    }
}
