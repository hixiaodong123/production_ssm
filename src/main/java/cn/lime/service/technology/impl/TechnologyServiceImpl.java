package cn.lime.service.technology.impl;


import cn.lime.entity.technology.Technology;
import cn.lime.entity.technology.TechnologyExample;
import cn.lime.mapper.tehnology.TechnologyMapper;
import cn.lime.service.technology.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public List<Technology> listTechnology() {
        TechnologyExample technologyExample = new TechnologyExample();
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    @Override
    public Technology getTechnologyById(String id) {
        Technology technology = technologyMapper.selectByPrimaryKey(id);
        return technology;
    }

    @Override
    public int updateTechnology(Technology technology) {
        int update = technologyMapper.updateByPrimaryKey(technology);
        return update;
    }

    @Override
    public int insertTechnology(Technology technology) {
        int insert = technologyMapper.insert(technology);
        return insert;
    }

    @Override
    public int deleteTechnologyBatch(String[] ids) {
        TechnologyExample technologyExample = new TechnologyExample();
        technologyExample.createCriteria().andTechnologyIdIn(Arrays.asList(ids));
        int i = technologyMapper.deleteByExample(technologyExample);
        return i;
    }

    //根据technology_id进行模糊查询
    @Override
    public List<Technology> selectTechnologyByIdLike(String searchValue) {
        TechnologyExample technologyExample = new TechnologyExample();
        technologyExample.createCriteria().andTechnologyIdLike("%" + searchValue + "%");
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }

    //根据technology_name进行模糊查询
    @Override
    public List<Technology> selectTechnologyByNameLike(String searchValue) {
        TechnologyExample technologyExample = new TechnologyExample();
        technologyExample.createCriteria().andTechnologyNameLike("%" + searchValue + "%");
        List<Technology> technologies = technologyMapper.selectByExample(technologyExample);
        return technologies;
    }
}
