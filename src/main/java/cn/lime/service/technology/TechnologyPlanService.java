package cn.lime.service.technology;

import cn.lime.entity.technology.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanService {

    List<TechnologyPlan> selectAllTechnologyPlan();

    //查询technologyPlan，联合technology表得到technology_name信息
    List<TechnologyPlan> selectAllTechnologyPlanLeft();

    //根据工艺计划编号technology_plan_id查询TechnologyPlan
    TechnologyPlan selectTechnologyPlanById(String id);

    int updateTechnologyPlan(TechnologyPlan technologyPlan);

    int insertTechnologyPlan(TechnologyPlan technologyPlan);

    int deleteTechnologyPlanBatch(String[] ids);

    List<TechnologyPlan> selectTechnologyPlanByTechnologyPlanIdLike(String searchValue);

    List<TechnologyPlan> selectTechnologyPlanByTechnologyNameLike(String searchValue);
}
