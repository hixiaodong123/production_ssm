package cn.lime.mapper.device;

import cn.lime.entity.device.Employee;
import cn.lime.entity.device.EmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateEmployeeByReturnMess(@Param("record")Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectEmployeeById(String id);

    List<Employee> selectAllEmployee();
}