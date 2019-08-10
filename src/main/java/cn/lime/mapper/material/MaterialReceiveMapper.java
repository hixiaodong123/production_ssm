package cn.lime.mapper.material;

import cn.lime.entity.material.MaterialReceive;
import cn.lime.entity.material.MaterialReceiveExample;
import java.util.List;

import cn.lime.entity.material.MaterialReceives;
import org.apache.ibatis.annotations.Param;

public interface MaterialReceiveMapper {
    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceives queryMaterialReceivesByReceiveId(String receiveId);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);
}