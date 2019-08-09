package cn.lime.service.technology;

import cn.lime.entity.technology.TechnologyPlan;
import cn.lime.entity.technology.TechnologyPlanExample;
import cn.lime.mapper.tehnology.TechnologyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public List<TechnologyPlan> selectAllTechnologyPlan() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectByExample(new TechnologyPlanExample());
        return technologyPlans;
    }
}
