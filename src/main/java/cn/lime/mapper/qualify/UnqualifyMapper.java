package cn.lime.mapper.qualify;

import cn.lime.entity.qualify.Unqualify;
import cn.lime.entity.qualify.UnqualifyExample;
import cn.lime.entity.qualify.UnqualifyJson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyMapper {
    long countByExample(UnqualifyExample example);

    int deleteByExample(UnqualifyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(Unqualify record);

    int insertSelective(Unqualify record);

    List<Unqualify> selectByExample(UnqualifyExample example);

    Unqualify selectByPrimaryKey(String unqualifyApplyId);

    UnqualifyJson selectUnqualifyJsonById(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") Unqualify record, @Param("example") UnqualifyExample example);

    int updateByExample(@Param("record") Unqualify record, @Param("example") UnqualifyExample example);

    int updateByPrimaryKeySelective(Unqualify record);

    int updateByPrimaryKey(Unqualify record);
}