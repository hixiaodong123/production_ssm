package cn.lime.mapper.others;

import cn.lime.entity.others.Corder;
import cn.lime.entity.others.CorderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CorderMapper {
    long countByExample(CorderExample example);

    int deleteByExample(CorderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Corder record);

    int insertSelective(Corder record);

    List<Corder> selectByExample(CorderExample example);

    Corder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Corder record, @Param("example") CorderExample example);

    int updateByExample(@Param("record") Corder record, @Param("example") CorderExample example);

    int updateByPrimaryKeySelective(Corder record);

    int updateByPrimaryKey(Corder record);
}