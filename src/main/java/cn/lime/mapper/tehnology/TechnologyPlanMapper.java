package cn.lime.mapper.tehnology;

import cn.lime.entity.technology.TechnologyPlan;
import cn.lime.entity.technology.TechnologyPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnologyPlanMapper {
    long countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    List<TechnologyPlan> selectAllTechnologyPlanLeft();

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectTechnologyPlanByTechnologyPlanIdLike(@Param("searchValue") String searchValue);

    List<TechnologyPlan> selectTechnologyPlanByTechnologyNameLike(@Param("searchValue") String searchValue);
}