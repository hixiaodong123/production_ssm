package cn.lime.service.system;


import cn.lime.entity.system.Department;
import cn.lime.entity.system.DepartmentExample;
import cn.lime.mapper.system.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public boolean insertDepartment(Department department) {
        Department department1 = departmentMapper.selectByPrimaryKey(department.getDepartmentId());
        if (department1 == null) {
            Department department2 = departmentMapper.selectByPrimaryKey(department.getDepartmentName());
            if (department2 == null) {
                departmentMapper.insert(department);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteDepartmentById(String departmentId) {
            return 0 != departmentMapper.deleteByPrimaryKey(departmentId);
    }

    @Override
    public boolean deleteDepartmentByIds(String[] departmentIds) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDepartmentIdIn(Arrays.asList(departmentIds));
        return 0 !=departmentMapper.deleteByExample(departmentExample);
    }

    @Override
    public boolean updateDepartment(Department department) {
        Department findDpm = departmentMapper.selectByPrimaryKey(department.getDepartmentName());
        if (null == findDpm || !findDpm.getDepartmentName().equals(department.getDepartmentName())) {
            departmentMapper.updateByPrimaryKey(department);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDepartmentNote(Department department) {
        Department dpm = departmentMapper.selectByPrimaryKey(department.getDepartmentId());
        dpm.setNote(department.getNote());
        return 0 != departmentMapper.updateByPrimaryKey(dpm);
    }

    @Override
    public List<Department> listDepartments() {
        List<Department> departmentList = departmentMapper.
                selectByExample(new DepartmentExample());
        return departmentList;
    }

    @Override
    public Department listDepartmentsById(String departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    @Override
    public List<Department> listDepartmentsByLikeId(String departmentId) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentId = "%" + departmentId + "%";
        departmentExample.createCriteria().andDepartmentIdLike(departmentId);
        return departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public List<Department> listDepartmentsByLikeName(String departmentName) {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentName = "%" + departmentName + "%";
        departmentExample.createCriteria().andDepartmentNameLike(departmentName);
        return departmentMapper.selectByExample(departmentExample);
    }
}
