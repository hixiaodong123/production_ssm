package cn.lime.service.technology;


import cn.lime.entity.technology.Technology;
import cn.lime.entity.technology.TechnologyExample;
import cn.lime.mapper.tehnology.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService{
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<Technology> selectAllTechnology() {
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }
}
