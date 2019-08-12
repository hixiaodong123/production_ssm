package cn.lime.mapper.device;

import cn.lime.entity.device.DeviceFault;
import cn.lime.entity.device.DeviceFaultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DeviceFaultMapper {
    long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    @Select("select count(*) from device_fault")
    int selectDeviceFaultNum();

    List<DeviceFault> selectAllDeviceFault();

    List<DeviceFault> likeSelectDeviceFaultByDeviceFaultId(String deviceFaultId);

    List<DeviceFault> likeSelectDeviceFaultByDeviceName(String deviceName);
}