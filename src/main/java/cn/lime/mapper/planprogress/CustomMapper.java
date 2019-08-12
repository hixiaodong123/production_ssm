package cn.lime.mapper.planprogress;

import cn.lime.entity.planprogress.Custom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    @Select("select * from custom")
    List<Custom> findAll();
}