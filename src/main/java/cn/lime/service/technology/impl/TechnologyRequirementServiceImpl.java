package cn.lime.service.technology.impl;

import cn.lime.entity.technology.*;
import cn.lime.mapper.tehnology.TechnologyMapper;
import cn.lime.mapper.tehnology.TechnologyRequirementMapper;
import cn.lime.service.technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<TechnologyRequirement> selectAllTechnologyRequirement() {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectByExample(new TechnologyRequirementExample());
        return technologyRequirements;
    }

    @Override
    public List<TechnologyRequirement> selectAllTechnologyRequirementLeft() {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectAllTechnologyRequirementLeft();
        return technologyRequirements;
    }

    @Override
    public int updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int update = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
        return update;
    }

    @Override
    public int insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int insert = technologyRequirementMapper.insert(technologyRequirement);
        return insert;
    }

    @Override
    public int deleteTechnologyRequirementBatch(String[] ids) {
        TechnologyRequirementExample technologyRequirementExample = new TechnologyRequirementExample();
        technologyRequirementExample.createCriteria().andTechnologyRequirementIdIn(Arrays.asList(ids));
        int i = technologyRequirementMapper.deleteByExample(technologyRequirementExample);
        return i;
    }

    //根据technologyRequirement_Id进行模糊查询
    @Override
    public List<TechnologyRequirement> selectTechnologyRequirementByTechnologyRequirementIdLike(String searchValue) {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectTechnologyRequirementByTechnologyRequirementIdLike(searchValue);
        return technologyRequirements;
    }
    //根据technologyName进行模糊查询
    @Override
    public List<TechnologyRequirement> selectTechnologyRequirementByTechnologyNameLike(String searchValue) {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectTechnologyRequirementByTechnologyNameLike(searchValue);
        return technologyRequirements;
    }
}
