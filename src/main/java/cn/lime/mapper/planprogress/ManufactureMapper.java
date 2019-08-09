package cn.lime.mapper.planprogress;

import cn.lime.entity.planprogress.Manufacture;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);
}