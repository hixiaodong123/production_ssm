package cn.lime.service.technology;

import cn.lime.entity.technology.TechnologyRequirement;
import cn.lime.entity.technology.TechnologyRequirementExample;
import cn.lime.mapper.tehnology.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService{
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Override
    public List<TechnologyRequirement> selectAllTechnologyRequirement() {
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.selectByExample(new TechnologyRequirementExample());
        return technologyRequirements;
    }
}
