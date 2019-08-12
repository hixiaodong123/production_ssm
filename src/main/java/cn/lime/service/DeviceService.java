package cn.lime.service;

import cn.lime.entity.device.*;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    Device selectByPrimaryKey(String deviceId);
    int selectDeviceNum();

    Map<String,Object> selectAllDevice(int page,int rows);

    int selectDeviceTypeNum();

    List<DeviceType> selectAllDeviceType();

    DeviceType selectDeviceTypeById(String id);

    Employee selectEmployeeById(String id);

    List<DeviceCheck> selectAllDeviceCheck();

    int selectDeviceCheckNum();

    List<DeviceFault> selectAllDeviceFault();

    int selectDeviceFaultNum();

    int selectDeviceMaintainNum();

    DeviceFault selectDeviceFaultById(String id);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateEmployeeByReturnMess(Employee record);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKeySelective(DeviceFault record);

    List<DeviceMaintain> selectAllDeviceMaintain();

    List<Department> selectAllDepartment();

    List<Employee> selectAllEmployee();

    List<Device> selectAllDevice();

    List<Device> likeSelectDeviceByDeviceId(String deviceId);

    List<Device> likeSelectDeviceByDeviceName(String deviceName);

    List<Device> likeSelectDeviceByDeviceTypeName(String deviceName);

    List<DeviceType> likeSelectDeviceTypeByDeviceTypeId(String deviceTypeId);

    List<DeviceType> likeSelectDeviceTypeByDeviceTypeName(String deviceTypeName);

    List<DeviceCheck> likeSelectDeviceCheckByDeviceCheckId(String deviceCheckId);

    List<DeviceCheck> likeSelectDeviceCheckByDeviceName(String deviceName);

    List<DeviceFault> likeSelectDeviceFaultByDeviceFaultId(String deviceFaultId);

    List<DeviceFault> likeSelectDeviceFaultByDeviceName(String deviceName);

    List<DeviceMaintain> likeSelectDeviceMaintainByDeviceMaintainId(String deviceMaintainId);

    List<DeviceMaintain> likeSelectDeviceMaintainByDeviceFaultId(String deviceFaultId);

    int insert(Device record);

    int deleteByPrimaryKey(String deviceId);

    int insert(DeviceType record);

    int insert(DeviceCheck record);

    int deleteDeviceTypeByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int deletedeviceCheckByPrimaryKey(String deviceCheckId);

    int insert(DeviceFault record);

    int updateByPrimaryKeySelectiveDeviceFault(DeviceFault record);

    int deleteByPrimaryKeyDeviceFault(String deviceFaultId);

    int insert(DeviceMaintain record);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int deleteByPrimaryKeyDeviceMaintain(String deviceMaintainId);

}
