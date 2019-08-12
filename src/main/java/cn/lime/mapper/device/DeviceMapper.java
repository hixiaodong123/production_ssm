package cn.lime.mapper.device;

import cn.lime.entity.device.Device;
import cn.lime.entity.device.DeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper {
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(String deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    int selectDeviceNum();

    List<Device> selectAllDevice();

    List<Device> likeSelectDeviceByDeviceId(String deviceId);

    List<Device> likeSelectDeviceByDeviceName(String deviceName);

    List<Device> likeSelectDeviceByDeviceTypeName(String deviceName);
}