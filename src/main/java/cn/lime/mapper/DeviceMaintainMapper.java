package cn.lime.mapper;

import cn.lime.entity.DeviceMaintain;

public interface DeviceMaintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);
}