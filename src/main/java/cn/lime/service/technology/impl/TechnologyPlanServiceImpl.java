package cn.lime.service.technology.impl;

import cn.lime.entity.technology.TechnologyExample;
import cn.lime.entity.technology.TechnologyPlan;
import cn.lime.entity.technology.TechnologyPlanExample;
import cn.lime.mapper.tehnology.TechnologyPlanMapper;
import cn.lime.service.technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    @Override
    public List<TechnologyPlan> selectAllTechnologyPlanLeft() {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectAllTechnologyPlanLeft();
        return technologyPlans;
    }

    @Override
    public TechnologyPlan selectTechnologyPlanById(String id) {
        TechnologyPlan technologyPlan = technologyPlanMapper.selectByPrimaryKey(id);
        return technologyPlan;
    }

    @Override
    public int updateTechnologyPlan(TechnologyPlan technologyPlan) {
        int update = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
        return update;
    }

    @Override
    public int insertTechnologyPlan(TechnologyPlan technologyPlan) {
        int insert = technologyPlanMapper.insert(technologyPlan);
        return insert;
    }

    @Override
    public int deleteTechnologyPlanBatch(String[] ids) {
        TechnologyPlanExample technologyPlanExample = new TechnologyPlanExample();
        technologyPlanExample.createCriteria().andTechnologyPlanIdIn(Arrays.asList(ids));
        int i = technologyPlanMapper.deleteByExample(technologyPlanExample);
        return i;
    }

    //模糊查询
    //根据technologyPlanId查询
    @Override
    public List<TechnologyPlan> selectTechnologyPlanByTechnologyPlanIdLike(String searchValue) {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectTechnologyPlanByTechnologyPlanIdLike(searchValue);
        return technologyPlans;
    }
    //根据TechnologyName查询
    @Override
    public List<TechnologyPlan> selectTechnologyPlanByTechnologyNameLike(String searchValue) {
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.selectTechnologyPlanByTechnologyNameLike(searchValue);
        return technologyPlans;
    }
}
