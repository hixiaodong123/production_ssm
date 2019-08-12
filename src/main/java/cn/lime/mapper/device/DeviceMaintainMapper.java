package cn.lime.mapper.device;

import cn.lime.entity.device.DeviceMaintain;
import cn.lime.entity.device.DeviceMaintainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DeviceMaintainMapper {
    long countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    List<DeviceMaintain> selectAllDeviceMaintain();

    @Select("select count(*) from device_maintain")
    int selectDeviceMaintainNum();

    List<DeviceMaintain> likeSelectDeviceMaintainByDeviceMaintainId(String deviceMaintainId);

    List<DeviceMaintain> likeSelectDeviceMaintainByDeviceFaultId(String deviceFaultId);
}