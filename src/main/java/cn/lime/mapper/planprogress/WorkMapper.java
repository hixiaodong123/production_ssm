package cn.lime.mapper.planprogress;

import cn.lime.entity.planprogress.Work;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}