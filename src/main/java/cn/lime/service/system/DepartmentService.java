package cn.lime.service.system;


import cn.lime.entity.system.Department;

import java.util.List;

public interface DepartmentService {

    boolean insertDepartment(Department department);

    boolean deleteDepartmentById(String departmentId);

    boolean deleteDepartmentByIds(String[] departmentIds);

    boolean updateDepartment(Department department);

    boolean updateDepartmentNote(Department department);

    List<Department> listDepartments();

    Department listDepartmentsById(String departmentId);

    List<Department> listDepartmentsByLikeId(String departmentId);

    List<Department> listDepartmentsByLikeName(String departmentName);

}
