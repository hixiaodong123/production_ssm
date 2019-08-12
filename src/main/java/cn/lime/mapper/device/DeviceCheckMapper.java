package cn.lime.mapper.device;

import cn.lime.entity.device.DeviceCheck;
import cn.lime.entity.device.DeviceCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceCheckMapper {
    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

    List<DeviceCheck> selectAllDeviceCheck();

    int selectDeviceCheckNum();

    List<DeviceCheck> likeSelectDeviceCheckByDeviceCheckId(String deviceCheckId);

    List<DeviceCheck> likeSelectDeviceCheckByDeviceName(String deviceName);
}