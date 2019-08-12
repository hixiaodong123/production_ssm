package cn.lime.mapper.tehnology;

import cn.lime.entity.technology.Process;
import cn.lime.entity.technology.ProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessMapper {
    long countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

//    List<Process> selectProcessByProcessIdLike(@Param("searchValue") String searchValue);
//
//    List<Process> selectProcessByTechnologyPlanIdLike(@Param("searchValue") String searchValue);
}