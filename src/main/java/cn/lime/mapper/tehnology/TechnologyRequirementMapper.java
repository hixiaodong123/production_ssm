package cn.lime.mapper.tehnology;

import cn.lime.entity.technology.TechnologyRequirement;
import cn.lime.entity.technology.TechnologyRequirementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    List<TechnologyRequirement> selectAllTechnologyRequirementLeft();

    List<TechnologyRequirement> selectTechnologyRequirementByTechnologyRequirementIdLike(@Param("searchValue") String searchValue);

    List<TechnologyRequirement> selectTechnologyRequirementByTechnologyNameLike(@Param("searchValue") String searchValues);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);
}