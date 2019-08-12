package cn.lime.mapper.qualify;

import cn.lime.entity.qualify.FinalCountCheck;
import cn.lime.entity.qualify.FinalCountCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    List<FinalCountCheck> selectALlFinalCountCheckLeft();

    List<FinalCountCheck> selectFinalCountCheckByFcountCheckIdLike(@Param("searchValue") String searchValue);

    List<FinalCountCheck> selectFinalCountCheckByOrderIdLike(@Param("searchValue") String searchValue);
}