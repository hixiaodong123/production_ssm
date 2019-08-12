package cn.lime.service.qualify.impl;

import cn.lime.entity.qualify.FinalCountCheck;
import cn.lime.entity.qualify.FinalCountCheckExample;
import cn.lime.mapper.qualify.FinalCountCheckMapper;
import cn.lime.service.qualify.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FinalCountCheckServiceImpl implements FinalCountCheckService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;

    @Override
    public List<FinalCountCheck> listFinalCountCheck() {
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectByExample(finalCountCheckExample);
        return finalCountChecks;
    }

    @Override
    public FinalCountCheck getFinalCountCheckById(String id) {
        FinalCountCheck finalCountCheck = finalCountCheckMapper.selectByPrimaryKey(id);
        return finalCountCheck;
    }

    @Override
    public int updateFinalCountCheck(FinalCountCheck finalCountCheck) {
        int update = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
        return update;
    }

    @Override
    public int insertFinalCountCheck(FinalCountCheck finalCountCheck) {
        int insert = finalCountCheckMapper.insert(finalCountCheck);
        return insert;
    }

    @Override
    public int deleteFinalCountCheckBatch(String[] ids) {
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        finalCountCheckExample.createCriteria().andFCountCheckIdIn(Arrays.asList(ids));
        int i = finalCountCheckMapper.deleteByExample(finalCountCheckExample);
        return i;
    }

    @Override
    public List<FinalCountCheck> selectALlFinalCountCheckLeft() {
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectALlFinalCountCheckLeft();
        return finalCountChecks;
    }

    //    @Override
//    public Technology getTechnologyById(String id) {
//        Technology technology = technologyMapper.selectByPrimaryKey(id);
//        return technology;
//    }
//
//    @Override
//    public int updateTechnology(Technology technology) {
//        int update = technologyMapper.updateByPrimaryKey(technology);
//        return update;
//    }
//
//    @Override
//    public int insertTechnology(Technology technology) {
//        int insert = technologyMapper.insert(technology);
//        return insert;
//    }
//
//    @Override
//    public int deleteTechnologyBatch(String[] ids) {
//        TechnologyExample technologyExample = new TechnologyExample();
//        technologyExample.createCriteria().andTechnologyIdIn(Arrays.asList(ids));
//        int i = technologyMapper.deleteByExample(technologyExample);
//        return i;
//    }
//
    //根据technology_id进行模糊查询
    @Override
    public List<FinalCountCheck> selectFinalCountCheckByFcountCheckIdLike(String searchValue) {
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountCheckByFcountCheckIdLike(searchValue);
        return finalCountChecks;
    }

    //根据technology_name进行模糊查询
    @Override
    public List<FinalCountCheck> selectFinalCountCheckByOrderIdLike(String searchValue) {
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectFinalCountCheckByOrderIdLike(searchValue);
        return finalCountChecks;
    }
}
