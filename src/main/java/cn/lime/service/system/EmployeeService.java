package cn.lime.service.system;


import cn.lime.entity.system.Employee;
import cn.lime.entity.system.EmployeeJson;

import java.util.List;

public interface EmployeeService {

    boolean insertEmployee(Employee employee);

    boolean deleteEmployeeById(String empId);

    boolean deleteEmployeeByIds(String[] empIds);

    boolean updateEmployee(Employee employee);

//    boolean updateEmployeeNote(Employee employee);

    List<EmployeeJson> listEmployees();

    List<EmployeeJson> listEmployeesByLikeId(String empId);

    List<EmployeeJson> listEmployeesByLikeEmpName(String empName);

    List<EmployeeJson> listEmployeesByLikeDepName(String empName);

    EmployeeJson listEmployeeById(String empId);
}
