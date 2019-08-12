package cn.lime.service.impl;

import cn.lime.entity.device.*;
import cn.lime.mapper.device.*;
import cn.lime.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DerviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Autowired
    DeviceFaultMapper deviceFaultMapper;
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public Device selectByPrimaryKey(String deviceId) {
        return deviceMapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public int selectDeviceNum() {
        return deviceMapper.selectDeviceNum();
    }

    @Override
    public Map<String, Object> selectAllDevice(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Device> devices = deviceMapper.selectAllDevice();
        PageInfo<Device> pageInfo = new PageInfo<>(devices);
        long total = pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",devices);
        return map;
    }


    @Override
    public int selectDeviceTypeNum() {
        return deviceTypeMapper.selectDeviceTypeNum();
    }

    @Override
    public List<DeviceType> selectAllDeviceType() {
        return deviceTypeMapper.selectAllDeviceType();
    }

    @Override
    public DeviceType selectDeviceTypeById(String id) {
        return deviceTypeMapper.selectDeviceTypeById(id);
    }

    @Override
    public Employee selectEmployeeById(String id) {
        return employeeMapper.selectEmployeeById(id);
    }

    @Override
    public List<DeviceCheck> selectAllDeviceCheck() {
        return deviceCheckMapper.selectAllDeviceCheck();
    }

    @Override
    public int selectDeviceCheckNum() {
        return deviceCheckMapper.selectDeviceCheckNum();
    }

    @Override
    public List<DeviceFault> selectAllDeviceFault() {
        return deviceFaultMapper.selectAllDeviceFault();
    }

    @Override
    public int selectDeviceFaultNum() {
        return deviceFaultMapper.selectDeviceFaultNum();
    }

    @Override
    public int selectDeviceMaintainNum() {
        return deviceMaintainMapper.selectDeviceMaintainNum();
    }

    @Override
    public DeviceFault selectDeviceFaultById(String id) {
        return deviceFaultMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DeviceType record) {
        return deviceTypeMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int updateEmployeeByReturnMess(Employee record) {
        //return employeeMapper.updateEmployeeByReturnMess(record);
        return employeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Device record) {
        return deviceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DeviceFault record) {
        return deviceFaultMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public List<DeviceMaintain> selectAllDeviceMaintain() {
        return deviceMaintainMapper.selectAllDeviceMaintain();
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeMapper.selectAllEmployee();
    }

    @Override
    public List<Device> selectAllDevice() {
        return deviceMapper.selectAllDevice();
    }

    @Override
    public List<Device> likeSelectDeviceByDeviceId(String deviceId) {

        return deviceMapper.likeSelectDeviceByDeviceId(deviceId);
    }

    @Override
    public List<Device> likeSelectDeviceByDeviceName(String deviceName) {
        return deviceMapper.likeSelectDeviceByDeviceName(deviceName);
    }

    @Override
    public List<Device> likeSelectDeviceByDeviceTypeName(String deviceName) {
        return deviceMapper.likeSelectDeviceByDeviceTypeName(deviceName);
    }

    @Override
    public List<DeviceType> likeSelectDeviceTypeByDeviceTypeId(String deviceTypeId) {
        return deviceTypeMapper.likeSelectDeviceTypeByDeviceTypeId(deviceTypeId);
    }

    @Override
    public List<DeviceType> likeSelectDeviceTypeByDeviceTypeName(String deviceTypeName) {
        return deviceTypeMapper.likeSelectDeviceTypeByDeviceTypeName(deviceTypeName);
    }

    @Override
    public List<DeviceCheck> likeSelectDeviceCheckByDeviceCheckId(String deviceCheckId) {
        return deviceCheckMapper.likeSelectDeviceCheckByDeviceCheckId(deviceCheckId);
    }

    @Override
    public List<DeviceCheck> likeSelectDeviceCheckByDeviceName(String devicName) {
        return deviceCheckMapper.likeSelectDeviceCheckByDeviceName(devicName);
    }

    @Override
    public List<DeviceFault> likeSelectDeviceFaultByDeviceFaultId(String deviceFaultId) {
        return deviceFaultMapper.likeSelectDeviceFaultByDeviceFaultId(deviceFaultId);
    }

    @Override
    public List<DeviceFault> likeSelectDeviceFaultByDeviceName(String deviceName) {
        return deviceFaultMapper.likeSelectDeviceFaultByDeviceName(deviceName);
    }

    @Override
    public List<DeviceMaintain> likeSelectDeviceMaintainByDeviceMaintainId(String deviceMaintainId) {
        return deviceMaintainMapper.likeSelectDeviceMaintainByDeviceMaintainId(deviceMaintainId);
    }

    @Override
    public List<DeviceMaintain> likeSelectDeviceMaintainByDeviceFaultId(String deviceFaultId) {
        return deviceMaintainMapper.likeSelectDeviceMaintainByDeviceFaultId(deviceFaultId);
    }

    @Override
    public int insert(Device record) {
        return deviceMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String deviceId) {
        return deviceMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public int insert(DeviceType record) {
        return deviceTypeMapper.insert(record);
    }

    @Override
    public int insert(DeviceCheck record) {
        return deviceCheckMapper.insert(record);
    }

    @Override
    public int deleteDeviceTypeByPrimaryKey(String deviceTypeId) {
        return deviceTypeMapper.deleteByPrimaryKey(deviceTypeId);
    }

    @Override
    public int updateByPrimaryKeySelective(DeviceCheck record) {
        return deviceCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deletedeviceCheckByPrimaryKey(String deviceCheckId) {
        return deviceCheckMapper.deleteByPrimaryKey(deviceCheckId);
    }

    @Override
    public int insert(DeviceFault record) {
        return deviceFaultMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelectiveDeviceFault(DeviceFault record) {
        return deviceFaultMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKeyDeviceFault(String deviceFaultId) {
        return deviceFaultMapper.deleteByPrimaryKey(deviceFaultId);
    }

    @Override
    public int insert(DeviceMaintain record) {
        return deviceMaintainMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(DeviceMaintain record) {
        return deviceMaintainMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKeyDeviceMaintain(String deviceMaintainId) {
        return deviceMaintainMapper.deleteByPrimaryKey(deviceMaintainId);
    }

    public Device selectDeviceById(String id){
        return deviceMapper.selectByPrimaryKey(id);
    }

}
