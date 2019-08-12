package cn.lime.mapper.device;

import cn.lime.entity.device.Device;
import cn.lime.entity.device.DeviceType;
import cn.lime.entity.device.DeviceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DeviceTypeMapper {
    long countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    interface DeviceService {
        Device selectByPrimaryKey(String deviceId);
        int selectDeviceNum();
        List<Device> selectAllDevice();
        int selectDeviceTypeNum();
    }

    @Select("select count(*) from device_type")
    int selectDeviceTypeNum();

    List<DeviceType> selectAllDeviceType();

    DeviceType selectDeviceTypeById(String id);

    List<DeviceType> likeSelectDeviceTypeByDeviceTypeId(String deviceTypeId);

    List<DeviceType> likeSelectDeviceTypeByDeviceTypeName(String deviceYypeName);


}