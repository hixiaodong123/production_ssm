package cn.lime.service.technology;

import cn.lime.entity.technology.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementService {
    List<TechnologyRequirement> selectAllTechnologyRequirement();

    //查询technologyRequirement，联合technology表得到technology_name信息
    List<TechnologyRequirement> selectAllTechnologyRequirementLeft();

    int updateTechnologyRequirement(TechnologyRequirement technologyRequirement);

    int insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    int deleteTechnologyRequirementBatch(String[] ids);

    //模糊查询
    //根据TechnologyRequirementId查询
    List<TechnologyRequirement> selectTechnologyRequirementByTechnologyRequirementIdLike(String searchValue);
    //根据TechnologyName查询
    List<TechnologyRequirement> selectTechnologyRequirementByTechnologyNameLike(String searchValue);
}
